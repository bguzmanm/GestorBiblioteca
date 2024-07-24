package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
  List<Author> authorList;

  public AuthorServiceImpl() {
    authorList = new ArrayList<>();
    authorList.add(new Author(1, "George", "Martin", 1948));
    authorList.add(new Author(2, "Stephen", "King", 1947));
    authorList.add(new Author(3, "Dan", "Brown", 1964));
    authorList.add(new Author(4, "Arnold", "Lobel", 1933));
  }

  public AuthorServiceImpl(List<Author> authorList) {
    this.authorList = authorList;
  }

  @Override
  public List<Author> findAll() {
    logger.warn("Ejecutando findAll de AuthorServiceImpl");
    return authorList;
  }

  @Override
  public Author findOne(int id) {
    return authorList.stream()
            .filter(author -> author.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean create(Author a) {
    authorList.add(a);
    return true;
  }

  @Override
  public boolean update(Author a) {
    Author author = findOne(a.getId());
    author.setName(a.getName());
    author.setLastname(a.getLastname());
    author.setYearOfBirth(a.getYearOfBirth());
    return true;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }
}
