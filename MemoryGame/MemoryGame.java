import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MemoryGame {
    public static void consoleClear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("--- MEMORY GAME ---\nChoose: \n1. Start game\n2. Highscores\n3. Exit\n\nPress defined key to do the action...");
        int menuOption = System.in.read();
        int rowsNumber, collumnsNumber;
        if(menuOption == '1'){
            consoleClear();
            do{
                System.out.print("\nPlease choose number of rows (between 1-10): ");
                rowsNumber = System.in.read();
            } while(rowsNumber > 0 && rowsNumber < 11);

            do{
                System.out.print("\nNow, please choose number of collumns (between 1-10): ");
                collumnsNumber = System.in.read();
            } while(collumnsNumber > 0 && collumnsNumber < 11);
            
            consoleClear();
            System.out.println("--- MEMORY GAME ---\n\t");
            for(int i = 0; i < collumnsNumber; i++) {
                System.out.print("\t" + i);
            }
            for(int i = 1; i < rowsNumber; i++) {
                System.out.print("\n" + i + ". collumn");
            }
        }

        /*File file = new File("MemoryGame/words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));*/

        // while powtorzony AxB razy, gdzie A - ilosc rzedow, B - ilosc wierszy
        // while bedzie losowal z LISTy slow losowe slowa i dodawal do array
        // mam array z losowo wybranymi slowami
        // duplikuje wartosci w arrayu i tworze arraya2 ktory bedzie zawieral slowa w kolejnosci
        // w jakiej bedzie juz ostateczny memoryGame
        // wtedy drukuje tabelke, pokolei drukujac X

        /*try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            br.close();
        }*/
    }
}
