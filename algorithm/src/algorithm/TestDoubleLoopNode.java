package algorithm;

import util.DoubleLoopNode;

public class TestDoubleLoopNode {

	public static void main(String[] args) {
		//创建节点
		DoubleLoopNode n1 = new DoubleLoopNode(1);
		DoubleLoopNode n2 = new DoubleLoopNode(2);
		DoubleLoopNode n3 = new DoubleLoopNode(3);
		DoubleLoopNode n4 = new DoubleLoopNode(4);
		//追加节点
		n1.after(n2);
		n2.after(n3);
		
		//查看上一个、自己、下一个节点的内容
		System.out.println(n1.prev().getData());
		System.out.println(n1.getData());
		System.out.println(n1.next().getData());
	}
}
