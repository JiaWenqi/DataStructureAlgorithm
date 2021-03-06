##给定一个整型矩阵map,其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
public int maxRecSize(int[][] map){
	if(map == null || map.length == 0 || map[0].length == 0){
		return 0;
	}
	int[] height = new int[map[0].length];
	for(int i = 0; i < map.length; i++){
		for(int j = 0; j< map[0].length; j++){
			height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
		}
		maxArea = Math.max(maxArea, maxRecFromBottom(height));
	}
	return maxArea;
}
public int maxRecFromBottom(int[] height){
	if(height == null && height.length == 0){
		return 0;
	}
	Stack<Node> stack = new Stack<Node>();
	for(int i = 0; i != height.length; i++){
		while(!stack.isEmpty() && height[i] < stack.peek().value){
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (i - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		stack.push(i);
	}
	while(!stack.isEmpty()){
		int j = stack.pop();
		int k = stack.isEmpty() ? -1 : stack.peek();
		int curArea = (i - k -1)*height[j];
		maxArea = Math.max(maxArea,curArea);
	}
	return maxArea;
}