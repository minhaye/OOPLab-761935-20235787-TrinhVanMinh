import java.util.Scanner;

public class Solve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 3 he so a,b,c: ");
        double a= sc.nextDouble();
        double b= sc.nextDouble();
        double c= sc.nextDouble();
        if(a==0){
            if(b==0){
                if(c==0) System.out.println("phuong trinh co vo so nghiem");
                else System.out.println("phuong trinh vo nghiem");
            }
            else System.out.println("phuong trinh co 1 nghiem: "+(-c/b));
        }
        else{
            double delta=b*b-4*a*c;
            if(delta<0) System.out.println("phuong trinh vo nghiem");
            else if(delta==0) System.out.println("phuong trinh co nghiem kep: "+(-b/(2*a)));
            else{
                double x1=(-b+Math.sqrt(delta))/(2*a);
                double x2=(-b-Math.sqrt(delta))/(2*a);
                System.out.println("phuong trinh co 2 nghiem phan biet: "+x1+" va "+x2);
            }
        }
    }
}