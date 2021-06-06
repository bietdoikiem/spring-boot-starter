package com.rmit.app.service;


import com.rmit.app.model.Author;
import com.rmit.app.model.Library;
import com.rmit.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService() {
    }

    public Author addOne(Author author) {
        return authorRepository.save(author);
    }

    public Author updateOne(int id, Author author) {
        Author foundOne = authorRepository.findById(id).orElseThrow(NullPointerException::new);
        foundOne.setName(author.getName());
        foundOne.setAcademicCredentials(author.getAcademicCredentials());
        return authorRepository.save(foundOne);
    }

    // Delete one staff
    public int deleteOne(int id) {
        Author author = authorRepository.findById(id).orElseThrow(NullPointerException::new);
        authorRepository.delete(author);
        return author.getId();
    }

    public List<Author> searchOneByName(String name, String sortType) {
        List<Author> searchResultSortedByName = null;
        if (sortType.equalsIgnoreCase("desc")) {
            searchResultSortedByName = authorRepository.findAllByNameOrderByNameDesc(name);
        } else if (sortType.equalsIgnoreCase("asc")) {
            searchResultSortedByName = authorRepository.findAllByNameOrderByNameAsc(name);
        }
        return searchResultSortedByName;
    }

    public List<Author> searchOneByAcademicCredentials(String academicCredentials, String sortType) {
        List<Author> searchResultSortedByName = null;
        if (sortType.equalsIgnoreCase("desc")) {
            searchResultSortedByName = authorRepository.findAllByAcademicCredentialsOrderByAcademicCredentialsAsc(academicCredentials);
        } else if (sortType.equalsIgnoreCase("asc")) {
            searchResultSortedByName = authorRepository.findAllByAcademicCredentialsOrderByAcademicCredentialsDesc(academicCredentials);
        }
        return searchResultSortedByName;
    }
}
