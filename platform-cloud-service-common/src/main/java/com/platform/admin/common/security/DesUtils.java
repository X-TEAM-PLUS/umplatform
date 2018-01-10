package com.platform.admin.common.security;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密解密
 *
 * @author Yankun
 */
public final class DesUtils {
    private final static String DES = "DES";

    /**
     * 初始化密钥
     *
     * @return byte[] 密钥
     * @throws Exception
     */
    public static String initSecretKey(int keyLength) {
        try {
            if (keyLength % 8 != 0) {
                keyLength = keyLength / 8 * 8;
            }
            //返回生成指定算法的秘密密钥的 KeyGenerator 对象
            KeyGenerator kg = KeyGenerator.getInstance(DES);
            //初始化此密钥生成器，使其具有确定的密钥大小
            kg.init(keyLength);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new String(secretKey.getEncoded(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "@yankun!";
    }

    /**
     * <p>
     * <b>功能描述: 加密</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param src
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    /**
     * <p>
     * <b>功能描述: 解密</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param src
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    /**
     * <p>
     * <b>功能描述: 二行制转字符串</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    /**
     * <p>
     * <b>功能描述: </b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param b
     * @return
     */
    private static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 解密
     *
     * @param key
     * @param data
     * @return
     */
    public static String decrypt(String key, String data) {
        try {
            if(data!=null)
            return new String(
                    decrypt(hex2byte(data.getBytes()), key.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param key
     * @param data
     * @return
     */
    public static String encrypt(String key, String data) {
        try {
            return byte2hex(encrypt(data.getBytes(), key.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
