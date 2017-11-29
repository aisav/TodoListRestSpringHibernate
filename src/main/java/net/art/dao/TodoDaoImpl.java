package net.art.dao;

import java.util.List;

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
        Todo todo = (Todo) session.load(Todo.class, new Integer(id));
        return todo;
    }

    @Transactional
    public Todo addTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(todo);
        return todo;
    }

    @Transactional
    public void updateTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(todo);
    }

    @Transactional
    public void deleteTodo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Todo p = (Todo) session.load(Todo.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}


