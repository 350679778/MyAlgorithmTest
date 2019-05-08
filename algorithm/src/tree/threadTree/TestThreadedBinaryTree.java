package tree.threadTree;

public class TestThreadedBinaryTree {
	public static void main(String[] args) {
		//����һ����
		ThreadedBinaryTree binTree = new ThreadedBinaryTree();
		//����һ�����ڵ�
		ThreadedNode root = new ThreadedNode(1);
		//�Ѹ��ڵ㸳����
		binTree.setRoot(root);
		//����һ����ڵ�
		ThreadedNode rootL = new ThreadedNode(2);
		//���´����Ľڵ�����Ϊ���ڵ���ӽڵ�
		root.setLeftNode(rootL);
		//����һ���ҽڵ�
		ThreadedNode rootR = new ThreadedNode(3);
		//���´����Ľڵ�����Ϊ���ڵ���ӽڵ�
		root.setRightNode(rootR);
		//Ϊ�ڶ������ڵ㴴�������ӽڵ�
		rootL.setLeftNode(new ThreadedNode(4));
		ThreadedNode fiveNode = new ThreadedNode(5);
		rootL.setRightNode(fiveNode);
		//Ϊ�ڶ�����ҽڵ㴴�������ӽڵ�
		rootR.setLeftNode(new ThreadedNode(6));
		rootR.setRightNode(new ThreadedNode(7));
		//���������
		binTree.middleShow();
		System.out.println("����������������----------------------");
		binTree.threadNodes();
		binTree.threadIterate();
	}
}
