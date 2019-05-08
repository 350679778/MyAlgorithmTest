package tree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//创建一棵树
		BinaryTree binTree = new BinaryTree();
		//创建一个根节点
		TreeNode root = new TreeNode(1);
		//把根节点赋给树
		binTree.setRoot(root);
		//创建一个左节点
		TreeNode rootL = new TreeNode(2);
		//把新创建的节点设置为根节点的子节点
		root.setLeftNode(rootL);
		//创建一个右节点
		TreeNode rootR = new TreeNode(3);
		//把新创建的节点设置为根节点的子节点
		root.setRightNode(rootR);
		//为第二层的左节点创建两个子节点
		rootL.setLeftNode(new TreeNode(4));
		rootL.setRightNode(new TreeNode(5));
		//为第二层的右节点创建两个子节点
		rootR.setLeftNode(new TreeNode(6));
		rootR.setRightNode(new TreeNode(7));
		
		binTree.frontShow();
		System.out.println("------------");
		binTree.middleShow();
		System.out.println("------------");
		binTree.afterShow();
		
		TreeNode result = binTree.frontSearch(8);
		System.out.println(1);
		System.out.println("------------------------");
		//删除一个子树
		binTree.delete(1);
		binTree.frontShow();
	}
}
