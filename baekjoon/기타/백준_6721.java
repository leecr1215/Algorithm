import java.io.*;

public class 백준_6721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split(" ");
            for(int j = 0; j <2; j++){
                sb = new StringBuffer(arr[j]);
                arr[j] = sb.reverse().toString();
            }
            int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            String sumSt = Integer.toString(sum);
            sb = new StringBuffer(sumSt);
            System.out.println(Integer.parseInt(sb.reverse().toString()));
        }

    }
}