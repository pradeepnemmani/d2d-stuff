package com.d2d.modules.corejava.threads.synchronization;

public class Account
{
    private String accountNumber;

    private double balance;

    public Account()
    {

    }

    public Account( double initialBalance )
    {
        balance = initialBalance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber( String accountNumber )
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance( double balance )
    {
        this.balance = balance;
    }

    public void deposit( double amountToDeposit )
    {
        System.out.println( "Entering the deposit method" );
        System.out.println( "Amount to deposit : " + amountToDeposit );

        double currentBalance = 0.0;
        synchronized ( this )
        {
            currentBalance = getBalance();
            System.out.println( "Current Balance : " + currentBalance );
            currentBalance += amountToDeposit;
            setBalance( currentBalance );
            System.out.println( "Current Available Balance after Deposit : "
                    + currentBalance );
        }

        System.out.println( "Sending SMS to the account owner" );
        System.out.println( "Returning from the deposit method" );
    }

    public double withdraw( double amountToWithdraw )
    // throws InsufficientFundsException
    {
        double currentBalance = getBalance();
        if ( currentBalance >= amountToWithdraw )
        {
            // Good shape. Go ahead and withdraw and return the same amount
            currentBalance -= amountToWithdraw;
            setBalance( currentBalance );
            System.out
                    .println( "Current Available Balance : " + currentBalance );
            return currentBalance;
        }
        System.out.println( "Current Available Balance : " + currentBalance );
        // throw new InsufficientFundsException();
        return currentBalance;
    }
}
