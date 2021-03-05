package home.project.library.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	@NonNull
	private String name;

	@Column(name = "surname", nullable = false, length = 250)
	@NonNull
	private String surname;

	@ManyToMany(mappedBy = "bookAuthors")
	private Set<Book> books = new HashSet<>();

	@ManyToMany(mappedBy = "contractAuthors")
	private Set<Publisher> publishers = new HashSet<>();

}
