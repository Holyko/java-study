package demo;

import java.util.concurrent.ThreadPoolExecutor;

public class Runner {

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString( -1 << (Integer.SIZE - 3)));
    System.out.println(Integer.toBinaryString( 0 << (Integer.SIZE - 3)));
    System.out.println(Integer.toBinaryString( 1 << (Integer.SIZE - 3)));
    System.out.println(( -1 << (Integer.SIZE - 3)) + ( 1 << (Integer.SIZE - 3)));
    System.out.println(( -1 << (Integer.SIZE - 3)) < 0);
  }
  
}
