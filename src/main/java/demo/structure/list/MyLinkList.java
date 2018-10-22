package demo.structure.list;

import demo.utils.Constant.Position;

public class MyLinkList<E> {

  public MyLink<E> first = null;
  public MyLink<E> last = null;
  private int size = 0;

  public MyLinkList() {

  }

  public void insert(E item) {
    insert(item, Position.BOTTOM);
  }

  public void insert(E item, Position position) {
    MyLink<E> link = new MyLink<E>(item);

    switch (position) {
    case TOP:
      if (size == 0) {
        first = link;
        last = link;
        size++;
      } else {
        MyLink<E> temp = first;
        first = link;
        temp.before = link;
        link.after = temp;
        size++;
      }
      break;

    case BOTTOM:
      if (size == 0) {
        first = link;
        last = link;
        size++;
      } else {
        MyLink<E> temp = last;
        last = link;
        temp.after = link;
        link.before = temp;
        size++;
      }
      break;

    default:
      break;
    }
  }

  public MyLink<E> delete(E e) {
    MyLink<E> temp = first;
    
    do {
      if (temp == null) {
        return null;
      }
      if (temp.data().toString() == e.toString() ) {
        MyLink<E> before = temp.before;
        MyLink<E> after = temp.after;
        if (before != null) {
          before.after = after;
        } 
        else {
          first = after;
        }
        if (after != null) {
          after.before = before;
        }
        else {
          last = before;
        }
        size--;
        return temp;
      }
      temp = temp.after;
    } while (true);
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public boolean isContain(E e) {
    MyLink<E> temp = first;
    
    do {
      if (temp == null) {
        return false;
      }
      if (temp.data() == e ) {
        return true;
      }
      temp = temp.after;
    } while (true);
  }
  
  public void display() {
    System.out.println("链表数据显示：" + size);
    MyLink<E> temp = first;
    
    do {
      if (temp == null) {
        System.out.println("没有更多了");
        break;
      }
      System.out.print(temp.data().toString() + " ");
      temp = temp.after;
    } while (true);
  }

}
