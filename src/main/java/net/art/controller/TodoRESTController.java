package net.art.controller;

import net.art.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.art.model.Todo;

import java.util.List;

@RestController
public class TodoRESTController {
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getAllTodos();
        if (todos.isEmpty()) {
            return new ResponseEntity<List<Todo>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
        Todo todo = todoService.getToDo(id);
        if (todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }
    }

    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Todo todo) {
        if (todo.getId() != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            todoService.addTodo(todo);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

}