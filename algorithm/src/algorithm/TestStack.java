package algorithm;

import util.MyStack;

public class TestStack {
	
	public static void main(String[] args) {
		//创建一个栈
		MyStack ms = new MyStack();
		//压入数据
		ms.push(9);
		ms.push(8);
		ms.push(7);
		ms.push(6);
		//取出栈顶元素
//		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
	}
}
