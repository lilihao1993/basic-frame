package com.basicframe.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/21.
 */
public class Md5Utils {
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public Md5Utils() {
    }

    /** @deprecated */
    @Deprecated
    public static String GetMD5Code(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] byteArray = str.getBytes("UTF-8");
        return md5(byteArray);
    }

    public static String md5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] byteArray = str.getBytes("UTF-8");
        return md5(byteArray);
    }

    public static String md5(byte[] bytes) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md5.digest(bytes);
        StringBuffer sb = new StringBuffer();
        byte[] arr$ = md5Bytes;
        int len$ = md5Bytes.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            byte _byte = arr$[i$];
            sb.append(hexDigits[_byte >>> 4 & 15]);
            sb.append(hexDigits[_byte & 15]);
        }

        return sb.toString();
    }
}
