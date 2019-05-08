package tree.balanceTree;

public class TestBinarySortTree {

	public static void main(String[] args) {
//		int[] arr = new int[]{8,9,6,7,5,4};
//		int[] arr = new int[]{2,1,4,3,5,6};
		int[] arr = new int[]{8,9,5,4,6,7};
		
		BinarySortTree tree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			tree.add(new Node(arr[i]));
		}
		//查看树中的值
		tree.midShow();
		System.out.println("------------");
		System.out.println(tree.root.height());
		//
		System.out.println(tree.root.value);
		System.out.println(tree.root.leftHeight());
		System.out.println(tree.root.rightHeight());
		
	}
}