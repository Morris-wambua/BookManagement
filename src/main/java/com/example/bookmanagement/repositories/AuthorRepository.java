package com.example.bookmanagement.repositories;

import com.example.bookmanagement.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {

}
