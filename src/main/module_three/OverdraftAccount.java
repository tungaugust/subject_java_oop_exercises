package main.module_three;

public class OverdraftAccount extends Account {
    // Tai khoan thau chi (tai khoan tin dung)

    private double odLimit; // han muc tin dung
    private double overdraft; // so tien thau chi, tuc la vuot qua so du kha dung
    private double availableBalance; // so du kha dung

    public double getOdLimit() {
        return odLimit;
    }

    private void setOdLimit(double odLimit) {
        this.odLimit = odLimit;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    private void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }


}
