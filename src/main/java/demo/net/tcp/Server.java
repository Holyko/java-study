package demo.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import demo.utils.Constant;

public class Server {
  
  public static void main(String[] args) {
    start();
  }

  public static void start() {
    System.out.println("服务器正在启动...");
    ServerSocket server = null;
    BufferedReader reader = null;
    PrintWriter writer = null;
    
    try {
      server = new ServerSocket(Constant.Net.Default_Port);
      System.out.println("服务器启动完成，端口 --> " + Constant.Net.Default_Port);
      System.out.println("等待客户端连接...");
      
      Socket socket = server.accept();
      System.out.println(socket.getInetAddress() + "已接入.");
      
      reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
      
      writer = new PrintWriter(socket.getOutputStream());
      writer.println("你已经接入服务端，请发言");
      writer.flush();
      
      ThreadReader threadReader = new ThreadReader(socket);
      threadReader.start();
      
      ThreadWriter threadWriter = new ThreadWriter(socket);
      threadWriter.start();
      
      String line;
      while ((line = reader.readLine()) != null) {
        threadWriter.send(line);
      }
      
      while (threadReader.isAlive()) {
        
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        writer.close();
      }
//      if (server != null) {
//        try {
//          server.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
    }
  }
  
}
