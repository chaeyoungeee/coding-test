import java.util.*;

public class Main {
    static int d = 1_000_000_000;
    static int[] a;
    static int[] w;
    static int n;

    public static void comb(int depth, int start, int r, int[] result) {
        if (r == depth) {
            int an = 1;
            int wn = 0;
            for (int i = 0; i < n; i++) {
                if (result[i] == 0) continue;
                an *= a[i];
                wn += w[i];
            }
            d = Math.min(Math.abs(an-wn), d);
            return;
        }
        for (int i = start; i < n; i++) {
            result[i] = 1;
            comb(depth+1, i+1, r, result);
            result[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        StringTokenizer st;
        a = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sc.nextLine());
            a[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n+1; i++) {
            comb(0, 0, i, new int[n]);
        }
        System.out.println(d);
    }
}