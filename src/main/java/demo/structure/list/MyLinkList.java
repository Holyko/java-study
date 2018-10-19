package demo.structure.list;

import demo.utils.Constant.Position;

/**
 * 有两种情形：
 * 1. 若first存在，last不存在，则是单链表
 * 2. 若first存在，last存在，则是双端链表
 *
 */
public class MyLinkList<E> {
  
  public MyLink<E> first = null;
  public MyLink<E> last = null;
  private int size = 0;
  
  public MyLinkList() {
    
  }
  
  public MyLink<E> find(E e) {
    if (isEmpty()) {
      return null;
    }
    
    MyLink<E> cur = first;
    while (cur != null ) {
    }
    
    return null;
  }
  
  public void insert(E item) {
    insert(item, Position.TOP);
  }
  
  public void insert(E item, Position position) {
    MyLink<E> link = new MyLink<E>(item);
    
    switch (position) {
    case TOP:
      if (size == 0) {
        first = link;
        last = link;
        size++;
      }
      else {
        MyLink<E> temp = first;
        first = link;
        link.after =temp;
        size++;
      }
      break;
      
    case BOTTOM:
      if (size == 0) {
        first = link;
        last = link;
        size++;
      }
      else {
        MyLink<E> temp = last;
        last = link;
        link.before = temp;
        size++;
      }
      break;

    default:
      break;
    }
  }
  
  public void delete(E item) {
    
  }
  
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

}
