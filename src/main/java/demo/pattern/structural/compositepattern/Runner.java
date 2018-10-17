package demo.pattern.structural.compositepattern;

/**
 * 组合模式
 * 二叉树数据模型就是一个典型的组合模式
 *
 */
public class Runner {

	// 手工构建一个简单的二叉树节点
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(0, "根节点");
		TreeNode left = new TreeNode(-100, "左子节点");
		TreeNode right = new TreeNode(100, "右子节点");
		
		root.setLeft(left);
		root.setRight(right);
		
		root.display();
	}
	
}
