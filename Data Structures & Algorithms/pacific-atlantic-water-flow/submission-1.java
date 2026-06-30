class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] p = new boolean[rows][cols];
        boolean[][] a = new boolean[rows][cols];
        
        for (int c = 0; c < cols; c++) {
            dfs(p, heights, 0, c);
            dfs(a, heights, rows - 1, c);
        }
        
        for (int r = 0; r < rows; r++) {
            dfs(p, heights, r, 0);
            dfs(a, heights, r, cols - 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (p[r][c] && a[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }
    
    private void dfs(boolean[][] ocean, int[][] heights, int r, int c) {
        ocean[r][c] = true;
        
        
        int[][] dirs = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length &&
                heights[nr][nc] >= heights[r][c] && !ocean[nr][nc]) {
                dfs(ocean, heights, nr, nc);
            }
        }
    }
}
