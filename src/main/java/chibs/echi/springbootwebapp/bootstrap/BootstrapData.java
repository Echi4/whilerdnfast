package chibs.echi.springbootwebapp.bootstrap;

import chibs.echi.springbootwebapp.domain.Author;
import chibs.echi.springbootwebapp.domain.Book;
import chibs.echi.springbootwebapp.domain.Publisher;
import chibs.echi.springbootwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import chibs.echi.springbootwebapp.repository.AuthorRepository;
import chibs.echi.springbootwebapp.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Creating and Saving publisher
        Publisher publisher = new Publisher();
        publisher.setAddress("435 Kwetu Street");
        publisher.setCity("Uptown");
        publisher.setPublisherName("Chibs & Readers Inc.");
        publisher.setState("Drawers");
        publisherRepository.save(publisher);

        //Creating and Saving books
        Book frankenstein = new Book();
        frankenstein.setTitle("Frankenstein");
        frankenstein.setIsbn("9780486282114");
        frankenstein.setPublisher(publisher);
        bookRepository.save(frankenstein);

        Book tii = new Book();
        tii.setTitle("The Intelligent Investor");
        tii.setIsbn("4638048234414");
        tii.setPublisher(publisher);
        bookRepository.save(tii);

        //Creating and Saving authors
        Author mary = new Author();
        mary.setFirstName("Mary");
        mary.setLastName("Shelley");
        mary.getBooks().add(frankenstein);
        authorRepository.save(mary);

        Author benjamin = new Author();
        benjamin.setFirstName("Benjamin");
        benjamin.setLastName("Graham");
        benjamin.getBooks().add(tii);
        authorRepository.save(benjamin);

        System.out.println("\nOn Ap Start");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
