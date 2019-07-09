package com.example.DarylCimafrancaU1M5Summative.dao;

import com.example.DarylCimafrancaU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;

    //statements
    private static final String INSERT_BOOK_SQL =
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "select * from book";

    private static final String UPDATE_BOOK_SQL =
            "update book set";

    private static final String DELETE_BOOK =
            "delete from book where book_id = ?";

    private static final String SELECT_BOOK_BY_AUTHOR_SQL =
            "select* from book where author_id = ?";


    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //map row to book
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        book.setBookId(id);

        return book;
    }

    @Override
    public Book getBook(int id){
        return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
    }

    @Override
    public List<Book> getAllBooks(){
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public void updateBook(Book book){
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());
    }

    @Override
    public void deleteBook(int id){
        jdbcTemplate.update(DELETE_BOOK, id);
    }

    @Override
    public List<Book> getBookByAuthor(int id){
        return jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR_SQL, this::mapRowToBook, id);
    }


}
