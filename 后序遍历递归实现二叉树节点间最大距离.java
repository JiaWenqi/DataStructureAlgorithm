##用递归实现二叉树节点间的最大距离——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public int maxDistance(Node head){
	int[] record = new int[1];
	return postOrder(head, record);
}
public int postOrder(Node head,int[] record){
	if(head == null){
		record[0] = 0;
		return 0;
	}
	int lMax = postOrderRecur(head.left,record);
	int maxFromLeft = record[0];
	int rMax = postOrderRecur(head.right,record);
	int maxFromRight = record[0];
	int curNodeMax = maxFromLeft + maxFromRight + 1;
	int record[0] = Math.max(maxFromLeft,maxFromRight) + 1;
	return Math.max(Math.max(lMax,rMax),curNodeMax);
}