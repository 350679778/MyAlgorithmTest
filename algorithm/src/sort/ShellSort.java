package sort;

import java.util.Arrays;

/**
 * ��������֮��
 * ϣ������
 * @author hasee
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[]{5,3,2,8,5,9,1,0};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shellSort(int[] arr){
		int k=1;
		//�������еĲ���
		for (int d = arr.length/2; d > 0; d/=2) {
			//�������е�Ԫ��
			for (int i = 0; i < arr.length; i++) {
				//�������������е�Ԫ��
				for (int j = i-d; j >= 0; j-=d) {
					if(arr[j] > arr[j+d]){
						int temp = arr[j];
						arr[j] = arr[j+d];
						arr[j+d] = temp;
					}
				}
			}
			System.out.println("��"+ k +"��������" + Arrays.toString(arr));
			k++;
		}
	}

}
