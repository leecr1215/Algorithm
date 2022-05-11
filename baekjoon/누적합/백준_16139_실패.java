import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16139 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int[][] sum = new int[s.length()][26]; // 행으로 알파벳 구분
        
        sum[0][s.charAt(0)-'a'] = 1;
        for(int i = 1; i < s.length(); i++){
            sum[i][s.charAt(i)-'a'] = 1;    // s에 있는 알파벳자리에 1넣기
        }

        // 각 알파벳마다 누적합을 구함
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < 26; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        

         // 각 질문에서 원하는 누적합 출력
        // l~r까지의 누적합 
        for(int i = 0; i < q; i++){
            String[] temp = br.readLine().split(" ");
            char c = temp[0].charAt(0);
            int l = Integer.parseInt(temp[1]);
            int r = Integer.parseInt(temp[2]);
            if(l==0){
                System.out.println(sum[r][c-'a']);
            }else{
                System.out.println(sum[r][c-'a'] - sum[l-1][c-'a']);
            }     
        }  
    }
}