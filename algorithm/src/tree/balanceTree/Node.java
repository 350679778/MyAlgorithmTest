package tree.balanceTree;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}
	
	
	/**
	 * ���ص�ǰ�ڵ�ĸ߶�
	 * @return
	 */
	public int height(){
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}
	
	/**
	 * ��ȡ�������ĸ߶�
	 * @return
	 */
	public int leftHeight(){
		if(left == null){
			return 0;
		}
		return left.height();
	}
	
	/**
	 * ��ȡ�������ĸ߶�
	 * @return
	 */
	public int rightHeight(){
		if(right == null){
			return 0;
		}
		return right.height();
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
		//��ѯ�Ƿ�ƽ��
		//��������ת
		if(leftHeight() - rightHeight()>=2){
			//˫��ת
			if(left != null && left.leftHeight()<left.rightHeight()){
				//������ת
				left.leftRotate();
				//������ת
				rightRotate();
			//����ת
			}else{
				rightRotate();
			}
			rightRotate();
		}
		
		//����ת
		if(leftHeight() - rightHeight() <= -2){
			//˫��ת
			if(right != null && right.rightHeight() < right.leftHeight()){
				right.rightRotate();
				leftRotate();
			//����ת
			}else{
				leftRotate();
			}
		}
	}

	/**
	 * ����ת
	 */
	private void leftRotate() {
		//1.����һ���½ڵ㣬ֵ���ڵ�ǰ�ڵ��ֵ
		Node newLeft = new Node(value);
		//2.���½ڵ������������Ϊ��ǰ�ڵ��������
		newLeft.left = left;
		//3.���½ڵ������������Ϊ��ǰ�ڵ����������������
		newLeft.right = right.left; 
		//4.�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
		value = right.value;
		//5.�ѵ�ǰ�ڵ������������Ϊ��������������
		right = right.right;
		//6.�ѵ�ǰ�ڵ������������Ϊ�½ڵ�
		left = newLeft;
	}


	/**
	 * ����ת
	 */
	private void rightRotate() {
		//1.����һ���½ڵ㣬ֵ���ڵ�ǰ�ڵ��ֵ
		Node newRight = new Node(value);
		//2.���½ڵ������������Ϊ��ǰ�ڵ��������
		newRight.right = right;
		//3.���½ڵ������������Ϊ��ǰ�ڵ����������������
		newRight.left = left.right;
		//4.�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
		value = left.value;
		//5.�ѵ�ǰ�ڵ������������Ϊ��������������
		left = left.left;
		//6.�ѵ�ǰ�ڵ������������Ϊ�½ڵ�
		right = newRight;
		
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