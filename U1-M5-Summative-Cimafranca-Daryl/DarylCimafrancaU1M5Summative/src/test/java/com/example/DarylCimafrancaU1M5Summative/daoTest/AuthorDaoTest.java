package com.example.DarylCimafrancaU1M5Summative.daoTest;

import com.example.DarylCimafrancaU1M5Summative.dao.AuthorDao;
import com.example.DarylCimafrancaU1M5Summative.dao.BookDao;
import com.example.DarylCimafrancaU1M5Summative.dao.PublisherDao;
import com.example.DarylCimafrancaU1M5Summative.model.Author;
import com.example.DarylCimafrancaU1M5Summative.model.Book;
import com.example.DarylCimafrancaU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.getAllBooks();
        for (Book item : bookList){
            bookDao.deleteBook(item.getBookId());
        }

        List<Author> authorList = authorDao.getAllAuthors();
        for (Author item : authorList) {
            authorDao.deleteAuthor(item.getAuthorId());
        }

        List<Publisher> publisherList = publisherDao.getAllPublishers();
        for (Publisher item : publisherList) {
            publisherDao.deletePublisher(item.getPublisherId());
        }
    }
    @Test
    public void getAddDeleteAuthors() {
        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setStreet("Salt Lake City Dr.");
        author.setCity("Salt Lake City");
        author.setState("UT");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        author = authorDao.addAuthor(author);

        Author author2 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author, author2);


        authorDao.deleteAuthor(author.getAuthorId());

        author2 = authorDao.getAuthor(author.getAuthorId());

        assertNull(author2);
    }

    @Test
    public void getAllAuthors() {
        List<Author> authorList = new ArrayList<>();

        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setStreet("Salt Lake City Dr.");
        author.setCity("Salt Lake City");
        author.setState("UT");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        authorDao.addAuthor(author);
        authorList.add(author);

        assertEquals(authorDao.getAllAuthors().size(), authorList.size());
    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setStreet("Salt Lake City Dr.");
        author.setCity("Salt Lake City");
        author.setState("UT");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        author = authorDao.addAuthor(author);

        author.setFirstName("Ken");
        author.setLastName("Masters");
        author.setStreet("Shoryuken Ave.");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("tatsumaki@masters.com");

        authorDao.updateAuthor(author);

        Author author2 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author2, author);

    }
}
