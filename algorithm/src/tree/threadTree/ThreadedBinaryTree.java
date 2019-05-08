package tree.threadTree;

public class ThreadedBinaryTree {

	private ThreadedNode root;
	//用于临时存储前驱节点
	private ThreadedNode pre;
	//获取根节点
	public ThreadedNode getRoot() {
		return root;
	}
	
	//遍历线索二叉树
	public void threadIterate(){
		//用于临时存储当前遍历节点
		ThreadedNode node = root;
		while(node != null){
			//循环找到最开始的节点
			while(node.leftType == 0){
				node = node.leftNode;
			}
			//打印当前节点的值
			System.out.println(node.value);
			//如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
			while(node.rightType == 1){
				node = node.rightNode;
				System.out.println(node.value);
			}
			//替换遍历的节点
			node = node.rightNode;
		}
	}
	
	
	
	//中序线索化二叉树
	public void threadNodes(){
		threadNodes(root);
	}
	
	public void threadNodes(ThreadedNode node){
		//当前节点为null，直接返回
		if(null == node){
			return;
		}
		//处理左子树
		threadNodes(node.leftNode);
		//处理前驱节点
		if(null == node.leftNode){
			//让当前节点的左指针指向前驱节点
			node.leftNode = null;
			//改变当前节点左指针的类型
			node.leftType = 1;
		}
		//处理前驱节点的右指针，如果前驱节点的右指针是null（没有指向右子树）
		if(pre != null && null == pre.rightNode){
			//让前驱节点的右指针指向当前节点
			pre.rightNode = node;
			//改变前驱节点的右指针类型
			pre.rightType = 1;
		}
		
		
		
		//每处理一个节点，当前节点是下一个节点的前驱节点
		pre = node;
		//处理右子树
		threadNodes(node.rightNode);
		
	}

	//设置根节点
	public void setRoot(ThreadedNode root) {
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
	
	public ThreadedNode frontSearch(int i){
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
