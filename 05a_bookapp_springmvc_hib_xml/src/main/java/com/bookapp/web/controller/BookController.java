package com.bookapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.web.forms.BookFormBean;
import com.bookapp.web.util.BookMapper;

@Controller
public class BookController {

	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// ------ Add Book ---- //
	@GetMapping("addbook")
	public String addGet(ModelMap map) {
		map.addAttribute("bookForm", new BookFormBean());
		return "bookform";
	}

	// ------ Update Book -----//
	@GetMapping("updatebook")
	public String updateGet(ModelMap map, @RequestParam(name = "id") Integer id) {
		BookFormBean bookFormBean = BookMapper.convertToBookForm(bookService.getBookById(id));
		map.addAttribute("bookForm", bookFormBean);
		return "bookformupdate";
	}

	// ----- Post add/update -----
	@PostMapping("addupdatebook")
	public String addPost(@Valid @ModelAttribute(name = "bookForm") BookFormBean bookFormBean,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "bookform";
		} else {
			Book book = BookMapper.convertToBook(bookFormBean);
			if (book.getId() == null)
				bookService.addBook(book);
			else
				bookService.updateBook(book.getId(), book);
			return "redirect:allbooks";
		}
	}
	
	//	---- Delete Book ------
	@GetMapping("delbook")
	public String delete(@RequestParam(name = "id") Integer id) {
		bookService.deleteBook(id);
		return "redirect:allbooks";
	}
	
	//	--- Show all Books -----
	@GetMapping("allbooks")
	public ModelAndView getAll(ModelAndView mv) {
		mv.addObject("books", bookService.getAllBooks());
		mv.setViewName("allbooks");
		return mv;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:allbooks";
	}
	
}
