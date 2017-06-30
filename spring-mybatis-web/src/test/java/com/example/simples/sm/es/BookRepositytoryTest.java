package com.example.simples.sm.es;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.simples.sm.BaseTest;
import com.example.simples.sm.es.document.Book;
import com.example.simples.sm.es.repositytory.BookRepositytory;

public class BookRepositytoryTest extends BaseTest {

	@Autowired
	private BookRepositytory bookRepositytory;

	@Test
	public void shouldIndexSingleBookEntity() {

		Book book = new Book();
		book.setId(123456L);
		book.setName("Spring Data Elasticsearch");
		book.setPrice(13L);
		// book.setVersion(System.currentTimeMillis());
		bookRepositytory.save(book);
		// lets try to search same record in elasticsearch
		Book indexedBook = bookRepositytory.findOne(book.getId());
		assertThat(indexedBook, is(notNullValue()));
		assertThat(indexedBook.getId(), is(book.getId()));
	}

	@Test
	public void countBook() {
		long count = bookRepositytory.count();
		assertThat(count, is(2L));
	}

}
