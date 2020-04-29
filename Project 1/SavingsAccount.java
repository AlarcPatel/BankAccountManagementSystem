
public class SavingsAccount extends BankAccount{
    
    
    public SavingsAccount( float value, float rate )
    {
        super.value=value;
        super.rate=rate*100;
        super.type="Savings";
    }    
    
    public float deposit(float value)
    {
        super.deposit(value);        
        return super.value;
    }
    
    public float withdraw(float amount)
    {
        super.withdraw(amount);        
        return super.value;
    }
}
