import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//*********For sample file type: sample.txt or about.txt **************/

class ReadingLevelCalculatorTest{
    public static void main(String[] args) throws FileNotFoundException{

        //User Prompt for Selection 
        System.out.println("Welcome to the Reading Level Calculator");
        System.out.println("Select input style ");
        System.out.println("1: By File"); 
        System.out.println("2: By console");
        System.out.print("Enter selection here: ");

        //create scanner for user selection
        Scanner selectionInput = new Scanner(System.in); 

        //integer stores user selection 
        int selection = 0;
        
        try{
            selection = selectionInput.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input");
        }

        try {
            performCalculation(selection);
        } 
        
        catch (InvalidSelectionException e) {
           System.out.println(e);
        }

        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        
        catch (InputMismatchException e){
            System.out.println("Invalid Input");
        }
        
    
    }

    public static void performCalculation(int selection) throws InvalidSelectionException, FileNotFoundException{
        if(selection != 1 && selection != 2){
            throw new InvalidSelectionException("This is not a valid selection.");
        }

        switch(selection){
            case 1: 
                Scanner scanner = new Scanner(System.in); 

                System.out.print("Enter the name of the text file you would like to analyze: ");
                String textFileName = scanner.nextLine();

                File file = new File(textFileName);
                Scanner textFile = new Scanner(file);


                //create ReadingLevelCalculator object 
                ReadingLevelCalculator calculator = new ReadingLevelCalculator(); 
               
                calculator.textFileInputCalculator(textFile);

                break;
            
            case 2:
                Scanner consoleInput = new Scanner(System.in);
                
                //create ReadingLevelCalculator object
                ReadingLevelCalculator calculator2 = new ReadingLevelCalculator();
                calculator2.consoleInputCalculator(consoleInput);

                System.out.println("Index " + calculator2.index);

                break;
        }

    }
   
}