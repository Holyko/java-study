package demo.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {
  
  private Socket socket;
  private BufferedReader reader = null;
  private PrintWriter writer = null;
  
  public ServerHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    System.out.println(socket.getInetAddress().getHostAddress());
    System.out.println(socket.getInetAddress().getHostName());
    
    try {
      send();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public void send() throws IOException, InterruptedException {
    writer = new PrintWriter(socket.getOutputStream());
    for (int i = 1; i <= 100; i++) {
      writer.println(i);
      writer.flush();
      Thread.sleep(1000);
    }
  }
  
  public void read() throws IOException {
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String line = null;
    while ((line = reader.readLine()) != null) {
      System.out.println("新消息：" + line);
    }
  }

}
