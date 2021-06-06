package com.rmit.app.controller;

import com.rmit.app.model.Library;
import com.rmit.app.service.LibraryService;
import com.rmit.app.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="libraries")
public class LibraryController {

    private LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // ADD
    @RequestMapping(path="", method= RequestMethod.POST)
    public ResponseEntity<Object> addOne(@RequestBody Library library) {
        Library addedOne = libraryService.addOne(library);
        return ResponseHandler.generateResponse(HttpStatus.CREATED, true,
                "/libraries",
                String.format("Library %d created successfully.", addedOne.getId()),
                addedOne);
    }

    @RequestMapping(path="{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateOne(@PathVariable int id, @RequestBody Library library) {
        Library updatedOne = libraryService.updateOne(id, library);
        return ResponseHandler.generateResponse(HttpStatus.OK, true,
                "/libraries/" + updatedOne.getId(),
                String.format("Library %d updated successfully.", updatedOne.getId()),
                updatedOne);
    }

    @RequestMapping(path="search", method=RequestMethod.GET, params={"subject", "sortType"})
    public ResponseEntity<Object> searchOne(@RequestParam String subject, @RequestParam String sortType) {
        List<Library> list = libraryService.searchOne(subject, sortType);
        return ResponseHandler.generateResponse(HttpStatus.OK, true,
                "/libraries/search",
                "Search By Subject successfully",
                list);
    }
}
