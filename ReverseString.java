import java.util.Scanner;

public class ReverseString{
    Scanner scnr = new Scanner(System.in);
    public void main(String[] args) throws Exception{
        
        program();
    }

    public void program(){
        //variables
        String normalWord = "";
        String reversedWord = "";

        //Program introduces the user to itself and gives them instructions on how to use it
        System.out.println("=====================================");
        System.out.println("Welcome to Reverse String");
        System.out.println("");
        System.out.println("This is a program that will reverse any word or combination of letters");
        System.out.println("and will reverse it.");
        System.out.println("For example, if you enter 'now', the program will return 'won.'");
        System.out.println("");
        
        //program asks user to input a word and will invert it
        System.out.println("To begin, simply enter the word or letter combination below and press ENTER:");
        normalWord = scnr.next();
        
        //program prints out finished product
        System.out.print("The reversed version of your word is: ");
        reversedWord = Inverter(normalWord);
        System.out.println(reversedWord);

        //program prepares for a possible restart
        normalWord = "";
        reversedWord = "";
        System.out.println("");
        Restart();
    }

    public String Inverter(String word){
        //program stores the string variable into a char array
        char[] letters = word.toCharArray();
        String reverse = "";

        //program adds each char from last to first to a string variable
        for(int i = word.length() - 1; i >= 0; i--){
            reverse += letters[i];
        }

        //program returns the reversed word
        return reverse;
    }

    public void Restart(){
        //program asks user if they'd like to restart
        System.out.println("Would you like to go again? If so, press 1 & then press ENTER");
        int input = scnr.nextInt();

        //program restarts if user agrees, thanks the user for participating if they don't
        if(input == 1){
            program();
        } else{
            System.out.println("Thanks for playing!");
        }
    }
}
