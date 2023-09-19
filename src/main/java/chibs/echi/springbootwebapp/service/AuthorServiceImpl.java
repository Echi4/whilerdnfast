package chibs.echi.springbootwebapp.service;

import chibs.echi.springbootwebapp.domain.Author;
import chibs.echi.springbootwebapp.repository.AuthorRepository;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
