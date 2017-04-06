package br.com.supero.tasklist.utils;

public class MessagesBean {
	private String system;
	private int status;
	
	public MessagesBean(MessageStatus status) {
		super();
		this.system = status.toString();
		this.status = status.status;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
