import java.util.Scanner;
public class TrianglePrinterLESSforLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integer of bottom line of the triangle: ");
        int x = sc.nextInt();
        //Check if 'x' is a good input, still can't figure out smart way to check if input is an integer.
        while(x <= 2) {
            System.out.println("Enter integer greater than 2: ");
            x = sc.nextInt();
        }
        PrintingTriangle(x);
        sc.close();
    }
    static void PrintingTriangle(int length) {
        //You can change here symbol used to print shape and background
        String symbol = "*";
        String background = " ";
        background = background.repeat(length);
        if(length%2 == 1) {
            System.out.print(background.substring(0, (length-1)/2));
            System.out.print(symbol);
            System.out.print(background.substring(0, (length-1)/2));
            System.out.println("|");
            for(int i = 0; i < ((length-1)/2)-1; i++) {
                System.out.print(background.substring(0, ((length-1)/2)-1-i));
                System.out.print(symbol);
                System.out.print(background.substring(0, 1+(i*2)));
                System.out.print(symbol);
                System.out.print(background.substring(0, ((length-1)/2)-1-i));
                System.out.println("|");
            }
        } else {
            int x = (length/2)-1;
            for(int i = 0; i < x; i++) {
                System.out.print(background.substring(0, x-i));
                System.out.print(symbol);
                System.out.print(background.substring(0, i*2));
                System.out.print(symbol);
                System.out.print(background.substring(0, x-i));
                System.out.println("|");
            }
        }
        System.out.print(symbol.repeat(length));
        System.out.print("|");
    }
}