package tree.balanceTree;

public class BinarySortTree {

	Node root;
	
	/**
	 * ���������������ӽڵ�
	 * @param node
	 */
	public void add(Node node){
		//�����һ�ſ���
		if(null == root){
			root = node;
		}else{
			root.add(node);
		}
	}
	
	public void midShow(){
		if(root != null){
			root.midShow(root);
		}
	}
	
	public Node search(int value){
		if(root != null){
			return root.search(value);
		}else{
			return null;
		}
	}
	
	
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public void delete(int value){
		if(root == null){
			return;
		}else{
			//�ҵ�����ڵ�
			Node target = search(value);
			//���û������ڵ�
			if(target == null){
				return;
			}
			//�ҵ����ĸ��ڵ�
			Node parent = searchParent(value);
			//Ҫɾ���Ľڵ���Ҷ�ӽڵ�
			if(target.left == null && target.right == null){
				//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
				if(parent.left.value == value){
					parent.left = null;
				}else{
					//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
					parent.right = null;
				}
			//Ҫɾ���Ľڵ��������ӽڵ�
			}else if(target.left != null && target.right != null){
				//ɾ����������ֵ��С�ļ��㣬ȡ��ȡ���ýڵ��ֵ
				int min = deleteMin(target.right);
				//�滻Ŀ��ڵ��е�ֵ
				target.value = min;
			//Ҫɾ���Ľڵ���һ�����ӽڵ�����ӽڵ�
			}else{
				if(target.left != null){
					//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
					if(parent.left.value == value){
						parent.left = target.left;
					}else{
						//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
						parent.right = target.left;
					}
				}else{
					//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
					if(parent.left.value == value){
						parent.left = target.right;
					}else{
						//Ҫɾ���Ľڵ��Ǹ��ڵ�����ӽڵ�
						parent.right = target.right;
					}
				}
			}
		}
	}
	
	/**
	 * ɾ��һ��������С�Ľڵ�
	 * @param right
	 * @return
	 */
	private int deleteMin(Node node) {
		Node target = node;
		//�ݹ�������
		while(target.left != null){
			target = node.left;
		}
		delete(target.value);
		return target.value;
	}

	/**
	 * �������ڵ�
	 * @param value
	 * @return
	 */
	public Node searchParent(int value){
		if(root == null){
			return null;
		}else{
			return root.searchParent(value);
		}
	}
}