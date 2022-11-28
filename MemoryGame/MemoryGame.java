import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MemoryGame {
    static ArrayList<String> wordsList = new ArrayList<String>();
    static ArrayList<String> pickedWords = new ArrayList<String>();
    //Method to clear console out of useless stuff.
    public static void consoleClear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    //Method to pick up random words for the game.
    public static void pickRandomWords(int rows, int collumns) throws IOException{
        //Here you can choose from which file you want to take words.
        File file = new File("MemoryGame/words.txt");

        //Adding every line of choosen file to wordsList.
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        
        try {
            String line;
            while ((line = br.readLine()) != null)
                wordsList.add(line);
        } finally {
            br.close();
        }

        //Picking up random index for wordsList to add indexed word to pickedWords list.
        Random random = new Random();
        
        for(int i = 0; i < ((rows*collumns)-((rows*collumns)%2))/2; i++) {
            int wordIndex = random.nextInt(wordsList.size());
            pickedWords.add(i, wordsList.get(wordIndex));
            wordsList.remove(wordIndex);
        }

        //Information about what words have been choosen for the game.
        System.out.println("\n\n\nPICKED WORDS ARE: \n");
        for(String word : pickedWords)
            System.out.print(word + ", ");

        //Reusing the old list to make it full of 'x' for printing them into the matrix.
        wordsList.clear();
        for(int j = 0; j < pickedWords.size()*2; j++) 
            wordsList.add(j, "x");
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MEMORY GAME ---\nChoose: \n1. Start game\n2. Highscores\n3. Exit\n\nPress defined key to do the action...");
        int menuOption = sc.nextInt();
        int rows, collumns, hearths;
        if(menuOption == 1){
            consoleClear();
            do{
                System.out.print("\nPlease choose number of rows (between 1-10): ");
                rows = sc.nextInt();
            } while(rows < 0 && rows > 11);

            do{
                System.out.print("\nNow, please choose number of collumns (between 1-10): ");
                collumns = sc.nextInt();
            } while(collumns < 0 && collumns > 11);
            pickRandomWords(rows, collumns);
            
            hearths = ((rows*collumns) + ((rows * collumns)%2))/2;
            System.out.println("\n\n\t\t--- MEMORY GAME ---\nHearths: " + hearths + "\n\n");
            for(int i = 1; i <= collumns; i++) {
                System.out.print("\t\t" + i);
            }
            int x = 0;
            for(int i = 1; i <= rows; i++) {
                System.out.print("\n" + i + ". ");
                for(int j = 0; j < collumns; j++){
                    System.out.print("\t\t" + wordsList.get(x));
                    x++;
                }
            }
        }

        sc.close();
    }
}
