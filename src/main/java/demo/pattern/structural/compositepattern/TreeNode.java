package demo.pattern.structural.compositepattern;


/**
 * 二叉树模型
 *
 */
public class TreeNode {
	
	private int no;
	
	private String name;
	
	private TreeNode left;
	
	private TreeNode right;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	// 采用递归，自我打印
	public void display() {
		System.out.println("[no: " + no + ", name: " + name + "]");
		if (left != null) {
			left.display();
		}
		if (right != null) {
			right.display();
		}
	}

}
