package 일차원배열;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < arr.length; i++) {
			set.add(arr[i] % 42);
		}
		System.out.println(set.size());
	}
}
