package com.max.interfaces;

import com.max.entities.Book;

public interface BookRepo {
    Book getById(int id);
}
