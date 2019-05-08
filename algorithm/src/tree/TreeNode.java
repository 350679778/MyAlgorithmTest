package tree;

public class TreeNode {

	//节点的权
	int value;
	//左子节点
	TreeNode leftNode;
	//右子节点
	TreeNode rightNode;
	
	public TreeNode(){
		
	}
	
	public TreeNode(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	//前序遍历
	public void frontShow() {
		//先遍历当前节点的内容
		System.out.println(value);
		//左节点
		if(null != leftNode){
			leftNode.frontShow();
		}
		//右节点
		if(null != rightNode){
			rightNode.frontShow();
		}
	}

	//中序遍历
	public void middleShow() {
		if(null != leftNode){
			leftNode.middleShow();
		}
		System.out.println(value);
		if(null != rightNode){
			rightNode.middleShow();
		}
		
	}

	//后序遍历
	public void afterShow() {
		if(null != leftNode){
			leftNode.afterShow();
		}
		if(null != rightNode){
			rightNode.afterShow();
		}
		System.out.println(value);
	}

	//前序查找
	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		//对比当前节点的值
		if(this.value == i){
			return this;
		//当前节点的值不是要查找的节点
		}else{
			//查找左子节点
			if(null != leftNode){
				//有可能可以查到，也可以查不到，查不到的话，target还是一个null
				target = leftNode.frontSearch(i);
			}
			//如果不为空，说明在左子节点中已经找到
			if(null != target){
				return target;
			}
			//查找右子节点
			if(null != rightNode){
				target = rightNode.frontSearch(i);
			}
		}
		return target;
	}
	
	//删除一个子树
	public void delete(int i){
		TreeNode parent = this;
		//判断左节点
		if(null != parent.leftNode && parent.leftNode.value == i){
			parent.leftNode = null;
			return;
		}
		//判断右节点
		if(null != parent.rightNode && parent.rightNode.value == i){
			parent.rightNode = null;
			return;
		}
		//递归检查并删除左节点
		parent = leftNode;
		if(null != parent){
			parent.delete(i);
		}
		
		//递归检查并删除右节点
		parent = rightNode;
		if(null != parent){
			parent.delete(i);
		}
	}
	
}
