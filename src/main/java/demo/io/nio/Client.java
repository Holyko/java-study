package demo.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import demo.Constant;

public class Client {

  private static Client client = null;

  private Selector selector = null;
  private SocketChannel channel = null;

  private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

  private Client() throws IOException {
    this.selector = Selector.open();
    this.channel = SocketChannel.open();
    this.channel.configureBlocking(false);
    channel.connect(new InetSocketAddress(Constant.Net.Default_IP, Constant.Net.Default_Port));
    channel.register(selector, SelectionKey.OP_CONNECT);

    while (true) {
      selector.select();
      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()) {
        SelectionKey key = iterator.next();
        iterator.remove();
        if (key.isConnectable()) {
          doConnect(key);
        } else if (key.isReadable()) {
          doRead(key);
        }
      }
    }
  }

  private synchronized static void init() throws IOException {
    if (client == null) {
      client = new Client();
    }
  }

  public static Client instance() throws IOException {
    if (client == null) {
      init();
    }

    return client;
  }

  public void doConnect(SelectionKey key) throws IOException {
    SocketChannel clientChannel = (SocketChannel) key.channel();
    if (clientChannel.isConnectionPending()) {
      clientChannel.finishConnect();
    }
    clientChannel.configureBlocking(false);
    String info = "服务端你好!!";
    byteBuffer.clear();
    byteBuffer.put(info.getBytes("UTF-8"));
    byteBuffer.flip();
    clientChannel.write(byteBuffer);
    // clientChannel.register(key.selector(),SelectionKey.OP_READ);
    clientChannel.close();
  }

  public void doRead(SelectionKey key) throws IOException {
    SocketChannel clientChannel = (SocketChannel) key.channel();
    clientChannel.read(byteBuffer);
    byte[] data = byteBuffer.array();
    String msg = new String(data).trim();
    System.out.println("服务端发送消息：" + msg);
    clientChannel.close();
    key.selector().close();
  }
  
  public static void main(String[] args) {
    try {
      Client client = Client.instance();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
