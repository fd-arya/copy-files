package com.arya.fd.copyFiles.business.service.internal.security;

/*
 * fd_arya
 * 12/04/2018
 */

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	private final String ALGO = "AES";
	private final byte[] keyValue = new byte[] { 'F', 'a', 'R', 'R', 's', 'H', 'i', 'D', 'f', 'A', 'r', 'A', 'j', 'I',
			'F', 'D' };

	public byte[] encrypt(byte[] data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(data);
		System.out.println("----->"+encVal);
		String v = new String(encVal);
		System.out.println("---++-->"+v);
		return Base64.getEncoder().encode(encVal);
	}

	public byte[] decrypt(byte[] encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		return decValue;
	}

	private Key generateKey() throws Exception {
		return new SecretKeySpec(keyValue, ALGO);
	}
}
