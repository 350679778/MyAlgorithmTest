package tree.binarySortTree;

public class TestBinarySortTree {

	public static void main(String[] args) {
		int[] arr = new int[]{7,3,10,12,5,1,9};
		BinarySortTree tree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			tree.add(new Node(arr[i]));
		}
		//�鿴���е�ֵ
		tree.midShow();
		
//		Node node = tree.search(10);
//		System.out.println(node.value);
//		System.out.println("---------------");
//		Node node2 = tree.search(20);
//		System.out.println(node2);
//		System.out.println("---------------");
		//���Ҹ��ڵ�
//		Node p1 = tree.searchParent(12);
//		System.out.println(p1.value);
//		System.out.println("---------------");
//		tree.delete(12);
//		tree.midShow();
//		System.out.println("---------------");
//		tree.delete(10);
//		tree.midShow();
//		System.out.println("ɾ��Ҷ�ӽڵ�---------------");
//		tree.delete(5);
//		tree.midShow();
//		System.out.println("ɾ��ֻ��һ���ӽڵ�Ľڵ�---------------");
//		tree.delete(3);
//		tree.midShow();
		
		System.out.println("ɾ���������ӽڵ�Ľڵ�----------");
		tree.delete(7);
		tree.midShow();
		System.out.println("----------");
		tree.delete(10);
		tree.midShow();
		
	}
}