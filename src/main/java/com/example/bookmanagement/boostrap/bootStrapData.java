package com.example.bookmanagement.boostrap;

import com.example.bookmanagement.domain.Author;
import com.example.bookmanagement.domain.Book;
import com.example.bookmanagement.domain.Publisher;
import com.example.bookmanagement.repositories.AuthorRepository;
import com.example.bookmanagement.repositories.BookRepository;
import com.example.bookmanagement.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public bootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author morris=new Author("Morris","Kioko");
        Book ddd=new Book("The river between","234221");
        Publisher pbs= new Publisher("KLB","Kenya");

        wrapData(ddd, pbs, morris, ddd);

        Author purity=new Author("Purity","Gwaro");
        Book afp=new Book("The African Poets","343291");


        wrapData(ddd, pbs, purity, afp);

        System.out.println("Starting Boostrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());
        System.out.println("Number of books per publisher: "+ pbs.getBook().size());
    }
    //Fixme: remove the function
    private void wrapData(Book ddd, Publisher pbs, Author purity, Book afp) {
        purity.getBooks().add(ddd);
        afp.getAuthors().add(purity);

        afp.setPublisher(pbs);
        pbs.getBook().add(afp);

        authorRepository.save(purity);
        bookRepository.save(afp);
        publisherRepository.save(pbs);
    }
}
