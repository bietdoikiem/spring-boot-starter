package com.rmit.app.controller;

import com.rmit.app.model.Author;
import com.rmit.app.model.Library;
import com.rmit.app.service.AuthorService;
import com.rmit.app.service.LibraryService;
import com.rmit.app.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="authors")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // ADD
    @RequestMapping(path="", method= RequestMethod.POST)
    public ResponseEntity<Object> addOne(@RequestBody Author author) {
        Author addedOne = authorService.addOne(author);
        return ResponseHandler.generateResponse(HttpStatus.CREATED, true,
                "/authors",
                String.format("Author %d created successfully.", addedOne.getId()),
                addedOne);
    }

    @RequestMapping(path="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Object> updateOne(@PathVariable int id, @RequestBody Author author) {
        Author updatedOne = authorService.updateOne(id, author);
        return ResponseHandler.generateResponse(HttpStatus.OK, true,
                "/authors/" + updatedOne.getId(),
                String.format("Author %d updated successfully.", updatedOne.getId()),
                updatedOne);
    }

    @RequestMapping(path="{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteOne(@PathVariable int id) {
        authorService.deleteOne(id);
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, true, "/authors/" + id, String.format("Author %d deleted successfully.", id), null);
    }

    @RequestMapping(path="search", method=RequestMethod.GET, params={"name", "sortType"})
    public ResponseEntity<Object> searchOneByName(@RequestParam String name, @RequestParam String sortType) {
        List<Author> list = authorService.searchOneByName(name, sortType);
        return ResponseHandler.generateResponse(HttpStatus.OK, true,
                "/libraries/search",
                "Search By Name successfully",
                list);
    }

    @RequestMapping(path="search", method=RequestMethod.GET, params={"academicCredentials", "sortType"})
    public ResponseEntity<Object> searchOneByCredentials(@RequestParam String academicCredentials, @RequestParam String sortType) {
        List<Author> list = authorService.searchOneByAcademicCredentials(academicCredentials, sortType);
        return ResponseHandler.generateResponse(HttpStatus.OK, true,
                "/libraries/search",
                "Search By Academic Credentials successfully",
                list);
    }

}
