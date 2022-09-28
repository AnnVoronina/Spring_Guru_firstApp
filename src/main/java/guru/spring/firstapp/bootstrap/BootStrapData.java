package guru.spring.firstapp.bootstrap;

import guru.spring.firstapp.domain.Author;
import guru.spring.firstapp.domain.Book;
import guru.spring.firstapp.domain.Publisher;
import guru.spring.firstapp.repository.AuthorRepository;
import guru.spring.firstapp.repository.BookRepository;
import guru.spring.firstapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("ABC Publishing");
        publisher.setCity("SPb");
        publisher.setState("Lenengrad Region");
        publisherRepository.save(publisher);


        Author puchkin = new Author("Alex", "Pushkin");
        authorRepository.save(puchkin);
        Author gogol = new Author("Nic", "Gogol");
        authorRepository.save(gogol);


        Book fish = new Book("Fish", "12345");
        Book bulba = new Book("Taras Bulba", "1234");
        bookRepository.save(fish);
        bookRepository.save(bulba);

        fish.getAuthors().add(puchkin);
        puchkin.getBooks().add(fish);
        fish.setPublisher(publisher);
        publisher.getBooks().add(fish);

        bulba.getAuthors().add(gogol);
        gogol.getBooks().add(bulba);
        publisher.getBooks().add(bulba);
        publisherRepository.save(publisher);


        System.out.println("App start");
        System.out.println("Number of author - " + authorRepository.count() + "\n"
                + "Number of book - " + bookRepository.count() +
                "\nPublisher have books - " + publisherRepository.count());

    }
}
