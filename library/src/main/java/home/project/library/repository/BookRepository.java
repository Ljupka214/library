package home.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.project.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
