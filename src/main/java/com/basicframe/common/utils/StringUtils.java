package com.basicframe.common.utils;

import com.basicframe.common.utils.icinfo.IcinfoStringUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/23.
 */
public class StringUtils extends IcinfoStringUtil {


    /**
     * 数组转成字符串
     *
     * @param arrObject  数组对象
     * @param separator  分隔符
     * @return
     */
    public static String arrayToString(Object[] arrObject, String separator) {
        // 默认为","号
        if (separator == null || separator.equals(""))
            separator = ",";

        String returnStrValue = "";

        if (arrObject != null) {
            for (Object object : arrObject) {
                if (returnStrValue.equals("")) {
                    returnStrValue = String.valueOf(object);
                } else {
                    returnStrValue = returnStrValue + separator
                            + String.valueOf(object);
                }
            }
        }
        return returnStrValue;
    }


    /**
     * 字符串长度达到一定长度截取固定长度的子串
     *
     * @param str 截取原始字符串
     * @param max 字符串最大长度校验
     * @param sub 需要截取的子串长度
     * @return 截取后的子串
     */
    public static String subString(String str, int max, int sub) {
        // 为空，则直接返回
        if (isBlank(str)) {
            return str;
        }

        // 小于指定最大长度，直接返回
        if (str.length() <= max) {
            return str;
        }

        // 截取固定长度子串
        return substring(str, 0, sub >= str.length() ? str.length() : sub);
    }

    /**
     * 拼接url
     *
     * @param url url
     * @return 拼接后的url
     */
    public static String jointUrl(String url) {
        if (url.indexOf("?") < 0) {
            url = IcinfoStringUtil.assemblyString(url, "?_t=" + new Date().getTime());
        }
        return url;
    }
}
