import java.util.Scanner;


public class Solution_1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for(int i = 0; i < N; i++){
                A[i] = sc.nextInt();
            }

            for(int i = 0; i < M; i++){
                B[i] = sc.nextInt();
            }

            int max = 0;
            int index = Math.abs(N-M) + 1;
            int sum = 0;

            if(N > M) {
                // A의 길이가 더 긴 경우
                for(int i = 0; i < index; i++){
                    sum = 0;
                    for(int j = 0; j < M; j++){
                        sum += A[j+i] * B[j];
                    }
                    if(sum >= max){
                        max = sum;
                    }
                }
            }else{
                // B의 길이가 더 긴 경우
                
                for(int i = 0; i < index; i++){
                    sum = 0;
                    for(int j = 0; j < N; j++){
                        sum += A[j] * B[j+i];
                    }
                    if(sum >= max){
                        max = sum;
                    }
                }

            }

            System.out.printf("#%d %d\n", t, max);

        }
    }
}
