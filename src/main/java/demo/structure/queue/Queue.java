package demo.structure.queue;

public class Queue<E> {
	
	private final static int DEFAULT_SIZE = 10;

	private Object[] datas;
    private int max;
    private volatile int size;
	private volatile int index;
	
	public Queue() {
		this(DEFAULT_SIZE);
	}

	public Queue(int size) {
		this.datas = new Object[size];
		this.max = size;
		this.size = 0;
        this.index = 0;
	}
	
	@SuppressWarnings("unchecked")
    private E data(int index) {
	  return (E) datas[index];
	}
	
	public void add(E e) throws Exception {
	  if (isFuill()) {
        throw new Exception();
      }
	  
	  datas[size++] = e;
	}
	
	public void remove() throws Exception {
	  if (isEmpty()) {
        throw new Exception();
      }
	  
	  index++;
	  size--;
	}
	
	public E element() {
	  if (isEmpty()) {
        return null;
      }
	  
	  return data(index);
	}
	
	public int size() {
	  return size;
	}
	
	public boolean hasNext() {
	  if (size > 0) {
        return true;
      }
	  return false;
	}
	
	public boolean isFuill() {
	  if (size == max) {
        return true;
      }
	  
	  return false;
	}
	
	public boolean isEmpty() {
	  if (size == 0) {
        return true;
      }
	  
	  return false;
	}
	
	public void dispaly() {
	  System.out.println("display: ");
      for (Object data : datas) {
        System.out.print(data + " ");
      }
      System.out.println("");
	}
	
}