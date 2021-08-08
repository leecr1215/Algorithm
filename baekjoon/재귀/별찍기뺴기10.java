package Àç±Í;

import java.util.Arrays;
import java.util.Scanner;

public class º°Âï±â•û±â10 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		star(0, 0, N);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	private static void star(int x, int y, int n) {
		if(n==1) {
			arr[x][y] = '*';
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i==1 && j==1)) {
					int sn = n/3;
					star(x+i*sn, y+j*sn, sn);
				}
			}
		}
		return;
	}
	
}
