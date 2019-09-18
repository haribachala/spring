package hari.springframework.spring5.repositories;

import hari.springframework.spring5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
