package net.art.service;

import net.art.dao.TodoDao;
import net.art.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;

import java.util.List;


@Service("toDoService")
public class TodoService {

    @Autowired
    TodoDao todoDao;

    @Transactional
    public List getAllTodos() {
        return todoDao.getAllTodos();
    }

    @Transactional
    public Todo getTodo(int id) {
        return todoDao.getTodo(id);
    }

    @Transactional
    public Todo addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    @Transactional
    public Todo updateTodo(int id, Todo todo) {
        Todo currentTodo = getTodo(id);
        currentTodo.setName(todo.getName());
        currentTodo.setPriority(todo.getPriority());
        currentTodo.setStatus(todo.getStatus());
        return todoDao.updateTodo( currentTodo);
    }

    @Transactional
    public boolean deleteTodo(int id) {
        return todoDao.deleteTodo(id);
    }
}

