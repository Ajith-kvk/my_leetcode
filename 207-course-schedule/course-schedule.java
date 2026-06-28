//USING KAHN'S ALGORITHM
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int completed = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completed++;
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }
        return completed == numCourses;
    }
}

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for(int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }
//         for(int[] pre : prerequisites) {
//             graph.get(pre[1]).add(pre[0]);
//         }
//         int[] state = new int[numCourses];
//         for(int i = 0; i < numCourses; i++) {
//             if(hasCycle(i, graph, state)) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     private boolean hasCycle(
//         int course,
//         List<List<Integer>> graph,
//         int[] state
//     ) {
//         if(state[course] == 1) {
//             return true;
//         }
//         if(state[course] == 2) {
//             return false;
//         }
//         state[course] = 1;
//         for(int next : graph.get(course)) {
//             if(hasCycle(next, graph, state)) {
//                 return true;
//             }
//         }
//         state[course] = 2;
//         return false;
//     }
// }