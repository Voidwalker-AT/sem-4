interface Printable { 
    void print();
}

interface Scannable { 
    void scan(); 
}

// Implementing multiple interfaces to achieve multiple inheritance
class MultiFunctionPrinter implements Printable, Scannable {
    public void print() { 
        System.out.println("Printing document...");
    }
    public void scan() { 
        System.out.println("Scanning document..."); 
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print();
        mfp.scan();
    }
}