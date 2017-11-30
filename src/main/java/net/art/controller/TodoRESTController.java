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

    //-------------------Retrieve All Todos--------------------------------------------------------

    @RequestMapping(value = "/todos", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getAllTodos();
        if (todos.isEmpty()) {
            return new ResponseEntity<List<Todo>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }

    //-------------------Retrieve Single Todoo--------------------------------------------------------

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
        Todo todo = todoService.getTodo(id);
        if (todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }
    }

    //-------------------Create a Todoo--------------------------------------------------------

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<Void> createTodo(@RequestBody Todo todo) {
        if (todo.getId() != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            todoService.addTodo(todo);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    //------------------- Update a Todoo --------------------------------------------------------

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        Todo currentTodo = todoService.updateTodo(id, todo);
        if (currentTodo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Todo>(currentTodo, HttpStatus.OK);
        }
    }
}