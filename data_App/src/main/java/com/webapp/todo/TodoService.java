package com.webapp.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	//here use static to store the data
	static {
		todos.add(new Todo(1,"cathy","Spark Cookbook", new Date(), false));
		todos.add(new Todo(2, "cathy", "Scala Cookbook", new Date(),
				false));
		todos.add(new Todo(3, "cathy", "Spring MVC Cookbook", new Date(),
				false));
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id ) {
				iterator.remove();
			}
		}
	}
	
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo x : todos) {
			if (x.getUser().equals(user)) {
				filteredTodos.add(x);
			}
		}		
		return filteredTodos;
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
}
