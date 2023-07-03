package main.module_three;

public abstract class Product {
    private String code;
    private String name;
    private double price;
    private int storedQuantity;

    protected static final String SLOW_SALE = "ban cham";
    protected static final String GOOD_SALE = "ban duoc";
    protected static final String DIFF_SALE = "kho ban";
    protected static final String NO_RATING = "khong danh gia";

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        if(code.equals("")){
            throw new RuntimeException("Ma hang khong hop le.");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(code.equals("")){
            code = "xxx";
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            price = 0;
        }
        this.price = price;
    }

    public int getStoredQuantity() {
        return storedQuantity;
    }

    public void setStoredQuantity(int storedQuantity) {
        if (storedQuantity < 0) {
            storedQuantity = 0;
        }
        this.storedQuantity = storedQuantity;
    }

    public Product(String code, String name, double price, int storedQuantity) {
        setCode(code);
        setName(name);
        setPrice(price);
        setStoredQuantity(storedQuantity);
    }

    public abstract double vatTax();

    public abstract String salesRating();
}
