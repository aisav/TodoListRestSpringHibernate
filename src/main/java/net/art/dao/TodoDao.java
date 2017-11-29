package net.art.dao;

import net.art.model.Todo;

import java.util.List;

public interface TodoDao {
     List getAllTodos();
     Todo getTodo(int id);
     Todo addTodo(Todo todo);
     void updateTodo(Todo todo);
     void deleteTodo(int id);
    }
