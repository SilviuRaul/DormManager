package ro.siit.dormmanager.model;

/**
 * Created by Raul on 11.10.2017.
 */
public class Student {

    private Integer studentId;
    private String name;
    private double admissionMean;
    private CivilStatus civilStatus;
    private String gender;
    private int age;
    private int currentYear;
    private String cnp;
    private String email;
    private String phoneNumber;
    private String faculty;
    private Integer dormRef;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAdmissionMean() {
        return admissionMean;
    }

    public void setAdmissionMean(double admissionMean) {
        this.admissionMean = admissionMean;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getDormRef() {
        return dormRef;
    }

    public void setDormRef(Integer dormRef) {
        this.dormRef = dormRef;
    }
}
