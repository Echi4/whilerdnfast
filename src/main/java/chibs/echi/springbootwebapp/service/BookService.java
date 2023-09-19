package chibs.echi.springbootwebapp.service;

import chibs.echi.springbootwebapp.domain.Book;

import java.util.Set;

public interface BookService {
    Iterable<Book> findAll();
}
