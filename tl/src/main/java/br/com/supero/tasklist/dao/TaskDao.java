package br.com.supero.tasklist.dao;

import java.util.List;

import br.com.supero.tasklist.entity.Task;

public interface TaskDao {
	List<Task> listAll();
	void save(Task task);
	Task getById(int id);
	void remove(Task task);
}
