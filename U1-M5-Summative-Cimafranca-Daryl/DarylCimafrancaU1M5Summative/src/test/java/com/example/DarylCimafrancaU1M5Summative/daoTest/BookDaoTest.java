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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

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
    public void getAddDeleteBooks(){

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

        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("0806535229");
        book.setTitle("Alphabet of Manliness");
        book.setPrice(new BigDecimal("19.99"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPublishDate(LocalDate.of(2011,10,1));

        book = bookDao.addBook(book);

        Book book2 = bookDao.getBook(book.getBookId());

        assertEquals(book, book2);

        bookDao.deleteBook(book.getBookId());

        book2 = bookDao.getBook(book.getBookId());

        assertNull(book2);

    }

    @Test
    public void getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setIsbn("28349823");
        book.setTitle("Alphabet of Manliness");
        book.setPrice(new BigDecimal("19.99"));
        book.setPublisherId(5);
        book.setAuthorId(2);
        book.setPublishDate(LocalDate.of(2011,10,1));

        Book book2 = new Book();
        book2.setIsbn("23948925");
        book2.setTitle("I am Better than Your Children");
        book2.setPrice(new BigDecimal("19.99"));
        book2.setPublisherId(5);
        book2.setAuthorId(2);
        book2.setPublishDate(LocalDate.of(2011,10,1));

        Author author = new Author();
        author.setAuthorId(2);
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setStreet("Salt Lake City Dr.");
        author.setCity("Salt Lake City");
        author.setState("UT");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        Publisher publisher = new Publisher();
        publisher.setPublisherId(5);
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");

        bookList.add(book);
        bookList.add(book2);

        assertEquals(bookList.size(),2);
    }

    @Test
    public void updateBook(){

        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setCity("Salt Lake City");
        author.setState("UT");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        Publisher publisher = new Publisher();
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");

        Book book = new Book();


        book.setTitle("Alphabet of Manliness");
        book.setIsbn("28349823");
        book.setPrice(new BigDecimal("19.99"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPublishDate(LocalDate.of(2011,10,1));
        bookDao.addBook(book);


        book.setTitle("I am Better than Your Children");
        book.setIsbn("28349833");
        book.setPrice(new BigDecimal("29.99"));
        book.setPublishDate(LocalDate.of(2011,10,1));
        bookDao.updateBook(book);

        Book book2 = bookDao.getBook(book.getBookId());
        assertEquals(book2, book);



    }

    @Test
    public void getBooksByAuthor(){
        List<Book> bookList = new ArrayList<>();


        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Ouzounian");
        author.setCity("Salt Lake City");
        author.setState("Utah");
        author.setPostalCode("05995");
        author.setPhone("(509)234-1435");
        author.setEmail("maddox@xmission.com");

        Publisher publisher = new Publisher();
        publisher.setName("Kensington Publishing Corp.");
        publisher.setStreet("West 40th Street");
        publisher.setCity("New York");
        publisher.setState("New York");
        publisher.setPostalCode("10018");
        publisher.setPhone("(212) 832-3753");
        publisher.setEmail("Kensington@kensingtonbooks.com.");

        Book book = new Book();
        book.setIsbn("28349823");
        book.setTitle("Alphabet of Manliness");
        book.setPrice(new BigDecimal("19.99"));
        book.setPublisherId(publisher.getPublisherId());
        book.setAuthorId(author.getAuthorId());
        book.setPublishDate(LocalDate.of(2011,10,1));
        bookDao.addBook(book);

        Book book2 = new Book();
        book2.setIsbn("23948925");
        book2.setTitle("I am Better than Your Children");
        book2.setPrice(new BigDecimal("19.99"));
        book2.setPublisherId(publisher.getPublisherId());
        book2.setAuthorId(author.getAuthorId());
        book2.setPublishDate(LocalDate.of(2011,10,1));
        bookDao.addBook(book2);



        assertEquals(bookDao.getBookByAuthor(2).size(),2);
    }
}
