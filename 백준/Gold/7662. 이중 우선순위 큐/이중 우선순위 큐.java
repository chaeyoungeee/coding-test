import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int i, n;
        public Node (int i, int n) { this.i = i; this.n = n; }
        public String toString() {
            return i + " " + n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st;

            TreeSet<Node> tree = new TreeSet<>((a, b) -> {
                if (a.n != b.n) return Integer.compare(a.n, b.n);
                return Integer.compare(a.i, b.i);
            });

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char o = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (o == 'I') tree.add(new Node(i, n));
                else {
                    if (n == 1) {
                        tree.pollLast();
                    } else {
                        tree.pollFirst();
                    }
                }

                // System.out.println(tree);
            }

            if (tree.isEmpty()) System.out.println("EMPTY");
            else if (tree.size() == 1) {
                Node nd = tree.pollFirst();
                System.out.printf("%d %d\n", nd.n, nd.n);
            } else {
                System.out.printf("%d %d\n", tree.pollLast().n, tree.pollFirst().n);
            }
        }
    }
}