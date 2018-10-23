package demo.structure.list;

import utils.StringHelper;

public class Runner {

  public static void main(String[] args) {
    MyLinkList<String> list = new MyLinkList<>();
    for (int i = 0; i < 10; i++) {
      String str = StringHelper.random(5);
      if (i == 5) {
        list.insert("xxx");
      }
      list.insert(str);
      System.out.print(str + " ");
    }
    System.out.println(" ");
    list.display();
    System.out.println("contain: " + list.isContain("xxx"));
    list.delete("xxx");
    list.display();
    
  }
  
}
