import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.io.IOException;
import java.text.DecimalFormat;

public class Menu extends Validation    
{  
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<>();  

	/**
	 * Entry Method To Login The Interface
	 * @throws InterruptedException
	*/
	public void login() throws InterruptedException
	{
		boolean b = true;        
	   do 
	  {   
		try 
		{	 // Assigning Keys and Values for Login into account			
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
		catch(final InputMismatchException | IllegalArgumentException in) 
		{ 
			// Are u such a dumb ? to enter characters or symbols,when asking for a number !?
			// So this exception is for u
			System.err.println("\007"+"\n** Invalid Input(s). Not an Valid Credentials **" + "\n");
            b = false;  
		}
		if(b)
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
	  }while(b);
    }

	public void AccountType() throws InterruptedException
	{
		System.out.println("\007"+"\n\n\t* Select the account you want to access: \n");
		System.out.println("\t\tType 1 - Current Account"); Atm.delay();
		System.out.println("\t\tType 2 - Savings Account"); Atm.delay();
		System.out.println("\t\tType 3 - Exit"); Atm.delay();
		System.out.print("Choice : "); 
		byte type = Atm.input.nextByte();

		switch (type) 
		{
			case 1 : CurrentAccount();
			case 2 : SavingsAccount();
			case 3 : 
					{
						Atm.exitMessage();
						System.exit(0);
					}
			default : 
					{
						Atm.invalid();
						System.out.println("\n\tReturning to Account Type ^-^ ");
						AccountType();
					}
		}
	}

	public void CurrentAccount() throws InterruptedException
	{
		System.out.println("\n\tCURRENT ACCOUNT : \n"); 
		System.out.println("\t\tType 1 - View Balance"); Atm.delay();
		System.out.println("\t\tType 2 - Withdraw funds"); Atm.delay();
		System.out.println("\t\tType 3 - Deposit Funds"); Atm.delay();
		System.out.println("\t\tType 4 - Return Back to AccountType");Atm.delay();
		System.out.println("\t\tType 5 - Exit"); Atm.delay();
		System.out.print("Choice : ");
		byte type = Atm.input.nextByte();
		
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
						System.out.println("\n\tReturning to Account Type ^-^ ");
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
					Atm.exitMessage(); 
					System.exit(0); 
			default: 
					Atm.invalid(); 
					System.out.println("\n\tReturning to Current Account ^-^ "); 
					CurrentAccount();
		}
	}

	public void SavingsAccount() throws InterruptedException
	{
		System.out.println("\n\tSAVINGS ACCOUNT : \n"); 
		System.out.println("\t\tType 1 - View Balance"); Atm.delay();
		System.out.println("\t\tType 2 - Withdraw funds"); Atm.delay();
		System.out.println("\t\tType 3 - Deposit Funds"); Atm.delay();
		System.out.println("\t\tType 4 - Return Back to AccountType");Atm.delay();
		System.out.println("\t\tType 5 - Exit"); Atm.delay();
		System.out.print("Choice : ");
		byte type = Atm.input.nextByte();
		
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
						System.out.println("\n\tReturning to Account Type ^-^ ");
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
					Atm.exitMessage(); 
					System.exit(0);
			default:
					Atm.invalid(); 
					System.out.println("\n\tReturning to Savings Account ^-^ "); 
					SavingsAccount();
		}
	}
}