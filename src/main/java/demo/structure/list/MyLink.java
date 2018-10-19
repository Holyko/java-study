package demo.structure.list;

/**
 * 有两种情形：
 * 1. 若只使用after，则是单向链表
 * 2. 若即使用after又使用before，则是双向链表
 *
 * @param <E>
 */
public class MyLink<E> {

  private E data;
  public MyLink<E> before = null;
  public MyLink<E> after = null;;

  public MyLink(E data) {
    this.data = data;
  }
  
  public E data() {
    return data;
  }
  
  public void display() {
    System.out.println(data.toString());
  }
  
}
