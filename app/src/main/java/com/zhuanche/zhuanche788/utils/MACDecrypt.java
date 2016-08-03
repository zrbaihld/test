package com.zhuanche.zhuanche788.utils;

/**
 * 
 * <p>Description: MAC�㷨</p> 
 * <p>Company:startech</p>
 * @author 
 * @version 1.0
 */
public class MACDecrypt {
	byte iperm[][][] = new byte[16][16][8];

	byte fperm[][][] = new byte[16][16][8];

	byte s[][] = new byte[4][4096];

	byte p32[][][] = new byte[4][256][4];

	byte kn[][] = new byte[16][16];

	byte ip[] = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4,
			62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57,
			49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53,
			45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

	byte fp[] = { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
			38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36,
			4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2,
			42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 };

	byte pc1[] = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2,
			59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31,
			23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21,
			13, 5, 28, 20, 12, 4 };

	byte totrot[] = { 1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28 };

	byte pc1m[] = new byte[56]; /* place to modify pc1 into */

	byte pcr[] = new byte[56]; /* place to rotate pc1 into */

	byte pc2[] = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4,
			26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51,
			45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };

	byte si[][] = { /* S[1] */
			{ 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7,
					4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8,
					13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4,
					9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 },
			/* S[2] */
			{ 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4,
					7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11,
					10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3,
					15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 },
			/* S[3] */
			{ 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0,
					9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8,
					15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9,
					8, 7, 4, 15, 14, 3, 11, 5, 2, 12 },
			/* S[4] */
			{ 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11,
					5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12,
					11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1,
					13, 8, 9, 4, 5, 11, 12, 7, 2, 14 },
			/* S[5] */
			{ 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2,
					12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10,
					13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14,
					2, 13, 6, 15, 0, 9, 10, 4, 5, 3 },
			/* S[6] */
			{ 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4,
					2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2,
					8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15,
					10, 11, 14, 1, 7, 6, 0, 8, 13 },
			/* S[7] */
			{ 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11,
					7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13,
					12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4,
					10, 7, 9, 5, 0, 15, 14, 2, 3, 12 },
			/* S[8] */
			{ 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13,
					8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9,
					12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10,
					8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } };

	byte p32i[] = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31,
			10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };

	int bytebit[] = { 0200, 0100, 040, 020, 010, 04, 02, 01 };

	int nibblebit[] = { 010, 04, 02, 01 };

	int permute(byte inblock[], byte perm[][][], byte outblock[]) {
		for (int i = 0; i < 8; i++)
			outblock[i] = 0;
		for (int j = 0, k = 0; j < 16; j += 2, k++) {
			byte p[] = perm[j][(inblock[k] >> 4) & 017];
			byte q[] = perm[j + 1][inblock[k] & 017];
			for (int i = 0; i < 8; i++)
				outblock[i] |= p[i] | q[i];
		}
		return 0;
	}

	byte[] getByteOff(byte inblock[], int off) {
		if (off >= inblock.length)
			return null;
		byte[] b = new byte[inblock.length - off];
		for (int i = 0; i < b.length; i++)
			b[i] = inblock[i + off];
		return b;
	}

	int expand(byte[] r, byte[] bigright) /* 32 to 48 bits with E oper */
	{
		int i = 0;
		bigright[i++] = (byte) (((r[3] & 0001) << 7) | /* 32 */
		((r[0] & 0370) >> 1) | /* 1 2 3 4 5 */
		((r[0] & 0030) >> 3)); /* 4 5 */
		bigright[i++] = (byte) (((r[0] & 0007) << 5) | /* 6 7 8 */
		((r[1] & 0200) >> 3) | /* 9 */
		((r[0] & 0001) << 3) | /* 8 */
		((r[1] & 0340) >> 5)); /* 9 10 11 */
		bigright[i++] = (byte) (((r[1] & 0030) << 3) | /* 12 13 */
		((r[1] & 0037) << 1) | /* 12 13 14 15 16 */
		((r[2] & 0200) >> 7)); /* 17 */
		bigright[i++] = (byte) (((r[1] & 0001) << 7) | /* 16 */
		((r[2] & 0370) >> 1) | /* 17 18 19 20 21 */
		((r[2] & 0030) >> 3)); /* 20 21 */
		bigright[i++] = (byte) (((r[2] & 0007) << 5) | /* 22 23 24 */
		((r[3] & 0200) >> 3) | /* 25 */
		((r[2] & 0001) << 3) | /* 24 */
		((r[3] & 0340) >> 5)); /* 25 26 27 */
		bigright[i++] = (byte) (((r[3] & 0030) << 3) | /* 28 29 */
		((r[3] & 0037) << 1) | /* 28 29 30 31 32 */
		((r[0] & 0200) >> 7)); /* 1 */
		return 0;
	}

	int contract(byte[] in48, byte[] out32) /* contract f from 48 to 32 bits */
	{
		int i = 0;
		out32[i++] = s[0][07777 & ((in48[0] << 4) | ((in48[1] >> 4) & 017))];
		out32[i++] = s[1][07777 & ((in48[1] << 8) | (in48[2] & 0377))];
		out32[i++] = s[2][07777 & ((in48[3] << 4) | ((in48[4] >> 4) & 017))];
		out32[i++] = s[3][07777 & ((in48[4] << 8) | (in48[5] & 0377))];
		return 0;
	}

	int perm32(byte inblock[], byte outblock[]) /* 32-bit permutation at end */
	{
		for (int i = 0; i < 4; i++) {
			outblock[i] = 0;
		}
		for (int i = 0; i < 4; i++) {
			byte q[] = p32[i][inblock[i] & 0377];
			for (int j = 0; j < 4; j++)
				outblock[j] |= q[j];
		}
		return 0;
	}

	int f(byte[] right, int num, byte[] fret) /* critical cryptographic trans */
	{
		byte bigright[] = new byte[6]; /* right expanded to 48 bits */
		byte result[] = new byte[6]; /* expand(R) XOR keyselect[num] */
		byte preout[] = new byte[4]; /* result of 32-bit permutation */

		expand(right, bigright); /* expand to 48 bits */
		for (int i = 0; i < 6; i++)
			result[i] = (byte) (bigright[i] ^ kn[num][i]);
		contract(result, preout); /* use S fns to get 32 bits */
		perm32(preout, fret); /* and do final 32-bit perm */
		return 0;
	}

	// churning operation
	int iter(int num, byte inblock[], byte outblock[]) {
		// return from f(R[i-1],key)
		byte fret[] = new byte[4];
		byte ib[], ob[], fb[];

		ob = outblock;
		ib = getByteOff(inblock, 4);
		// the primary transformation
		f(ib, num, fret);
		// L[i] = R[i-1]
		int i, k = 0;
		for (i = 0; i < 4; i++)
			ob[k++] = ib[i];
		ib = inblock;
		fb = fret;
		// R[i]=L[i] XOR f(R[i-1],key)
		for (i = 0; i < 4; i++)
			ob[k++] = (byte) (ib[i] ^ fb[i]);
		return 0;
	}

	void endes(byte inblock[], byte outblock[]) /* encrypt 64-bit inblock */
	{
		byte iters[][] = new byte[17][8]; /* workspace for each iteration */
		byte swap[] = new byte[8]; /* place to interchange L and R */
		int i, k = 0;
		byte t[];

		permute(inblock, iperm, iters[0]);/* apply initial permutation */
		for (i = 0; i < 16; i++)
			/* 16 churning operations */
			iter(i, iters[i], iters[i + 1]);
		/* don't re-copy to save space */
		t = getByteOff(iters[16], 4); /* interchange left */
		for (i = 0; i < 4; i++)
			swap[k++] = t[i];
		t = iters[16]; /* and right */
		for (i = 0; i < 4; i++)
			swap[k++] = t[i];
		permute(swap, fperm, outblock); /* apply final permutation */
	}

	int desinit(byte[] key) /* initialize all des arrays */
	{
		perminit(iperm, ip); /* initial permutation */
		perminit(fperm, fp); /* final permutation */
		kinit(key); /* key schedule */
		sinit(); /* compression functions */
		p32init(); /* 32-bit permutation in f */
		return 0;
	}

	int perminit(byte perm[][][], byte p[]) /* initialize a perm array */
	{
		int l, j, k, i, m;

		for (i = 0; i < 16; i++)
			/* each input nibble position */
			for (j = 0; j < 16; j++)
				/* all possible input nibbles */
				for (k = 0; k < 8; k++)
					/* each byte of the mask */
					perm[i][j][k] = 0;/* clear permutation array */
		for (i = 0; i < 16; i++)
			/* each input nibble position */
			for (j = 0; j < 16; j++)
				/* each possible input nibble */
				for (k = 0; k < 64; k++)/* each output bit position */
				{
					l = p[k] - 1; /* where does this bit come from */
					if ((l >> 2) != i) /* does it come from input posn? */
						continue; /* if not, bit k is 0 */
					if ((j & nibblebit[l & 3]) == 0)
						continue; /* any such bit in input? */
					m = k & 07; /* which bit is this in the byte */
					perm[i][j][k >> 3] |= bytebit[m];
				}
		return 0;
	}

	int kinit(byte[] key) /* initialize key schedule array */
	{
		int i, j, l, m;

		for (j = 0; j < 56; j++) /* convert pc1 to bits of key */
		{
			l = pc1[j] - 1; /* integer bit location */
			m = l & 07; /* find bit */
			/*
			 * find which key byte l is in and which bit of that byte and store
			 * 1-bit result
			 */
			pc1m[j] = (byte) (((key[l >> 3] & bytebit[m]) != 0) ? 1 : 0);
		}
		for (i = 0; i < 16; i++)
			/* for each key sched section */
			for (j = 0; j < 6; j++)
				/* and each byte of the kn */
				kn[i][j] = 0; /* clear it for accumulation */
		for (i = 0; i < 16; i++) /* key chunk for each iteration */
		{
			for (j = 0; j < 56; j++)
				/* rotate pc1 the right amount */
				pcr[j] = pc1m[(l = j + totrot[i]) < (j < 28 ? 28 : 56) ? l
						: l - 28];
			/* rotate left and right halves independently */
			for (j = 0; j < 48; j++)
				/* select bits individually */
				if (pcr[pc2[j] - 1] != 0) /* check bit that goes to kn[j] */
				{
					l = j & 07;
					kn[i][j >> 3] |= bytebit[l];
				} /* mask it in if it's there */
		}
		return 0;
	}

	int getcomp(int k, int v) /* 1 compression value for sinit */
	{
		int i, j; /* correspond to i and j in FIPS */
		i = ((v & 040) >> 4) | (v & 1); /* first and last bits make row */
		j = (v & 037) >> 1; /* middle 4 bits are column */
		return (int) si[k][(i << 4) + j]; /* result is ith row, jth col */
	}

	int sinit() /* initialize s1-s8 arrays */
	{
		int i, j;
		for (i = 0; i < 4; i++)
			/* each 12-bit position */
			for (j = 0; j < 4096; j++)
				/* each possible 12-bit value */
				s[i][j] = (byte) ((getcomp(i * 2, j >> 6) << 4) | (017 & getcomp(
						i * 2 + 1, j & 077)));
		/* store 2 compressions per char */
		return 0;
	}

	int p32init() /* initialize 32-bit permutation */
	{
		int l, j, k, i, m;
		for (i = 0; i < 4; i++)
			/* each input byte position */
			for (j = 0; j < 256; j++)
				/* all possible input bytes */
				for (k = 0; k < 4; k++)
					/* each byte of the mask */
					p32[i][j][k] = 0; /* clear permutation array */
		for (i = 0; i < 4; i++)
			/* each input byte position */
			for (j = 0; j < 256; j++)
				/* each possible input byte */
				for (k = 0; k < 32; k++) /* each output bit position */
				{
					l = p32i[k] - 1; /* invert this bit (0-31) */
					if ((l >> 3) != i) /* does it come from input posn? */
						continue; /* if not, bit k is 0 */
					if ((j & bytebit[l & 07]) == 0)
						continue; /* any such bit in input? */
					m = k & 07; /* which bit is it? */
					p32[i][j][k >> 3] |= bytebit[m];
				}
		return 0;
	}

	/**
	 * ASCII��ת����BCD��
	 * 
	 * @param sASC
	 *            ASCII��
	 * @param sBCD
	 *            BCD��
	 * @param nLen
	 *            ASCII���Ӧ�ĳ���?
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
			sBCD[i / 2] = (byte) (((i % 2) != 0) ? ((sBCD[i / 2] << 4) | (ch + (sASC[i] & 0x0f)))
					: (ch + (sASC[i] & 0x0f)));
		}

		return 0;
	}

	/**
	 * BCD��ת����ASCII��
	 * 
	 * @param sBCD
	 *            BCD�ֽ�
	 * @param sASC
	 *            ASCII�ֽ�
	 * @param nLen
	 *            BCD���Ӧ�ĳ���?
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

	byte[] ansi99c_internal(byte[] msg, int l, byte[] key) {
		byte block[] = new byte[8];
		byte mab[] = new byte[8];
		int i, j, k;

		for (j = 0; j < 8; j++)
			mab[j] = 0;
		asc2bcd(key, block, 16);
		desinit(block);
		i = 0;
		while (i < l) {
			if ((l - i) < 8) {
				for (j = 0; j < 8; j++)
					block[j] = 0;
				for (j = 0; j < l - i; j++)
					block[j] = msg[j + i];
			} else {
				for (j = 0; j < 8; j++)
					block[j] = msg[j + i];
			}
			i += 8;
			for (k = 0; k < 8; k++)
				mab[k] = (byte) (mab[k] ^ block[k]);
			endes(mab, mab);
		}
		byte[] mac = new byte[16];
		for (j = 0; j < 16; j++) {
			mac[j] = '0';
		}
		bcd2asc(mab, mac, 8);
		return mac;
	}

	public static byte[] ansi99(byte[] msg, int len, byte[] key) {
		MACDecrypt od = new MACDecrypt();
		byte[] bRet = od.ansi99c_internal(msg, len, key);
		od = null;
		return bRet;
	}
}
