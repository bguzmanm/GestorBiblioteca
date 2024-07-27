package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.model.dto.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
public class AuthorServiceTest {

  @Autowired
  AuthorService service;

  @Test
  void findAllTest(){
    List<Author> authorList = service.findAll();
//    assertTrue("should return all authors", authorList.size()>0);
    assertEquals("should return 4 elements", 4, authorList.size());
  }
  @Test
  void findOmeTest(){
    int id = 1;
    Author author = service.findOne(id);

    assertEquals("should return one element", id, author.getId());
  }

}
