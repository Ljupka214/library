package home.project.library.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import home.project.library.domain.Book;
import home.project.library.infrastucture.exception.ResourceNotFoundException;
import home.project.library.repository.BookRepository;
import home.project.library.service.GenericService;

@Service
@Slf4j
@Transactional
public class BookServiceImpl implements GenericService<Book, Integer> {

	@Autowired
	public BookRepository repository;

	@Override
	public Book findById(Integer id) {
		Book entity = repository.findById(id).orElseThrow(() -> {
			log.error("Resource Book with id {} is not found", id);
			return new ResourceNotFoundException("Resource Book not found");
		});

		return entity;
	}

	@Override
	public List<Book> findAll() {
		log.debug("Execute findAll Book");
		return repository.findAll();
	}

	@Override
	public Book create(Book entity) {
		log.debug("Execute create Book with parameters ", entity);
		Book persistedEntity = repository.save(entity);
		return persistedEntity;
	}

	@Override
	public Book update(Integer id, Book entity) {
		log.debug("Execute update Category with parameters {}", entity);
		Book persistedEntity = findById(id);

		// TODO use mapper
		persistedEntity.setTitle(entity.getTitle());
		return repository.saveAndFlush(persistedEntity);
	}

	@Override
	public void deleteById(Integer id) {
		log.debug("Execute deleteById Book with parameters {}", id);
		repository.deleteById(id);
	}

}
