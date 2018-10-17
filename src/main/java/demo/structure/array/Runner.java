package demo.structure.array;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		
		int total = 1000 * 100;
		long init = System.currentTimeMillis();
		Array array = new Array(total);
		for (int i = 0; i < total; i++) {
			long b = System.currentTimeMillis();
			array.add(getRandomString(3));
			long e = System.currentTimeMillis();
			System.out.println("add: " + (e - b));
		}
		long begin = System.currentTimeMillis();
		System.out.println("init: " + (begin - init));
		System.out.println(array.find("dc3"));
		long end = System.currentTimeMillis();
		System.out.println("find: " + (end - begin));
	}
	
	public static String getRandomString(int length){
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
	                   sb.append(String.valueOf
	                          (new Random().nextInt(10)));
	        break; 
	      }
	    }
	    return sb.toString();
	  }
	
}
