package my.ATM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account
{
    private int howManyTransactions;
    public ArrayList<Transaction> history = new ArrayList<>();
    private int clientNr;
    private int accountNr;
    private double accountBalance;//stan konta
    private String typeOfAccount;
    private String bankName;

    Account(int accountNr, int clientNr, String typeOfAccount, String bankName)
    {
        this.setClientNr(clientNr);
        this.setTypeOfAccount(typeOfAccount);
        this.setBankName(bankName);
        this.setAccountNr(accountNr);
        setAccountBalance(0);
    }

    public String toString()
    {
        return "Client number: " + clientNr + " balance: " + accountBalance + "type of account: " + typeOfAccount;
    }
    public void deposit(double ammount)
    {
        //deposit the money - increase the account balance by the given ammount
        setAccountBalance(getAccountBalance()+ammount);
        System.out.println("Operation was successful");

    }
    public void withdrawal(double ammount)
    {
        //if the ammount you're trying to withdraw is <= than the account balance, do it
        if(ammount<= getAccountBalance())
        {
            setAccountBalance(getAccountBalance()-ammount);
            System.out.println("Operation was successful");
        }
        else
        {
            //else do not make any changes and print an information
            System.out.println("Operation was unsuccessful, the ammount of funds is insufficient");
        }

    }
    public void transfer(double ammount, Account kB)
    {
        //allows money transfer from this account to some given account B
        //if the account balance >= than the ammount you want to transfer, allow it
        if(getAccountBalance()>=ammount)
        {
            Transfer transfer = new Transfer(LocalDate.now(),ammount, getAccountNr(), kB.getAccountNr(),kB.chargeCommission(getBankName(),ammount),0);
            //withdraw the ammount from current account
            withdrawal(ammount);
            //deposit it on the account given as an argument
            kB.deposit(ammount);
            //add the operation to the history of transactions
            history.add(transfer);
            System.out.println("Operation was successful");
        }
        else
        {
            System.out.println("Operation was unsuccessful");
        }
    }

    public double chargeCommission(String atmBankName, double ammount)
    {
        //calculates commision if the bankname of current account is different from the bank name of the account given as an argument
        if(!(atmBankName.equals(getBankName())))
        {
            //calculates a commision of 0.05 * the ammount of the transfer
            return ammount * 0.05;
        }
        else return 0;
    }
    public void displayHistory()
    {
        for (Transaction element : history)
        {
            System.out.println(element.toString());
        }

    }
    public int getClientNr()
    {
        return clientNr;
    }

    public void setClientNr(int clientNr)
    {
        this.clientNr = clientNr;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }

    public String getTypeOfAccount()
    {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount)
    {
        this.typeOfAccount = typeOfAccount;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public int getAccountNr()
    {
        return accountNr;
    }

    public void setAccountNr(int accountNr)
    {
        this.accountNr = accountNr;
    }
}
