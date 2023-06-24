package main.module_two;

public class Worker {
    private long code;
    private String firstName;
    private String lastName;
    private int productCount;

    public Worker() {
        this.code = 999999;
        this.firstName = "Unidentified First Name";
        this.lastName = "Unidentified Last Name";
        this.productCount = 0;
    }

    public Worker(long code, String firstName, String lastName, int productCount) {
        setCode(code);
        setFirstName(firstName);
        setLastName(lastName);
        setProductCount(productCount);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        if (code <= 0) {
            code = 999999;
        }
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.equals("")) {
            firstName = "Unidentified First Name";
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.equals("")) {
            lastName = "Unidentified Last Name";
        }
        this.lastName = lastName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        if (productCount <= 0) {
            productCount = 0;
        }
        this.productCount = productCount;
    }

    public double salary() {
        double basic = 0.5;
        int products = getProductCount();
        if (products >= 600) {
            basic = 0.65;
        } else if (products >= 400 && products <= 599) {
            basic = 0.6;
        } else if (products >= 200 && products <= 399) {
            basic = 0.55;
        }
        double salary = products * basic;
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "code=" + code +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", productCount=" + productCount +
                String.format(", salary=%.2f", salary()) +
                '}';
    }
}
