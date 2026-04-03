import java.util.Scanner;
public class Calculate {
    public static void main(String[] args) {
        java.util.Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so dau tien: ");
        double a=sc.nextDouble();
        System.out.println("Nhap so thu hai: ");
        double b=sc.nextDouble();
        System.out.println("sum: "+(a+b));
        System.out.println("difference: "+(a-b));
        System.out.println("product: "+(a*b)); 
        if(b!=0) System.out.println("quotient: "+(a/b));
        else System.out.println("Khong the chia cho 0");
    }
}
