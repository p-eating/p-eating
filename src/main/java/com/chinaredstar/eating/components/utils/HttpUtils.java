package com.chinaredstar.eating.components.utils;

import com.chinaredstar.perseus.utils.JsonUtil;

import javax.net.ssl.SSLException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class HttpUtils {

    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();

    public static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if (fileMap != null && fileMap.size() > 0) {
            Iterator fileIter = fileMap.entrySet().iterator();
            while (fileIter.hasNext()) {
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try {
            if (code == 200) {
                ins = conne.getInputStream();
            } else {
                ins = conne.getErrorStream();
            }
        } catch (SSLException e) {
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while ((len = ins.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }

    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }

    private static String encode(String value) throws Exception {
        return URLEncoder.encode(value, "UTF-8");
    }

    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1) {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }



    /**
     * post 请求，返回指定对象
     *
     * @param url
     * @param params
     * @param clazz
     * @param <K>
     * @return
     * @throws Exception
     */
    public static <K> K postBean(String url, Object params, Class<K> clazz) throws Exception {
        return postBean(url, params, null, clazz);
    }

    /**
     * post 请求，返回指定对象
     *
     * @param url
     * @param params
     * @param fileMap
     * @param clazz
     * @param <K>
     * @return
     * @throws Exception
     */
    public static <K> K postBean(String url, Object params, HashMap<String, byte[]> fileMap, Class<K> clazz) throws Exception {
        String response = postString(url, params, fileMap);
        return (K) JsonUtil.fromJson(response, clazz);
    }

    /**
     * post请求，返回字符
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String postString(String url, Object params) throws Exception {
        return postString(url, params, null);
    }

    /**
     * post请求，返回字符
     *
     * @param url
     * @param params
     * @param fileMap
     * @return
     * @throws Exception
     */
    public static String postString(String url, Object params, HashMap<String, byte[]> fileMap) throws Exception {
        byte[] data = postBytes(url, params, fileMap);
        return new String(data);
    }


    /**
     * post请求，获取返回的字节
     *
     * @param url
     * @param params
     * @param fileMap
     * @return
     * @throws Exception
     */
    public static byte[] postBytes(String url, Object params, HashMap<String, byte[]> fileMap) throws Exception {
        HashMap<String, String> param = (HashMap<String, String>) JsonUtil.fromJson(JsonUtil.toJson(params, false), HashMap.class);

        return HttpUtils.post(url, param, fileMap);
    }




    public static void main(String[] args) throws Exception {

        File file = new File("你的本地图片路径");
        byte[] buff = getBytesFromFile(file);
        String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", "你的KEY");
        map.put("api_secret", "你的SECRET");
        map.put("return_landmark", "1");
        map.put("return_attributes", "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
        byteMap.put("image_file", buff);
        try {
            byte[] bacd = post(url, map, byteMap);
            String str = new String(bacd);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
