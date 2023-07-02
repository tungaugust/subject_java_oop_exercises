package main.module_three;

public class Savings extends Account{
    private double interestRate; // ti le lai suat theo nam
    private double interestAmount = 0.0; // tien lai

    public double getInterestRate() {
        return this.interestRate;
    }

    public double getInterestAmount() {
        this.interestAmount = calculateInterest();
        return this.interestAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    private double calculateInterest(){
        return this.getBalance() * this.getInterestRate();
    }

    public void addInterestToBalance(){
        this.deposit(this.getInterestAmount());
    }
}
