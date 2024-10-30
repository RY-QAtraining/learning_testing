package org.lbg.bankAccApp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BankAccount newAcc  = new BankAccount(33.33);
        System.out.println(newAcc.getBalance());

        newAcc.debit(34);
        System.out.println(newAcc.getBalance());

    }
}
