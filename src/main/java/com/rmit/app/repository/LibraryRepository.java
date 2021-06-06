package com.rmit.app.repository;

import com.rmit.app.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    List<Library> findAllBySubjectOrderBySubjectAsc(String subject);
    List<Library> findAllBySubjectOrderBySubjectDesc(String subject);

}
