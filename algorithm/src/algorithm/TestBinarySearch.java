package algorithm;

public class TestBinarySearch {

	public static void main(String[] args) {
		//���ַ�����
		//Ŀ������
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		//Ŀ��Ԫ��
		int target = 3;
		//��¼��ʼλ��
		int begin = 0;
		//��¼����λ��
		int end = arr.length - 1;
		//��¼�м��λ��
		int mid = (begin + end) / 2;
		//��¼Ŀ��λ��
		int index = -1;
		//ѭ������
		while(true){
			System.out.println("begin:"+begin+",end:"+end+",mid:"+mid);
			//�ж��м�����Ԫ���ǲ���Ҫ���ҵ�Ԫ��
			if(arr[mid] == target){
				index = mid;
				break;
			//�м����Ԫ�ز���Ҫ���Ԫ��
			}else{
				//�ж��м����Ԫ���ǲ��Ǳ�Ŀ��Ԫ�ش�
				if(arr[mid] > target){
					//�ѽ���λ�õ������м�λ��ǰһ��λ��
					end = mid;
				//�м����Ԫ�ر�Ŀ��Ԫ��С
				}else{
					//�ѿ�ʼλ�õ������м�λ�õĺ�һ��λ��
					begin = mid;
				}
				//ȡ���µ��м�λ��
				mid = (begin + end) / 2;
			}
		}
		System.out.println("index : " + index);
		
	}
}
