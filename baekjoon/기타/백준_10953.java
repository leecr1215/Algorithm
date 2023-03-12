package 기타;

import java.io.*;

public class 백준_10953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] temp = br.readLine().split(",");
            System.out.println(Integer.parseInt(temp[0])+Integer.parseInt(temp[1]));
        }

    }
}