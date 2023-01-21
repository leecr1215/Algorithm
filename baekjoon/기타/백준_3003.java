import java.util.Scanner;

public class 백준_3003 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split(" ");
		int[] answer = {1,1,2,2,2,8};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(answer[i]-Integer.parseInt(arr[i])+" ");
		}
	}
}
