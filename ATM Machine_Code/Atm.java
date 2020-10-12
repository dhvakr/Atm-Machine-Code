//package atm;
/*  
*   @TITLE : ATM Machine Code
*   @Coded Version : 2020/Oct     
*  This contain code of ATM Machine in Core Java, works with the below given credential's
*
*    Account Number : 73974994 , PIN : 6300
*    Account Number : 94793113 , PIN : 7410
*    Account Number : 45101100 , PIN : 8520
*    Account Number : 16345225 , PIN : 9630
*
* /> You can also add your preferred credentials to test the code.
*    1.> - Navigate to MENU class 
*    2.> - In line 20, change values inside " data.put(xxxxxxx,xxxxx) " as you wish \☺
*    ~NOTE : It only allows in range of 10 digit
*
* REMEMBER :-
* ?> Your Initial balance is Always Zero(0), "Do Deposit some amount before withdrawing amount"
* ?> Modifying variables may cause errors
* ?> You're Good to go ♥

* ------------
*   @author DIVAKARAN  
*   GITHUB  : https://github.com/dhvakr 
*   TWITTER : https://twitter.com/dhvakr 
* ------------
*      (THIS PROJECT IS UNDER MIT LICENSE) 
* Feel free to provide ur feedback of my code ,Thank u
**/
import java.io.IOException; 
import java.util.Scanner; 

public class Atm   /* Main Class */
{   
    static Scanner input = new Scanner(System.in);
	public static void main(String[] atm) throws IOException , Exception
	{   
       try 
       {
        System.out.println(" \n\t\t " + " Welcome to Virtual ATM "); 

		 Menu option = new Menu();
         option.login();
         input.close();
       } 
       catch(Exception z)
       { 
         System.err.println("\tATM is Temporary Out Of Service");
       } 
       finally
       { 
         System.out.println("\n\t Something Went Wrong");
       }        
    }
// Repetition Global Methods //
    public static void dot() throws Exception
    {
        for (int dot = 1; dot <= 3 ; dot++)
        {
            System.out.print(".");
            Thread.sleep(550);
        }
    }
    public static void delay() throws Exception
    {
        for (int delay = 0; delay <= 3 ; delay++)
        {
            Thread.sleep(200);
        }
    }
    public static void ExitMessage()
    {
       System.out.println("\nThank you for using this ATM, Have a Nice day !!");
       System.out.println("\n\n\t *_* Please feel free to provide your feedback of my code");
    }
    public static void invalid()
    {
       System.err.println("\007" + "\nInvalid !! " + " Select Appropriative Selection\n");
    }  
}