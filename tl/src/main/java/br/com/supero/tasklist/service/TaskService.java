package br.com.supero.tasklist.service;

import java.util.List;

import br.com.supero.tasklist.entity.Task;

public interface TaskService {
	List<Task> listAll();
	boolean addTask(Task task);
	boolean editTask(Task task);
	boolean removeTask(Task task);
}
