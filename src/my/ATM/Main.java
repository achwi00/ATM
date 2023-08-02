package my.ATM;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        ATM atm0 = new ATM("ING","Kra-001","Krakow-Stare Miasto");
        Account account0 = new Account(1,1,"personal","ING");
        Account account1 = new Account(2,2,"company","ING");

        Banknote200Zl zloty200 = new Banknote200Zl();
        Banknote100Zl zloty100 = new Banknote100Zl();
        atm0.deposit(1, account0,zloty100,zloty200);

        System.out.println("Account balance for account0: " + account0.getAccountBalance());

        atm0.withdrawal(1,100, account0);
        System.out.println("Account balance for account0:: " + account0.getAccountBalance());

        account0.transfer(500, account1);
        System.out.println("Account balance for account1:: "+ account1.getAccountBalance());
        LocalDate dateee = LocalDate.now();
        atm0.printTransaction(dateee);

    }
}