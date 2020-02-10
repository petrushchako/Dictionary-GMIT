package ie.gmit.dip;

import java.util.*;
import ie.gmit.dip.Parser;;


public class Menu {
    private Scanner scanner;
    private Scanner decryptionScanner;
    private Parser parser = new Parser();
   private boolean keepRunning = true;


    public void start() {
        scanner = new Scanner(System.in);

        do {
            initMenu();
            processInput();
        } while (keepRunning == true);
    }



    private void processInput() {
        String input = scanner.next();
        int choice = Integer.parseInt(input);
        switch (choice) {
            case 1:
                System.out.println("Enter Key");
                parser.keyTableArray(scanner.next());
                //Enter Keys(); 
                break;
            case 2:
                
              break;
            case 3:
                System.out.println("Decrypt");
                System.out.println("Enter encrypted text");
                decryptionScanner = new Scanner(System.in);
                parser.decrypt((decryptionScanner.nextLine()).toString());
                
                break;
            case 4:
                keepRunning = false;
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
   
    
    
    
    private void initMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("|\t\t4 Square Cipher               |");
        System.out.println("-----------------------------------------------");
        System.out.println("|   1) Enter Keys                             |");
        System.out.println("|   2) Encrypt                                |");
        System.out.println("|   3) Decrypt                                |");
        System.out.println("|   4) Quit                                   |");
        System.out.println("|               Select 1-4                    |");
        System.out.println("-----------------------------------------------");
    }
}
