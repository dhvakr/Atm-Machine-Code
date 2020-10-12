//package atm
import java.text.DecimalFormat;
import java.util.HashMap;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map.Entry;

public class Menu extends Validation    /* Menu class */
{  
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();  

	public void login() throws IOException , Exception    
	{
		boolean b = true;        
	   do 
	  {   
		try 
		{	 //Assigning Keys and Values for Login into account
			
		       data.put(73974994, 6300);      
			   data.put(94793113, 7410);       
               data.put(45101100, 8520);      
			   data.put(16345225, 9630); 	  

			System.out.print("\n\nEnter your Customer Number : ");  
			setAccountNumber(Atm.input.nextInt()); 

			System.out.print("\nEnter your Secret Pin : ");
			setPinNumber(Atm.input.nextShort());

			System.out.print("\t\nVALIDATING DATABASE"); Atm.dot(); 
		} 
		catch(InputMismatchException in) 
		{   
			// Are u such a dumb ? to enter characters or symbols,when asking for a number !?
			// So this exception is for u
			System.err.println("\007"+"\n** Invalid character(s). Only numbers allowed **" + "\n");
            b = false;  
		}
		if(b == true)
		{
		 for(Entry<Integer, Integer> entry : data.entrySet()) 
		   {
			 if(entry.getKey() == getAccountNumber() && entry.getValue() == getPinNumber()) 
			 {  
			 AccountType();
			 }	
		   }
		System.err.println("\007" + "\n\n[OOPS!! Invalid Customer number (or) Pin - " + "Try Again with the correct credentials]"); 
		}			 
	  }while(b == true);
    }

	public void AccountType() throws Exception
	{
		System.out.println("\007"+"\n\n\t* Select the account you want to access: \n");
		System.out.println("\t\tType 1 - Current Account"); Atm.delay();
		System.out.println("\t\tType 2 - Savings Account"); Atm.delay();
		System.out.println("\t\tType 3 - Exit"); Atm.delay();
		System.out.print("Choice : "); 
		Byte type = Atm.input.nextByte();

		switch(type) 
		{
		case 1:
		    CurrentAccount(); 
			break;
		case 2:
			SavingsAccount(); 
			break;
		case 3: 
            Atm.ExitMessage();
			System.exit(0);
		default:
			Atm.invalid(); 
			System.out.println("\n\tReturning to Account Type ^-^ "); AccountType();
		}
	}

	public double CurrentAccount() throws Exception
	{
		System.out.println("\n\tCURRENT ACCOUNT : \n"); 
		System.out.println("\t\tType 1 - View Balance"); Atm.delay();
		System.out.println("\t\tType 2 - Withdraw funds"); Atm.delay();
		System.out.println("\t\tType 3 - Deposit Funds"); Atm.delay();
		System.out.println("\t\tType 4 - Return Back to AccountType");Atm.delay();
		System.out.println("\t\tType 5 - Exit"); Atm.delay();
		System.out.print("Choice : ");
		Byte type = Atm.input.nextByte();
		
		switch(type) 
		{
		case 1:
		    System.out.println("\nYour Current Account Balance : " + moneyFormat.format(getCurrentBalance()));
		    Atm.delay();
		    if(getCurrentBalance() <= 0)
			{ 
             System.out.println("Oops, u have 'Zero(0)' balance in your Current account");
			 System.out.println("Select Type '3' to Deposit Funds"); Atm.delay();
			  CurrentAccount();
			}
			else
			{ 
			  AccountType();
			}
			break;
		case 2:	    
			CurrentWithdrawFunds(); Atm.delay();
		    AccountType(); 
		    break;
		case 3:
			CurrentDepositFunds(); 
			System.out.println("\n\nReturning to Current Account ^-^"); Atm.delay();
		    CurrentAccount();   
			break;
		case 4 :
			AccountType();
		case 5:
            Atm.ExitMessage(); 
		    System.exit(0); 
		default: 
		    Atm.invalid(); 
		    System.out.println("\n\tReturning to Current Account ^-^ "); 
		    CurrentAccount();
		}
		return type;
	}

	public void SavingsAccount() throws Exception
	{
		System.out.println("\n\tSAVINGS ACCOUNT : \n"); 
		System.out.println("\t\tType 1 - View Balance"); Atm.delay();
		System.out.println("\t\tType 2 - Withdraw funds"); Atm.delay();
		System.out.println("\t\tType 3 - Deposit Funds"); Atm.delay();
		System.out.println("\t\tType 4 - Return Back to AccountType");Atm.delay();
		System.out.println("\t\tType 5 - Exit"); Atm.delay();
		System.out.print("Choice : ");
		Byte type = Atm.input.nextByte();
		
		switch(type)
		{
		case 1:
			System.out.println("Your Savings Account Balance is : " + moneyFormat.format(getSavingBalance()));
            Atm.delay();
			if(getSavingBalance() <= 0)
			{ 
             System.out.println("Oops, u have 'Zero(0)' balance in your savings account");
			 System.out.println("   Select Type '3' to Deposit Funds"); Atm.delay();
			  SavingsAccount();
			}
			else
			{ 
			  AccountType();
			}
			break;
		case 2:		  
			SavingsWithdrawFunds(); Atm.delay();
			AccountType(); 
			break;
		case 3:
			SavingsDepositFunds();
			System.out.println("\n\nReturning to Savings Account ^-^"); Atm.delay();
		    SavingsAccount(); 
			break;
		case 4 :
			AccountType();
		case 5:
			Atm.ExitMessage(); 
			System.exit(0);
		default:
			Atm.invalid(); 
			System.out.println("\n\tReturning to Savings Account ^-^ "); 
			SavingsAccount();
		}
	}
}