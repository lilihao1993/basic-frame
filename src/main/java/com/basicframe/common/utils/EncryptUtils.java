package com.basicframe.common.utils;


import com.basicframe.system.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;

/**
 * 加密工具
 * MD5 盐值加密
 */
public class EncryptUtils extends Md5Utils {

    // 随机数生成器
    private static SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    // 密码hash算法
    private static final String PASSWORD_HASH_ALGORITHM_NAME = "md5";

    // 密码迭代次数
    private static int PASSWORD_HASH_ITERATIONS = 2;

    /**
     * 密码加密
     *
     * @param password 原始密码
     * @param salt     hash盐值
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return new SimpleHash(PASSWORD_HASH_ALGORITHM_NAME, password,
                ByteSource.Util.bytes(salt), PASSWORD_HASH_ITERATIONS)
                .toHex();
    }

    /**
     * admin 用户密码加密
     *
     * @param adminUser 后台用户信息
     */
    public static void adminEncryptPassword(User adminUser) {
        String salt = randomNumberGenerator.nextBytes().toHex();
        adminUser.setEncryptSalt(salt);
        adminUser.setPassword(encryptPassword(adminUser.getPassword(), adminUser.getEncryptSalt()));
    }

    /**
     * md5哈希
     *
     * @param str 源信息
     * @return 哈希值
     */
    public static String md5Encoder(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            char[] strChars = str.toCharArray();
            byte[] strBytes = new byte[strChars.length];
            for (int i = 0; i < strChars.length; i++)
                strBytes[i] = (byte) strChars[i];
            byte[] md5Bytes = md5.digest(strBytes);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(EncryptUtils.encryptPassword("llh1993824", "6206856f28573361ee38126ea0159d32"));
    }
}