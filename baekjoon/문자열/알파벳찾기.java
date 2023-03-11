package 문자열;

import java.util.Scanner;

public class 알파벳찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr= new int[26]; 	// ���ĺ� 26��
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < s.length(); i++) {
			int a = s.charAt(i);
			if(arr[a-97]==-1) {
				arr[a-97] = i;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
