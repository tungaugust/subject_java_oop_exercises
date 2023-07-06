package main.module_three;

public abstract class Person {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, String address) {
        this.setName(name);
        this.setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                '}';
    }
}
