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
    public List getAllToDos() {
        return todoDao.getAllTodos();
    }

    @Transactional
    public Todo getToDo(int id) {
        return todoDao.getTodo(id);
    }

    @Transactional
    public void addToDo(Todo ToDo) {
        todoDao.addTodo(ToDo);
    }

    @Transactional
    public void updateToDo(Todo ToDo) { todoDao.updateTodo(ToDo); }

    @Transactional
    public void deleteToDo(int id) {
        todoDao.deleteTodo(id);
    }
}

