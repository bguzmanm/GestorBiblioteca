package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {
  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

  private AuthorService service;

  public AuthorController(AuthorService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){

    logger.info("Ejecutando findAll de AuthorController");
    model.addAttribute("authors", service.findAll());
    return "authorsList";
  }
}
