class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(grid[i][j] == 0){
                    bfs(grid, i, j, 0);
                }
            }
        }
    }

    public void bfs(int[][] grid, int x, int y, int distance){
        int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, distance});
        while(!q.isEmpty()){
            int[] pointInfo = q.remove();
            int curX = pointInfo[0];
            int curY = pointInfo[1];
            int curD = pointInfo[2];
            if(curD == 0 || curD < grid[curX][curY]){
                grid[curX][curY] = curD;
                for(int[] d : dirs){
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if(newX < 0 || newY < 0 || 
                        newX  >= grid.length || newY  >= grid[0].length ||
                        grid[newX ][newY] == -1){
                            continue;
                    }
                    q.add(new int[]{newX, newY, curD + 1});
                }
            }
        }


    }
}
