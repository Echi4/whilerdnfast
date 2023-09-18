package chibs.echi.springbootwebapp.repository;

import chibs.echi.springbootwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
