package main.module_two;
import java.util.ArrayList;

public class HocVien {

    private String name;
    private int birthYear;
    private ArrayList<MonHoc> subjectList;
    private static ArrayList<String> SUBJECT_NAME_LIST;
    public String getName() {
        return name;
    }

    public void setName(String name) throws RuntimeException {
        if (name.equals("")){
            throw new RuntimeException("Name is not allowed that is the empty string.");
        }
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    private ArrayList<MonHoc> getSubjectList() {
        return subjectList;
    }

    public void setBirthYear(int birthYear) throws RuntimeException {
        if (birthYear < 0) {
            throw new RuntimeException("The birth year is not allowed that is the negative number.");
        }
        this.birthYear = birthYear;
    }
    private void createSubject(){
        this.SUBJECT_NAME_LIST = new ArrayList<String>();
        this.SUBJECT_NAME_LIST.add("Subject A");
        this.SUBJECT_NAME_LIST.add("Subject B");
        this.SUBJECT_NAME_LIST.add("Subject C");
        this.SUBJECT_NAME_LIST.add("Subject D");
        this.SUBJECT_NAME_LIST.add("Subject E");
    }
    private void setSubjectList(){
        createSubject();
        this.subjectList = new ArrayList<MonHoc>();
        for (String subject: this.SUBJECT_NAME_LIST){
            this.subjectList.add(new MonHoc(subject));
        }
    }
    private void setSubjectList(double... scores){
        createSubject();
        this.subjectList = new ArrayList<MonHoc>();
        int scoreSize = scores.length;
        int subjectSize = this.SUBJECT_NAME_LIST.size();
        if (scoreSize >= subjectSize){
            for (int i = 0; i < subjectSize; i++){
                this.subjectList.add(new MonHoc(this.SUBJECT_NAME_LIST.get(i), scores[i]));
            }
        }
        else {
            for (int i = 0; i < subjectSize; i++){
                if (scoreSize >= i){
                    this.subjectList.add(new MonHoc(this.SUBJECT_NAME_LIST.get(i), scores[i]));
                }
                this.subjectList.add(new MonHoc(this.SUBJECT_NAME_LIST.get(i)));
            }
        }
    }

    public HocVien(String name, int birthYear) {
        setName(name);
        setBirthYear(birthYear);
        setSubjectList();
    }
    public HocVien(String name, int birthYear, double... scores) {
        this(name,birthYear);
        setSubjectList(scores);
    }

    public double averageScore(){
        double score = 0.0;
        for (MonHoc mon: getSubjectList()){
            score += mon.getScore();
        }
        return score / getSubjectList().size();
    }
    private boolean isNotAchieved(){
        for (MonHoc mon: getSubjectList()){
            if (mon.getScore() < 5.0){
                return true;
            }
        }
        return false;
    }
    public String status(){
        String status = "Thi tot nghiep";
        if (isNotAchieved()){
            status = "Thi lai";
        }
        if (averageScore() > 7){
            status = "Lam luan van";
        }
        return status;
    }

    @Override
    public String toString() {
        return "HocVien{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", subjectCount=" + getSubjectList().size() +
                ", averageScore=" + averageScore() +
                ", status=" + status() +
                '}';
    }
}
