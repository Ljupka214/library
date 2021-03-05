package home.project.library.dto;

import java.util.HashSet;
import java.util.Set;

import home.project.library.domain.*;
import lombok.Data;

@Data
public class BookDto {

	private Integer id;

	private String title;


	private Publisher publisher;


	private Category category;

	
	private Set<Author> bookAuthors = new HashSet<>();


	private Integer numberOfPages;


	private String language;


	private Integer publicationYear;


	private String format;

}
