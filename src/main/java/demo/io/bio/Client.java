package demo.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import demo.Constant;

public class Client {

  private static Client client = null;
  
  private Socket socket = null;
  private BufferedReader reader = null;
  private PrintWriter writer = null;
  
  private Client() throws UnknownHostException, IOException {
    socket = new Socket(Constant.Net.Default_IP, Constant.Net.Default_Port);
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    writer = new PrintWriter(socket.getOutputStream());
    writer.println("username client");
    writer.flush();
  }
  
  private synchronized static void init() throws UnknownHostException, IOException {
   if (client == null) {
    client = new Client();
   } 
  }
  
  public static Client instance() throws UnknownHostException, IOException {
    if (client == null) {
      init();
    }
    return client;
  }
  
  public void send() throws IOException {
    
  }
  
  public void read() throws IOException {
    
    String line = null;
    while ((line = reader.readLine()) != null) {
      System.out.println("新消息：" + line);
    }
  }
  
  public static void main(String[] args) {
    try {
      Client client = Client.instance();
      client.read();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
