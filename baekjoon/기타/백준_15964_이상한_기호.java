import java.util.Scanner;

public class 백준_15964_이상한_기호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        System.out.println((A+B)*(A-B));
    }
}
