package com.max.interfaces;

import com.max.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookAutoRepository extends JpaRepository<Book,Long>, BookRepo {
    Book findByName(String name);
    @Query("select b from Book b where b.name = :name")
    Book findByNames(@Param("name") String name);
//    Book findBookByName(String name);
//    Book getByName(String name);
//    Book readByName(String name);
//    int countByName(String name);
//    Book findByNameOrAge(String name, int age);
//    Book findDistinctByName(String name);
//    List<Book> findByNameAndSecondName(String name, String secondName);
//    List<Book> findByNameIgnoringCaseAndSecondNameIgnoringCase(String name, String secondName);
//    List<Book> findByNameAndSecondNameAllIgnoringCase(String name, String secondName);
//    List<Book> findByNameAndSecondNameOrderByNameAsc(String name, String secondName);
//    List<Book> findByNameAndSecondNameOrderByNameAscSecondNameDesc(String name, String secondName);

//     IsAfter , After , IsGreaterThan , GreaterThan
//     IsGreaterThanEqual , GreaterThanEqual
//     IsBefore , Before , IsLessThan , LessThan
//     IsLessThanEqual , LessThanEqual
//     IsBetween , Between
//     IsNull , Null
//     IsNotNull , NotNull
//     IsIn , In
//     IsNotIn , NotIn
//     IsStartingWith , StartingWith , StartsWith
//     IsEndingWith , EndingWith , EndsWith
//     IsContaining , Containing , Contains
//     IsLike , Like
//     IsNotLike , NotLike
//     IsTrue , True
//     IsFalse , False
//     Is , Equals
//     IsNot , Not
}
