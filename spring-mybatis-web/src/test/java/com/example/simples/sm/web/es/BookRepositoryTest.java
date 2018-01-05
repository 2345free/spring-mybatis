package com.example.simples.sm.web.es;

import com.example.simples.sm.web.es.document.Book;
import com.example.simples.sm.web.es.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/bak-application-elasticsearch.xml")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldIndexSingleBookEntity() {

        Book book = new Book();
        book.setWordCount(10000L);
        book.setTitle("Spring Data Elasticsearch");
        book.setAuthor("spring team");
        book.setPublishDate(new Date());
        // book.setVersion(System.currentTimeMillis());
        this.bookRepository.save(book);
        // lets try to search same record in elasticsearch
        Book indexedBook = this.bookRepository.findById(book.getId()).get();
        assertThat(indexedBook, is(notNullValue()));
        assertThat(indexedBook.getId(), is(book.getId()));
    }

    @Test
    public void countBook() {
        long count = this.bookRepository.count();
        assertThat(count, is(1L));
    }

}
