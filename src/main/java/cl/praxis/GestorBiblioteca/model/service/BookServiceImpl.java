package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  private List<Book> bookList;
  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

  private AuthorService authorService = new AuthorServiceImpl();

  public BookServiceImpl() {

    bookList = new ArrayList<>();

    bookList.add(new Book(1, "123", "Canción de Hielo y Fuego",
            1, authorService.findOne(1), "El invierno se acerca"));
    bookList.add(new Book(2, "234", "El Resplandor",
            2,  authorService.findOne(2), "Las paredes sangran"));
    bookList.add(new Book(3, "345", "Inferno",
            3,  authorService.findOne(3), "Es como el infierno pero sin i"));
    bookList.add(new Book(4, "456", "Sapo y Sepo",
            4,  authorService.findOne(4), "Amigos inseparables"));
  }

  public BookServiceImpl(List<Book> bookList) {
    this.bookList = bookList;
  }

  @Override
  public List<Book> findAll() {

    logger.info("Ejecutando findAll de BookServiceImpl");

    return bookList;
  }

  @Override
  public Book findOne(int id) {
    return bookList.stream()
            .filter(book -> book.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean create(Book b) {
    bookList.add(b);
    return true;
  }

  @Override
  public boolean update(Book b) {

    Book bookUp = findOne(b.getId());
    bookUp.setTitle(b.getTitle());
    bookUp.setExtract(b.getExtract());
    bookUp.setIsbn(b.getIsbn());

    return true;
  }

  @Override
  public boolean delete(int id) {

    Book b = findOne(id);
    if (b != null){
      bookList.remove(b);
      return true;
    }

    return false;
  }
}
