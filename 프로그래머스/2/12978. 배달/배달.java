import java.util.*;

class Solution {
    
    static class Node {
        int x, cost;
        
        public Node (int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
    
    static void djikstra(int[] dist, ArrayList<Node>[] adjList) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        dist[1] = 0;
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : adjList[now.x]) {
                if (dist[next.x] < now.cost + next.cost) continue;
                dist[next.x] = now.cost + next.cost;
                pq.add(new Node(next.x, dist[next.x]));
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        
        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            adjList[r[0]].add(new Node(r[1], r[2]));
            adjList[r[1]].add(new Node(r[0], r[2]));
        }
        
        djikstra(dist, adjList);
        
        int cnt = 0;
        
        for (int d : dist) {
            if (d <= K) cnt++;
        }
        
        return cnt;
    }
}