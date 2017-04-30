package com.webapp.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	//Set the login service from the framework with dependency injection
	//Set the login service -Auto Wiring
	//LoginService service = new LoginService();
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//map to /login
	@RequestMapping(value = "/list-todos", method=RequestMethod.GET)	
	public String listTodos(ModelMap model) {
		model.addAttribute("todos", service.retrieveTodos(retrieveLoggedinUserName()));
		return "list-todos" ;
	}

	private String retrieveLoggedinUserName() {
		return "cathy";
	}
	
	//map to /add-todo
	@RequestMapping(value = "/add-todo", method=RequestMethod.GET)	
	public String showTodoPage(ModelMap model) {
		//or in the todolist, the name will not show up 
		model.addAttribute("todo", new Todo(0, retrieveLoggedinUserName(),"", new Date(), false));
		return "todo" ;
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(retrieveLoggedinUserName(), todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" or "password" to be passed
		return "redirect:/list-todos";
	}
	
	//delete
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	//Update_GET
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	//Update_POST
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo() {
		return "todo";
	}
	
	
}
