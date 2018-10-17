package demo.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ThreadReader extends Thread {

  private Socket socket;
  
  private BufferedReader reader = null;

  public ThreadReader(Socket socket) throws UnsupportedEncodingException, IOException {
    this.socket = socket;
    this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
  }
  
  public void run() {
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println("客户端：" + line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
