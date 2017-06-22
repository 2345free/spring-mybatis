package com.example.simples.sm.protobuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import com.example.simples.sm.BaseTest;
import com.example.tutorial.AddressBookProtos.Person;

public class Tests extends BaseTest {
	

	@Test
    public void testWrite() throws IOException {
        
    }
	
	public static void main(String[] args) throws Exception {
		String baseUri="http://localhost";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(baseUri+"/proto/w");

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
        httpPost.addHeader("Content-Type","application/x-protobuf");
        httpPost.addHeader("Accept", "application/x-protobuf");
        httpPost.setEntity(inputStreamEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();

            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            entity.writeTo(buf);
            System.out.println(new String(buf.toByteArray())+"#################");
            Person person2 = Person.parseFrom(buf.toByteArray());
            System.out.println(person2);
        } finally {
            response.close();
        }
	}

}
