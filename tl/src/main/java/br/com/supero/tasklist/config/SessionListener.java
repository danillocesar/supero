package br.com.supero.tasklist.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	 
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(-1);
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}