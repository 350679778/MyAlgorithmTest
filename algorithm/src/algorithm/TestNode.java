package algorithm;

import util.Node;

public class TestNode {

	public static void main(String[] args) {
		//�����ڵ�
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		//׷�ӽڵ�
		n1.append(n2).append(n3).append(new Node(4));
		//ȡ����һ���ڵ�
//		System.out.println(n1.next().next().next().getData());
		//�жϽڵ��Ƿ�Ϊ���һ���ڵ�
//		System.out.println(n1.next().next().isLast());
//		System.out.println(n1.next().next().next().isLast());
		//��ʾ���нڵ�����
		n1.show();
		//ɾ��һ���ڵ�
//		n1.next().removeNext();
		//��ʾ���нڵ�����
//		n1.show();
		//����һ���½ڵ�
		Node node = new Node(5);
		n1.next().after(node);
		n1.show();
	}
}
