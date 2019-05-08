package util;

public class MyStack {
	
	//ջ�ĵײ�����ʹ���������洢����
	int[] elements;
	
	public MyStack(){
		elements = new int[0];
	}
	
	//ѹ��Ԫ��
	public void push(int element){
		//����һ���µ�����
		int[] newArr = new int[elements.length + 1];
		//��ԭ�����е�Ԫ�ظ�ֵ����������
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		//����ӵ�Ԫ�ط�����������
		newArr[elements.length] = element;
		//ʹ���������滻������
		elements = newArr;
	}
	
	//ȡ��ջ��Ԫ��
	public int pop(){
		if(elements.length == 0){
			throw new RuntimeException("stack is empty");
		}
		//ȡ�������е����һ��Ԫ��
		int element = elements[elements.length - 1];
		//����һ���µ�����
		int[] newArr = new int[elements.length - 1];
		//ԭ�����г������һ��Ԫ�ص�����Ԫ�ض������µ�������
		for (int i = 0; i < elements.length - 1; i++) {
			newArr[i] = elements[i];
		}
		//�滻����
		elements = newArr;
		//����ջ��Ԫ��
		return element;
	}
	
	//�鿴ջ��Ԫ��
	public int peek(){
		return elements[elements.length - 1];
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return elements.length == 0;
	}
}
