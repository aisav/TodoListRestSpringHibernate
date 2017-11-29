package net.art.controller;
 
import net.art.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.art.model.Todo;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TodoRESTController
{
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/getAllTodos", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getTodos() {

        List listOfTodos = todoService.getAllToDos();
        return listOfTodos;
    }

    @RequestMapping(value = "/todos/{id}")
    @Transactional
    @ResponseBody
    public ResponseEntity<Todo> getTodoById (@PathVariable("id") int id)
    {
        if (true) {
            return null;
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}