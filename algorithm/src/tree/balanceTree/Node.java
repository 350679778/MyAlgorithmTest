package tree.balanceTree;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}
	
	
	/**
	 * 返回当前节点的高度
	 * @return
	 */
	public int height(){
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}
	
	/**
	 * 获取左子树的高度
	 * @return
	 */
	public int leftHeight(){
		if(left == null){
			return 0;
		}
		return left.height();
	}
	
	/**
	 * 获取右子树的高度
	 * @return
	 */
	public int rightHeight(){
		if(right == null){
			return 0;
		}
		return right.height();
	}
	
	
	/**
	 * 向子树中添加节点
	 * @param node
	 */
	public void add(Node node) {
		if(null == node){
			return;
		}
		//判断传入的节点的值比当前子树的根节点的值大还是小
		//添加的节点比当前节点小
		if(node.value < this.value){
			//如果左节点为空
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
		//查询是否平衡
		//进行右旋转
		if(leftHeight() - rightHeight()>=2){
			//双旋转
			if(left != null && left.leftHeight()<left.rightHeight()){
				//先左旋转
				left.leftRotate();
				//再右旋转
				rightRotate();
			//单旋转
			}else{
				rightRotate();
			}
			rightRotate();
		}
		
		//左旋转
		if(leftHeight() - rightHeight() <= -2){
			//双旋转
			if(right != null && right.rightHeight() < right.leftHeight()){
				right.rightRotate();
				leftRotate();
			//单旋转
			}else{
				leftRotate();
			}
		}
	}

	/**
	 * 左旋转
	 */
	private void leftRotate() {
		//1.创建一个新节点，值等于当前节点的值
		Node newLeft = new Node(value);
		//2.把新节点的左子树设置为当前节点的左子树
		newLeft.left = left;
		//3.把新节点的右子树设置为当前节点的右子树的左子树
		newLeft.right = right.left; 
		//4.把当前节点的值换为右子节点的值
		value = right.value;
		//5.把当前节点的右子树设置为右子树的右子树
		right = right.right;
		//6.把当前节点的左子树设置为新节点
		left = newLeft;
	}


	/**
	 * 右旋转
	 */
	private void rightRotate() {
		//1.创建一个新节点，值等于当前节点的值
		Node newRight = new Node(value);
		//2.把新节点的右子树设置为当前节点的右子树
		newRight.right = right;
		//3.把新节点的左子树设置为当前节点的左子树的右子树
		newRight.left = left.right;
		//4.把当前节点的值换为左子节点的值
		value = left.value;
		//5.把当前节点的左子树设置为左子树的左子树
		left = left.left;
		//6.把当前节点的右子树设置为新节点
		right = newRight;
		
	}


	/**
	 * 中序遍历
	 */
	public void midShow(Node node) {
		if(node == null)
			return;
		midShow(node.left);
		System.out.println(node.value);
		midShow(node.right);
	}

	/**
	 * 查找节点
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
	 * 搜索父节点
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