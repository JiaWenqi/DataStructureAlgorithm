//对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
//给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
public class Node{
	public int value;
	public Node left;
	public Node right;
	
	public Node(int data){
		this.value = data;
	}
}

public class IndenticalTree{
	public boolean chkIndentical(Node t1,Node t2){
		String t1Str = serialPre(t1);
		String t2Str = serialPre(t2);
		return getIndexOf(t1Str,t2Str) != -1;
	}
	public String serialPre(Node head){
		if(head == null){
			return '#!';
		}
		String res = head.value + '!';
		res += serialPre(head.left);
		res += serialPre(head.right);
		return res;
	}
	###kmp部分
	public int getIndexOf(String s, String m){
		if(s == null || m == null || m.length < 1 || s.length < m.length){
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] nextArr = getNextArray(ms);
		int si = 0;
		int mi = 0;
		while(si < ss.length && mi < ms.length){
			if(ss[si] == ms[mi]){
				si++;
				mi++;
			}else if(mi == -1){
				si++;
			}else{
				mi = nextArr[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}
	
	public int[] getNextArray(char[] ms){
		if(ms.length == -1){
			return int[]{-1};
		}
		int[] nextArr = new int[ms.length];
		nextArr[0] = -1;
		nextArr[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos < ms.length){
			if(ms[pos-1] == ms[cn]){
				nextArr[pos++] = ++cn;
			}else if(cn > 0){
				cn = nextArr[cn];
			}else{
				nextArr[pos++] = 0;
			}
		}
		return nextArr;
	}
	
}