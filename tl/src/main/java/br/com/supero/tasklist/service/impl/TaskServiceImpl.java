package br.com.supero.tasklist.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.supero.tasklist.dao.StatusDao;
import br.com.supero.tasklist.dao.TaskDao;
import br.com.supero.tasklist.dao.UserDao;
import br.com.supero.tasklist.entity.Task;
import br.com.supero.tasklist.service.TaskService;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskDao dao;
	@Autowired
	UserDao userDao;
	@Autowired
	StatusDao statusDao;
	
	@Override
	public List<Task> listAll() {
		return dao.listAll();
	}

	@Override
	public boolean addTask(Task task) {
		try {
			task.setDate(Calendar.getInstance().getTime());
			dao.save(task);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean editTask(Task task) {
		try {
			Task t = dao.getById(task.getId());
			t.setDescription(task.getDescription());
			t.setTitle(task.getTitle());
			t.setStatus(statusDao.getById(task.getStatus().getId()));
			t.setUser(userDao.getById(task.getUser().getId()));
			dao.save(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean removeTask(Task task) {
		try {
			Task t = dao.getById(task.getId());
			dao.remove(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
