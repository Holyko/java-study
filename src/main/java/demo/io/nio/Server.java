package demo.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import demo.Constant;

public class Server {

  private static Server server = null;
  
  // 声明多路复用选择器
  private Selector selector = null;
  // 声明通道
  private ServerSocketChannel channel = null;
  // 运行状态
  private boolean isRunning = false;
  
  private Server() throws IOException {
    // 打开选择器
    selector = Selector.open();
    // 打开通道
    channel = ServerSocketChannel.open();
    // 设置为非阻塞模式
    channel.configureBlocking(false);
    // 监听端口
    channel.socket().bind(new InetSocketAddress(Constant.Net.Default_Port), 1024);
    
    channel.register(selector, SelectionKey.OP_ACCEPT);
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
  
  public void run() {
    while ((isRunning = true)) {
      try {
        selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()) {
          SelectionKey key = iterator.next();
          iterator.remove(); 
          if (key.isAcceptable()) {
            doAccept(key);
          }
          else if (key.isReadable()) {
            doRead(key);
          }
          else if (key.isWritable() && key.isValid()) {
            doWrite(key);
          }
          else if (key.isConnectable()) {
            System.out.println("哈哈哈。连接上了。。。");
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        
      }
    }
  }
  
  public void doAccept(SelectionKey key) throws IOException {
    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
    System.out.println("ServerSocketChannel正在循环监听");
    SocketChannel clientChannel = serverChannel.accept();
    clientChannel.configureBlocking(false);
    clientChannel.register(key.selector(),SelectionKey.OP_READ);
  }
  
  public void doRead(SelectionKey key) throws IOException {
      SocketChannel clientChannel = (SocketChannel) key.channel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
      long bytesRead = clientChannel.read(byteBuffer);
      while (bytesRead>0){
          byteBuffer.flip();
          byte[] data = byteBuffer.array();
          String info = new String(data).trim();
          System.out.println("从客户端发送过来的消息是："+info);
          byteBuffer.clear();
          bytesRead = clientChannel.read(byteBuffer);
      }
      if (bytesRead==-1){
          clientChannel.close();
      }
  }
  
  public void doWrite(SelectionKey key) throws IOException {
      ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
      byteBuffer.flip();
      SocketChannel clientChannel = (SocketChannel) key.channel();
      while (byteBuffer.hasRemaining()){
          clientChannel.write(byteBuffer);
      }
      byteBuffer.compact();
  } 
  
  public static void main(String[] args) {
    try {
      Server server = Server.instance();
      server.run();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
