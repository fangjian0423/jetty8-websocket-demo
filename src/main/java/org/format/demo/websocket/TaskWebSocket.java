package org.format.demo.websocket;

import org.eclipse.jetty.websocket.WebSocket;

import java.util.Random;
import java.util.concurrent.*;


public class TaskWebSocket implements WebSocket.OnTextMessage {

    private Connection conn;

    private ExecutorService executorService;
    private CompletionService<String> completionService;

    private Random random = new Random();

    public TaskWebSocket() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        completionService = new ExecutorCompletionService<String>(executorService);
    }

    public void onMessage(String s) {
        try {
            conn.sendMessage("开始执行任务");
            int taskNum = 4;
            for(int i = 0; i < taskNum; i ++) {
                Task task = new Task(random.nextInt(20), conn, String.valueOf(i + 1));
                completionService.submit(task);
            }
            for(int i = 0; i < taskNum; i ++) {
                String result = completionService.take().get();
                conn.sendMessage(result);
            }
            conn.sendMessage("任务执行完毕");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error");
        }
    }

    public void onOpen(Connection connection) {
        System.out.println("on Open");
        this.conn = connection;
    }

    public void onClose(int i, String s) {
        System.out.println("on Close");
    }

}

class Task implements Callable<String> {

    private int sleepSec;
    private WebSocket.Connection conn;
    private String name;

    public Task(int sleepSec, WebSocket.Connection conn, String name) {
        this.sleepSec = sleepSec;
        this.conn = conn;
        this.name = name;
    }

    public String call() throws Exception {
        conn.sendMessage("任务(" + name + ")开始执行, 该任务大概会执行" + sleepSec + "秒");
        Thread.sleep(sleepSec * 1000);
        return "任务" + name + "执行完成";
    }

}
