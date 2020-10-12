//package atm;
import java.text.DecimalFormat;

public class Validation    /* Account Validating class */
{	
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	// Getters and Setters for Account number
	public int setAccountNumber(int account_number) 
	{   
		this.account_number = account_number;
		return account_number;
	}
	public int getAccountNumber() 
	{
		return account_number;
	}

    // Getters and Setters for Pin number 
	public int setPinNumber(short pin_number) 
	{
		this.pin_number = pin_number;
		return pin_number;
	}
	public int getPinNumber() 
	{
		return pin_number;
	}

    // Gets initial Current Account Balance 
	public double getCurrentBalance() 
	{
		return initial_current_balance;
	}

    // Get initial Savings Account Balance
	public double getSavingBalance() 
	{
		return initial_savings_balance;
	}

    // Calculate the Withdrawal Balance on both accounts
	public double CurrentBalanceWithdrawal(double amount)        
	{
		initial_current_balance = (initial_current_balance - amount);
		return initial_current_balance;
	}
    public double SavingsBalanceWithdrawal(double amount)        
	{
		initial_savings_balance = (initial_savings_balance - amount);
		return initial_savings_balance;
	}

	// Calculate the Deposit Balance on both accounts
    public double CurrentBalanceDeposit(double amount)            
	{
		initial_current_balance = (initial_current_balance + amount);
		return initial_current_balance;
	}  
    public double SavingsBalanceDeposit(double amount)            
	{
		initial_savings_balance = (initial_savings_balance + amount);
		return initial_savings_balance;
	}

    // Withdrawal Input Operation for 1.Current and 2.Savings Accounts 

/*1*/public void CurrentWithdrawFunds()  throws Exception
	{   
		System.out.println("Your Current Account balance is : " + moneyFormat.format(initial_current_balance));
		System.out.print("Enter your amount to withdraw : ");
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance - amount) > 0) 
		{
			CurrentBalanceWithdrawal(amount);
			System.out.println("\nYour updated Current Account balance : " + moneyFormat.format(initial_current_balance));
			Thread.sleep(600);
			System.out.println("\nThank u , Returned to Account Type");
		}
		else if((initial_current_balance - amount) == 0)
			System.out.println("\007"+"\n\t\tYou Cannot Withdraw Zero");
		else
		    System.out.println("\007"+"\n**INSUFFICIENT BALANCE :(");
	}

/*2*/public void SavingsWithdrawFunds()  throws Exception
	{   
		System.out.println("Your Saving Account balance is : " + moneyFormat.format(initial_savings_balance));
		System.out.print("Enter your amount to withdraw : ");
        double amount = Atm.input.nextDouble();
        
		if((initial_savings_balance - amount) > 0) 
		{
			SavingsBalanceWithdrawal(amount);
			System.out.println("Your updated Savings Account balance : " + moneyFormat.format(initial_savings_balance));
			Thread.sleep(600);
			System.out.println("\nThank u , Returned to Account Type");
		} 
		else if((initial_savings_balance - amount) == 0) 
			System.out.println("\007"+"\n\t\tYou Cannot Withdraw Zero");
		else
		    System.out.println("\007"+"\n**INSUFFICIENT BALANCE :(");
	}

     // Deposit Input Operation for 1.Current and 2.Savings Accounts 

/*1*/public void CurrentDepositFunds() throws Exception
	{
		System.out.println("Your Current Account balance is : " + moneyFormat.format(initial_current_balance));
		System.out.print("Enter your amount to deposit : "); Atm.delay();
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance + amount) > 0) 
		{
			CurrentBalanceDeposit(amount);
			System.out.println("   [Amount is successfully deposited in your current account]   "); 
			Thread.sleep(600); 
			System.out.println("\nYour updated Current Account balance : " + moneyFormat.format(initial_current_balance));
		} 
		else 
		{
			System.out.println("\007"+"\nYour entered amount is lower or equals Zero(0)");
        }       
	}

/*2*/public void SavingsDepositFunds() throws Exception
	{
		System.out.println("Your Savings Account balance is : " + moneyFormat.format(initial_savings_balance));
		System.out.print("Enter your amount to deposit : "); Atm.delay();
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance + amount) > 0) 
		{
			SavingsBalanceDeposit(amount);
			System.out.println("   [Amount is successfully deposited in your savings account]   "); 
			Thread.sleep(600);
			System.out.println("\nYour updated Savings Account balance : " + moneyFormat.format(initial_savings_balance));
		} 
		else 
		{
			System.out.println("\007"+"\nYour balance is lower or equals Zero(0)");
        }       
	}	
    //Variables declaration -- do not modify (Modify may cause errors)
	private int account_number;
	private short pin_number;
	private double initial_current_balance = 0;
	private double initial_savings_balance = 0;
	
}
