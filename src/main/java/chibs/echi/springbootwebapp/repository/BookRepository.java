package chibs.echi.springbootwebapp.repository;

import chibs.echi.springbootwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
}
