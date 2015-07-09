package com.d2d.modules.corejava.threads.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Account
{
    private WriteLock writeLock = new ReentrantReadWriteLock(true).writeLock();
    private String accountNumber;

    private double balance;

    public Account()
    {
        // writeLock = new ReentrantReadWriteLock().writeLock();
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
        boolean locked = false;
        try
        {
//            if ( writeLock == null )
//            {
//                writeLock = new ReentrantReadWriteLock().writeLock();
//            }
            locked = writeLock.tryLock();
            if ( locked )
            {
                currentBalance = getBalance();
                System.out.println( "Current Balance : " + currentBalance );
                currentBalance += amountToDeposit;
                setBalance( currentBalance );
                System.out
                        .println( "Current Available Balance after Deposit : "
                                + currentBalance );
            }
            else
            {
                System.out.println( "UNABLE TO ACQUIRE A LOCK......" );
            }
        }
        finally
        {
            if ( writeLock != null && locked )
            {
                writeLock.unlock();
            }
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
