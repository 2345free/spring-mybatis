package com.example.simples.sm.web.es.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * @author tianyi
 */
@Data
@Document(indexName = "ecs.book", type = "book")
public class Book {
    @Id
    private Long id;

    private String name;

    private Long price;

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
