package com.max.impl;

import com.max.entities.Book;
import com.max.interfaces.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//@Repository
public class BookRepository implements Repo {
    @Autowired
    JdbcOperations jdbcOperations;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void createTable() {
        jdbcOperations.execute("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
        jdbcOperations.update("insert into Books (name) values ('first')");
//        jdbcOperations.update("update Books set name = 'two' where id = 1");
        jdbcOperations.update("update Books set name = 'two' where id = ?", 1);
//        jdbcOperations.queryForObject("select * from Books where id = 1", new BookRowMapper());
//        Book book = jdbcOperations.queryForObject("select * from Books where id = ?", new BookRowMapper(),1);
//        Book book = jdbcOperations.queryForObject("select * from Books where id = ?",
//                (rs, rowNum) -> {return new Book(rs.getInt("id"), rs.getString("name"));},
//                1);
//        System.out.println(book.getId());
//        System.out.println(book.getName());

        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        namedParameterJdbcTemplate.update("UPDATE Books set name = 'hi' where id = :id", map);
    }

    private static final class BookRowMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Book(rs.getInt("id"), rs.getString("name"));
        }
    }
}
