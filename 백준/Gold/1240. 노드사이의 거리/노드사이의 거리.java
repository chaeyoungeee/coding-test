import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> tree = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            tree.get(a).add(new int[] {b, d});
            tree.get(b).add(new int[] {a, d});
        }

        // for (List<int[]> t : tree) {
        //     for (int[] i : t) {
        //         System.out.print(Arrays.toString(i));
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] dist = new int[n+1];
            Arrays.fill(dist, 1000_000_000);

            ArrayDeque<Integer> que = new ArrayDeque<>();
            que.add(a);
            dist[a] = 0;

            while (!que.isEmpty()) {
                int curr = que.poll();
                List<int[]> next = tree.get(curr);
                for (int[] nt : next) {
                    int ndist = dist[curr] + nt[1];
                    if (ndist > dist[nt[0]]) continue;
                    que.add(nt[0]);
                    dist[nt[0]] = ndist;
                }
                if (curr == b) break;
            }

            System.out.println(dist[b]);
        }
    }
}