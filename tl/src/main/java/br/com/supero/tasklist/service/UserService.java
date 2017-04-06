package br.com.supero.tasklist.service;

import br.com.supero.tasklist.entity.User;

public interface UserService {
	User logon(String login, String password);
}
