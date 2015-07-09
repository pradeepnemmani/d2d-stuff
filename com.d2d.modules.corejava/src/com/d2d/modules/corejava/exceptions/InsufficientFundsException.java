package com.d2d.modules.corejava.exceptions;

public class InsufficientFundsException extends Exception
{
    private double currentBalance;

    private double withdrawAmt;

    public InsufficientFundsException( double currentBalance, double withdrawAmt )
    {
        super( "Insufficient funds in your account. Your balance is "
                + currentBalance + " and the amount being withdrawn is "
                + withdrawAmt );
        this.currentBalance = currentBalance;
        this.withdrawAmt = withdrawAmt;
    }

    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public double getWithdrawAmt()
    {
        return withdrawAmt;
    }

}
