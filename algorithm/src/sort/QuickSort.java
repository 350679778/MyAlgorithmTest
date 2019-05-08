package sort;

import java.util.Arrays;

/**
 * ��������֮��
 * ��������
 * @author hasee
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{3,4,6,7,2,7,2,8,0};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr,int start,int end){
		if(start >= end){
			return;
		}
		//�������еĵ�0��������Ϊ��׼��
		int startObj = arr[start];
		//��¼��Ҫ������±�
		int low = start;
		int high = end;
		//ѭ���ұȱ�׼��������ͱȱ�׼��С����
		while(low<high){
			//�ұߵ����ֱȱ�׼����
			while(low<high && startObj <= arr[high]){
				high--;
			}
			//ʹ���ұߵ������滻��ߵ���
			arr[low] = arr[high];
			//���
			while(low<high && arr[low] <= startObj){
				low++;
			}
			arr[high] = arr[low];
		}
		//�ѱ�׼������������λ�õ�Ԫ��
		arr[low] = startObj;
		//�������е�С������
		quickSort(arr,start,low);
		//�������еĴ������
		quickSort(arr,low+1,end);
	}
}
