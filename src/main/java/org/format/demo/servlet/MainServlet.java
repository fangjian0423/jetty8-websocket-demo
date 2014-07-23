package org.format.demo.servlet;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.format.demo.websocket.TaskWebSocket;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "main", urlPatterns = "/main.do")
public class MainServlet extends WebSocketServlet {

    public WebSocket doWebSocketConnect(HttpServletRequest httpServletRequest, String s) {
        return new TaskWebSocket();
    }

}
