package com.example.simples.sm.web.es.repository;

import com.example.simples.sm.web.es.document.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

}
