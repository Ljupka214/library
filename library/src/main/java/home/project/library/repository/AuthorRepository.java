package home.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.project.library.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
