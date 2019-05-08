package util;

public class LoopNode {
	//�ڵ�����
	int data;
	//��һ���ڵ�
	LoopNode next = this;
	
	public LoopNode(int data){
		this.data = data;
	}
	
	//����һ���ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
	public void after(LoopNode node){
		//ȡ����һ���ڵ㣬��Ϊ����һ���ڵ�
		LoopNode nextNext = next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next = node;
		//������һ���ڵ�����Ϊ�½ڵ����һ���ڵ�
		node.next = nextNext;
	}
	
	//ɾ����һ���ڵ�
	public void removeNext(){
		//ȡ������һ���ڵ�
		LoopNode newNext = next.next;
		//������һ���ڵ����óɵ�ǰ�ڵ����һ���ڵ�
		this.next = newNext;
	}
	//ȡ����һ���ڵ�
	public LoopNode next(){
		return this.next;
	}
	
	//��ȡ�ڵ��е�����
	public int getData(){
		return this.data;
	}
	
	//�ж��Ƿ������һ���ڵ�
	public boolean isLast(){
		return null == next;
	}

}
