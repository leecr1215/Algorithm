package 기타;

import java.io.*;

public class 백준_2744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < st.length(); i++){
            char C = st.charAt(i);
            if(Character.isUpperCase(C)){
                sb.append(String.valueOf(C).toLowerCase());
            }else if(Character.isLowerCase(C)){
                sb.append(String.valueOf(C).toUpperCase());
            }
        }
        System.out.println(sb);
    }
}