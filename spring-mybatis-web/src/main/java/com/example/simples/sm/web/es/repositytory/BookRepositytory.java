package com.example.simples.sm.web.es.repositytory;

import com.example.simples.sm.web.es.document.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepositytory extends ElasticsearchRepository<Book, Long> {

}
