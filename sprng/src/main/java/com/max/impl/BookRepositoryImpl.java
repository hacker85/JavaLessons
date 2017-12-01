package com.max.impl;

import com.max.entities.Book;
import com.max.interfaces.BookRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class BookRepositoryImpl implements BookRepo {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Book getById(int id) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.id = " + id, Book.class);
        return query.getSingleResult();
    }
}
