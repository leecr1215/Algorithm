package level2;

import java.util.Arrays;
public class 가장큰수 {
    public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(solution(new int[] { 0, 0, 0, 0 }));
	}

    public static String solution(int[] numbers) {
        
		String[] str = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(str, (a,b)->{
			return b.repeat(3).compareTo(a.repeat(3));
		});
		
		String answer = "";
		
		if(str[0].equals("0")) return "0";
		
		for(int i = 0; i < str.length; i++) {
 			answer += str[i];
 		}
		return answer;
    }
}

