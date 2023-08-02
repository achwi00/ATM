package my.ATM;
public class Card
{
    private String clientNr;
    private String name;
    private String surname;
    private int cardNr;
    private int accountNr;


    public Card(String clientNr, String name, String surname, int cardNr, int accountNr)
    {
        this.setClientNr(clientNr);
        this.setName(name);
        this.setSurname(surname);
        this.setCardNr(cardNr);
        this.setAccountNr(accountNr);
    }

    public String getClientNr()
    {
        return clientNr;
    }

    public void setClientNr(String clientNr)
    {
        this.clientNr = clientNr;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getCardNr()
    {
        return cardNr;
    }

    public void setCardNr(int cardNr)
    {
        this.cardNr = cardNr;
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
