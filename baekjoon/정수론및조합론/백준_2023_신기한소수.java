package 정수론및조합론;

import java.util.Scanner;
public class 백준_2023_신기한소수 {
    static int[] array = new int[]{1,2,3,5,7,9}; // 1~9 중 가능성 있는 수
	static int N;
	
	// 9개중에 4개뽑기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// 중복 순열
		// 안에서 신기한 소수인지 판별
		permutation("");
		
		
	}

	private static void permutation(String str) {
		if(str.length() == N) {
			System.out.println(str);
			return;
		}
		
		for(int i = 0; i < 6; i++) {
			if(isPrime(Integer.parseInt(str + array[i]))) {
				permutation(str + array[i]);
			}
		}
		
	}
	
	// num이 소수인지 판별
	private static boolean isPrime(int num) {
		if(num <= 1) return false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
