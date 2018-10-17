package demo.structure.stack;

public class Stack<E> {
	
	private final static int DEFAULT_SIZE = 10;

	private Object[] datas;
	private int index;
	private int max;
	
	public Stack() {
		this(DEFAULT_SIZE);
	}

	public Stack(int size) {
		this.index = -1;
		this.datas = new Object[size];
		this.max = size;
	}
	
	@SuppressWarnings("unchecked")
	private E data(int index) {
	  return (E) datas[index];
	}
	
	public boolean push(E e) {
		if (isFull()) {
			return false;
		}
		datas[++index] = e;
		return true;
	}
	
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		return data(index--);
	}
	
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return data(index);
	}
	
	public boolean isEmpty() {
		if (index + 1 == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (index + 1 == max) {
			return true;
		}
		return false;
	}
	
	public boolean hasNext() {
	  if (index + 1 != 0) {
        return true;
      }
	  return false;
	}
	
	public int size() {
	  return index + 1;
	}
	
	public void display() {
      System.out.println("display: ");
	  for (Object data : datas) {
        System.out.print(data + " ");
      }
      System.out.println("");
	}
	
}