import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class hangman 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("");
        System.out.println("------------------");
        System.out.println("WELCOME TO HANGMAN");
        System.out.println("------------------");
        File dictionary = new File("Dictionary.txt"); //allows imported text file to be used
        Scanner read = new Scanner(dictionary); // Scanner allows to read the text file of words
        Scanner input = new Scanner(System.in); // Allows for user Input
        
        ArrayList<String> words = new ArrayList<>(); // creates an arraylist of strings that stores the values of the text file
        while (read.hasNextLine())
        {
            words.add(read.nextLine());
        }
        
        String hidden_word = words.get((int)(Math.random() *words.size())); // generates a random word from the word list and casts it as a int
        char[] letters = hidden_word.toCharArray();

        char[] myAnswers = new char[letters.length];

        for(int i = 0; i < letters.length; i++)
        {
            myAnswers[i] = '?';
        }
        
        boolean finished = false; 
        int lives = 6;
        while (finished == false) // while its false, program will run
        { 
            System.out.println("");
            System.out.print("Pick a letter: ");
            String letterRead = input.next();
            while(letterRead.length() != 1 || Character.isDigit(letterRead.charAt(0))) // makes sure user can't use any length greater than one and makes sure that the input is not a digit
            {
                System.out.println("");
                System.out.println("ERROR: INVALID! TRY AGAIN!");
                System.out.println("");
                System.out.print("Pick a letter: ");
                letterRead = input.next();
            }

            /*ArrayList<Character> reused = new ArrayList<>();
            for(int i = 0; i < 26; i++)
            {
                reused.add(letterRead.charAt(0));
            }
            char[] Reused = new char[26];
            for (int i = 0; i < Reused.length; i++)
            {
                Reused[i] = letterRead.charAt(0);
                if (Reused[i] == letters[i])
                {
                    System.out.println("Letter already guessed!");
                } 
            }
            */
            boolean found = false;
            for (int i = 0; i < letters.length; i++)
            {
                /*if (Reused[i] == letterRead.charAt(0))
                {
                    System.out.println("Letter already guessed!");
                    found = true;
                }
                else if (letterRead.charAt(0) == letters[i])
                {
                    myAnswers[i] = letters[i];
                    found = true;
                }*/
                if 
                    (letterRead.charAt(0) == letters[i])
                {
                    myAnswers[i] = letters[i];
                    found = true;
                }
            }
            if (!found)
            {
                lives--;
                System.out.println("");
                System.out.println("Wrong letter!");
            }

            boolean done = true;
            for (int i = 0; i < myAnswers.length; i++)
            {
                if (myAnswers[i] == '?')
                {
                    System.out.print(" _");
                    done = false;
                }
                else
                {
                    System.out.print(" " + myAnswers[i]);
                }
            }
            System.out.println("");
            System.out.println("\n" + "Lives Remaining: " + lives);
            if(lives == 6) {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|_________");
               }
               else if(lives == 5) 
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|_________");
               }
               else if(lives == 4) 
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|_________");
               }
               else if(lives == 3) 
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|");
                System.out.println("|");
                System.out.println("|_________");
               }
               else if(lives == 2) 
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|\\");
                System.out.println("|");
                System.out.println("|_________");
               }
               else if(lives == 1) 
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O");
                System.out.println("|   /|\\");
                System.out.println("|   /");
                System.out.println("|_________");
               }
               else
               {
                System.out.println(" _____");
                System.out.println("|    |");
                System.out.println("|    O ");
                System.out.println("|   /|\\");
                System.out.println("|   / \\");
                System.out.println("|_________");
                System.out.println("Sorry the word was " + "\"" + hidden_word + "\"" + "!");
               }

            if(done)
            {
                System.out.println("Congratulations, you've guessed the word!");
                finished = true;
            }
            if(lives <= 0)
            {
                System.out.println("You lost the game!");
                finished = true;
            }

        }
        
        read.close();
        input.close();
    }
}