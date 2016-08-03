package com.zhuanche.zhuanche788.utils;

import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Des {
	public static byte[] tripledesEncrypt(String sDATA, String sKEY)
			throws Exception {
		if (sKEY == null || sKEY.length() < 32)
			throw new Exception("密钥长度不够，至少需�?32�?");

		// 处理key
		byte[] key = new byte[16];
		byte[] key1 = new byte[8], key2 = new byte[8];
		asc2bcd(sKEY.getBytes(), key, 32); // 记得把key转换成bcd�?
		System.arraycopy(key, 0, key1, 0, 8);
		System.arraycopy(key, 8, key2, 0, 8);

		// 处理数据，字节长度必须是8的�?�数
		int dataLen = sDATA.getBytes().length;
		int addLen = (dataLen % 8 == 0) ? 0 : (8 - dataLen % 8);
		byte[] data = new byte[dataLen + addLen];
		System.arraycopy(sDATA.getBytes(), 0, data, 0, dataLen);

		// 加密
		byte[] enc = encrypt(decrypt(encrypt(data, key1), key2), key1);
		return enc;
	}

	public static byte[] tripledesDecrypt(String sDATA, String sKEY)
			throws Exception {
		if (sKEY == null || sKEY.length() < 32)
			throw new Exception("密钥长度不够，至少需�?32�?");

		// 处理key
		byte[] key = new byte[16];
		byte[] key1 = new byte[8], key2 = new byte[8];
		asc2bcd(sKEY.getBytes(), key, 32); // 记得把key转换成bcd�?
		System.arraycopy(key, 0, key1, 0, 8);
		System.arraycopy(key, 8, key2, 0, 8);

		// //处理数据，字节长度必须是8的�?�数
		// int dataLen = sDATA.getBytes().length;
		// int addLen = (dataLen % 8 == 0) ? 0 : (8 - dataLen % 8);
		// byte[] data = new byte[dataLen + addLen];
		// System.arraycopy(sDATA.getBytes(), 0, data, 0, dataLen);

		// 加密
		byte[] dec = decrypt(encrypt(decrypt(sDATA.getBytes(), key1), key2),
				key1);
		return dec;
	}

	// -----des---------------
	private static byte[] decrypt(byte[] crypt, byte[] key) throws Exception {
		KeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		Key k = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(crypt);
	}

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		KeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		Key k = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 * 加密
	 * 
	 * @param strData
	 *            原数�? byte长度不足8位要�?0x20
	 * @param strKey
	 *            密钥
	 * @return 返回数据格式为ASCII码数�?
	 */
	public static String encrypt(String strData, String strKey) {
		byte[] key = new byte[8];
		asc2bcd(strKey.getBytes(), key, 16);

		byte[] bData;
		// 把数据长度补�?8的�?�数
		int datalen = strData.getBytes().length;
		int addLen = (datalen % 8 == 0 ) ? 0 : (8 - datalen % 8);
		bData = new byte[datalen + addLen];
		System.arraycopy(strData.getBytes(), 0, bData, 0, datalen);
		if (addLen > 0)
			System.arraycopy("        ".getBytes(), 0, bData, datalen, addLen);
		byte[] enc;
		try {
			enc = encrypt(bData, key);
		} catch (Exception e) {
			enc = new byte[8];
		}
		System.out.println("public des enc return :"
				+ new String(getAscFromBcd(enc)));
		System.out.println("public des enc return :" + new String(enc));

		return new String(getAscFromBcd(enc));
	}

	/**
	 * 解密
	 * 
	 * @param strData
	 *            加密生成的ASCII码数�?
	 * @param strKey
	 *            密钥
	 * @return 返回明文 明文包含 0x20要去�?
	 */
	public static String decrypt(String strData, String strKey) {
		byte[] key = new byte[8];
		asc2bcd(strKey.getBytes(), key, 16);

		byte[] enc3 = new byte[strData.getBytes().length / 2];
		asc2bcd(strData.getBytes(), enc3, strData.getBytes().length);
		byte[] dec;
		try {
			dec = decrypt(enc3, key);
		} catch (Exception e) {
			dec = new byte[8];
		}
		System.out.println("public des dec return :"
				+ new String(getAscFromBcd(dec)));
		System.out.println("public des dec return :" + new String(dec));

		return new String(dec).trim();
	}

	// ---------------
	/**
	 * ASCII码转换成BCD�?
	 * 
	 * @param sASC
	 *            ASCII�?
	 * @param sBCD
	 *            BCD�?
	 * @param nLen
	 *            ASCII码对应的长度
	 * @return
	 */
	static public int asc2bcd(byte[] sASC, byte[] sBCD, int nLen) {
		int i;
		byte ch;

		for (i = 0; i < nLen; i++) {
			if (sASC[i] >= '0' && sASC[i] <= '9')
				ch = 0;
			else if ((sASC[i] >= 'A' && sASC[i] <= 'F')
					|| (sASC[i] >= 'a' && sASC[i] <= 'f'))
				ch = 9;
			else {
				return -1;
			}
			sBCD[i / 2] = (byte) (((i % 2) != 0)
					? ((sBCD[i / 2] << 4) | (ch + (sASC[i] & 0x0f)))
					: (ch + (sASC[i] & 0x0f)));
		}

		return 0;
	}

	/**
	 * BCD码转换成ASCII�?
	 * 
	 * @param sBCD
	 *            BCD字节
	 * @param sASC
	 *            ASCII字节
	 * @param nLen
	 *            BCD码对应的长度
	 * @return
	 */
	static public int bcd2asc(byte[] sBCD, byte[] sASC, int nLen) {
		int i;
		byte ch;

		for (i = 0; i < nLen; i++) {
			ch = (byte) ((sBCD[i] >> 4) & 0x0f);
			if (ch >= 0 && ch < 10)
				ch = 0x30;
			else if (ch >= 10 && ch < 16)
				ch = (0x41 - 10);
			else {
				return -1;
			}
			sASC[(i << 1)] = (byte) ((ch + ((sBCD[i] >> 4) & 0x0f)));

			ch = (byte) (sBCD[i] & 0x0f);
			if (ch >= 0 && ch < 10)
				ch = 0x30;
			else if (ch >= 10 && ch < 16)
				ch = (0x41 - 10);
			else {
				return -1;
			}
			sASC[(i << 1) + 1] = (byte) ((ch + (sBCD[i] & 0x0f)));
		}
		return 0;
	}

	public static byte[] getAscFromBcd(byte[] bcd) {
		byte[] asc = new byte[bcd.length * 2];
		bcd2asc(bcd, asc, bcd.length);
		return asc;
	}

	public static byte[] getBcdFromAsc(byte[] asc) {
		byte[] bcd = new byte[asc.length / 2];
		asc2bcd(asc, bcd, asc.length);
		return bcd;
	}

}