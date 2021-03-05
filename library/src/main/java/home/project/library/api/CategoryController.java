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

import home.project.library.domain.Category;
import home.project.library.infrastucture.Endpoints;
import home.project.library.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping(Endpoints.CATEGORIES)
public class CategoryController {

	@Autowired
	private CategoryServiceImpl service;

	@GetMapping("/{id}")
	public Category findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Category> findAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Category create(@RequestBody Category entity) {
		return service.create(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Category update(@PathVariable(value = "id") Integer id, @RequestBody Category entity) {
		return service.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id") Integer id) {
		service.deleteById(id);
	}
}
