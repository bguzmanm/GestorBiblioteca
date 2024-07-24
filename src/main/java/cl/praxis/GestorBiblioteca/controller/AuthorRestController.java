package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

  private AuthorService service;

  public AuthorRestController(AuthorService service) {
    this.service = service;
  }

  @GetMapping
  public List<Author> holaMundo(){
    return service.findAll();
  }
}
