package com.example.simples.sm.es.repositytory;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.simples.sm.es.document.Book;

public interface BookRepositytory extends ElasticsearchRepository<Book, Long> {

}
