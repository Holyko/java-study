package demo.algorithm.selection;

import demo.algorithm.Sort;
import demo.algorithm.bubble.BubbleSort;
import utils.IntegerHelper;

public class SelectionSort implements Sort {

  private Integer[] datas = null;

  public SelectionSort(Integer[] datas) {
    this.datas = datas;
  }

  public void display() {
    System.out.print(datas.length + "[");
    for (Integer data : datas) {
      System.out.print(" " + data + ",");
    }
    System.out.println("]");
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
  
  public void sort() {
    for (int i = 0; i < size() - 1; i++) {
      int target = i;
      int min = i;
      for (int j = i + 1; j < size(); j++) {
        if (datas[min] > datas[j]) {
          min = j;
        }
      }
      swap(target, min);
    }
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
    SelectionSort selectionSort = new SelectionSort(datas);
    selectionSort.display();
    selectionSort.sort();
    selectionSort.display();
  }

}
