package chibs.echi.springbootwebapp.bootstrap;

import chibs.echi.springbootwebapp.domain.Author;
import chibs.echi.springbootwebapp.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import chibs.echi.springbootwebapp.repository.AuthorRepository;
import chibs.echi.springbootwebapp.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book frankenstein = new Book();
        frankenstein.setTitle("Frankenstein");
        frankenstein.setIsbn("9780486282114");
        bookRepository.save(frankenstein);

        Author mary = new Author();
        mary.setFirstName("Mary");
        mary.setLastName("Shelley");
        mary.getBooks().add(frankenstein);
        authorRepository.save(mary);

        Book tii = new Book();
        tii.setTitle("The Intelligent Investor");
        tii.setIsbn("4638048234414");
        bookRepository.save(tii);

        Author benjamin = new Author();
        benjamin.setFirstName("Benjamin");
        benjamin.setLastName("Graham");
        benjamin.getBooks().add(tii);
        authorRepository.save(benjamin);

        System.out.println("\nOn Ap Start");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
