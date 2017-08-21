package com.basicframe.common.utils;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtils extends org.springframework.util.StringUtils {
    public StringUtils() {
    }

    public static String maptToUrlParam(Map<String, Object> paramMap, String encode) throws Exception {
        String params = "";
        Set paramKey = paramMap.keySet();
        Iterator it = paramKey.iterator();

        while (it.hasNext()) {
            String tempKey = (String) it.next();
            String tempValue = paramMap.get(tempKey) != null ? URLEncoder.encode(paramMap.get(tempKey).toString(), encode) : "";
            if (params.equals("")) {
                params = tempKey + "=" + tempValue;
            } else {
                params = params + "&" + tempKey + "=" + tempValue;
            }
        }

        return params;
    }

    /**
     * 数组转成字符串
     *
     * @param arrObject 数组对象
     * @param separator 分隔符
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

    public static String assemblyString(String... strParam) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] arr$ = strParam;
        int len$ = strParam.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            String string = arr$[i$];
            stringBuffer.append(string);
        }

        return stringBuffer.toString();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static boolean isNumeric(Object obj) {
        if (obj == null) {
            return false;
        } else {
            char[] chars = obj.toString().toCharArray();
            int length = chars.length;
            if (length < 1) {
                return false;
            } else {
                int i = 0;
                if (length > 1 && chars[0] == 45) {
                    i = 1;
                }

                while (i < length) {
                    if (!Character.isDigit(chars[i])) {
                        return false;
                    }

                    ++i;
                }

                return true;
            }
        }
    }

    public static String[] replaceDanger(String[] values) {
        if (values == null) {
            return null;
        } else {
            int count = values.length;
            String[] _values = new String[count];

            for (int i = 0; i < count; ++i) {
                _values[i] = replaceDanger(values[i]);
            }

            return _values;
        }
    }

    public static String replaceDanger(String value) {
        if (!isEmpty(value) && isDanger(value)) {
            char[] chars = value.toCharArray();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < chars.length; ++i) {
                char c = chars[i];
                switch (c) {
                    case '\"':
                        sb.append("&quot;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(c);
                }
            }

            return sb.toString();
        } else {
            return value;
        }
    }

    public static String[] escapeDanger(String[] values) {
        if (values == null) {
            return null;
        } else {
            int count = values.length;
            String[] _values = new String[count];

            for (int i = 0; i < count; ++i) {
                _values[i] = escapeDanger(values[i]);
            }

            return _values;
        }
    }

    public static String escapeDanger(String value) {
        return !isEmpty(value) && isDanger(value) ? value.replaceAll("(?<!\\\\)\'", "\\\\\'") : value;
    }

    public static boolean isDanger(String str) {
        return isEmpty(str) ? false : Pattern.compile("[\'|\"|\\|<|>]").matcher(str).find();
    }
}
