package demo.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ThreadWriter extends Thread {

  private boolean isAlive = true;
  
  private Socket socket;
  
  private List<String> cache = new LinkedList<String>();
  
  private BufferedWriter writer = null;

  public ThreadWriter(Socket socket) throws IOException {
    this.socket = socket;
    this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
  }
  
  public void send(String msg) {
    cache.add(msg);
  }
  
  public void run() {
    try {
      String line;
      while (isAlive) {
        if (!cache.isEmpty()) {
          line = cache.remove(0);
          writer.write(line + "/n");
          writer.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
