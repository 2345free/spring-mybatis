package com.example.simples.sm.web.es;

import com.example.simples.sm.web.es.document.Book;
import com.example.simples.sm.web.es.repositytory.BookRepositytory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/application-elasticsearch.xml")
public class BookRepositytoryTest {

    @Autowired
    private BookRepositytory bookRepositytory;

    @Test
    public void shouldIndexSingleBookEntity() {

        Book book = new Book();
        book.setId(123456L);
        book.setName("Spring Data Elasticsearch");
        book.setPrice(13L);
        // book.setVersion(System.currentTimeMillis());
        this.bookRepositytory.save(book);
        // lets try to search same record in elasticsearch
        Book indexedBook = this.bookRepositytory.findOne(book.getId());
        assertThat(indexedBook, is(notNullValue()));
        assertThat(indexedBook.getId(), is(book.getId()));
    }

    @Test
    public void countBook() {
        long count = this.bookRepositytory.count();
        assertThat(count, is(1L));
    }

}
