package demo.algorithm.bubble;

import demo.algorithm.Sort;
import utils.IntegerHelper;

public class BubbleSort implements Sort {

  private Integer[] datas = null;

  public BubbleSort(Integer[] datas) {
    this.datas = datas;
  }

  public void sort() {
    for (int i = size() -1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (datas[j] > datas[j + 1]) {
          swap(j, j + 1);
        }
        display();
      }
    }
  }
  
  public int size() {
    int size = 0;
    for (int i = 0; i < datas.length; i++) {
      if (datas[i] == null) {
        break;
      }
      size ++;
    }
    return size;
  }

  public void display() {
    System.out.print(datas.length + "[");
    for (Integer data : datas) {
      System.out.print(" " + data + ",");
    }
    System.out.println("]");
  }

  private void swap(int a, int b) {
    int temp = datas[a];
    datas[a] = datas[b];
    datas[b] = temp;
  }

  public static void main(String[] args) {
    Integer[] datas = new Integer[20];
    for (int i = 0; i < 10; i++) {
      datas[i] = IntegerHelper.random(2);
    }
    BubbleSort bubbleSort = new BubbleSort(datas);
    bubbleSort.display();
    bubbleSort.sort();
    bubbleSort.display();
  }

}
