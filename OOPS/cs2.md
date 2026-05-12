# Java Complete Syntax Cheat Sheet

> Highly Condensed Code-Only Reference

---

# 1. Java Basics

## Main Method

```java
class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
    }
}
```

---

## Scanner Input

```java
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String str = s.next();

        System.out.println(n + " " + str);
    }
}
```

---

## 1D Array

```java
class Main
{
    public static void main(String[] args)
    {
        int[] a = {1,2,3};

        for(int x : a)
        {
            System.out.println(x);
        }
    }
}
```

---

## 2D Array

```java
class Main
{
    public static void main(String[] args)
    {
        int[][] a =
        {
            {1,2},
            {3,4}
        };

        System.out.println(a[1][0]);
    }
}
```

---

## String Methods

```java
class Main
{
    public static void main(String[] args)
    {
        String s = "Java";

        System.out.println(s.length());
        System.out.println(s.toUpperCase());
        System.out.println(s.charAt(1));
        System.out.println(s.substring(1,3));
    }
}
```

---

# 2. OOP Fundamentals

## Class & Object

```java
class A
{
    void show()
    {
        System.out.println("Hello");
    }
}

class Main
{
    public static void main(String[] args)
    {
        A o = new A();

        o.show();
    }
}
```

---

## Parameterized Constructor

```java
class A
{
    int x;

    A(int x)
    {
        this.x = x;
    }
}

class Main
{
    public static void main(String[] args)
    {
        A o = new A(10);

        System.out.println(o.x);
    }
}
```

---

## Static Members

```java
class A
{
    static int x = 10;

    static void show()
    {
        System.out.println(x);
    }
}

class Main
{
    public static void main(String[] args)
    {
        A.show();
    }
}
```

---

## Method Overloading

```java
class A
{
    void add(int a,int b)
    {
        System.out.println(a + b);
    }

    void add(double a,double b)
    {
        System.out.println(a + b);
    }
}
```

---

## Method Overriding

```java
class A
{
    void show()
    {
        System.out.println("A");
    }
}

class B extends A
{
    void show()
    {
        System.out.println("B");
    }
}
```

---

# 3. Inheritance & Abstraction

## extends Keyword

```java
class A
{
    void show()
    {
        System.out.println("A");
    }
}

class B extends A
{

}
```

---

## super Keyword

```java
class A
{
    A()
    {
        System.out.println("A");
    }
}

class B extends A
{
    B()
    {
        super();
        System.out.println("B");
    }
}
```

---

## Abstract Class

```java
abstract class A
{
    abstract void show();
}

class B extends A
{
    void show()
    {
        System.out.println("Hello");
    }
}
```

---

## Interface

```java
interface A
{
    void show();
}

class B implements A
{
    public void show()
    {
        System.out.println("Hello");
    }
}
```

---

# 4. Nested Classes

## Static Nested Class

```java
class Outer
{
    static class Inner
    {
        void show()
        {
            System.out.println("Inner");
        }
    }
}
```

---

## Member Inner Class

```java
class Outer
{
    class Inner
    {
        void show()
        {
            System.out.println("Inner");
        }
    }
}
```

---

## Local Inner Class

```java
class A
{
    void test()
    {
        class B
        {
            void show()
            {
                System.out.println("Local");
            }
        }

        B o = new B();

        o.show();
    }
}
```

---

## Anonymous Inner Class

```java
abstract class A
{
    abstract void show();
}

class Main
{
    public static void main(String[] args)
    {
        A o = new A()
        {
            void show()
            {
                System.out.println("Anonymous");
            }
        };

        o.show();
    }
}
```

---

# 5. Exception Handling

## try-catch-finally

```java
class Main
{
    public static void main(String[] args)
    {
        try
        {
            int x = 10 / 0;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Done");
        }
    }
}
```

---

## throw Keyword

```java
class Main
{
    public static void main(String[] args)
    {
        throw new ArithmeticException("Error");
    }
}
```

---

## throws Keyword

```java
class A
{
    void test() throws Exception
    {
        throw new Exception();
    }
}
```

---

## Custom Exception

```java
class MyEx extends Exception
{
    MyEx(String s)
    {
        super(s);
    }
}
```

---

# 6. Multithreading

## extends Thread

```java
class A extends Thread
{
    public void run()
    {
        System.out.println("Thread");
    }
}

class Main
{
    public static void main(String[] args)
    {
        A t = new A();

        t.start();
    }
}
```

---

## implements Runnable

```java
class A implements Runnable
{
    public void run()
    {
        System.out.println("Run");
    }
}

class Main
{
    public static void main(String[] args)
    {
        Thread t = new Thread(new A());

        t.start();
    }
}
```

---

## sleep()

```java
class Main
{
    public static void main(String[] args) throws Exception
    {
        Thread.sleep(1000);

        System.out.println("Done");
    }
}
```

---

## join()

```java
class A extends Thread
{
    public void run()
    {
        System.out.println("Run");
    }
}

class Main
{
    public static void main(String[] args) throws Exception
    {
        A t = new A();

        t.start();

        t.join();

        System.out.println("End");
    }
}
```

---

## Daemon Thread

```java
class A extends Thread
{
    public void run()
    {
        System.out.println(isDaemon());
    }
}

class Main
{
    public static void main(String[] args)
    {
        A t = new A();

        t.setDaemon(true);

        t.start();
    }
}
```

---

## synchronized Method

```java
class A
{
    synchronized void show()
    {
        System.out.println("Sync");
    }
}
```

---

## synchronized Block

```java
class A
{
    void show()
    {
        synchronized(this)
        {
            System.out.println("Block");
        }
    }
}
```

---

# 7. File Handling

## File Class

```java
import java.io.File;

class Main
{
    public static void main(String[] args)
    {
        File f = new File("a.txt");

        System.out.println(f.exists());
    }
}
```

---

## FileWriter (Append Mode)

```java
import java.io.FileWriter;

class Main
{
    public static void main(String[] args) throws Exception
    {
        FileWriter fw = new FileWriter("a.txt",true);

        fw.write("Hello");

        fw.close();
    }
}
```

---

## FileReader

```java
import java.io.FileReader;

class Main
{
    public static void main(String[] args) throws Exception
    {
        FileReader fr = new FileReader("a.txt");

        int x;

        while((x = fr.read()) != -1)
        {
            System.out.print((char)x);
        }

        fr.close();
    }
}
```

---

# 8. Generics

## Generic Class

```java
class Box<T>
{
    T x;

    void set(T x)
    {
        this.x = x;
    }

    T get()
    {
        return x;
    }
}
```

---

## Bounded Type

```java
class A<T extends Number>
{
    T x;

    A(T x)
    {
        this.x = x;
    }
}
```

---

## Wildcards

```java
import java.util.*;

class Main
{
    static void show(List<?> l)
    {
        System.out.println(l);
    }
}
```

---

# 9. Lambdas & Functional Interfaces

## Functional Interface

```java
@FunctionalInterface
interface A
{
    void show();
}
```

---

## Lambda Expression

```java
interface A
{
    void add(int a,int b);
}

class Main
{
    public static void main(String[] args)
    {
        A o = (a,b) ->
        {
            System.out.println(a + b);
        };

        o.add(10,20);
    }
}
```

---

# 10. Java Swing (GUI)

## JFrame & Components

```java
import javax.swing.*;

class Main
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();

        JButton b = new JButton("Click");

        JTextField t = new JTextField();

        f.setLayout(null);

        b.setBounds(50,50,100,30);

        t.setBounds(50,100,100,30);

        f.add(b);

        f.add(t);

        f.setSize(300,300);

        f.setVisible(true);
    }
}
```

---

## addActionListener()

```java
import javax.swing.*;
import java.awt.event.*;

class Main
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();

        JButton b = new JButton("Click");

        b.setBounds(50,50,100,30);

        b.addActionListener(e ->
        {
            System.out.println("Pressed");
        });

        f.add(b);

        f.setLayout(null);

        f.setSize(300,300);

        f.setVisible(true);
    }
}
```

---

# 11. JDBC

## Database Connection

```java
import java.sql.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Connection con =
        DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/db",
        "root",
        "1234"
        );
    }
}
```

---

## PreparedStatement

```java
import java.sql.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Connection con = null;

        String q = "insert into emp values(?,?)";

        PreparedStatement ps =
        con.prepareStatement(q);

        ps.setInt(1,1);

        ps.setString(2,"A");

        ps.executeUpdate();
    }
}
```

---

## ResultSet Iteration

```java
import java.sql.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Connection con = null;

        Statement st = con.createStatement();

        ResultSet rs =
        st.executeQuery("select * from emp");

        while(rs.next())
        {
            System.out.println(rs.getInt(1));
        }
    }
}
```

---

# 12. Collections & Wrappers

## Autoboxing

```java
class Main
{
    public static void main(String[] args)
    {
        Integer x = 10;

        int y = x;

        System.out.println(y);
    }
}
```

---

## ArrayList

```java
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> a =
        new ArrayList<String>();

        a.add("Java");

        System.out.println(a);
    }
}
```

---

## HashSet

```java
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        HashSet<Integer> h =
        new HashSet<Integer>();

        h.add(10);

        System.out.println(h);
    }
}
```

---

## HashMap

```java
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> h =
        new HashMap<Integer,String>();

        h.put(1,"Java");

        System.out.println(h);
    }
}
```

---

## Iterator Traversal

```java
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> a =
        new ArrayList<Integer>();

        a.add(10);

        Iterator<Integer> i =
        a.iterator();

        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
```

---

# End