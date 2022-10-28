import java.util.Scanner;

public class TrianglePrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integer of bottom line of the triangle: ");
        int x = sc.nextInt();
        //Check if 'x' is a good input
        while(x <= 2){
            System.out.println("Enter integer greater than 2: ");
            x = sc.nextInt();
        }
        PrintingTriangle(x);
        sc.close();
    }
    static void PrintingTriangle(int length){
        //Check if number is odd or even. It will determine tip of the triangle and futher placement
        if(length%2 == 1){
            //Triangle's tip
            Spacing((length-1)/2);
            System.out.print("*");
            Spacing((length-1)/2);
            System.out.println("|");
            //Triangle's walls
            for(int i = ((length-1)/2)-1; i > 0; i--){
                Spacing(i);
                //Left wall
                System.out.print("*");
                //Middle space
                Spacing(length - ((i+1)*2));
                //Right wall
                System.out.print("*");
                Spacing(i);
                System.out.println("|");
            }
        } else {
            //Triangle's tip
            Spacing((length/2)-1);
            System.out.print("**");
            Spacing((length/2)-1);
            System.out.println("|");
            for(int i = ((length/2)-2); i > 0; i--){
                Spacing(i);
                //Left wall
                System.out.print("*");
                //Middle space
                Spacing(length - (i*2)-2);
                //Right wall
                System.out.print("*");
                Spacing(i);
                System.out.println("|");
            }
        }
        //Bottom line
        for(int j = length; j > 0; j--){
            System.out.print("*");
        }
        System.out.println("|");
    }
    //A function to not repeat one loop multiple times
    static void Spacing(int times){
        for(int i = times; i > 0; i--){
            System.out.print(" ");
        }
    }
}