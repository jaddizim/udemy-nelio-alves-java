package application;

import entities.Account;
import exceptions.BalanceException;
import exceptions.WithdrawLimitException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int mainNumber = 0;
        double mainBalance, mainWithdrawLimit, mainAmount;
        String mainHolder;
        Scanner t = new Scanner(System.in);

        while (true) {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            mainNumber = t.nextInt();
            t.nextLine();
            System.out.print("Holder: ");
            mainHolder = t.nextLine();
            System.out.print("Initial balance: ");
            mainBalance = t.nextDouble();
            System.out.print("Withdraw limit: ");
            mainWithdrawLimit = t.nextDouble();

            Account acc = new Account(mainNumber, mainHolder, mainBalance, mainWithdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            mainAmount = t.nextDouble();
            try {
                acc.withdraw(mainAmount);
                System.out.printf("New balance: %.2f%n", acc.getBalance());
            } catch (WithdrawLimitException e) {
                System.out.println(e.getMessage());
            } catch (BalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}