package chibs.echi.springbootwebapp.bootstrap;

import chibs.echi.springbootwebapp.domain.Author;
import chibs.echi.springbootwebapp.domain.Book;
import chibs.echi.springbootwebapp.domain.Publisher;
import chibs.echi.springbootwebapp.repository.AuthorRepository;
import chibs.echi.springbootwebapp.repository.BookRepository;
import chibs.echi.springbootwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        //Creating and saving the publisher
        Publisher publisher = new Publisher();
        publisher.setAddress("435 Kwetu Street");
        publisher.setCity("Uptown");
        publisher.setPublisherName("Chibs & Readers Inc.");
        publisher.setState("Drawers");
        publisher.setZipcode("32301");
        publisher = publisherRepository.save(publisher);

        //Creating authors
        Author mary = new Author();
        mary.setFirstName("Mary");
        mary.setLastName("Shelley");

        Author benjamin = new Author();
        benjamin.setFirstName("Benjamin");
        benjamin.setLastName("Graham");

        //Creating books and setting the publisher
        Book frs = new Book();
        frs.setTitle("Frankenstein");
        frs.setIsbn("748320398843");
        frs.setPublisher(publisher);

        Book tii = new Book();
        tii.setTitle("The Intelligent Investor");
        tii.setIsbn("978621392833");
        tii.setPublisher(publisher);

        //Establishing the relationship(works both ways back and forth)
        mary.getBooks().add(frs);
        benjamin.getBooks().add(tii);
        tii.getAuthors().add(benjamin);
        frs.getAuthors().add(mary);

        //Saving authors and books into their respective tables...Its advised to catch the returned object
        mary = authorRepository.save(mary);
        benjamin = authorRepository.save(benjamin);
        frs = bookRepository.save(frs);
        tii = bookRepository.save(tii);
    }
}
