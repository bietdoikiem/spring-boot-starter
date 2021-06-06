package com.rmit.app.service;

import com.rmit.app.model.Author;
import com.rmit.app.model.Library;
import com.rmit.app.repository.AuthorRepository;
import com.rmit.app.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public LibraryService() {}

    public Library addOne(Library library) {
        return libraryRepository.save(library);
    }

    public Library updateOne(int id, Library library) {
        Library foundOne = libraryRepository.findById(id).orElseThrow(NullPointerException::new);
        foundOne.setSubject(library.getSubject());
        return libraryRepository.save(foundOne);
    }

    public List<Library> searchOne(String subject, String sortType) {
        List<Library> searchResultSortedBySubject = null;
        if (sortType.equalsIgnoreCase("desc")) {
            searchResultSortedBySubject = libraryRepository.findAllBySubjectOrderBySubjectDesc(subject);
        } else if(sortType.equalsIgnoreCase("asc")) {
            searchResultSortedBySubject = libraryRepository.findAllBySubjectOrderBySubjectAsc(subject);
        }
        return searchResultSortedBySubject;
    }

}
