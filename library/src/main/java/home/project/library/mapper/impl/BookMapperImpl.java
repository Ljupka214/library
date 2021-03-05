package home.project.library.mapper.impl;


import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import home.project.library.domain.Book;
import home.project.library.dto.BookDto;
import home.project.library.mapper.BookMapper;
import home.project.library.infrastucture.mapper.*;

@Component
public class BookMapperImpl extends AbstractGeneralMapper implements BookMapper {
	
	@Autowired
	public BookMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public BookDto entityToDto (Book book) {		
		return this.modelMapper.map(book, BookDto.class);
	}
	
	@Override
	public Book dtoToEntity(BookDto bookDto) {		
		return this.modelMapper.map(bookDto, Book.class);	
	}
	
	public void mapRequestedFieldForUpdate(Book entity, BookDto dto) {
		entity.setTitle(dto.getTitle());
		entity.setPublisher(dto.getPublisher());
		entity.setCategory(dto.getCategory());
		entity.setBookAuthors(dto.getBookAuthors());
		entity.setNumberOfPages(dto.getNumberOfPages());
		entity.setLanguage(dto.getLanguage());
		entity.setPublicationYear(dto.getPublicationYear());
		entity.setFormat(dto.getFormat());
		
	}
}
