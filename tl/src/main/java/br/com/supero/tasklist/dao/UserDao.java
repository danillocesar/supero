package br.com.supero.tasklist.dao;

import br.com.supero.tasklist.entity.User;

public interface UserDao {
	User getByLoginPass(String login, String password);
	User getById(int id);
}
