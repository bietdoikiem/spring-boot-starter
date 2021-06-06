package com.rmit.app.repository;

import com.rmit.app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByNameOrderByNameAsc(String name);
    List<Author> findAllByNameOrderByNameDesc(String name);
    List<Author> findAllByAcademicCredentialsOrderByAcademicCredentialsAsc(String academicCredentials);
    List<Author> findAllByAcademicCredentialsOrderByAcademicCredentialsDesc(String academicCredentials);

}
