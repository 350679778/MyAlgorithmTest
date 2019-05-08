package sort;

import java.util.Arrays;

/**
 * 插入排序之：
 * 希尔排序
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
		//遍历所有的步长
		for (int d = arr.length/2; d > 0; d/=2) {
			//遍历所有的元素
			for (int i = 0; i < arr.length; i++) {
				//遍历本组中所有的元素
				for (int j = i-d; j >= 0; j-=d) {
					if(arr[j] > arr[j+d]){
						int temp = arr[j];
						arr[j] = arr[j+d];
						arr[j+d] = temp;
					}
				}
			}
			System.out.println("第"+ k +"次排序结果" + Arrays.toString(arr));
			k++;
		}
	}

}
