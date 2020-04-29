//Parent class for SavingAccount and CheckingAccount

public class BankAccount implements Account{
    
    protected float value;
    protected float rate;
    protected String type;
    
    //overriding interface method
    public float deposit(float deposit)
    {
        this.value+=deposit;
        return this.value;
    }
    
    //overriding interface method
    public float withdraw(float withdraw)
    {
        this.value=value-withdraw;
        return value;
    }
    
    //overriding interface method
    public float ProcessCheck(float ProcessCheck)
    {
       this.value=value-ProcessCheck;
       return value;
    }
    
}
