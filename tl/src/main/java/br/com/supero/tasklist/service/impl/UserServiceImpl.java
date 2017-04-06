package br.com.supero.tasklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.supero.tasklist.dao.UserDao;
import br.com.supero.tasklist.entity.User;
import br.com.supero.tasklist.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	
	@Override
	public User logon(String login, String password) {
		return dao.getByLoginPass(login, password);
	}
}
