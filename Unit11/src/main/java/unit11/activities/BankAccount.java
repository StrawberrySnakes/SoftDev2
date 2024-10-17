package unit11.activities;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    
public class BankAccount {
    private double balance;
    private final Lock lock;

    public BankAccount(double balance) {
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        from.lock.lock();
        try {
            to.lock.lock();
            try {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from " + from + " to " + to);
                } else {
                    System.out.println(Thread.currentThread().getName() + " tried to transfer " + amount + " but insufficient funds");
                }
            } finally {
                to.lock.unlock();
            }
        } finally {
            from.lock.unlock();
        }
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        // Create threads for deposit, withdrawal, and transfer
        Thread depositThread = new Thread(() -> {
            account1.deposit(500);
            account2.deposit(1000);
        });

        Thread withdrawThread = new Thread(() -> {
            account1.withdraw(200);
            account2.withdraw(300);
        });

        Thread transferThread = new Thread(() -> BankAccount.transfer(account1, account2, 300));

        // Start threads
        depositThread.start();
        withdrawThread.start();
        transferThread.start();

        try {
            // Wait for threads to finish
            depositThread.join();
            withdrawThread.join();
            transferThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balances
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}


