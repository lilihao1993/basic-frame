package com.basicframe.common.utils;


import com.basicframe.common.utils.icinfo.IcinfoStringUtil;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 加密工具
 */
public class EncryptUtils extends Md5Utils {

    /**
     * Base64 编码
     *
     * @param str     源信息
     * @param charset 编码字符集
     * @return 编码结果
     * @throws UnsupportedEncodingException
     */
    public static String base64Encoder(String str, String charset) throws UnsupportedEncodingException {
        if (IcinfoStringUtil.isEmpty(charset)) {
            charset = "utf-8";
        }
        return new String(Base64.encodeBase64(str.getBytes(charset)), charset);
    }

    /**
     * Base64 解码
     *
     * @param str     源信息
     * @param charset 解码字符集
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Decoder(String str, String charset) throws UnsupportedEncodingException {
        if (IcinfoStringUtil.isEmpty(charset)) {
            charset = "utf-8";
        }
        return new String(Base64.decodeBase64(str), charset);
    }
}