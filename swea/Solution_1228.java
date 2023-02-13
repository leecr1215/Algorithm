import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 
public class Solution_1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
             
            List<Integer>original = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                original.add(sc.nextInt());
            }
             
            int commandNum = sc.nextInt();
            sc.nextLine();
            String[] commands = sc.nextLine().split("I ");
             
            for(int i = 1; i < commands.length; i++) {
                String[] temp = commands[i].split(" ");
                 
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);
                 
                for(int j = 0; j < y; j++) {
                    original.add(x + j, Integer.parseInt(temp[j+2]));
                }
            }
             
            // 수정된 암호문 출력
            System.out.print("#"+ t + " ");
            for(int i = 0; i < 10; i++) {
                System.out.print(original.get(i) + " ");
            }
            System.out.println();
             
        }
         
    }
}