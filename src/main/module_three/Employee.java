package main.module_three;

public class Employee extends Person {
    private double salaryCoefficient;
    private final double BASIC_SALARY = 1800000.0;
    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    private void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public Employee(String name, String address, double salaryCoefficient) {
        super(name, address);
        this.setSalaryCoefficient(salaryCoefficient);
    }
    public double computeSalary(){
        return BASIC_SALARY * this.getSalaryCoefficient();
    }
    public String evaluate(){
        return "khong danh gia";
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", alaryCoefficient=" + this.getSalaryCoefficient() +
                ", salary=" + this.computeSalary() +
                ", evaluate=\"" + this.evaluate() + '\"' +
                '}';
    }
}
