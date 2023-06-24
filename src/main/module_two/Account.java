package main.module_two;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private final static long ACCOUNT_NUMBER = 999999;
    private final static String NAME = "Chua xac dinh";
    private final static double BALANCE = 50000.0;
    private final static double FEE = 1000.0;
    private final double RATE = 0.035;
    //    - accountNumber : long
//- name : String
//- balance : double
//- RATE = 0.035 : final double
    private long accountNumber;
    private String name;
    private double balance;

    public Account() {
        setAccountNumber(ACCOUNT_NUMBER);
        setName(NAME);
        setBalance(BALANCE);
    }

    public Account(long accountNumber, String name) {
        setAccountNumber(accountNumber);
        setName(name);
    }

    public Account(long accountNumber, String name, double balance) {
        this(accountNumber, name);
        setBalance(currencyConvertor(balance));
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(long accountNumber) {
        if (accountNumber <= 0) {
            accountNumber = ACCOUNT_NUMBER;
        }
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.equals("")) {
            name = NAME;
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        if (balance < BALANCE) {
            balance = BALANCE;
        }
        this.balance = balance;
    }

    private double currencyConvertor(double currency) {
        return currency * 1000;
    }

    public boolean deposit(double amount) {
        amount = currencyConvertor(amount);
        if (amount > 0.0) {
            setBalance(amount + getBalance());
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, double fee) {
        amount = currencyConvertor(amount);
        fee = currencyConvertor(fee);
        double withdrawMoney = amount + fee;
        if (amount > 0.0 && withdrawMoney <= getBalance()) {
            setBalance(getBalance() - withdrawMoney);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        double fee = FEE;
        amount = currencyConvertor(amount);
        double withdrawMoney = amount + fee;
        if (amount > 0.0 && withdrawMoney <= getBalance()) {
            setBalance(getBalance() - withdrawMoney);
            return true;
        }
        return false;
    }

    public double addInterest() {
        return getBalance() + getBalance() * this.RATE;
    }

    public boolean transfer(Account otherAccount, double amount) {
        amount = currencyConvertor(amount);
        if (amount > 0 && withdraw(amount)) {
            if (otherAccount.deposit(amount)) {
                return true;
            }
            deposit(amount + FEE);
        }
        return false;
    }


    @Override
    public String toString() {
        Locale local = new Locale("vi", "vn");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
        String balance = formatter.format(getBalance());
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", RATE=" + RATE +
                '}';
    }
}
