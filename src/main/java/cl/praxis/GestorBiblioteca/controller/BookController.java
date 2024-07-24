package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.service.BookService;
import cl.praxis.GestorBiblioteca.model.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
  BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping()
  public String findAll(Model model){
    logger.info("Ejecutando findAll() de BookController");
    model.addAttribute("books", service.findAll());
    return "booksList";
  }

  @GetMapping("/{id}")
  public String findOne(@PathVariable("id") int id, Model model){
    model.addAttribute("book", service.findOne(id));

    return "bookEdit";
  }

  @PostMapping
  public String update(@ModelAttribute Book book){
    boolean result = service.update(book);

    if (result){
      logger.info("Libro actualizado correctamente");
    } else {
      logger.error("Error al actualizar libro");
    }

    return "redirect:/books";
  }
  @GetMapping("/new")
  public ModelAndView create(){
    return new ModelAndView("bookNew");
  }

  @PostMapping("/new")
  public String save(@ModelAttribute Book book){
    boolean result = service.create(book);

    if (result){
      logger.info("Libro creado correctamente");
    } else {
      logger.error("Error al crear libro");
    }
    return "redirect:/books";
  }

  @GetMapping("/del/{id}")
  public String delete(@PathVariable("id") int id){
    boolean result = service.delete(id);

    if (result){
      logger.info("Libro eliminado correctamente");
    } else {
      logger.error("Error al eliminar el libro");
    }
    return "redirect:/books";
  }

}
