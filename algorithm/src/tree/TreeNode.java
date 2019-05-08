package tree;

public class TreeNode {

	//�ڵ��Ȩ
	int value;
	//���ӽڵ�
	TreeNode leftNode;
	//���ӽڵ�
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

	//ǰ�����
	public void frontShow() {
		//�ȱ�����ǰ�ڵ������
		System.out.println(value);
		//��ڵ�
		if(null != leftNode){
			leftNode.frontShow();
		}
		//�ҽڵ�
		if(null != rightNode){
			rightNode.frontShow();
		}
	}

	//�������
	public void middleShow() {
		if(null != leftNode){
			leftNode.middleShow();
		}
		System.out.println(value);
		if(null != rightNode){
			rightNode.middleShow();
		}
		
	}

	//�������
	public void afterShow() {
		if(null != leftNode){
			leftNode.afterShow();
		}
		if(null != rightNode){
			rightNode.afterShow();
		}
		System.out.println(value);
	}

	//ǰ�����
	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		//�Աȵ�ǰ�ڵ��ֵ
		if(this.value == i){
			return this;
		//��ǰ�ڵ��ֵ����Ҫ���ҵĽڵ�
		}else{
			//�������ӽڵ�
			if(null != leftNode){
				//�п��ܿ��Բ鵽��Ҳ���Բ鲻�����鲻���Ļ���target����һ��null
				target = leftNode.frontSearch(i);
			}
			//�����Ϊ�գ�˵�������ӽڵ����Ѿ��ҵ�
			if(null != target){
				return target;
			}
			//�������ӽڵ�
			if(null != rightNode){
				target = rightNode.frontSearch(i);
			}
		}
		return target;
	}
	
	//ɾ��һ������
	public void delete(int i){
		TreeNode parent = this;
		//�ж���ڵ�
		if(null != parent.leftNode && parent.leftNode.value == i){
			parent.leftNode = null;
			return;
		}
		//�ж��ҽڵ�
		if(null != parent.rightNode && parent.rightNode.value == i){
			parent.rightNode = null;
			return;
		}
		//�ݹ��鲢ɾ����ڵ�
		parent = leftNode;
		if(null != parent){
			parent.delete(i);
		}
		
		//�ݹ��鲢ɾ���ҽڵ�
		parent = rightNode;
		if(null != parent){
			parent.delete(i);
		}
	}
	
}
