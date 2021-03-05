package home.project.library.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import home.project.library.domain.Author;
import home.project.library.infrastucture.exception.ResourceNotFoundException;
import home.project.library.repository.AuthorRepository;
import home.project.library.service.GenericService;

@Service
@Slf4j
@Transactional
public class AuthorServiceImpl implements GenericService<Author, Integer> {
	@Autowired
	public AuthorRepository repository;

	@Override
	public Author findById(Integer id) {
		Author entity = repository.findById(id).orElseThrow(() -> {
			log.error("Resource Author with id {} is not found", id);
			return new ResourceNotFoundException("Resource Author not found");
		});

		return entity;
	}

	@Override
	public List<Author> findAll() {
		log.debug("Execute findAll Author");
		return repository.findAll();
	}

	@Override
	public Author create(Author entity) {
		log.debug("Execute create Author with parameters ", entity);
		Author persistedEntity = repository.save(entity);
		return persistedEntity;
	}

	@Override
	public Author update(Integer id, Author entity) {
		log.debug("Execute update Author with parameters {}", entity);
		Author persistedEntity = findById(id);

		// TODO use mapper
		persistedEntity.setName(entity.getName());
		return repository.saveAndFlush(persistedEntity);
	}

	@Override
	public void deleteById(Integer id) {
		log.debug("Execute deleteById Author with parameters {}", id);
		repository.deleteById(id);
	}

}
