package demo.structure.array;


/**
 * 优点：插入快，如果知道下表查找非常快，实现简单
 * 缺点：大小固定，查找慢，删除慢
 * 
 * 名词解释：
 * 元素：数组中的每一个对象
 * 下标：数组中某个对象所在的位置
 * 
 * 无须数组对实际意义不大，因此直接实现有序数组
 */
public class Array {

	private String[] values;
	private int length;
	
	public Array() {
		this.values = new String[10];
		this.length = 0;
	}
	
	public Array(int length) {
		this.values = new String[length];
		this.length = 0; 
	}
	
	public int length() {
		return length;
	}
	
	// 检测数组是否包含目标值
	public boolean contain(String v) {
		return contain(v, false);
	}
	
	public boolean contain(String v, boolean is) {
		// 二分查找，时间复杂度 O(logN)
		if (is) {
			int begin = 0, end = values.length;
			while (is) {
				int index = begin + (end - begin) / 2;
				int c = v.compareTo(values[index]);
				if (c == 0) {
					return true;
				}

				if (begin == end) {
					return false;
				}
				
				if (c > 0) {
					begin = index + 1;
				}
				if (c < 0) {
					end = index - 1;
				}
			}
			
			return false;
		} 
		// 逐个遍历，时间复杂度 N
		else {
			for (String string : values) {
				if (v.equals(string)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public String get(int i) {
		if (i > values.length - 1 || i < 0) {
			return null;
		}
		
		return values[i];
	}
	
	// 新增元素
	// 注：有序数组，在插入的时候进行排序。1.确定插入位置；2.将插入位置及以后的所有元素向后移动一位
	public boolean add(String v) {
		if (values.length == length) {
			return false;
		}
		
		for (int i = 0; i <= length; i++) {
			if (values[i] == null) {
				values[i] = v;
				length++;
				return true;
			}
			int compare = v.compareTo(values[i]);
			if (compare < 0) {
				String current = v;
				String temp = "";
				for (int j = i; j < length; j++) {
					temp = values[j];
					values[j] = current;
					current = temp;
				}
				values[length] = current;
				length++;
				return true;
			}
		}
		return false;
	}
	
	// 删除元素
	// 注：1.确定被删除的元素下标；2.将此下标之后的所有元素向前移动一位
	public boolean del(String v) {
		Integer index = find(v);
		if (index != null) {
			for (int i = index; i < values.length - 1; i++) {
				values[i] = values[i + 1];
			}
			values[values.length] = null;
		}
		return false;
	}
	
	public int find(String v) {
		Integer r = find(v, null, null);
		return r == null ? -1 : r;
	}
	
	// 根据值获取下标
	private Integer find(String v, Integer begin, Integer end) {
		if (begin == null) {
			begin = 0;
		}
		if (end == null) {
			end = length - 1;
		}
		
		if (begin >= end) {
			return null;
		}
		
		int index = begin + (end - begin) / 2;
		
		int c = v.compareTo(values[index]);
		if (c == 0) {
			return index;
		} 
		else if (c < 0) {
			return find(v, begin, index - 1);
		}
		else {
			return find(v, index + 1, end);
		}
	}
	
	// 根据值获取下标
	private int[] findAll(String v, Integer begin, Integer end) {
		if (begin == null) {
			begin = 0;
		}
		if (end == null) {
			end = values.length - 1;
		}
		int[] results = new int[] {};
		int times = 0;
		
		int index = begin + (end - begin) / 2;
		int c = v.compareTo(values[index]);
		if (c == 0) {
			results[times] = index;
			times++;
			
			// 检测左侧相邻对象是否与目标对象相等
			String left = null;
			int l = -1;
			do {
				left = find(index, l);
				if (left.equals(v)) {
					results[times] = index + l;
					l--;
					times++;
				}
			} while (left.equals(v));
			
			// 按测右侧相邻对象是否与目标对象相等
			String right = null;
			int r = +1;
			do {
				right = find(index, r);
				if (right.equals(v)) {
					results[times] = index + r;
					r++;
					times++;
				}
			} while (right.equals(v));
		} 
		else if (c < 0) {
			find(v, begin, index - 1);
		}
		else {
			find(v, index + 1, end);
		}
		
		return results;
	}
	
	private String find(int index, int offset) {
		if (index == 0 && offset < 0) {
			return null;
		}
		if (index == values.length && offset > 0) {
			return null;
		}
		
		return values[index + offset];
	}
	
	public void display() {
		for (String string : values) {
			System.out.print(string + " ");
		}
		System.out.println(" ");
	}
	
}
