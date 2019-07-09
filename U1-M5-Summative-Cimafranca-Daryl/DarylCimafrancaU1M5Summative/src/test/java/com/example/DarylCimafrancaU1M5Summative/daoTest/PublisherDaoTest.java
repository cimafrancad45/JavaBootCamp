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
public class PublisherDaoTest {

    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.getAllBooks();
        for (Book item : bookList) {
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
    public void getAddDeletePublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");

        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher2, publisher);


        publisherDao.deletePublisher(publisher.getPublisherId());

        publisher2 = publisherDao.getPublisher(publisher.getPublisherId());

        assertNull(publisher2);
    }

    @Test
    public void getAllPublishers() {
        List<Publisher> publisherList = new ArrayList<>();

        Publisher publisher = new Publisher();
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");

        publisherDao.addPublisher(publisher);

        publisherList.add(publisher);

        assertEquals(publisherDao.getAllPublishers().size(), publisherList.size());
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");
        publisher = publisherDao.addPublisher(publisher);

        publisher.setName("Yen Press");
        publisher.setStreet("East 39th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10318");
        publisher.setPhone("(212)832-3753");
        publisher.setEmail("ryu@yenpress.com.");

        publisherDao.updatePublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher2, publisher);

    }
}
