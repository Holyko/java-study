package utils;

import java.util.Random;

public class IntegerHelper {

  public static int random(int length) {
    StringBuffer sb=new StringBuffer();
    //循环length次
    for(int i=0; i<length; i++){
      sb.append(String.valueOf(new Random().nextInt(10)));
    }
    return Integer.parseInt(sb.toString());
  }
  
}
