package br.com.supero.tasklist.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.supero.tasklist.entity.Task;
import br.com.supero.tasklist.service.TaskService;
import br.com.supero.tasklist.utils.MessageStatus;
import br.com.supero.tasklist.utils.MessagesBean;

@RestController
public class TaskController {
	@Autowired
	TaskService taskService;
	
	@CrossOrigin
	@RequestMapping("/task/list")
    public Response list() {
		System.out.println("teste");
		return Response.ok().entity(taskService.listAll()).build();
    }
	@CrossOrigin
	@RequestMapping(value = { "/task/addObj" }, method = RequestMethod.POST)
    public Response addTask(@RequestBody Task task) {
		//cadastra
		System.out.println(task.getDescription());
		System.out.println(task.getStatus().getName());
		if(taskService.addTask(task)){
			return Response.ok().entity(new MessagesBean(MessageStatus.CADASTRO_SUCESSO)).build();
		}
		return Response.serverError().entity(new MessagesBean(MessageStatus.ERRO_INTERNO)).build();
    }
	@CrossOrigin
	@RequestMapping(value = { "/task/editObj" }, method = RequestMethod.POST)
    public Response editTask(@RequestBody Task task) {
		//cadastra
		if(taskService.editTask(task)){
			return Response.ok().entity(new MessagesBean(MessageStatus.CADASTRO_SUCESSO)).build();
		}
		return Response.serverError().entity(new MessagesBean(MessageStatus.ERRO_INTERNO)).build();
    }
	@CrossOrigin
	@RequestMapping(value = { "/task/removeObj" }, method = RequestMethod.POST)
    public Response removeTask(@RequestBody Task task) {
		//cadastra
		if(taskService.removeTask(task)){
			return Response.ok().entity(new MessagesBean(MessageStatus.CADASTRO_SUCESSO)).build();
		}
		return Response.serverError().entity(new MessagesBean(MessageStatus.ERRO_INTERNO)).build();
    }
}
