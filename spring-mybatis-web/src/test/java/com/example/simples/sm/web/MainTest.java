package com.example.simples.sm.web;

import com.example.simples.sm.common.http.PoolingHttpClient;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws Exception {

        testPoolingHttpClient();

    }

    public static void testPoolingHttpClient() throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = PoolingHttpClient.getHttpClient();
        HttpGet httpGet = new HttpGet("http://baidu.com");
        CloseableHttpResponse response1 = httpClient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            InputStream inputStream = entity1.getContent();
            String str1 = IOUtils.toString(inputStream);
            System.out.println(str1);
            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }

        HttpPost httpPost = new HttpPost("http://baidu.com");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpClient.execute(httpPost);

        System.out.println("-------------------------------------------");

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            InputStream inputStream = entity2.getContent();
            String str2 = IOUtils.toString(inputStream);
            System.out.println(str2);
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }

    }

}
