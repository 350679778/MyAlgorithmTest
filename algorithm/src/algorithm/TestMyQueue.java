package algorithm;

import util.MyQueue;

public class TestMyQueue {

	public static void main(String[] args) {
		//����һ������
		MyQueue mq = new MyQueue();
		//���
		mq.add(9);
		mq.add(8);
		mq.add(7);
		//����
		System.out.println(mq.poll());
		System.out.println(mq.poll());
		System.out.println(mq.poll());
	}
}
