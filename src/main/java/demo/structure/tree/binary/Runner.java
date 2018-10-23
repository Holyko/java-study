package demo.structure.tree.binary;

import handlers.StringCompareHandler;
import utils.IntegerHelper;
import utils.StringHelper;

public class Runner {

  public static void main(String[] args) {
    BinaryTree<String> tree = new BinaryTree<>(new StringCompareHandler());
    
    for (int i = 0; i < 8; i++) {
      String str = IntegerHelper.random(3) + "";
      System.out.print(str + " ");
      tree.insert(str);
      if (i == 1) {
        tree.insert(333 + "");
      }
    }
    
    System.out.println("");
    tree.display();
    System.out.println("");
    tree.delete(333+"");
    tree.display();
  }
  
}
