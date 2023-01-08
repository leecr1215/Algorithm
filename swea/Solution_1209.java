import java.util.Scanner;

public class Solution_1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int t = sc.nextInt();
            int[][] arr = new int[100][100];

            int max = 0;
            int rowSum = 0; // 행 합
            int colSum = 0; // 열 합
            int rightDownSum = 0;
            int leftDownSum = 0;

            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    arr[j][k] = sc.nextInt();
                }
            }

        
            for(int j = 0; j < 100; j++){
                rowSum = 0;
                colSum = 0;
                for(int k = 0; k < 100; k++){
                    rowSum += arr[j][k];
                    colSum += arr[k][j];
                }
                if(max <= rowSum){
                    max = rowSum;
                }
                if(max <= colSum){
                    max = colSum;
                }
            }
          
            
            for(int j = 0; j < 100; j++){
                rightDownSum += arr[j][j];
                leftDownSum += arr[j][99-j];
            }

            if(max <= rightDownSum){
                max = rightDownSum;
            }

           if(max <= leftDownSum){
                max = leftDownSum;
            }
            
            System.out.println("#" + t + " " + max);

        }


    }
}
