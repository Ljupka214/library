package home.project.library.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import home.project.library.domain.Publisher;
import home.project.library.infrastucture.exception.ResourceNotFoundException;
import home.project.library.repository.PublisherRepository;
import home.project.library.service.GenericService;

@Service
@Slf4j
@Transactional
public class PublisherServiceImpl implements GenericService<Publisher, Integer> {
	@Autowired
	public PublisherRepository repository;

	@Override
	public Publisher findById(Integer id) {
		Publisher entity = repository.findById(id).orElseThrow(() -> {
			log.error("Resource Publisher with id {} is not found", id);
			return new ResourceNotFoundException("Resource Publisher not found");
		});

		return entity;
	}

	@Override
	public List<Publisher> findAll() {
		log.debug("Execute findAll Publisher");
		return repository.findAll();
	}

	@Override
	public Publisher create(Publisher entity) {
		log.debug("Execute create Publisher with parameters ", entity);
		Publisher persistedEntity = repository.save(entity);
		return persistedEntity;
	}

	@Override
	public Publisher update(Integer id, Publisher entity) {
		log.debug("Execute update Publisher with parameters {}", entity);
		Publisher persistedEntity = findById(id);

		// TODO use mapper
		persistedEntity.setName(entity.getName());
		return repository.saveAndFlush(persistedEntity);
	}

	@Override
	public void deleteById(Integer id) {
		log.debug("Execute deleteById Publisher with parameters {}", id);
		repository.deleteById(id);
	}

}