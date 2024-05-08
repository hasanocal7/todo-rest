package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(long id, Todo todo){
        Optional<Todo> optTodo = todoRepository.findById(id);
        if (optTodo.isEmpty()){
            throw new TodoNotFoundException("Todo with id" + id + "is not found.");
        }
        todo.setId(id);
        return todoRepository.save(todo);
    }

    public void deleteTodo(long id){
        Optional<Todo> optTodo = todoRepository.findById(id);
        if (optTodo.isEmpty()){
            throw new TodoNotFoundException("Todo with id" + id + "is not found.");
        }
        todoRepository.deleteById(id);
    }

    public Todo getTodo(long id){
        Optional<Todo> optTodo = todoRepository.findById(id);
        if (optTodo.isEmpty()){
            throw new TodoNotFoundException("Todo with id" + id + "is not found.");
        }
        return optTodo.get();
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
}
