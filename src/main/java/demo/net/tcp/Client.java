package demo.net.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import demo.Constant;

public class Client {
  
  public static void main(String[] args) {
    start();
  }

  public static void start() {
    System.out.println("正在接入服务器...");
    Socket client = null;
    
    Scanner keyboard = null;
    Scanner reader = null;
    PrintWriter writer = null;
    
    try {
      client = new Socket(Constant.Net.Default_IP, Constant.Net.Default_Port);
      System.out.println("成功接入服务器。");
      
      keyboard = new Scanner(System.in);
      reader = new Scanner(client.getInputStream());
      writer = new PrintWriter(client.getOutputStream());
      
      System.out.println(reader.nextLine());
      
      while (keyboard.hasNextLine()) {
        String word = keyboard.nextLine();
        System.out.println("我：" + word);
        writer.println(word);
        writer.flush();
//        while (reader.hasNextLine()) {
//          System.out.println("服务端：" + reader.nextLine());
//        }
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        writer.close();
      }
      if (reader != null) {
        reader.close();
      }
      if (keyboard != null) {
        keyboard.close();
      }
      if (client != null) {
        try {
          client.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
  }
  
}
