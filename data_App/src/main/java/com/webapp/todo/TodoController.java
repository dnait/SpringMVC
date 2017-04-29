package com.webapp.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.login.LoginService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	//Set the login service from the framework with dependency injection
	//Set the login service -Auto Wiring
	//LoginService service = new LoginService();
	@Autowired
	TodoService service;
	//map to /login
	@RequestMapping(value = "/list-todos", method=RequestMethod.GET)	
	public String listTodos(String name, ModelMap model) {
		//or in the todolist, the name will not show up 
		String user = (String)model.get("name");
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos" ;
	}
	
	//map to /add-todo
	@RequestMapping(value = "/add-todo", method=RequestMethod.GET)	
	public String showTodoPage() {
		//or in the todolist, the name will not show up 
		return "todo" ;
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		service.addTodo((String) model.get("name"), desc, new Date(), false);
		model.clear();// to prevent request parameter "name" or "password" to be passed
		return "redirect:/list-todos";
	}
	
	//delete
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
}
