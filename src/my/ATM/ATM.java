package my.ATM;

import java.time.LocalDate;
import java.util.ArrayList;

public class ATM
{
    private int resetCode;
    private String location;
    private String bankBranch;
    private String bankName;
    private int howManyTransactions;
    public ArrayList<Banknote> stan = new ArrayList<>();
    public ArrayList<Transaction> archieve = new ArrayList<>();//history of transactions

    ATM(String bankName, String bankBranch, String location)
    {
        //we set the ammount of transactions to 0, as it is a new ATM
        setHowManyTransactions(0);
        this.setBankName(bankName);
        this.bankBranch = bankBranch;
        this.location = location;

    }
    public void printTransaction(LocalDate transactionDate)
    {
        //iterrate through the whole archieve
        for (Transaction element : archieve)
        {
            if(element.getDate().equals(transactionDate))//if the date is the same as the given one, print information about the transaction
            {
                System.out.println(element.toString());//element.toString() to wywolanie polimorficzne
            }
        }
    }
    public String toString()//override toString method
    {
        String a=" ";//create an empty string
        for (Transaction element : archieve)//iterrate through the entire array
        {
            System.out.println(element.toString());//print information about the element - for testing only
            a= a.concat(element.toString());//add the information about the element to the string
        }
        return a;//return the string
    }
    public void deposit(int nrKonta, Account kA, Banknote... banknotes)//wplata
    {
        //increment the ammount of transactions that took place
        setHowManyTransactions(getHowManyTransactions() + 1);
        //set the ammount to zero
        double ammount=0;
        //iterrate through the Banknote array that was given as an argument
        for (Banknote banknote : banknotes) {
            //get the nominal of the banknote, add it to the ammount that has been calculated
            ammount = ammount + banknote.getNominal();
        }
        System.out.println("deposited: " + ammount);
        //use the deposit method from Account class, to deposit the money to the account
        kA.deposit(ammount);
        //create a new Deposit with current date and given account details
        Deposit deposit = new Deposit(LocalDate.now(),ammount,nrKonta,kA.chargeCommission(getBankName(),ammount),getHowManyTransactions());
        //add the deposit to the archieve and to the history of transactions in Account class
        archieve.add(deposit);
        kA.history.add(deposit);

    }
    public void withdrawal(int accountNr, double ammount, Account kA)
    {
        setHowManyTransactions(getHowManyTransactions() + 1);
        //use the withdrawal method from Account class
        kA.withdrawal(ammount);
        Withdrawal withdrawal = new Withdrawal(LocalDate.now(),ammount,accountNr, getBankName(), kA.chargeCommission(getBankName(),ammount), getHowManyTransactions());
        archieve.add(withdrawal);
        kA.history.add(withdrawal);

    }
    public void memoryReset(int code)
    {
        //if the provided code is correct
        if(code== getResetCode())
        {
            //clear the archieve, set the number of transactions to 0
            archieve.clear();
            setHowManyTransactions(0);
        }
        else
        {
            System.out.println("The code You provided is incorrect.");
        }
    }

    public int getResetCode()
    {
        return resetCode;
    }

    public void setResetCode(int resetCode)
    {
        this.resetCode = resetCode;
    }

    public int getHowManyTransactions()
    {
        return howManyTransactions;
    }

    public void setHowManyTransactions(int howManyTransactions)
    {
        this.howManyTransactions = howManyTransactions;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
}
