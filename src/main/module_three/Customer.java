package main.module_three;

public class Customer extends Person{
    private String company;
    private double invoiceValue;
    private String evaluate;

    public String getCompany() {
        return company;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    public double getInvoiceValue() {
        return invoiceValue;
    }

    private void setInvoiceValue(double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getEvaluate() {
        return evaluate;
    }

    private void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Customer(String name, String address, String company, double invoiceValue, String evaluate) {
        super(name, address);
        this.setCompany(company);
        this.setInvoiceValue(invoiceValue);
        this.setEvaluate(evaluate);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", company='" + this.getCompany() + '\'' +
                ", invoiceValue=" + this.getInvoiceValue() +
                ", evaluate=\"" + this.getEvaluate() + '\"' +
                '}';
    }
}
