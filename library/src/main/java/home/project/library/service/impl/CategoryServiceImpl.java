package home.project.library.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import home.project.library.domain.Category;
import home.project.library.infrastucture.exception.ResourceNotFoundException;
import home.project.library.repository.CategoryRepository;
import home.project.library.service.GenericService;

@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements GenericService<Category, Integer> {

	@Autowired
	public CategoryRepository repository;

	@Override
	public Category findById(Integer id) {
		Category entity = repository.findById(id).orElseThrow(() -> {
			log.error("Resource Category with id {} is not found", id);
			return new ResourceNotFoundException("Resource Category not found");
		});

		return entity;
	}

	@Override
	public List<Category> findAll() {
		log.debug("Execute findAll Category");
		return repository.findAll();
	}

	@Override
	public Category create(Category entity) {
		log.debug("Execute create Category with parameters ", entity);
		Category persistedEntity = repository.save(entity);
		return persistedEntity;
	}

	@Override
	public Category update(Integer id, Category entity) {
		log.debug("Execute update Category with parameters {}", entity);
		Category persistedEntity = findById(id);

		// TODO use mapper
		persistedEntity.setName(entity.getName());
		return repository.saveAndFlush(persistedEntity);
	}

	@Override
	public void deleteById(Integer id) {
		log.debug("Execute deleteById Category with parameters {}", id);
		repository.deleteById(id);
	}

}
