package br.com.supero.tasklist.controller;


import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supero.tasklist.entity.User;
import br.com.supero.tasklist.service.UserService;
import br.com.supero.tasklist.utils.MessageStatus;
import br.com.supero.tasklist.utils.MessagesBean;

@RestController
public class AppController {

	@Autowired
	UserService userService;
	
	@CrossOrigin
	@RequestMapping("/logon")
    public Response logon(@PathParam("login") String login, @PathParam("password") String password) {
		User usuario = userService.logon(login, password);
		System.out.println("teste");
		if(usuario != null){
			return Response.ok().entity(usuario).build();
		}
		return Response.serverError().entity(new MessagesBean(MessageStatus.LOGIN_INVALIDO)).build();
    }
	
}
