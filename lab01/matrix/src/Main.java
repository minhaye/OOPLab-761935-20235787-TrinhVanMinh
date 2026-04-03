import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        System.out.println("nhap kich thuoc axb: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Nhap ma tran thu nhat: ");
        int[][] m1 = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                m1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Nhap ma tran thu hai: ");
        int[][] m2 = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                m2[i][j] = sc.nextInt();
            }
        }
        int[][] sum = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }
        System.out.println("tong: ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
