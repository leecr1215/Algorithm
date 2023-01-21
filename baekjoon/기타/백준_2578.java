import java.util.Scanner;

public class 백준_2578 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// map 초기화
		int[][] map = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 부르는 순서 초기화
		int[] nums = new int[25];
		
		for(int i = 0; i < 25; i++) {
			nums[i] = sc.nextInt();
		}
		
		// 부르는 수는 -1로 채워넣기
		// 최소 13개부터 빙고인지 확인.
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			count++;
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					if(map[j][k] == nums[i]) {
						map[j][k] = -1;
					}
				}
			}
			if(isBingo(map)) {
				break;
			}
			
		}
		
		
		System.out.println(count);
				
	}
	
	public static boolean isBingo(int[][] arr) {
		/*
		 * [선이 그어지는 경우]
		 * 행이 같은게 5개일때
		 * 열이 같은게 5개일때
		 * 대각선1
		 * 대각선2
		 * 
		 * 선이 그어지는 경우가 3개 이상이 되면 빙고.
		 * */
		boolean result = false;
		int lines = 0;
		
		for(int i = 0; i < 5; i++) {
			int rowCount = 0;
			for(int j = 0; j < 5; j++) {
				if(arr[j][i]==-1) {
					rowCount++;
				}
			}
			if(rowCount==5) {
				lines++;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			int colCount = 0;
			for(int j = 0; j < 5; j++) {
				if(arr[i][j]==-1) {
					colCount++;
				}
			}
			if(colCount==5) {
				lines++;
			}
		}
		
		if(isDiagnol1(arr)) {
			lines++;
		}
		if(isDiagnol2(arr)) {
			lines++;
		}
		
		
		if(lines >= 3) {
			result = true;
		}
		return result;
	}
	
	// 동남 대각선 방향
	public static boolean isDiagnol1(int[][] arr) {
		boolean result = false;
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(arr[i][i]==-1) {
				count++;
			}
		}
		if(count == 5) {
			result = true;
		}
		return result;
	}
	
	// 서남 대각선 방향
	public static boolean isDiagnol2(int[][] arr) {
		boolean result = false;
		int count = 0;

		for(int i = 0; i < 5; i++) {
			if(arr[i][4-i] == -1) {
				count++;
			}
		}
		
		if(count == 5) {
			result = true;
		}
		
		return result;
	}
}
