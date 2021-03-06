package net.art.dao.impl;

import java.util.List;

import net.art.dao.TodoDao;
import net.art.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;


@Repository
@EnableTransactionManagement
public class TodoDaoImpl implements TodoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Transactional
    public List getAllTodos() {
        Session session = this.sessionFactory.getCurrentSession();
        List todoList = session.createQuery("from Todo").list();
        return todoList;
    }

    @Transactional
    public Todo getTodo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return  (Todo) session.get(Todo.class, new Integer(id));

    }

    @Transactional
    public Todo addTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(todo);
        return todo;
    }

    @Transactional
    public Todo updateTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(todo);
        return todo;
    }

    @Transactional
    public boolean deleteTodo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Todo todo = getTodo(id);
        if (null != todo) {
            session.delete(todo);
            return true;
        }
        return false;
    }
}


