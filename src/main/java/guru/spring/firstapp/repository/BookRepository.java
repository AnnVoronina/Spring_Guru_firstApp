package guru.spring.firstapp.repository;


import guru.spring.firstapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
