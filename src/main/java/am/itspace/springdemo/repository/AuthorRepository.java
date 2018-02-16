package am.itspace.springdemo.repository;

import am.itspace.springdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
