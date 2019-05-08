package tree;

public class BinaryTree {

	private TreeNode root;

	//��ȡ���ڵ�
	public TreeNode getRoot() {
		return root;
	}

	//���ø��ڵ�
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	//ǰ�����
	public void frontShow(){
		if(null != root)
		root.frontShow();
	}
	
	//�������
	public void middleShow(){
		if(null != root)
		root.middleShow();
	}

	//��������
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
