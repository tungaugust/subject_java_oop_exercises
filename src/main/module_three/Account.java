package main.module_three;

public class Account {
    private double balance = 0; // so du

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount){
        if (getBalance() >= amount){
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
    public void deposit(double amount) {
        setBalance(amount + getBalance());
    }

}
