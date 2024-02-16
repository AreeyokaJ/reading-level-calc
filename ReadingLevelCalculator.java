import java.util.Scanner;

public class ReadingLevelCalculator {
   
    int wordCounter = 0; //will keep count of the amount of words in the text
    int sentenceCounter = 0; //will keep count of the amount of sentences in the text
    int letterCounter = 0; //will keep count of the amount of the letters in the text
    
    //will keep count of the groups of 100 words
    //can possibly be fractional if the text contains less than 100 words
    double groupsOf100Words; 
    
    double index; //Will store the calculated value of the Coleman-Liau index
    
    /*This method will calculate and display the reading level of a text inputted in the console */
    public void consoleInputCalculator(Scanner scanner){
        consoleInputCounter(scanner); //counts words, sentences, and letters in the text provided by user in console
        colemanLiauIdexCalculation(); //calculate index using the Coleman-Liau Index equation
        displayResults(); //display the results based on calculated index
    }


    /*This method will calculate and display the reading level of a text inputted in the  */
    public void textFileInputCalculator(Scanner scanner){
        textFileInputCounter(scanner);
        colemanLiauIdexCalculation();
        displayResults();
    }

    /*
     * If the user choses the method of inputting text using a textFile .
       This method will use a for loop nested within a while loop to count all of the words, sentences, 
       and letters within the input
     */

    public void textFileInputCounter(Scanner scan){
        while(scan.hasNextLine()){
            String currentLine = scan.nextLine();

            for (int i = 0; i < currentLine.length(); i++){
                if (currentLine.charAt(i) == '.' || currentLine.charAt(i) == '?' || currentLine.charAt(i) == '!'){
                    sentenceCounter++;
                }

                /*This will increment letter counter by one if a character is a letter */
                if(Character.isLetter(currentLine.charAt(i))){
                    letterCounter++;
                }

                /*If there is a space that marks the end of the word, the  word Counter will be incremented by one */
                if (currentLine.charAt(i) == ' '){
                    wordCounter++;
                }
            }

        }
    }

    /*
     * If the user choses the method of inputting text using the console.
     * This method will use a for loop to count all of the words, sentences, and letters within the input
     */

    public void consoleInputCounter(Scanner input){
        //Prompt user for text 
        System.out.println("Please enter the text that you would like to analyze: ");

        //this text String will hold the input from console
        String text = input.nextLine();

        for (int i = 0; i < text.length(); i++){

            /*if at any-point in the text there is a '.', '?', or '!', in the english language this signifies
                therefore the sentenceCounter will be incremented by one
            */
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!'){
                sentenceCounter++;
            }

            /*This will increment letter counter by one if a character is a letter */
            if(Character.isLetter(text.charAt(i))){
                letterCounter++;
            }

            /*If there is a space that marks the end of the word, the  word Counter will be incremented by one */
            if (text.charAt(i) == ' '){
                wordCounter++;
            }
        }
    }

    /* This method will store the value obtained from Coleman-Liau index equation to the variable index */
    public void colemanLiauIdexCalculation() {
        
        //calculate the groups-of-100 words by dividing the amount of words in text by 100
        groupsOf100Words = (double) wordCounter/100;

        /*Index = 0.0588 * L - 0.296 * S - 15.8 ...
         where L is the average # of letters per 100 words in text, and S is the average 
         # of sentences per 100 words in the text
        */
        index = (0.0588 * (letterCounter/groupsOf100Words)) - (0.296 * (sentenceCounter/groupsOf100Words)) -15.8;
    }

    //this method will display results based on the index calculated
    public void displayResults(){

        //indexIntegerValue will round to the nearest integer
        int indexIntegerValue = (int) Math.round(index);

        //if indexIntegerValue is equal to 0 it will print the following
        if (indexIntegerValue == 0){
            System.out.println("\nThis text is at a Kindergarten reading level.");
        }
        
        //if indexIntegerValue is equal to 1  it will print the following
        else if(indexIntegerValue == 1){
            System.out.println("\nThis text is at a 1st grade reading level."); 
        }

        //if indexIntegerValue is equal to 2, it will print the following
        else if(indexIntegerValue == 2){
            System.out.println("\nThis text is at a 2nd grade reading level.");
        }

        //if indexIntegerValue is equal to 3, it will print the following
        else if(indexIntegerValue == 3){
            System.out.println("\nThis text is at a 3rd grade reading level.");
        }

        //if indextIntegerValue is greater than 3 and less than or equal to 12 it will print the following
        else if(indexIntegerValue > 3 && indexIntegerValue <= 12){
            System.out.println("\nThis text is at a " + indexIntegerValue + "th grade reading level.");
        }

        //if indexIntegerValue is greater than 12 and less than or equal 16 it will print the following. 
        else if(indexIntegerValue > 12 && indexIntegerValue <= 16) {
            System.out.println("\nThis text is at a college grade reading level.");
        }

        //if indexIntegerValue is greater than 16 then it will print the following
        else{
            System.out.println("This text is at a professional grade reading level.");
        }

    }

}
