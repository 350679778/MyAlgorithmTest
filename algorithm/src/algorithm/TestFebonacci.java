package algorithm;
 
//쳲���������
public class TestFebonacci {

	public static void main(String[] args) {
		//쳲���������
		int i = febonacci(4);
		System.out.println(i);
	}
	
	public static int febonacci(int i){
		if(i == 1 || i == 2){
			return 1;
		}else{
			return febonacci(i - 1) + febonacci(i - 2);
		}
	}
}
