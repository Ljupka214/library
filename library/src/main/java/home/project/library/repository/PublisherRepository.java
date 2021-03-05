package home.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.project.library.domain.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
