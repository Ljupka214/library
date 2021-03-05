package home.project.library.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "title", nullable = false, length = 200, unique = true)
	@NonNull
	private String title;

	@ManyToOne
	@JoinColumn(name = "fk_Publisher")
	private Publisher publisher;

	@ManyToOne
	@JoinColumn(name = "fk_Category")
	private Category category;

	@ManyToMany
	@JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> bookAuthors = new HashSet<>();

	@Column(name = "pages")
	private Integer numberOfPages;

	@Column(name = "language", length = 100)
	private String language;

	@Column(name = "year")
	private Integer publicationYear;

	@Column(name = "format", length = 50)
	private String format;
}
