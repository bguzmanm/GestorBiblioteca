package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.util.AssertionErrors.*;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

  @Autowired
  BookService service;

  @Test
  @DisplayName("should return all books")
  void findAllTest(){
    List<Book> bookList = service.findAll();
    assertEquals("should return all books", true, bookList.size()>0);
    assertTrue("should return all books", bookList.size()>0);
  }
  @Test
  @DisplayName("should return one book")
  void findOneTest(){
    Book b = service.findOne(1);
    assertNotNull("should return a book",b);
  }

}
