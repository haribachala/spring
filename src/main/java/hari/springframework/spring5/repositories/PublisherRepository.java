package hari.springframework.spring5.repositories;

import hari.springframework.spring5.model.Book;
import hari.springframework.spring5.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
