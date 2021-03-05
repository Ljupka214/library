package home.project.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.project.library.domain.Author;
import home.project.library.infrastucture.Endpoints;
import home.project.library.service.impl.AuthorServiceImpl;

@RestController
@RequestMapping(Endpoints.AUTHORS)
public class AuthorController {

	@Autowired
	private AuthorServiceImpl service;

	@GetMapping("/{id}")
	public Author findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Author> findAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Author create(@RequestBody Author entity) {
		return service.create(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Author update(@PathVariable(value = "id") Integer id, @RequestBody Author entity) {
		return service.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id") Integer id) {
		service.deleteById(id);
	}
}
