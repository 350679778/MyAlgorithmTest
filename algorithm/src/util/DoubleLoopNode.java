package util;

public class DoubleLoopNode {

	//上一个节点
	DoubleLoopNode prev = this;
	//下一个节点
	DoubleLoopNode next = this;
	//节点数据
	int data;
	
	public DoubleLoopNode(int data){
		this.data = data;
	}
	
	//增加节点
	public void after(DoubleLoopNode node){
		//原来的下一个节点
		DoubleLoopNode nextNext = next;
		//把新节点作为当前节点的下一个节点
		this.next = node;
		//把当前节点作为新节点的前一个节点
		node.prev = this;
		//让原来的下一个节点作新节点的下一个节点
		node.next = nextNext;
		//让原来的下一个节点的上一个节点为新节点
		nextNext.prev = node;
	}
	
	//下一个节点
	public DoubleLoopNode next(){
		return this.next;
	}
	
	//上一个节点
	public DoubleLoopNode prev(){
		return this.prev;
	}
	
	//获取数据
	public int getData(){
		return data;
	}
	
}
