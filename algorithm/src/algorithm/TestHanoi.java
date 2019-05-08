package algorithm;

public class TestHanoi {

	public static void main(String[] args) {
		hanoi(4,'A','B','C');
	}
	
	/**
	 * @param n		����N������
	 * @param from 	��ʼ������
	 * @param in	�м������
	 * @param to	Ŀ������
	 * �����ж��ٸ����ӣ�����Ϊֻ��������������������Ӻ�������һ������
	 */
	public static void hanoi(int n,char from,char in,char to){
		if (n == 1) {
			System.out.println("��1�����Ӵ�" + from + "�Ƶ�" + to);
		//�����ж��ٸ����ӣ�����Ϊֻ��������������������Ӻ�������һ������
		}else{
			//�ƶ��������е����ӵ��м�λ��
			hanoi(n-1,from,to,in);
			//�ƶ����������
			System.out.println("��"+ n +"�����Ӵ�" + from + "�Ƶ�" + to);
			//��������������Ӵ��м�λ���Ƶ�Ŀ��λ��
			hanoi(n-1,in,from,to);
		}
	}
}
