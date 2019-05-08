package tree;

public class BinaryTree {

	private TreeNode root;

	//获取根节点
	public TreeNode getRoot() {
		return root;
	}

	//设置根节点
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	//前序遍历
	public void frontShow(){
		if(null != root)
		root.frontShow();
	}
	
	//中序遍历
	public void middleShow(){
		if(null != root)
		root.middleShow();
	}

	//后续遍历
	public void afterShow() {
		if(null != root)
		root.afterShow();
	}
	
	public TreeNode frontSearch(int i){
		return root.frontSearch(i);
	}
	
	public void delete(int i){
		if(root.value == i){
			root = null;
		}else{
			root.delete(i);
		}
	}
	
}
