package 문자열;

import java.util.Scanner;

public class 다이얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int time = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int num=1;
			if(c=='A' || c=='B' || c=='C') {
				num=2;
			}else if(c=='D' || c=='E' || c=='F') {
				num=3;
			}else if(c=='G' || c=='H' || c=='I') {
				num=4;
			}else if(c=='J' || c=='K' || c=='L') {
				num=5;
			}else if(c=='M' || c=='N' || c=='O') {
				num=6;
			}else if(c=='P' || c=='Q' || c=='R' || c=='S') {
				num=7;
			}else if(c=='T' || c=='U' || c=='V') {
				num=8;
			}else if(c=='W' || c=='X' || c=='Y' || c=='Z') {
				num=9;
			}
			
			time+=num+1;
		}
		System.out.println(time);
	}
}
