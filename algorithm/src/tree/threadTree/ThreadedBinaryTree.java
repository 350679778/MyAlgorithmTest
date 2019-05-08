package tree.threadTree;

public class ThreadedBinaryTree {

	private ThreadedNode root;
	//������ʱ�洢ǰ���ڵ�
	private ThreadedNode pre;
	//��ȡ���ڵ�
	public ThreadedNode getRoot() {
		return root;
	}
	
	//��������������
	public void threadIterate(){
		//������ʱ�洢��ǰ�����ڵ�
		ThreadedNode node = root;
		while(node != null){
			//ѭ���ҵ��ʼ�Ľڵ�
			while(node.leftType == 0){
				node = node.leftNode;
			}
			//��ӡ��ǰ�ڵ��ֵ
			System.out.println(node.value);
			//�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬���ܺ�̽ڵ㻹�к�̽ڵ�
			while(node.rightType == 1){
				node = node.rightNode;
				System.out.println(node.value);
			}
			//�滻�����Ľڵ�
			node = node.rightNode;
		}
	}
	
	
	
	//����������������
	public void threadNodes(){
		threadNodes(root);
	}
	
	public void threadNodes(ThreadedNode node){
		//��ǰ�ڵ�Ϊnull��ֱ�ӷ���
		if(null == node){
			return;
		}
		//����������
		threadNodes(node.leftNode);
		//����ǰ���ڵ�
		if(null == node.leftNode){
			//�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.leftNode = null;
			//�ı䵱ǰ�ڵ���ָ�������
			node.leftType = 1;
		}
		//����ǰ���ڵ����ָ�룬���ǰ���ڵ����ָ����null��û��ָ����������
		if(pre != null && null == pre.rightNode){
			//��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.rightNode = node;
			//�ı�ǰ���ڵ����ָ������
			pre.rightType = 1;
		}
		
		
		
		//ÿ����һ���ڵ㣬��ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		pre = node;
		//����������
		threadNodes(node.rightNode);
		
	}

	//���ø��ڵ�
	public void setRoot(ThreadedNode root) {
		this.root = root;
	}
	
	//ǰ�����
	public void frontShow(){
		if(null != root)
		root.frontShow();
	}
	
	//�������
	public void middleShow(){
		if(null != root)
		root.middleShow();
	}

	//��������
	public void afterShow() {
		if(null != root)
		root.afterShow();
	}
	
	public ThreadedNode frontSearch(int i){
		return root.frontSearch(i);
	}
	
	public void delete(int i){
		if(root.value == i){
			root = null;
		}else{
			root.delete(i);
		}
	}
	
}
