package guru.spring.firstapp.repository;

import guru.spring.firstapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
