package net.art.service;

import net.art.dao.TodoDao;
import net.art.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Todo getToDo(int id) {
        return todoDao.getTodo(id);
    }

    @Transactional
    public void addTodo(Todo ToDo) {
        todoDao.addTodo(ToDo);
    }

    @Transactional
    public void updateTodo(Todo ToDo) { todoDao.updateTodo(ToDo); }

    @Transactional
    public void deleteTodo(int id) {
        todoDao.deleteTodo(id);
    }
}

