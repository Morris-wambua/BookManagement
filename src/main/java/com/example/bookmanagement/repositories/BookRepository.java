package com.example.bookmanagement.repositories;

import com.example.bookmanagement.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
}
