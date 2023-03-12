package 기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int x = X;
		
		int number = 1;
		int result = 0;
		int sum = 0;
		
		while(X > 0) {
			sum+=number;
			X-=number;
			number++;
			result++;
		}

//		����: result-sum
//		�и�: sum-1;

		int a = sum-x;
		if((result+1)%2==0) {	
			System.out.println((1+a)+"/"+(result-a));
		}else {
			System.out.println((result-a)+"/"+(1+a));
		}
		
	}
}
