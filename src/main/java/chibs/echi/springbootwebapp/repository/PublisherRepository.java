package chibs.echi.springbootwebapp.repository;

import chibs.echi.springbootwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
