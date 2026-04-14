import java.util.*;
class BankAccount
{
    int accountno=0;
    double Balance=0;
    String accounttype;

    BankAccount(int a,double b,String c)
    {
        accountno=a;
        Balance=b;
        accounttype=c;
    }
    BankAccount(int a,String c)
    {
        accountno=a;
        accounttype=c;
    }
    void deposit(int a)
    {
        Balance+=a;
    }
    void withdraw(int a)
    {
        if(a>Balance)
        {
            System.out.println("Insufficient Balance");
        }
        else
        {
            Balance-=a;
        }
    }
    void deposit(int a,String r)
    {
        Balance+=a;
        System.out.println("Your balance after deposit is: "+Balance);
    }
    void withdraw(int a,String r)
    {
        if(a>Balance)
        {
            System.out.println("Insufficient Balance");
        }
        else
        {
            Balance-=a;
            System.out.println("Your balance after withdrawal is: "+Balance);
        }
    }
}
public class BA
{
    public static void main(String args[])
    {
        BankAccount ba;
        int a;
        double b;
        String c,r;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter account number:");
        a=sc.nextInt();
        System.out.println("Enter account type (savings/current):");
        c=sc.next();
        System.out.println("do you want to enter initial balance? (yes/no)");
        r=sc.next();
        if(r.equals("yes"))
        {
            System.out.println("Enter initial balance:");
            b=sc.nextDouble();
            ba=new BankAccount(a,b,c);
        }
        else
        {
            ba=new BankAccount(a,c);
        }
        System.out.println("Enter amount to deposit:");
        a=sc.nextInt();
        System.out.println("do you want to see balance after deposit? (yes/no)");
        r=sc.next();
        if(r.equals("yes"))
        {
            ba.deposit(a,r);
        }
        else
        {
            ba.deposit(a);
        }
        System.out.println("Enter amount to withdraw:");
        a=sc.nextInt();
        System.out.println("do you want to see balance after withdrawal? (yes/no)");
        r=sc.next();
        if(r.equals("yes"))
        {
            ba.withdraw(a,r);
        }
        else
        {
            ba.withdraw(a);
        }
    }
}