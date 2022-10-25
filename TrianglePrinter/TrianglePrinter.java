import java.util.Scanner;

public class TrianglePrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of bottom line of the triangle: ");
        int x = sc.nextInt();
        //Check if 'x' is a good input
        while(x <= 0){
            System.out.println("Enter length greater than 0: ");
            x = sc.nextInt();
        }
        PrintingTriangle(x);
        sc.close();
    }
    static void PrintingTriangle(int length){
        //First line, the tip
        for(int j = length+1; j > 0; j--){
            System.out.print(" ");
        }
        System.out.print("*");
        for(int j = length+1; j > 0; j--){
            System.out.print(" ");
        }
        System.out.println("|");
        //Rest of the triangle
        for(int i = length; i > 0; i--){
            //Left spacing
            for(int j = i; j > 0; j--){
                System.out.print(" ");
            }
            //Left line
            System.out.print("*");
            //Inside
            for(int j = 1+(length - i)*2; j > 0; j--){
                System.out.print(" ");
            }
            //Right line
            System.out.print("*");
            //Right spacing
            for(int j = i; j > 0; j--){
                System.out.print(" ");
            }
            System.out.println("|");
        }
        //Bottom line
        for(int j = (length)*2+3; j > 0; j--){
            System.out.print("*");
        }
        System.out.println("|");
    }
}
 
