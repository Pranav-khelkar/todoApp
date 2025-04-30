package com.todo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Task;
import com.todo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService service;
	
	public TaskController(TaskService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Task> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Task getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public Task create(@RequestBody Task newTask) {
		return service.create(newTask);
	}
	
	@PutMapping("/{id}")
	public Task update(@PathVariable Long id, @RequestBody Task newTask ) {
		return service.update(id, newTask);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
