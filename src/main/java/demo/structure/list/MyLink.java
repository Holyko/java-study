package demo.structure.list;

import net.sf.json.JSONObject;

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
  
  @Override
  public String toString() {
    return JSONObject.fromObject(this).toString();
  }
  
}
