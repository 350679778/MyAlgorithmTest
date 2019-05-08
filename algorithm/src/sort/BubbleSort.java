package sort;

import java.util.Arrays;

/**
 * ��������֮��
 * ð������
 * @author hasee
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[]{5,7,2,9,4,1,0,5,7};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * ð������
	 * 5,7,2,9,4,1,0,5,7	����Ҫ�Ƚ�length-1��
	 * 5,7,2,9,4,1,0,5,7
	 * @param arr
	 */
	public static void bubbleSort(int[] arr){
		//���ƹ��Ƚ϶�����
		for (int i = 0; i < arr.length - 1; i++) {
			//���ƱȽϵĴ���
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
