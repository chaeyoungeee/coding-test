import java.util.*;
import java.io.*;

public class Main {
    private static int parseInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st);
        int M = parseInt(st);

        int[] basket = new int[N+1];
        for (int i=1;i<N+1;i++) basket[i] = i;

        for (int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine());
            int i = parseInt(st);
            int j = parseInt(st);

            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }

        for (int i=1;i<N+1;i++) System.out.print(basket[i] + " ");
    }
}