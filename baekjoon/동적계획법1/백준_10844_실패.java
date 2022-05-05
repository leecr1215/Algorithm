import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10844_실패 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        arr[0] = 9;

        for(int i = 1; i < N; i++){
            arr[i] = arr[i-1] * 2 -i;
        }

        System.out.println(arr[N-1]%1000000000);

    }
}