package org.lbg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest
{
    private double sampleBalance = 34.75;

    @Test
    public void onConstruction_verify_object_initialised_correctly()
    {
        //arrange
        double expectedResult = 34.75;
        BankAccount cut = new BankAccount(expectedResult);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(expectedResult,actualResult);

    }

    //test credit method
    @Test
    public void check_deposit_works_as_intended_credit_more_than_0()
    {
        //arrange
        double creditAdded = 6.23;
        double expectedResult = sampleBalance+creditAdded;
        BankAccount cut = new BankAccount(sampleBalance);
        cut.credit(creditAdded);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void check_deposit_works_as_intended_credit_less_than_0()
    {
        //arrange
        double creditAdded = -6.23;
        BankAccount cut = new BankAccount(sampleBalance);
        cut.credit(creditAdded);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(sampleBalance,actualResult);
    }

    @Test
    public void check_deposit_works_as_intended_credit_equals_0()
    {
        //arrange

        double creditAdded = 0.0;
        BankAccount cut = new BankAccount(sampleBalance);
        cut.credit(creditAdded);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(sampleBalance,actualResult);
    }

    //test debit method
    @Test
    public void check_debit_works_as_intended_balance_more_than_debit()
    {
        //arrange
        double sampleBalance = 34.75;
        double debitAmount = 6.23;
        double expectedResult = sampleBalance-debitAmount;
        BankAccount cut = new BankAccount(sampleBalance);
        cut.debit(debitAmount);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void check_debit_works_as_intended_balance_less_than_debit()
    {
        //arrange
        double sampleBalance = 34.75;
        double debitAmount = 36.23;
        BankAccount cut = new BankAccount(sampleBalance);
        cut.debit(debitAmount);

        //act
        double actualResult = cut.getBalance();

        //assert
        assertEquals(sampleBalance,actualResult);
    }
}
