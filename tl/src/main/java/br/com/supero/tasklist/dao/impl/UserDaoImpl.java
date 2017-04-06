package br.com.supero.tasklist.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import br.com.supero.tasklist.dao.AbstractDao;
import br.com.supero.tasklist.dao.UserDao;
import br.com.supero.tasklist.entity.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User getByLoginPass(String login, String password) {
		Criteria c = createEntityCriteria();
		c.setFetchMode("tasks", FetchMode.JOIN);
		c.createAlias("tasks", "tasks", JoinType.LEFT_OUTER_JOIN);
		c.add(Restrictions.eq("login", login));
		c.add(Restrictions.eq("password", password));
		return (User) c.uniqueResult();
	}

	@Override
	public User getById(int id) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("id", id));
		return (User) c.uniqueResult();
	}

}
