import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        if(n<0) {
            System.out.println("khong hop le");
            return;
        }
        int[] a = new int[n];
        System.out.println("nhpa mang: ");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int sum = 0;
        for (int x : a) sum += x;
        double avg = (double) sum / n;
        System.out.println(Arrays.toString(a));
        System.out.println("sum= " + sum);
        System.out.println("avg= " + avg);
    }
}