package com.example.simples.sm.web.protobuf;

import com.example.simples.sm.entity.proto.AddressBookProtos.Person;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Tests {


    public static void main(String[] args) throws Exception {
        String baseUri = "http://localhost:8080";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(baseUri + "/proto/w");

        //构造
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(Person.PhoneType.HOME))
                        .build();


        ByteArrayInputStream inputStream = new ByteArrayInputStream(john.toByteArray());
        InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);

        // 这两行很重要的，是告诉springmvc客户端请求和响应的类型，指定application/x-protobuf类型,spring会用ProtobufHttpMessageConverter类来解析请求和响应的实体
        httpPost.addHeader("Content-Type", "application/x-protobuf");
        httpPost.addHeader("Accept", "application/x-protobuf");
        httpPost.setEntity(inputStreamEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();

            Person person = Person.parseFrom(entity.getContent());
            System.out.println(person);
        } finally {
            response.close();
        }
    }

    @Test
    public void testWrite() throws IOException {

    }

}
