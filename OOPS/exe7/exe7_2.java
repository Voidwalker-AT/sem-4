import java.util.*;
class BankCustomer
{
    String customerName;
    int accountBalances[]=new int[5];
    BankCustomer(String customerName)
    {
        this.customerName=customerName;
        for(int i=0;i<5;i++)
        {
            accountBalances[i]=0;
        }
    }
    BankCustomer(String customerName,int[] inputBalances)
    {
        this.customerName=customerName;
        for(int i=0;i<5;i++)
        {
            if(i<inputBalances.length)
            {
                accountBalances[i]=inputBalances[i];
            }
            else
            {
                accountBalances[i]=0;
            }
        }
    }
    String getCustomerName()
    {
        return customerName;
    }
    int[] getAccountBalances()
    {
        return accountBalances;
    }
    void addAccountBalance(int accIndex,int amount)
    {
        if(accIndex<0||accIndex>=accountBalances.length)
        {
            throw new ArrayIndexOutOfBoundsException("Account "+(accIndex+1)+" does not exist.");
        }
        if(amount<0)
        {
            throw new IllegalArgumentException("Balance cannot be negative: "+amount);
        }
        accountBalances[accIndex]+=amount;
    }
    void withdrawFromAccount(int accIndex,int amount)
    {
        if(accIndex<0||accIndex>=accountBalances.length)
        {
            throw new IllegalArgumentException("Account "+(accIndex+1)+" does not exist.");
        }
        if(amount<=0)
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if(amount>accountBalances[accIndex])
        {
            throw new IllegalArgumentException(
                "Account "+(accIndex+1)+" has only Rs."+accountBalances[accIndex]+". Cannot withdraw Rs."+amount+"."
            );
        }
        accountBalances[accIndex]-=amount;
    }
    void displayAccountBalances()
    {
        System.out.println("--- Customer: "+customerName+" ---");
        for(int i=0;i<accountBalances.length;i++)
        {
            System.out.println("Account "+(i+1)+": Rs."+accountBalances[i]);
        }
    }
}
public class exe7_2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BankCustomer customer=null;
        try
        {
            System.out.print("Enter customer name: ");
            String name=sc.nextLine();
            String ans="";
            while(true)
            {
                System.out.print("Do you have initial balances to enter? (yes/no): ");
                ans=sc.nextLine().trim().toLowerCase();
                if(ans.equals("yes")||ans.equals("no"))
                {
                    break;
                }
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
            if(ans.equals("yes"))
            {
                int n=0;
                while(true)
                {
                    try
                    {
                        System.out.print("How many initial balances? (max 5): ");
                        n=sc.nextInt();
                        if(n<1||n>5)
                        {
                            System.out.println("Invalid. Enter a number between 1 and 5.");
                            continue;
                        }
                        break;
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.nextLine();
                    }
                }
                int[] initBal=new int[n];
                for(int i=0;i<n;i++)
                {
                    while(true)
                    {
                        try
                        {
                            System.out.print("Enter balance for Account "+(i+1)+": ");
                            int b=sc.nextInt();
                            if(b<0)
                            {
                                System.out.println("Balance cannot be negative. Try again.");
                                continue;
                            }
                            initBal[i]=b;
                            break;
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input. Please enter a number.");
                            sc.nextLine();
                        }
                    }
                }
                customer=new BankCustomer(name,initBal);
                System.out.println("Customer created with initial balances.");
            }
            else
            {
                customer=new BankCustomer(name);
                System.out.println("Customer created with empty accounts.");
            }
            customer.displayAccountBalances();
        }
        catch(Exception e)
        {
            System.out.println("Unexpected error during setup: "+e.getMessage());
            sc.close();
            return;
        }
        boolean running=true;
        while(running)
        {
            System.out.println("===== MENU =====");
            System.out.println("1. Add Balance");
            System.out.println("2. Display Balances");
            System.out.println("3. Withdraw");
            System.out.println("4. Account Summary");
            System.out.println("5. Exit");
            int choice=-1;
            while(true)
            {
                System.out.print("Choose option: ");
                try
                {
                    choice=sc.nextInt();
                    if(choice<1||choice>5)
                    {
                        System.out.println("Invalid option. Please choose 1-5.");
                        continue;
                    }
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine();
                }
            }
            try
            {
                switch(choice)
                {
                    case 1:
                    {
                        customer.displayAccountBalances();
                        int accNo=-1;
                        while(true)
                        {
                            try
                            {
                                System.out.print("Enter account number to deposit into (1-5): ");
                                accNo=sc.nextInt();
                                if(accNo<1||accNo>5)
                                {
                                    System.out.println("Invalid. Enter account number between 1 and 5.");
                                    continue;
                                }
                                break;
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.nextLine();
                            }
                        }
                        int bal=-1;
                        while(true)
                        {
                            try
                            {
                                System.out.print("Enter amount to deposit: ");
                                bal=sc.nextInt();
                                if(bal<0)
                                {
                                    System.out.println("Amount cannot be negative. Try again.");
                                    continue;
                                }
                                break;
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.nextLine();
                            }
                        }
                        customer.addAccountBalance(accNo-1,bal);
                        System.out.println("Rs."+bal+" deposited into Account "+accNo+" successfully.");
                        break;
                    }
                    case 2:
                    {
                        customer.displayAccountBalances();
                        break;
                    }
                    case 3:
                    {
                        customer.displayAccountBalances();
                        System.out.println("Withdraw from:");
                        System.out.println("  1. Single account");
                        System.out.println("  2. Multiple accounts");
                        int wChoice=-1;
                        while(true)
                        {
                            try
                            {
                                System.out.print("Choose: ");
                                wChoice=sc.nextInt();
                                if(wChoice<1||wChoice>2)
                                {
                                    System.out.println("Invalid. Enter 1 or 2.");
                                    continue;
                                }
                                break;
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Invalid input. Please enter a number.");
                                sc.nextLine();
                            }
                        }
                        if(wChoice==1)
                        {
                            int accNo=-1;
                            while(true)
                            {
                                try
                                {
                                    System.out.print("Enter account number (1-5): ");
                                    accNo=sc.nextInt();
                                    if(accNo<1||accNo>5)
                                    {
                                        System.out.println("Invalid. Enter account number between 1 and 5.");
                                        continue;
                                    }
                                    break;
                                }
                                catch(InputMismatchException e)
                                {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.nextLine();
                                }
                            }
                            int amt=-1;
                            while(true)
                            {
                                try
                                {
                                    System.out.print("Enter amount to withdraw: ");
                                    amt=sc.nextInt();
                                    if(amt<=0)
                                    {
                                        System.out.println("Amount must be positive. Try again.");
                                        continue;
                                    }
                                    break;
                                }
                                catch(InputMismatchException e)
                                {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.nextLine();
                                }
                            }
                            customer.withdrawFromAccount(accNo-1,amt);
                            System.out.println("Withdrawn Rs."+amt+" from Account "+accNo+" successfully.");
                        }
                        else
                        {
                            sc.nextLine();
                            System.out.print("Enter account numbers to withdraw from (e.g. 3,4): ");
                            String input=sc.nextLine().trim();
                            String[] parts=input.split(",");
                            int totalAmt=-1;
                            while(true)
                            {
                                try
                                {
                                    System.out.print("Enter total amount to withdraw: ");
                                    totalAmt=sc.nextInt();
                                    if(totalAmt<=0)
                                    {
                                        System.out.println("Amount must be positive. Try again.");
                                        continue;
                                    }
                                    break;
                                }
                                catch(InputMismatchException e)
                                {
                                    System.out.println("Invalid input. Please enter a number.");
                                    sc.nextLine();
                                }
                            }
                            int remaining=totalAmt;
                            for(int i=0;i<parts.length&&remaining>0;i++)
                            {
                                int accNo=Integer.parseInt(parts[i].trim());
                                if(accNo<1||accNo>5)
                                {
                                    System.out.println("Skipping invalid account: "+accNo);
                                    continue;
                                }
                                int accIdx=accNo-1;
                                int available=customer.accountBalances[accIdx];
                                if(available<=0)
                                {
                                    System.out.println("Account "+accNo+" is empty. Skipping.");
                                    continue;
                                }
                                int deduct=Math.min(available,remaining);
                                customer.accountBalances[accIdx]-=deduct;
                                remaining-=deduct;
                                System.out.println("Withdrew Rs."+deduct+" from Account "+accNo+
                                    ". Remaining: Rs."+remaining);
                            }
                            if(remaining>0)
                            {
                                System.out.println("Could only withdraw Rs."+(totalAmt-remaining)+
                                    " of Rs."+totalAmt+". Insufficient balance in selected accounts.");
                            }
                            else
                            {
                                System.out.println("Total Rs."+totalAmt+" withdrawn successfully.");
                            }
                        }
                        break;
                    }
                    case 4:
                    {
                        int[] balances=customer.getAccountBalances();
                        String name=customer.getCustomerName();
                        int total=0;
                        int count=0;
                        for(int i=0;i<balances.length;i++)
                        {
                            if(balances[i]>0)
                            {
                                total+=balances[i];
                                count++;
                            }
                        }
                        System.out.println("====== ACCOUNT SUMMARY ======");
                        System.out.println("Customer Name  : "+name);
                        if(count>0)
                        {
                            double avg=(double)total/count;
                            System.out.println("Active Accounts: "+count);
                            System.out.println("Total Balance  : Rs."+total);
                            System.out.printf ("Average Balance: Rs.%.2f%n",avg);
                        }
                        else
                        {
                            System.out.println("No active accounts (all balances are 0).");
                        }
                        break;
                    }
                    case 5:
                    {
                        running=false;
                        System.out.println("Goodbye");
                        break;
                    }
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Unexpected error: "+e.getMessage());
            }
        }
        sc.close();
    }
}
//Observations:
//1. The BankCustomer class encapsulates customer data and operations on accounts, demonstrating OOP principles.
//2. The main method provides a user-friendly menu-driven interface for interacting with the BankCustomer object.
//3. Robust error handling is implemented to manage invalid inputs and operations gracefully.
//4. The program allows for both single and multiple account withdrawals, showcasing flexibility in design.
//5. The account summary feature provides insights into the customer's financial status, enhancing usability.
//6. The program gracefully handles exceptions and provides clear error messages, ensuring a smooth user experience.
//7. The use of arrays to manage multiple accounts demonstrates basic data structure usage in OOP.
//8. Overall, the program effectively demonstrates encapsulation, error handling, and user interaction in a banking context.