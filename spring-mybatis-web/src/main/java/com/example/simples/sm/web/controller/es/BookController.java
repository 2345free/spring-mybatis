package com.example.simples.sm.web.controller.es;

import com.example.simples.sm.web.es.document.Book;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RestController
@RequestMapping("/es/book")
public class BookController {

    @Autowired
    public TransportClient transportClient;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/list")
    public ResponseEntity list() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .build();

        AggregatedPage<Book> books = elasticsearchTemplate.queryForPage(searchQuery, Book.class);
        return new ResponseEntity(books.getContent(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable String id) {
        GetResponse response = transportClient.prepareGet("book", "novel", id).get();
        return new ResponseEntity(response.getSource(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        DeleteResponse response = transportClient.prepareDelete("book", "novel", id).get();
        return new ResponseEntity(response.getResult(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Book book) {
        IndexResponse response = transportClient.prepareIndex().setSource(book).get();
        return new ResponseEntity(response.getResult(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Book book) {
        UpdateResponse response = transportClient.prepareUpdate().setDoc(book).get();
        return new ResponseEntity(response.getResult(), HttpStatus.OK);
    }

}
