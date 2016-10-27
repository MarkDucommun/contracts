package io.pivotal.chicago.contracts.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RestController
@RequestMapping(path = "/todos")
public class TodosController {


    @PostMapping
    public ResponseEntity createTodo(@RequestBody HashMap todoRequest) {
        todoRequest.put("id", 1);
        return ResponseEntity
                .status(CREATED)
                .contentType(APPLICATION_JSON_UTF8)
                .body(todoRequest);
    }
}
