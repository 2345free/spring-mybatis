package com.example.simples.sm.web.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author tianyi
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.example.simples.sm.web.es.repository"})
public class EsConfig {

    @Bean
    public TransportClient transportClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "b5c")
                .put("client.transport.sniff", false).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        try {
            InetSocketTransportAddress master = new InetSocketTransportAddress(InetAddress.getByName("cluster"), 9300);
            InetSocketTransportAddress slave1 = new InetSocketTransportAddress(InetAddress.getByName("cluster"), 9301);
            InetSocketTransportAddress slave2 = new InetSocketTransportAddress(InetAddress.getByName("cluster"), 9302);
            client.addTransportAddresses(master, slave1, slave2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        ElasticsearchTemplate template = new ElasticsearchTemplate(transportClient());
        return template;
    }

    @Bean
    public SimpleElasticsearchRepository simpleEsRepos() {
        SimpleElasticsearchRepository repository = new SimpleElasticsearchRepository(elasticsearchTemplate());
        return repository;
    }

}
