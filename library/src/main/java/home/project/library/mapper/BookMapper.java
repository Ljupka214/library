package home.project.library.mapper;

import home.project.library.domain.Book;
import home.project.library.dto.BookDto;
import home.project.library.infrastucture.mapper.GeneralMapper;

public interface BookMapper extends GeneralMapper<BookDto, Book> {
	public void mapRequestedFieldForUpdate(Book entity, BookDto dto);
}