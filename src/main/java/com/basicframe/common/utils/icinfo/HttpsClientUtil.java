package com.basicframe.common.utils.icinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.Consts;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.protocol.https.Handler;

public class HttpsClientUtil {
    private static final String CONTENT_CHARSET = "UTF-8";
    private static final int CONNECTION_TIMEOUT = 30000;
    private static final int READ_DATA_TIMEOUT = 30000;

    public HttpsClientUtil() {
    }

    private static CloseableHttpClient generateSSLHttpClient() throws Exception {
        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial((KeyStore) null, new TrustSelfSignedStrategy());
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    public static String doHttpPost(String requestURL, Map<String, Object> paraM) throws Exception {
        String postResult = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(requestURL);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();
        httpPost.setConfig(requestConfig);
        ArrayList nvps = new ArrayList();
        Iterator i$ = paraM.entrySet().iterator();

        while (i$.hasNext()) {
            Map.Entry entry = (Map.Entry) i$.next();
            nvps.add(new BasicNameValuePair((String) entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        response = generateSSLHttpClient().execute(httpPost);
        postResult = EntityUtils.toString(response.getEntity(), "UTF-8");
        if (response != null) {
            EntityUtils.consume(response.getEntity());
            response.close();
        }

        return postResult;
    }

    public static String doHttpGet(String requestURL) throws Exception {
        String result = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(requestURL);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();
        httpGet.setConfig(requestConfig);
        response = generateSSLHttpClient().execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        if (response != null) {
            EntityUtils.consume(response.getEntity());
            response.close();
        }

        return result;
    }

    public static String postRequest(String url, Map<String, String> params, Map<String, String> cookies) {
        HttpsURLConnection connection = null;

        String cookie1;
        try {
            SSLContext e = SSLContext.getInstance("SSL");
            e.init((KeyManager[]) null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
            URL httpsUrl1 = new URL((URL) null, url, new Handler());
            connection = (HttpsURLConnection) httpsUrl1.openConnection();
            connection.setSSLSocketFactory(e.getSocketFactory());
            connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            StringBuffer e1 = new StringBuffer();
            if (params != null && params.size() > 0) {
                Iterator osw = params.entrySet().iterator();

                while (osw.hasNext()) {
                    Entry code = (Entry) osw.next();
                    if (!IcinfoStringUtil.isBlank((CharSequence) code.getValue())) {
                        if (e1.length() > 0) {
                            e1.append("&");
                        }

                        e1.append(URLEncoder.encode((String) code.getValue(), "UTF-8"));
                        e1.append("=");
                        e1.append(URLEncoder.encode((String) code.getValue(), "UTF-8"));
                    }
                }
            }

            connection.setRequestProperty("Content-Length", String.valueOf(e1.length()));
            if (cookies != null && cookies.size() > 0) {
                StringBuffer osw1 = new StringBuffer();
                Iterator code1 = cookies.entrySet().iterator();

                while (code1.hasNext()) {
                    Map.Entry cookie = (Map.Entry) code1.next();
                    if (!IcinfoStringUtil.isBlank((CharSequence) cookie.getValue())) {
                        if (osw1.length() > 0) {
                            osw1.append(";");
                        }

                        osw1.append(URLEncoder.encode((String) cookie.getKey(), "UTF-8"));
                        osw1.append("=");
                        osw1.append(URLEncoder.encode((String) cookie.getValue(), "UTF-8"));
                    }
                }

                connection.setRequestProperty("Cookie", osw1.toString());
            }

            connection.setRequestProperty("User-Agent", "Icinfo framework");
            connection.connect();
            OutputStreamWriter osw2 = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            osw2.write(e1.toString());
            osw2.flush();
            osw2.close();
            int code2 = connection.getResponseCode();
            if (code2 != 200) {
                cookie1 = readInputStream(connection.getErrorStream());
                return cookie1;
            }

            cookie1 = readInputStream(connection.getInputStream());
        } catch (Exception var20) {
            var20.printStackTrace();
            String httpsUrl = "";
            return httpsUrl;
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception var19) {
                    ;
                }
            }

        }

        return cookie1;
    }

    private static String readInputStream(InputStream stream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }
}
