package sort;

import java.util.Arrays;
/**
 * ѡ������֮��
 * ��ѡ������
 * @author hasee
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = new int[]{5,3,2,8,5,9,1,0};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectSort(int[] arr){
		//�������е���
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			//�ѵ�ǰ���������ͺ������е������ν��бȽϣ�����¼����С�������±�
			for (int j = i+1; j < arr.length; j++) {
				//�������Ƚϵ����ȼ�¼����С����С
				if(arr[minIndex] > arr[j]){
					//��¼����С���Ǹ������±�
					minIndex = j;
				}
			}
			//�����С�����͵�ǰ���������±겻һ�£�˵���±�ΪminIndex�����ȵ�ǰ����������С
			if(i!= minIndex){
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
