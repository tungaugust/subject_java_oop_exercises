package main.module_three;

public class ProductManager {
    private Product[] products;
    private int capacity;
    private int size;

    public Product[] getProducts() {
        return this.products;
    }

    private void setProducts(Product[] products) {
        this.products = products;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }
    private void increaseSize(){
        setSize(getSize() + 1);
    }

    private void decreaseSize(){
        setSize(getSize() - 1);
    }

    public ProductManager(int capacity) {
        this.setCapacity(capacity);
        this.setSize(0);
        this.setProducts(new Product[this.getCapacity()]);
    }

    public boolean add(Product product){

        return false;
    }
}
