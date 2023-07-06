package main.module_three;

public class StudentNeo extends Person{
    private double firstSubjectScore;
    private double secondSubjectScore;

    public double getFirstSubjectScore() {
        return firstSubjectScore;
    }

    private void setFirstSubjectScore(double firstSubjectScore) {
        this.firstSubjectScore = firstSubjectScore;
    }

    public double getSecondSubjectScore() {
        return secondSubjectScore;
    }

    private void setSecondSubjectScore(double secondSubjectScore) {
        this.secondSubjectScore = secondSubjectScore;
    }

    public StudentNeo(String name, String address, double firstSubjectScore, double secondSubjectScore) {
        super(name, address);
        this.setFirstSubjectScore(firstSubjectScore);
        this.setSecondSubjectScore(secondSubjectScore);
    }

    public double averageScore(){
        return (this.getFirstSubjectScore() + this.getSecondSubjectScore()) / 2;
    }
    public String evaluate(){
        return "khong danh gia";
    }
    @Override
    public String toString() {
        return "StudentNeo{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", firstSubjectScore=" + this.getFirstSubjectScore() +
                ", secondSubjectScore=" + this.getSecondSubjectScore() +
                ", averageScore=" + this.averageScore() +
                ", evaluate=\"" + this.evaluate() + "\"" +
                '}';
    }
}
