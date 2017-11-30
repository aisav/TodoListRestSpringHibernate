package net.art.dao;

import net.art.model.Todo;

import java.util.List;

public interface TodoDao {
     List getAllTodos();
     Todo getTodo(int id);
     Todo addTodo(Todo todo);
     Todo updateTodo(Todo todo);
     boolean deleteTodo(int id);
    }
