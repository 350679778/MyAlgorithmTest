package tree.balanceTree;

public class BinarySortTree {

	Node root;
	
	/**
	 * 向二叉排序树中添加节点
	 * @param node
	 */
	public void add(Node node){
		//如果是一颗空树
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
	 * 删除节点
	 * @param value
	 */
	public void delete(int value){
		if(root == null){
			return;
		}else{
			//找到这个节点
			Node target = search(value);
			//如果没有这个节点
			if(target == null){
				return;
			}
			//找到他的父节点
			Node parent = searchParent(value);
			//要删除的节点是叶子节点
			if(target.left == null && target.right == null){
				//要删除的节点是父节点的左子节点
				if(parent.left.value == value){
					parent.left = null;
				}else{
					//要删除的节点是父节点的右子节点
					parent.right = null;
				}
			//要删除的节点有两个子节点
			}else if(target.left != null && target.right != null){
				//删除右子树中值最小的几点，取获取到该节点的值
				int min = deleteMin(target.right);
				//替换目标节点中的值
				target.value = min;
			//要删除的节点有一个左子节点或右子节点
			}else{
				if(target.left != null){
					//要删除的节点是父节点的左子节点
					if(parent.left.value == value){
						parent.left = target.left;
					}else{
						//要删除的节点是父节点的右子节点
						parent.right = target.left;
					}
				}else{
					//要删除的节点是父节点的左子节点
					if(parent.left.value == value){
						parent.left = target.right;
					}else{
						//要删除的节点是父节点的右子节点
						parent.right = target.right;
					}
				}
			}
		}
	}
	
	/**
	 * 删除一棵树中最小的节点
	 * @param right
	 * @return
	 */
	private int deleteMin(Node node) {
		Node target = node;
		//递归向左找
		while(target.left != null){
			target = node.left;
		}
		delete(target.value);
		return target.value;
	}

	/**
	 * 搜索父节点
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