
public class CheckingAccount extends BankAccount{
      
    public CheckingAccount( float value )
    {
        super.value=value;
        super.rate=(float) 0.0;
        super.type="Checking";
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
     
    public float ProcessCheck(float ProcessCheck)
    {
        super.ProcessCheck(ProcessCheck);        
        return super.value;
    }
    
}
