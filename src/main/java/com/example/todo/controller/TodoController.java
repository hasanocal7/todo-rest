package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Write Operations
    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        Todo createdTodo = todoService.createTodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo){
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    // Read Operations
    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") long id){
        Todo todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);

    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
}
