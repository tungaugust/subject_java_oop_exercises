package main.module_two;
public class Student {
    private long code;
    private String fullName;
    private double theoryMark;
    private double experimentMark;

    public Student() {
        this.code = 999999;
        this.fullName = "Unidentified Student";
        this.theoryMark = 0.0;
        this.experimentMark = 0.0;
    }

    public Student(long code, String fullName, double theoryMark, double experimentMark) {
        setCode(code);
        setFullName(fullName);
        setTheoryMark(theoryMark);
        setExperimentMark(experimentMark);
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.equals("")) {
            fullName = "Unidentified Name";
        }
        this.fullName = fullName;
    }

    public double getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(double theoryMark) {
        if (theoryMark <= 0 || theoryMark > 10.0) {
            theoryMark = 0.0;
        }
        this.theoryMark = theoryMark;
    }

    public double getExperimentMark() {
        return experimentMark;
    }

    public void setExperimentMark(double experimentMark) {
        if (experimentMark <= 0 || experimentMark > 10.0) {
            experimentMark = 0.0;
        }
        this.experimentMark = experimentMark;
    }

    public double averageScore() {
        return (getTheoryMark() + getExperimentMark()) / 2.0;
    }

    @Override
    public String toString() {
        String record = String.format("%-10s %-30s %20.2f %20.2f %20.2f"
                , getCode()
                , getFullName()
                , getTheoryMark()
                , getExperimentMark()
                , averageScore()
        );
        return record;
    }
}
