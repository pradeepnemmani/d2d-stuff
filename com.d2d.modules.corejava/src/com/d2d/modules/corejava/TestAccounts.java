package com.d2d.modules.corejava;

public class TestAccounts
{

    public static void main( String[] args )
    {
        BankAccount ba = new BankAccount();
        System.out.println( "Rate of Interest for BankAccount : "
                + ba.getRateOfInterest() );

        SavingsAccount sa = new SavingsAccount();
        System.out.println( "Rate of Interest for SavingsAccount : "
                + sa.getRateOfInterest() );

        BankAccount ba1 = new SavingsAccount();
        System.out.println( "Rate of Interest for ba1 : "
                + ba1.getRateOfInterest() );
    }

}
