package br.com.supero.tasklist.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.supero.tasklist.dao.AbstractDao;
import br.com.supero.tasklist.dao.StatusDao;
import br.com.supero.tasklist.entity.Status;


@Repository("statusDao")
public class StatusDaoImpl extends AbstractDao<Integer, Status> implements StatusDao {

	@Override
	public Status getById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		return (Status) c.uniqueResult();
	}

	@Override
	public List<Status> listAll() {
		Criteria c = createEntityCriteria();
		return c.list();
	}

}
