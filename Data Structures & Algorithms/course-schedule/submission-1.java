class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> [] arr = new List[numCourses];
        for(int[] preq: prerequisites){
            int course = preq[0];
            int needed = preq[1];
            if(arr[course] == null){
                arr[course] = new ArrayList<>();
            }
            arr[course].add(needed);
        }
        for(int i = 0; i < numCourses; i++){
            Set<Integer> visited = new HashSet<>();
            if(!dfs(i, arr, visited)) return false;
        }
        return true;
    }
    public boolean dfs(int course, List<Integer>[] prerequisites, Set<Integer> visited){
        visited.add(course);
        if(prerequisites[course] != null){
            for(int preq: prerequisites[course]){
                if(visited.contains(preq)){
                    return false;
                }
                boolean clear = dfs(preq, prerequisites, visited);
                if(!clear) return false;
                visited.remove(preq);
            }
        }
        return true;
    }
}
