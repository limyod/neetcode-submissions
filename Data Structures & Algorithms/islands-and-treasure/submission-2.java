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
        if(x < 0 || y < 0 || 
        x >= grid.length || y >= grid[0].length ||
        grid[x][y] == -1){
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, distance});
        while(!q.isEmpty()){
            int[] pointInfo = q.remove();
            int curX = pointInfo[0];
            int curY = pointInfo[1];
            int curD = pointInfo[2];
            if(curD == 0 || curD < grid[curX][curY]){
                grid[curX][curY] = curD;
                List<int[]> points = new ArrayList<>();
                points.add(new int[]{curX + 1, curY, curD + 1});
                points.add(new int[]{curX - 1, curY, curD + 1});
                points.add(new int[]{curX, curY + 1, curD + 1});
                points.add(new int[]{curX, curY - 1, curD + 1});
                for(int[] point : points){
                    if(point[0] < 0 || point[1] < 0 || 
                        point[0] >= grid.length || point[1] >= grid[0].length ||
                        grid[point[0]][point[1]] == -1){
                            continue;
                    }
                    q.add(point);
                }
            }
        }


    }
}
