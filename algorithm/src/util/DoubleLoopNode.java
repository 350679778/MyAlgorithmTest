package util;

public class DoubleLoopNode {

	//��һ���ڵ�
	DoubleLoopNode prev = this;
	//��һ���ڵ�
	DoubleLoopNode next = this;
	//�ڵ�����
	int data;
	
	public DoubleLoopNode(int data){
		this.data = data;
	}
	
	//���ӽڵ�
	public void after(DoubleLoopNode node){
		//ԭ������һ���ڵ�
		DoubleLoopNode nextNext = next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next = node;
		//�ѵ�ǰ�ڵ���Ϊ�½ڵ��ǰһ���ڵ�
		node.prev = this;
		//��ԭ������һ���ڵ����½ڵ����һ���ڵ�
		node.next = nextNext;
		//��ԭ������һ���ڵ����һ���ڵ�Ϊ�½ڵ�
		nextNext.prev = node;
	}
	
	//��һ���ڵ�
	public DoubleLoopNode next(){
		return this.next;
	}
	
	//��һ���ڵ�
	public DoubleLoopNode prev(){
		return this.prev;
	}
	
	//��ȡ����
	public int getData(){
		return data;
	}
	
}
