package hari.springframework.spring5.bootstrap;


import hari.springframework.spring5.model.Author;
import hari.springframework.spring5.model.Book;
import hari.springframework.spring5.model.Publisher;
import hari.springframework.spring5.repositories.AuthorRepository;
import hari.springframework.spring5.repositories.BookRepository;
import hari.springframework.spring5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("Orelly", "America");
        publisherRepository.save(publisher);

        Author author = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Desin", "178678", publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);

        Author martin = new Author("Martin", "uncle");
        Book cleanCode = new Book("cleanCode", "98080", publisher);
        martin.getBooks().add(cleanCode);
        authorRepository.save(martin);
        bookRepository.save(cleanCode);
    }
}
