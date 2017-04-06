package br.com.supero.tasklist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.supero.tasklist.dao.StatusDao;
import br.com.supero.tasklist.entity.Status;
import br.com.supero.tasklist.service.StatusService;


@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService{

	@Autowired
	StatusDao dao;
	
	@Override
	public List<Status> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

}
