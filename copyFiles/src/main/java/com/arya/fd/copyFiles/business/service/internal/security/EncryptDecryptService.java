package com.arya.fd.copyFiles.business.service.internal.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class EncryptDecryptService {

	public EncryptDecryptService() {
	}

	private String password;
	private String key;

	private final String CHARSET_NAME = "UTF-8";
	private final String AES = "AES";

	private String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	private String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}

	private Cipher cipher;

	private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
		if (cipher == null) {

			final String ALGORITHM = "AES/CBC/PKCS5PADDING";
			cipher = Cipher.getInstance(ALGORITHM);
		}
		return cipher;
	}

	private IvParameterSpec createIvParameterSpec() throws UnsupportedEncodingException {
		return new IvParameterSpec(getKey().getBytes(CHARSET_NAME));
	}

	private SecretKeySpec createSecretKeySpec() throws UnsupportedEncodingException {
		return new SecretKeySpec(getPassword().getBytes(CHARSET_NAME), AES);
	}

	public final String encrypted(String value)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		getCipher().init(Cipher.ENCRYPT_MODE, createSecretKeySpec(), createIvParameterSpec());
		return new BASE64Encoder().encode(getCipher().doFinal(value.getBytes()));

	}

	public final void encrypted(Map<File, File> files) throws InvalidAlgorithmParameterException,
			NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IOException {

		for (Map.Entry<File, File> entry : files.entrySet()) {

			encrypted(entry.getKey(), entry.getValue());
		}
	}

	private void encrypted(File inputFile, File outputFile) throws IOException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {

		getCipher().init(Cipher.ENCRYPT_MODE, createSecretKeySpec(), createIvParameterSpec());
		FileInputStream inputStream = new FileInputStream(inputFile);
		CipherOutputStream outputStream = new CipherOutputStream(new FileOutputStream(outputFile), getCipher());
		copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();

	}

	public final String decrypted(String encrypted)
			throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		getCipher().init(Cipher.DECRYPT_MODE, createSecretKeySpec(), createIvParameterSpec());
		byte[] original = cipher.doFinal(new BASE64Decoder().decodeBuffer(encrypted));
		return new String(original);
	}

	public final void decrypted(Map<File, File> files) throws InvalidAlgorithmParameterException,
			NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IOException {

		for (Map.Entry<File, File> entry : files.entrySet()) {

			decrypted(entry.getKey(), entry.getValue());
		}
	}

	private void decrypted(File inputFile, File outputFile) throws NoSuchAlgorithmException, NoSuchPaddingException,
			IOException, InvalidAlgorithmParameterException, InvalidKeyException {

		getCipher().init(Cipher.DECRYPT_MODE, createSecretKeySpec(), createIvParameterSpec());
		CipherInputStream inputStream = new CipherInputStream(new FileInputStream(inputFile), getCipher());
		FileOutputStream outputStream = new FileOutputStream(outputFile);

		copy(inputStream, outputStream);

		inputStream.close();
		outputStream.close();
	}

	private void copy(InputStream fileInputStream, OutputStream outputStream) throws IOException {
		int i;
		byte[] b = new byte[1024];
		while ((i = fileInputStream.read(b)) != -1) {
			outputStream.write(b, 0, i);
		}
	}
}
