public class 피로도 {
    public static boolean[] visit;
    public static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        // 던전 개수만큼 visit 설정
        visit = new boolean[dungeons.length];
        
        int cnt = 0; // 유저가 탐험할 수 있는 최대 던전 수
        DFS(k, dungeons, cnt);

        return answer;
    }
    public static void DFS(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            // visit[i]를 방문x & 피로도 조건 충족
            if(!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                // 소모 피로도를 설정하고 재귀
                DFS(k - dungeons[i][1], dungeons, cnt+1);
                visit[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }
}
