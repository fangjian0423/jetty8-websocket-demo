package org.format.demo.websocket;

import org.eclipse.jetty.websocket.WebSocket;


public class TaskWebSocket implements WebSocket.OnTextMessage {

    private Connection conn;

    public void onMessage(String s) {
    }

    public void onOpen(Connection connection) {
        System.out.println("on Open");
        this.conn = connection;
    }

    public void onClose(int i, String s) {
        System.out.println("on Close");
    }

}
