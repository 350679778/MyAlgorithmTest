package algorithm;

import util.DoubleLoopNode;

public class TestDoubleLoopNode {

	public static void main(String[] args) {
		//�����ڵ�
		DoubleLoopNode n1 = new DoubleLoopNode(1);
		DoubleLoopNode n2 = new DoubleLoopNode(2);
		DoubleLoopNode n3 = new DoubleLoopNode(3);
		DoubleLoopNode n4 = new DoubleLoopNode(4);
		//׷�ӽڵ�
		n1.after(n2);
		n2.after(n3);
		
		//�鿴��һ�����Լ�����һ���ڵ������
		System.out.println(n1.prev().getData());
		System.out.println(n1.getData());
		System.out.println(n1.next().getData());
	}
}
