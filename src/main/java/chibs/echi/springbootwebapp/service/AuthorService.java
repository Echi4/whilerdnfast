package chibs.echi.springbootwebapp.service;

import chibs.echi.springbootwebapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
