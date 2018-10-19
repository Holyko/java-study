package demo.structure.list;

public class Runner {

  public static void main(String[] args) {
    System.out.println("a".hashCode());
    Object o1 = new Object();
    Object o2 = new Object();
    MyLink<Object> a = new MyLink<Object>(o1);
    MyLink<Object> b = new MyLink<Object>(o2);
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    System.out.println(a.equals(b));
    System.out.println(a.data().toString());
    System.out.println(b.data().toString());
  }
  
}
