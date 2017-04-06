package br.com.supero.tasklist.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.supero.tasklist.dao.AbstractDao;
import br.com.supero.tasklist.dao.TaskDao;
import br.com.supero.tasklist.entity.Task;


@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao {

	@Override
	public List<Task> listAll() {
		Criteria c = createEntityCriteria();
		c.setFetchMode("status", FetchMode.JOIN);
		c.setFetchMode("user", FetchMode.JOIN);
		c.createAlias("status", "status");
		c.createAlias("user", "user");
		return c.list();
	}

	@Override
	public Task getById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		return (Task) c.uniqueResult();
	}

	@Override
	public void save(Task task) {
		saveOrUpdate(task);
	}

	@Override
	public void remove(Task task) {
		delete(task);
	}

}
