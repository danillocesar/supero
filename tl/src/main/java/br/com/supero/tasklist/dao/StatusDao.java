package br.com.supero.tasklist.dao;

import java.util.List;

import br.com.supero.tasklist.entity.Status;

public interface StatusDao {
	Status getById(int id);
	List<Status> listAll();
}
