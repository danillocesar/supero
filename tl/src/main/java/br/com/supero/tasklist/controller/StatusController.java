package br.com.supero.tasklist.controller;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supero.tasklist.service.StatusService;

@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	
	@CrossOrigin
	@RequestMapping("/status/list")
    public Response listStatus(@PathParam("login") String login, @PathParam("password") String password) {
		return Response.serverError().entity(statusService.listAll()).build();
    }
}
