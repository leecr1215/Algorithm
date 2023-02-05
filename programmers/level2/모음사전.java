public class 모음사전 {
    static String[] vowels = { "A", "E", "I", "O", "U" };
	static List<String> list = new ArrayList<>();

	public static int solution(String word) {
		// ['A','E', 'I', 'O', 'U'] 중에서 만들 수 있는 부분집합
		
		recursion("", 0);
		
		// 만든 부분 수열 중 같으면 index 출력
		
		return list.indexOf(word);

	}

	public static void recursion(String subStr, int depth) {
		list.add(subStr);

		if (depth == 5) {
			return;
		}

		for (int i = 0; i < vowels.length; i++) {
			recursion(subStr + vowels[i], depth+1);
		}

	}

	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
//		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
}
