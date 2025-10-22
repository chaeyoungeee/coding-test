import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int v = Integer.parseInt(br.readLine());
        int count = Collections.frequency(numbers, v);

        System.out.println(count);        
    }
}