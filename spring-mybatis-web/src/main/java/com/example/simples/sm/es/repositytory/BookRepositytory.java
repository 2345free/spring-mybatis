package com.example.simples.sm.es.repositytory;

import com.example.simples.sm.es.document.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepositytory extends ElasticsearchRepository<Book, Long> {

}
