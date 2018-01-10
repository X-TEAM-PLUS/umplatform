package com.platform.admin.common.security;

import com.platform.admin.common.util.Base64Utils;

import javax.crypto.Cipher;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.*;

public final class RSAUtils {
    private static final String RSA_ALGORITHM = "RSA";

    /**
     * 生成RSA密钥对
     *
     * @return 密钥对
     * @throws NoSuchAlgorithmException
     * @since 1.0
     */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyGen.initialize(1024);
        return keyGen.generateKeyPair();
    }

    /**
     * 生成公钥私钥文件
     *
     * @param publicKeyPath
     * @param privateKeyPath
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void buildKeyPairGenerator(String publicKeyPath, String privateKeyPath) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        //创建密钥对生成器，指定加密和解密算法为RSA
        KeyPair keyPair = generateKeyPair();
        //获取公钥
        PublicKey publicKey = keyPair.getPublic();
        //获取私钥
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("public key len:" + publicKey.getEncoded().length);
        System.out.println("public key:" + publicKey.toString());
        System.out.println("private key len:" + privateKey.getEncoded().length);
        System.out.println("private key:" + privateKey.toString());

        //保存公钥到文件
        FileOutputStream f1 = new FileOutputStream(publicKeyPath);
        ObjectOutputStream b1 = new ObjectOutputStream(f1);
        b1.writeObject(publicKey);
        b1.close();
        f1.close();
        //保存私钥到文件
        FileOutputStream f2 = new FileOutputStream(privateKeyPath);
        ObjectOutputStream b2 = new ObjectOutputStream(f2);
        b2.writeObject(privateKey);
        b2.close();
        f2.close();


    }

    /**
     * 加密
     *
     * @param key
     * @param str
     * @return
     * @throws Exception
     */
    public static String encrypt(Key key, String str) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(str.getBytes("UTF8"));
        String s = new String(bytes);
        return new String(Base64Utils.decode(s));
    }

    /**
     * 加密
     *
     * @param keyFileName
     * @param str
     * @return
     * @throws Exception
     */
    public static String encrypt(String keyFileName, String str) throws Exception {
        java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream(keyFileName));
        Key key = (Key) in.readObject();
        in.close();

        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64Utils.encode(cipher.doFinal(str.getBytes("UTF8")));
    }


    /**
     * 解密
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(Key key, String data) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64Utils.decode(data)));
    }


    /**
     * 解密
     *
     * @param keyFileName
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String keyFileName, String data) throws Exception {
        java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream(keyFileName));
        Key key = (Key) in.readObject();
        in.close();

        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(getFromBASE64(data)));
    }

    /**
     * base64编码
     *
     * @param b
     * @return
     */
    public static String getBASE64(byte[] b) {
        String s = null;
        if (b != null) {
            s = Base64Utils.encode(b);
        }
        return s;
    }

    /**
     * 将base64还原
     *
     * @param s
     * @return
     */
    public static byte[] getFromBASE64(String s) {
        byte[] b = null;
        if (s != null) {

            try {
                b = Base64Utils.decode(s);
                return b;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }
}
