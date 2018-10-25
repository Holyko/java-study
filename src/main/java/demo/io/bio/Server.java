package demo.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.Constant;

public class Server {

  private static Server server = null;
  
  // 多线程的线程数量，设置为（内核数量 + 2）
  private ExecutorService executor = Executors.newFixedThreadPool(4);
  private ServerSocket sockets = null;
  private boolean running = false;
  
  private Server() throws IOException {
    sockets = new ServerSocket(Constant.Net.Default_Port);
    System.out.println("端口：" + Constant.Net.Default_Port);
  }
  
  private synchronized static void init() throws IOException {
    if (server == null) {
      server = new Server();
    }
  }
  
  public static Server instance() throws IOException {
   if (server == null) {
     init();
   }
   
   return server;
  }
  
  public void start() {
    running = true;
    
    while (running) {
      try {
        Socket socket = sockets.accept();
        executor.execute(new ServerHandler(socket));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    try {
      Server server = Server.instance();
      server.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  
}
