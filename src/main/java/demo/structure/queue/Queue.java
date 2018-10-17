package demo.structure.queue;

public class Queue<E> {
	
	private final static int DEFAULT_SIZE = 10;

	private Object[] datas;
    private int max;
    private int size;
	private int index;
	
	public Queue() {
		this(DEFAULT_SIZE);
	}

	public Queue(int size) {
		this.datas = new Object[size];
		this.max = size;
		this.size = 0;
        this.index = -1;
	}
	
	@SuppressWarnings("unchecked")
    private E data(int index) {
	  return (E) datas[index];
	}
	
	public void add() {
	  
	}
	
	public void remove() {
	  
	}
	
	public void element() {
	  
	}
	
	public int size() {
	  return size;
	}
	
	public boolean hasNext() {
	  return false;
	}
	
	public boolean isFuill() {
	  return false;
	}
	
	public boolean isEmpty() {
	  return false;
	}
	
	public void dispaly() {
	  
	}
	
}