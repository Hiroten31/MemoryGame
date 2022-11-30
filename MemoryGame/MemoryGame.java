import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MemoryGame {
    static ArrayList<String> wordsList = new ArrayList<String>();
    static ArrayList<String> pickedWords = new ArrayList<String>();
    static ArrayList<String> wordsToUncover = new ArrayList<String>();
    static int hearths;

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

        //Picking up random index from wordsList to add indexed word to pickedWords list.
        Random random = new Random();
        
        for(int i = 0; i < ((rows*collumns)-((rows*collumns)%2))/2; i++) {
            int wordIndex = random.nextInt(wordsList.size());
            pickedWords.add(i, wordsList.get(wordIndex));
            wordsList.remove(wordIndex);
        }

        //Reusing the old list to make it full of 'x' for printing them into the matrix.
        wordsList.clear();
        for(int j = 0; j < pickedWords.size()*2; j++) 
            wordsList.add(j, "x");
        //Filling list of words from which we will pick words in matrix
        wordsToUncover.addAll(pickedWords);
        wordsToUncover.addAll(pickedWords);
        Collections.shuffle(wordsToUncover);
        if((rows*collumns)%2 == 1){
            wordsList.add(0, "EMPTY");
            wordsToUncover.add(0, "EMPTY");
        }
    }
    
    public static void printMatrix(int r, int c, int coords){
        System.out.println("\n\n\t\t--- MEMORY GAME ---\nHearths: " + hearths + "\n");

        //Information about what words have been choosen for the game.
        System.out.println("\n\nPICKED WORDS ARE: ");
        for(int k = 0; k < pickedWords.size()-1; k++)
            System.out.print(pickedWords.get(k) + ", ");
        System.out.print(pickedWords.get(pickedWords.size()-1) + ".\n\n");

        //Printing table
        for(int i = 1; i <= c; i++) {
            System.out.print("\t\t" + i);
        }
        int x = 0;
        if(coords != -1){
            for(int i = 1; i <= r; i++) {
                System.out.print("\n" + i + ". ");
                for(int j = 0; j < c; j++){
                    if(x == coords){
                        System.out.print("\t\t" + wordsToUncover.get(x));
                    } else {
                        System.out.print("\t\t" + wordsList.get(x));
                    }
                    x++;
                }
            }
        } else {
            for(int i = 1; i <= r; i++) {
                System.out.print("\n" + i + ". ");
                for(int j = 0; j < c; j++){
                    System.out.print("\t\t" + wordsList.get(x));
                    x++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MEMORY GAME ---\nChoose: \n1. Start game\n2. Highscores\n3. Exit\n\nPress defined key to do the action...");
        int menuOption = sc.nextInt();
        int rows, collumns;
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
            int coordinates = -1;
            printMatrix(rows, collumns, coordinates);
            do {
                int uncoverRow, uncoverCollumn;
                System.out.print("\nGive me coordinates in the range of the matrix to uncover choosen word: \nRow: ");
                do{
                    uncoverRow = sc.nextInt();
                } while(uncoverRow >= rows && uncoverRow < 0);
                System.out.print("Collumn: ");
                do{
                    uncoverCollumn = sc.nextInt();
                } while(uncoverCollumn >= collumns && uncoverCollumn < 0);
                coordinates = (uncoverRow-1)*collumns + uncoverCollumn-1;
                printMatrix(rows, collumns, coordinates);
            } while(hearths > 0);
        }

        sc.close();
    }
}
/*To do:
- Saving the choosen coordinates and then comparing if another ones are the same (perhaps coordinates2 in method?).
*/
