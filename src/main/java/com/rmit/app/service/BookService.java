package com.rmit.app.service;

import com.rmit.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService() {}
}
