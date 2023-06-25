package main.module_two;
public class Triangle {
    public final static String REGULAR_TRIANGLE = "thuong";
    public final static String ISOSCELES_TRIANGLE = "can";
    public final static String EQUILATERAL_TRIANGLE = "deu";
    public final static String NOT_TRIANGLE = "khong";
    private double ma;
    private double mb;
    private double mc;

    public Triangle() {
        this.ma = 0.0;
        this.mb = 0.0;
        this.mc = 0.0;
    }

    public Triangle(double ma, double mb, double mc) {
        if (isNotValid(ma, mb, mc)) {
            ma = 0.0;
            mb = 0.0;
            mc = 0.0;
        }
        setMa(ma);
        setMb(mb);
        setMc(mc);
    }

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        if (ma > 0.0) {
            this.ma = ma;
        }
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        if (mb > 0.0) {
            this.mb = mb;
        }
    }

    public double getMc() {
        return mc;
    }

    public void setMc(double mc) {
        if (mc > 0.0) {
            this.mc = mc;
        }
    }

    private boolean isNotValid(double ma, double mb, double mc) {
        if (ma <= 0.0 || mb <= 0.0 || mc <= 0.0) {
            return true;
        }
        return false;
    }

    public double perimeter() {
        double perimeter = 0.0;
        if (type().equals(NOT_TRIANGLE)) {
            return perimeter;
        }
        perimeter = getMa() + getMb() + getMc();
        return perimeter;
    }

    public double surfaceArea() {
        double surfaceArea = 0.0;
        if (type().equals(NOT_TRIANGLE)) {
            return surfaceArea;
        }
        double p = (getMa() + getMb() + getMc()) / 2;
        surfaceArea = Math.sqrt(p * (p - getMa()) * (p - getMb()) * (p - getMc()));
        return surfaceArea;
    }

    private boolean isNotTriangle() {
        boolean isNotTriangle = isNotValid(getMa(), getMb(), getMc());
        if (isNotTriangle) {
            return true;
        }
        return false;
    }

    private boolean isEquilateralTriangle() {
        boolean isEquilateralTriangle = getMa() == getMb() && getMb() == getMc();
        if (isEquilateralTriangle) {
            return true;
        }
        return false;
    }

    private boolean isIsoscelesTriangle() {
        if (!isEquilateralTriangle()) {
            boolean isIsoscelesTriangle = getMa() == getMb() || getMb() == getMc() || getMc() == getMa();
            if (isIsoscelesTriangle) {
                return true;
            }
        }
        return false;
    }

    public String type() {
        if (isNotTriangle()) {
            return NOT_TRIANGLE;
        } else if (isEquilateralTriangle()) {
            return EQUILATERAL_TRIANGLE;
        } else if (isIsoscelesTriangle()) {
            return ISOSCELES_TRIANGLE;
        }
        return REGULAR_TRIANGLE;
    }

    public static String headerLine(){
        return String.format("%10s %10s %10s %-20s %10s %10s"
                , "CANH A", "CANH B", "CANH C", "LOAI", "CHU VI", "DIEN TICH"
        );
    }

    @Override
    public String toString() {
        return String.format("%10.2f %10.2f %10.2f %-20s %10.2f %10.2f"
                , getMa()
                , getMb()
                , getMc()
                , type()
                , perimeter()
                , surfaceArea()
        );
    }
}
