package demo.structure.tree.node;

import net.sf.json.JSONObject;

public class TreeNode<E> {

  private E data;
  private TreeNode<E> left;
  private TreeNode<E> right;
  
  public TreeNode(E data) {
    this(data, null, null);
  }
  
  public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  public E data() {
    return this.data;
  }
  
  public TreeNode<E> left() {
    return left;
  }

  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  public TreeNode<E> right() {
    return right;
  }

  public void setRight(TreeNode<E> right) {
    this.right = right;
  }

  public void display() {
    System.out.println("data: " + JSONObject.fromObject(this.data).toString());
  }
  
}
