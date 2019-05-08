package tree.binarySortTree;

public class TestBinarySortTree {

	public static void main(String[] args) {
		int[] arr = new int[]{7,3,10,12,5,1,9};
		BinarySortTree tree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			tree.add(new Node(arr[i]));
		}
		//查看树中的值
		tree.midShow();
		
//		Node node = tree.search(10);
//		System.out.println(node.value);
//		System.out.println("---------------");
//		Node node2 = tree.search(20);
//		System.out.println(node2);
//		System.out.println("---------------");
		//查找父节点
//		Node p1 = tree.searchParent(12);
//		System.out.println(p1.value);
//		System.out.println("---------------");
//		tree.delete(12);
//		tree.midShow();
//		System.out.println("---------------");
//		tree.delete(10);
//		tree.midShow();
//		System.out.println("删除叶子节点---------------");
//		tree.delete(5);
//		tree.midShow();
//		System.out.println("删除只有一个子节点的节点---------------");
//		tree.delete(3);
//		tree.midShow();
		
		System.out.println("删除有两个子节点的节点----------");
		tree.delete(7);
		tree.midShow();
		System.out.println("----------");
		tree.delete(10);
		tree.midShow();
		
	}
}