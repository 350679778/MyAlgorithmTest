package algorithm;

import util.MyStack;

public class TestStack {
	
	public static void main(String[] args) {
		//����һ��ջ
		MyStack ms = new MyStack();
		//ѹ������
		ms.push(9);
		ms.push(8);
		ms.push(7);
		ms.push(6);
		//ȡ��ջ��Ԫ��
//		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
	}
}
