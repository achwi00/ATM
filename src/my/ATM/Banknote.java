package my.ATM;

public class Banknote
{
    private int nominal;
    public int getNominal()
    {
        return nominal;
    }

    protected void setNominal(int nominal)
    {
        this.nominal = nominal;
    }
}
class Banknote10Zl extends Banknote
{
    Banknote10Zl()
    {
        setNominal(10);
    }

}
class Banknot20zl extends Banknote
{
    Banknot20zl()
    {
        setNominal(20);
    }

}
class Banknot50zl extends Banknote
{
    Banknot50zl()
    {
        setNominal(50);
    }
}
class Banknote100Zl extends Banknote
{
    Banknote100Zl()
    {
        setNominal(100);
    }
}
class Banknote200Zl extends Banknote
{
    Banknote200Zl()
    {
        setNominal(200);
    }
}
class Banknot500zl extends Banknote
{
    Banknot500zl()
    {
        setNominal(500);
    }
}