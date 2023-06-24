package main.module_two;

public class CD {
    private long code;
    private String title;
    private int songCount;
    private double price;

    public CD() {
        this.code = 999999;
        this.title = "Chua xac dinh";
        this.songCount = 0;
        this.price = 0.0;
    }

    public CD(long code, String title, int songCount, double price) {
        setCode(code);
        setTitle(title);
        setSongCount(songCount);
        setPrice(price);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals("")) {
            title = "Chua xac dinh";
        }
        this.title = title;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        if (songCount <= 0) {
            songCount = 0;
        }
        this.songCount = songCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0.0) {
            price = 0.0;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "CD{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", songCount=" + songCount +
                ", price=" + price +
                '}';
    }
}
