package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository repository;
	
	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
	
	public List<Task> getAll(){
		return repository.findAll();
	}
	
	public Task getById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Task create(Task task) {
		return repository.save(task);
	}
	
	public Task update(Long id, Task newTask) {
		Task existing = repository.findById(id).orElse(null);
		if(existing != null) {
			existing.setUser(newTask.getUser());
			existing.setStatus(newTask.getStatus());
			existing.setDueDate(newTask.getDueDate());
			existing.setPriority(newTask.getPriority());
			existing.setComments(newTask.getComments());
			existing.setDescription(newTask.getDescription());
			
            return repository.save(existing);
		}
		return null; 
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
