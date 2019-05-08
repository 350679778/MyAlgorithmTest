package tree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//����һ����
		BinaryTree binTree = new BinaryTree();
		//����һ�����ڵ�
		TreeNode root = new TreeNode(1);
		//�Ѹ��ڵ㸳����
		binTree.setRoot(root);
		//����һ����ڵ�
		TreeNode rootL = new TreeNode(2);
		//���´����Ľڵ�����Ϊ���ڵ���ӽڵ�
		root.setLeftNode(rootL);
		//����һ���ҽڵ�
		TreeNode rootR = new TreeNode(3);
		//���´����Ľڵ�����Ϊ���ڵ���ӽڵ�
		root.setRightNode(rootR);
		//Ϊ�ڶ������ڵ㴴�������ӽڵ�
		rootL.setLeftNode(new TreeNode(4));
		rootL.setRightNode(new TreeNode(5));
		//Ϊ�ڶ�����ҽڵ㴴�������ӽڵ�
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
		//ɾ��һ������
		binTree.delete(1);
		binTree.frontShow();
	}
}
