package 스택;

import java.io.*;
import java.util.*;

public class 백준_17608 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }

        int result = 1;
        int front = stack.pop();
        int back = 0;

        while(!stack.empty()){
            back = stack.pop();
            if(back > front){
                result += 1;
            }
            if(front < back){
                front = back;
            }
        }

        System.out.println(result);

    }
}