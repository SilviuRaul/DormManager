package ro.siit.dormmanager.service;

import ro.siit.dormmanager.model.CivilStatus;
import ro.siit.dormmanager.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static StudentService instance;

    private Connection connection;

    private StudentService() {
    }

    @Override
    protected void finalize() throws Throwable{
        getConnection().close();
    }

    public static StudentService getInstance(){
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    private Connection getConnection() {
        if (connection == null){
            String connectionString = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
                Class.forName("org.postgresql.Driver").newInstance();
                connection = DriverManager.getConnection(connectionString);
            } catch (final InstantiationException e) {
                e.printStackTrace();
            } catch (final IllegalAccessException e){
                e.printStackTrace();
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            } catch (final SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    public List<Student> getStudents() {
        List<Student> outcome = new ArrayList<>();

        ResultSet rs = null;

        try {
            Statement statement = getConnection().createStatement();
            rs = statement.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                Student student = new Student();
                student.setAdmissionMean(rs.getDouble("admissionMean"));
                student.setAge(rs.getInt("age"));
                student.setCnp(rs.getString("cnp"));
                student.setDormRef(rs.getInt("dormRef"));
                student.setFaculty(rs.getString("faculty"));
                student.setName(rs.getString("name"));
                student.setStudentId(rs.getInt("studentId"));
                student.setCivilStatus(CivilStatus.valueOf( rs.getString("civilStatus") ) );
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setCurrentYear(rs.getInt("currentYear"));

                outcome.add(student);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return outcome;
    }

    public Integer getStudentCountForDorm(Integer dormRef) {
        Integer count = 0;
        ResultSet rs = null;

        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT COUNT(*) FROM student WHERE \"dormRef\" = ?");
            statement.setInt(1, dormRef);

            rs = statement.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return count;
    }

    public void addStudent(Student student){
        try {
            PreparedStatement statement = getConnection().prepareStatement(
                    "INSERT INTO student (name, \"currentYear\", \"civilStatus\", email, gender, \"phoneNumber\", faculty, \"dormRef\", cnp, age, \"admissionMean\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, student.getName());
            statement.setInt(2, student.getCurrentYear());
            statement.setString(3, student.getCivilStatus().toString());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getPhoneNumber());
            statement.setString(7, student.getFaculty());
            statement.setInt(8, student.getDormRef());
            statement.setString(9, student.getCnp());
            statement.setInt(10,student.getAge());
            statement.setDouble(11,student.getAdmissionMean());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student){
        try {
            PreparedStatement statement = getConnection().prepareStatement(
                    "UPDATE student SET name = ?, \"civilStatus\" = ?, email = ?, gender = ?, \"phoneNumber\" = ?, faculty = ?, \"dormRef\" = ?, cnp = ?, age = ?, \"admissionMean\" = ?, \"currentYear\" = ? WHERE \"studentId\" = ?"
            );
            statement.setString(1, student.getName());
            statement.setString(2, student.getCivilStatus().toString());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getPhoneNumber());
            statement.setString(6, student.getFaculty());
            statement.setInt   (7, student.getDormRef());
            statement.setString(8, student.getCnp());
            statement.setInt   (9, student.getAge());
            statement.setDouble(10,student.getAdmissionMean());
            statement.setInt   (11,student.getCurrentYear());
            statement.setInt   (12,student.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(Integer StudentId) {

        ResultSet rs = null;

        try {
            PreparedStatement statement  = getConnection().prepareStatement("SELECT * FROM student WHERE \"studentId\" = ?");
            statement.setInt(1, StudentId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setAdmissionMean(rs.getDouble("admissionMean"));
                student.setAge(rs.getInt("age"));
                student.setCnp(rs.getString("cnp"));
                student.setDormRef(rs.getInt("dormRef"));
                student.setFaculty(rs.getString("faculty"));
                student.setName(rs.getString("name"));
                student.setStudentId(rs.getInt("studentId"));
                student.setCivilStatus(CivilStatus.valueOf( rs.getString("civilStatus") ) );
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setCurrentYear(rs.getInt("currentYear"));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteStudent(Integer studentId) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM student WHERE \"studentId\" = ?");
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


