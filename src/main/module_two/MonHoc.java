package main.module_two;
public class MonHoc {
    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) throws RuntimeException {
        if (name.equals("")){
            throw new RuntimeException("Name is not allowed that is the empty string.");
        }
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score > 10 && score < 0){
            score = 0.0;
        }
        this.score = score;
    }

    public MonHoc(String name) {
        setName(name);
        this.score = 0.0;
    }
    public MonHoc(String name, double score) {
        this(name);
        setScore(score);
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
