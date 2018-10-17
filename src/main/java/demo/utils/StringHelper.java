package demo.utils;

import java.util.Random;

/**
 *   字符串工具类
 * @author scholar
 *
 */
public class StringHelper {

  /**
   * 生成随机字符串，包含大写字母，小写字母，阿拉伯数字
   * @param length 字符串长度
   * @return
   */
  public static String random(int length) {
    //产生随机数
    Random random=new Random();
    StringBuffer sb=new StringBuffer();
    //循环length次
    for(int i=0; i<length; i++){
      //产生0-2个随机数，既与a-z，A-Z，0-9三种可能
      int number=random.nextInt(3);
      long result=0;
      switch(number){
        //如果number产生的是数字0；
        case 0:
        //产生A-Z的ASCII码
        result=Math.round(Math.random()*25+65);
        //将ASCII码转换成字符
        sb.append(String.valueOf((char)result));
        break;
        case 1:
          //产生a-z的ASCII码
          result=Math.round(Math.random()*25+97);
          sb.append(String.valueOf((char)result));
        break;
        case 2:
          //产生0-9的数字
          sb.append(String.valueOf(new Random().nextInt(10)));
        break; 
      }
    }
    return sb.toString();
  }
  
}
