##构造数组的MaxTree,数组没有重复的元素，MaxTree是一个二叉树，数组的每一个值都对应着二叉树的每一个节点，每一颗子树上最大的值都在树的头
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public Node getMapTree(int[] arr){
	Node[] nArr = new Node[arr.length];
	for(int i = 0; i != arr.length; i++){
		nArr[i] = new Node[arr[i]];
	}
	HashMap<Node, Node>lBigMap = new HashMap<Node, Node>();
	HashMap<Node, Node>rBigMap = new HashMap<Node, Node>();
	Stack<Node> stack = new Stack<Node>();
	//寻找每个元素左边第一个比它大的元素
	for(int i = 0; i != nArr.length; i++){
		Node curNode = nArr[i];
		while((!stack.isEmpty()) && stack.peek().value < curNode.value){
			popStackSetMap(stack, lBigMap);
		}
		stack.push(curNode);
	}
	while(!stack.isEmpty()){
		popStackSetMap(stack, lBigMap)；
	}
	//寻找每个元素右边第一个比它大的元素
	for(int i = nArr.length-1; i != -1; i--){
		Node curNode = nArr[i];
		while(!stack.isEmpty()) && stack.peek().value < curNode.value){
			popStackSetMap(stack, rBigMap);
		}
		stack.push(curNode);
	}
	while(!stack.isEmpty()){
		popStackSetMap(stack, rBigMap);
	}
	Node head = null;
	for(int i = 0; i != nArr.length; i++){
		Node curNode = nArr[i];
		Node left = lBigMap.get(curNode);
		Node right = rBigMap.get(curNode);
		if(left == null && right == null){
			head = curNode;
		}else if(left == null && right != null){
			if(right.left == null){
				right.left = curNode;
			}else{
				right.right = curNode;
			}		
		}else if(right == null && left != null){
			if(left.left == null){
				left.left = curNode;
			}else{
				left.right = curNode;
			}
		}else{
			Node parent = left.value > right.value ? left : right;
			if(parent.left == null){
				parent.left = curNode;
			}else{
				parent.right = curNode;
			}	
		}
	}	
}
	public void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> map){
		Node popNode = stack.pop();
		if(stack.isEmpty()){
			map.put(popNode, null);
		}else{
			map.put(popNode, stack.peek());
		}
	}
}


