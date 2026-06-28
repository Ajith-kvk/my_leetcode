class Solution {
    public int minMutation(String startGene,
                           String endGene,
                           String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank)
            bankSet.add(gene);
        if (!bankSet.contains(endGene))
            return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                if (current.equals(endGene))
                    return mutations;
                for (String gene : bankSet) {
                    if (!visited.contains(gene) &&
                        isOneMutation(current, gene)) {
                        visited.add(gene);
                        queue.offer(gene);
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
    private boolean isOneMutation(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }
}

//OPTIMIZED METHOD
// class Solution {
//     public int minMutation(String startGene, String endGene, String[] bank) {
//         Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
//         if (!bankSet.contains(endGene))
//             return -1;
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(startGene);
//         Set<String> visited = new HashSet<>();
//         visited.add(startGene);
//         char[] genes = {'A', 'C', 'G', 'T'};
//         int steps = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (size-- > 0) {
//                 String curr = queue.poll();
//                 if (curr.equals(endGene))
//                     return steps;
//                 char[] arr = curr.toCharArray();
//                 for (int i = 0; i < 8; i++) {
//                     char original = arr[i];
//                     for (char ch : genes) {
//                         if (ch == original)
//                             continue;
//                         arr[i] = ch;
//                         String next = new String(arr);
//                         if (bankSet.contains(next) && !visited.contains(next)) {
//                             visited.add(next);
//                             queue.offer(next);
//                         }
//                     }
//                     arr[i] = original;
//                 }
//             }
//             steps++;
//         }
//         return -1;
//     }
// }