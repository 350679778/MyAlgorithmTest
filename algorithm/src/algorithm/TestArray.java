package algorithm;

public class TestArray {
	
	public static void main(String[] args) {
		//����һ������
		int[] arr1 = new int[3];
		//��ȡ���鳤��
		int length1 = arr1.length;
		System.out.println("arr1's length : " + length1);
		
		//���������е�Ԫ��:������[�±�] ע�⣺�±��0��ʼ
		int element1 = arr1[0];
		System.out.println("element0 : " + element1);
		//Ϊ�����е�Ԫ�ظ�ֵ
		arr1[0] = 99;
		System.out.println("element0 : " + arr1[0]);
		arr1[1] = 98;
		arr1[2] = 97;
		
		//��������
		for (int i = 0; i < length1; i++) {
			System.out.println("arr1 element" + i + " : " + arr1[i]);
			
		}
		
		//���������ͬʱΪ�����е�Ԫ�ظ�ֵ
		int[] arr2 = new int[]{90,80,70,60,50};
		//��ȡ����ĳ���
		System.out.println("arr2 length : " + arr2.length);
	}
}
