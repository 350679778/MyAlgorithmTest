package tree.binarySortTree;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}
	
	/**
	 * ����������ӽڵ�
	 * @param node
	 */
	public void add(Node node) {
		if(null == node){
			return;
		}
		//�жϴ���Ľڵ��ֵ�ȵ�ǰ�����ĸ��ڵ��ֵ����С
		//��ӵĽڵ�ȵ�ǰ�ڵ�С
		if(node.value < this.value){
			//�����ڵ�Ϊ��
			if(this.left == null){
				this.left = node;
			}else{
				this.left.add(node);
			}
		}else{
			if(this.right == null){
				this.right = node;
			}else{
				this.right.add(node);
			}
		}
	}

	/**
	 * �������
	 */
	public void midShow(Node node) {
		if(node == null)
			return;
		midShow(node.left);
		System.out.println(node.value);
		midShow(node.right);
	}

	/**
	 * ���ҽڵ�
	 * @param node
	 */
	public Node search(int value) {
		if(this.value == value){
			return this;
		}else if(value < this.value){
			if(left == null)
				return null;
			return left.search(value);
		}else{
			if(right == null)
				return null;
			return right.search(value);
		}
	}

	
	/**
	 * �������ڵ�
	 * @param value2
	 * @return
	 */
	public Node searchParent(int value) {
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
			return this;
		}else{
			if(this.value > value && this.left != null){
				return this.left.searchParent(value);
			}else if(this.value < value && this.right != null){
				return this.right.searchParent(value);
			}
			return null;
		}
	}
	
	
}