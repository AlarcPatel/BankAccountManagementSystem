//Authors: Alark,Harsh and Ceaser

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

//Driver metod
public class Project_1 {

    public static ArrayList<BankAccount> MyBank = new ArrayList<BankAccount>();//Making arraylist global so every method can have reference to it.
    
    public static void main(String[] args) {
            
        JOptionPane.showMessageDialog(null,"Welcome to our Bank Account System.");
        Scanner scanf= new Scanner(System.in);
        int passwd = 12345;
        int user;
        for(int j=0; j<3; j++)//Loop for three times asking the password
        {
            
            String InputPasswd = JOptionPane.showInputDialog(null,"Please input the Password:");
            user =Integer.parseInt(InputPasswd);
                
            for(int i=0; i<=1; i++)//Loop for keep printing Menu until pressed exit
            {
                if(user == passwd)
                {
                    int choice=CallMenu();
                    
                    switch(choice)// calls individual methods for Menu and its functions.
                    {
                        case 1:
                            GetAccountSummary();
                            i=0;
                            break;

                        case 2:
                            CreateNewAccount();
                            i=0;
                            break;

                        case 3:
                            MakeDeposit();
                            i=0;
                            break;

                        case 4:
                            Withdraw();
                            i=0;
                            break;

                        case 5:
                            ProcessChecks();
                            i=0;
                            break; 

                        case 6:
                            //Exit
                            JOptionPane.showMessageDialog(null,"Thanks for using our Bank Account System. We wish you have a Good Day!" );
                            i=2;
                            j=3;
                            break;   
                            
                        default:
                            i=0;
                            break;
                    }
                }
                else
                {
                    i=1;
                    JOptionPane.showMessageDialog(null,"You have entered WRONG password!!");
                    
                } 
            }                            
        }  
        //JOptionPane.showMessageDialog(null,"Authentiaction Failed!!");
    }        
    
    static void GetAccountSummary()// Method for printing summary.
    {
        String Summary="";        
        for(int i=0; i<MyBank.size();i++)
        {   
            int j=i+1;
            if(MyBank.get(i).type=="Savings")
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + "    |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
            else
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + " |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
        }
        JOptionPane.showMessageDialog(null,"Acc#      Type           Balance    Interest Rate\n"+ Summary);
    }
              
    static int CallMenu()// Menu method which is called in case method
    {
        
        String InputChoice = JOptionPane.showInputDialog(null,"1> Get account summary" + "\n2> Create a new account"+"\n3> Make deposit"+"\n4> Withdraw"+ "\n5> Process check" + "\n6> Exit"+"\n\nPlease input your choice!!");        	 
        int choice=Integer.parseInt(InputChoice);
        return choice;
    }
        
    static void CreateNewAccount()//Creates new account method which is called in main class case structure
    {
                
        String InputChoice = JOptionPane.showInputDialog(null,"You want to create a new \n\n1> Checking Account \n2> Saving Account\n\nPlease input your choice!!");
        int account=Integer.parseInt(InputChoice);
        switch(account)// gets choie from user 1) Saving account 2) Checking account
        {        
            case 1:                                            
                String InputCheckingDeposit = JOptionPane.showInputDialog(null,"Please input your starting deposit:");                
                float checkingdeposit=Float.parseFloat(InputCheckingDeposit); 
                
                //First create new checking account object and add it to arraylist.
                CheckingAccount Checking = new CheckingAccount((float)checkingdeposit);
                MyBank.add(Checking);                                
                JOptionPane.showMessageDialog(null,"A checking account is created.");   

                break;
                
            case 2:      
                
                String InputSavingDeposit = JOptionPane.showInputDialog(null,"Please input your starting deposit:");                
                float savingdeposit=Float.parseFloat(InputSavingDeposit);                         

                String YesNo = JOptionPane.showInputDialog(null,"Use the default interest rate(0.3%)? Y/N");                        
                //creates a new saving object depending on user choice
                ////First create new saving account object and add it to arraylist.
                if(YesNo.equals("y") || YesNo.equals("Y"))                
                {                        
                    SavingsAccount Savings = new SavingsAccount(savingdeposit, (float) 0.003);
                    MyBank.add(Savings);                    
                    JOptionPane.showMessageDialog(null,"An saving account is created.");   
                }        
                else
                {       
                    String InputRate = JOptionPane.showInputDialog(null,"Pleaseinput the rate:");
                    float rate= Float.parseFloat(InputRate); 
                    SavingsAccount Savings = new SavingsAccount(savingdeposit, (float) rate);
                    MyBank.add(Savings);                    
                    JOptionPane.showMessageDialog(null,"An saving account is created. ");            
                }
                
                break;
         
        }
    }
    
    static void MakeDeposit()//Makes a deposit which is called in main class case structure.
    {
        String Summary="";        
        for(int i=0; i<MyBank.size();i++)
        {   
            int j=i+1;
            if(MyBank.get(i).type=="Savings")
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + "    |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
            else
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + " |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
        }
        String InputAccountNumber = JOptionPane.showInputDialog(null,"You want to deposit to which account\n"+"\nAcc#      Type           Balance    Interest Rate\n"+ Summary+"\n\nPlease input your choice:");        
        int AccountNumber=Integer.parseInt(InputAccountNumber);
        String InputDeposit = JOptionPane.showInputDialog(null,"Please input the deposit amount:");
        float deposit= Integer.parseInt(InputDeposit);        
        AccountNumber-=1;
        //gets account number and deposit from user and calls a method of deposit
        MyBank.get(AccountNumber).deposit(deposit);
        
        //System.out.println(MyBank.get(0).value);
    }
    
     static void Withdraw()
    {
        String Summary="";        
        for(int i=0; i<MyBank.size();i++)
        {   
            int j=i+1;
            if(MyBank.get(i).type=="Savings")
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + "    |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
            else
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + " |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
        }
        String InputAccountNumber = JOptionPane.showInputDialog(null,"You want to withdraw from which account\n"+"\nAcc#      Type           Balance    Interest Rate\n"+ Summary+"\n\nPlease input your choice:");        
        int AccountNumber=Integer.parseInt(InputAccountNumber);
                       
        String InputWithdraw = JOptionPane.showInputDialog(null, "Please input the withdraw amount:");
        float withdrawn= Integer.parseInt(InputWithdraw);
        
        //gets account number and withdraw from user and calls a method of withdraw
        //checks if enough fund is available
        if(withdrawn>MyBank.get(0).value)
        {
            JOptionPane.showMessageDialog(null,"Not enough funds");           
        }
        else            
        {        
            AccountNumber-=1;            
            MyBank.get(AccountNumber).withdraw(withdrawn);            
        }
    }
    
    static void ProcessChecks()
    {
        String Summary="";        
        for(int i=0; i<MyBank.size();i++)
        {   
            int j=i+1;
            if(MyBank.get(i).type=="Savings")
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + "    |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
            else
            {
                Summary=Summary + " |  " + j + "   |   " + MyBank.get(i).type + " |  " +MyBank.get(i).value + "  |   " + MyBank.get(i).rate + "%" + "\n";
            }
        }
        String InputAccountNumber = JOptionPane.showInputDialog(null,"You want to withdraw from which account\n"+"\nAcc#      Type           Balance    Interest Rate\n"+ Summary+"\n\nPlease input your choice:");        
        int AccountNumber=Integer.parseInt(InputAccountNumber);
        
        AccountNumber-=1;
        
        //only checking account processes checks
        if(MyBank.get(AccountNumber).type=="Savings")
        {
            JOptionPane.showMessageDialog(null,"Savings Account cannot process checks!!");
        }
        else
        {
            //calls a process checks method for checking method
            String InputCheckNumber = JOptionPane.showInputDialog(null,"Please input the check #:");
            int CheckNumber = Integer.parseInt(InputCheckNumber);  
            String InputCheck = JOptionPane.showInputDialog(null,"Please input the process check amount:");        
            float ProcessCheck = Integer.parseInt(InputCheck);        
            
            if(ProcessCheck>MyBank.get(AccountNumber).value)
            {
                JOptionPane.showMessageDialog(null,"Not enough funds");           
            }
            else            
            {                          
                MyBank.get(AccountNumber).ProcessCheck(ProcessCheck);
            }
            
        }
    }
    
    
    
}
