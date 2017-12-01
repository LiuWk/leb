//package util;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Base64;
//
///**
// * @author Siyuan.Shi
// * @date 2013/11/14 3DES 加密、解密工具类
// */
//public class Des3Util {
//	// 定义 加密算法,可用 DES,DESede,Blowfish
//	public static final String Algorithm = "DESede";
//	// 24字节的密钥
//	// 测试密钥
////	public static final byte[] keyBytes = CommonManager.des3key;
////	// 线上密钥
//	public static final byte[] keyBytes = { 
//		0x10, 0x42, 0x3F, 0x38, 0x38, 0x10, 0x30, 0x36,
//		0x38, 0x15, 0x39, 0x41, (byte) 0xCB, (byte) 0xD1, 0x29, 0x36,
//		0x10, 0x42, 0x3F, 0x38, 0x38, 0x10, 0x30, 0x36,
//	};
//	
//	public final static byte[] encrypt(byte[] src) {
//		try {
//			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			c1.init(Cipher.ENCRYPT_MODE, deskey);
//			return Base64.encodeBase64(c1.doFinal(src));
//		} catch (java.security.NoSuchAlgorithmException e1) {
//			e1.printStackTrace();
//		} catch (javax.crypto.NoSuchPaddingException e2) {
//			e2.printStackTrace();
//		} catch (java.lang.Exception e3) {
//			e3.printStackTrace();
//		}
//		return src;
//	}
//
//	public final static byte[] decrypt(byte[] src) {
//		try {
//			// 生成密钥
//			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
//			// 解密
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			c1.init(Cipher.DECRYPT_MODE, deskey);
//			return c1.doFinal(Base64.decodeBase64(src));
//		} catch (java.security.NoSuchAlgorithmException e1) {
//			e1.printStackTrace();
//		} catch (javax.crypto.NoSuchPaddingException e2) {
//			e2.printStackTrace();
//		} catch (java.lang.Exception e3) {
//			e3.printStackTrace();
//		}
//		return src;
//	}
//
//	// 转换成十六进制字符串
//	public static String byte2hex(byte[] b) {
//		String hs = "";
//		String stmp = "";
//		for (int n = 0; n < b.length; n++) {
//			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
//			if (stmp.length() == 1)
//				hs += "0" + stmp;
//			else
//				hs += stmp;
//		}
//		return hs.toUpperCase();
//	}
//
//	public static void main(String[] args) throws Exception {
//		// 添加新安全算法,如果用JCE就要把它添加进去
////		Security.addProvider(new com.sun.crypto.provider.SunJCE());
////		String szSrc = "This is a 3DES test. 测试";
//		String szSrc = "240707|123|20140325100442|1|130102197401290336|";
//		System.out.println("加密前的字符串:" + szSrc);
//		byte[] encoded = encrypt(szSrc.getBytes());
//		System.out.println("加密后的字符串:" + new String(encoded));
//		byte[] srcBytes = decrypt(encoded);
//		System.out.println("解密后的字符串:" + (new String(srcBytes)));
//	}
//}
