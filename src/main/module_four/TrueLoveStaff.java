package main.module_four;

import java.util.Objects;

public class TrueLoveStaff {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        if (code.equals("")){
            code = "SXXX";
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")){
            name = "True Love Staff";
        }
        this.name = name;
    }

    public TrueLoveStaff(String code, String name) {
        setCode(code);
        setName(name);
    }

    @Override
    public boolean equals(Object o) {
        // Doi tuong so sanh voi chinh no
        if (this == o) return true;
        // Doi tuong co cung lop hay khong va co NULL hay khong
        if (o == null || getClass() != o.getClass()) return false;
        // Typecast doi tuong
        TrueLoveStaff that = (TrueLoveStaff) o;
        return Objects.equals(this.code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
