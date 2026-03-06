import java.util.*;

class Solution {
    
    static class Node {
        int x, cost;
        
        public Node (int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static int[] cost;
    
    static void djikstra(int start) {
        cost[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (cost[now.x] < now.cost) continue;
            
            for (Node next : graph[now.x]) {
                int ncost = now.cost + next.cost;
                if (cost[next.x] > ncost) {
                    cost[next.x] = ncost;
                    pq.add(new Node(next.x, ncost));
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();    
        }
        
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        djikstra(1);
        
        return (int) Arrays.stream(cost)
                    .filter(c -> {
                        if (c <= K) return true;
                        return false;
                    })
                    .count();
    }
}