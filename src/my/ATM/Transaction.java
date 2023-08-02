package my.ATM;

import java.time.LocalDate;

public class Transaction
{

    private int accountNrA;
    private double commission;
    private double ammount;
    private int TransactionNr;
    private LocalDate date;

    Transaction(LocalDate date, double ammount, int accountNrA, double commission, int TransactionNr)
    {
        this.setDate(date);
        this.setAmmount(ammount);
        this.setAccountNrA(accountNrA);
        this.TransactionNr = TransactionNr;
        this.commission = commission;
    }
    public String toString()
    {
        return "Account Nr: " + getAccountNrA() + " commission: " + getCommission() + " ammount: " + getAmmount() + " transaction nr: " + getTransactionNr() +" date: " + getDate();
    }
    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public double getAmmount()
    {
        return ammount;
    }

    public void setAmmount(double ammount)
    {
        this.ammount = ammount;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public int getAccountNrA()
    {
        return accountNrA;
    }

    public void setAccountNrA(int accountNrA)
    {
        this.accountNrA = accountNrA;
    }

    public int getTransactionNr()
    {
        return TransactionNr;
    }

    public void setTransactionNr(int transactionNr)
    {
        this.TransactionNr = transactionNr;
    }

}
class Deposit extends Transaction
{

    Deposit(LocalDate date, double ammount, int accountNrA, double commission, int TransactionNr)
    {
        super(date, ammount, accountNrA, commission, TransactionNr);
    }
}
class Withdrawal extends Transaction
{

    Withdrawal(LocalDate date, double ammount, int accountNrA, String bankName, double commission, int TransactionNr)
    {
        super(date, ammount, accountNrA, commission, TransactionNr);
    }
}
class Transfer extends Transaction
{
    //money transfer from account A to account B
    private int accountNrB;
    //I need to provide a correction with this TransactionNr
    //The number is relevant as the number of transaction in ATM, and this Transfer is not connected with the ATM
    //Temporarily, I put 0 here as the number of transaction
    Transfer(LocalDate date, double ammount, int accountNrA, int accountNrB, double commission, int TransactionNr)
    {
        super(date, ammount, accountNrA, commission, 0);
        this.setAccountNrB(accountNrB);

    }

    public String toString()
    {
        return "From account:" + getAccountNrA() + " to account: "+ getAccountNrB() + ", commission: " + getCommission() + ", ammount: " + getAmmount() + ", transaction Nr: " + getTransactionNr() +"data: " + getDate();
    }

    public int getAccountNrB()
    {
        return accountNrB;
    }

    public void setAccountNrB(int accountNrB)
    {
        this.accountNrB = accountNrB;
    }
}

