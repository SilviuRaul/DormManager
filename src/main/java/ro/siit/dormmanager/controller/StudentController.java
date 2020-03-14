package ro.siit.dormmanager.controller;

import ro.siit.dormmanager.model.CivilStatus;
import ro.siit.dormmanager.model.Dorm;
import ro.siit.dormmanager.model.Student;
import ro.siit.dormmanager.service.DormService;
import ro.siit.dormmanager.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/students"})
public class StudentController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String SHOW_FORM = "showForm";
    private static final String ADD = "add";
    private static final String EDIT = "edit";

    public static final String STUDENT_LIST = "studentList";

    private StudentService studentService;
    private DormService dormService;

    @Override
    public void init() throws ServletException {
        this.studentService = StudentService.getInstance();
        this.dormService = DormService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action == null) {
            action = LIST;
        }

        switch (action) {
            case LIST:
                list(req, resp);
                break;
            case SHOW_FORM:
                String studentId = req.getParameter("id");

                if (studentId != null) {
                    Student student = studentService.getStudent( Integer.parseInt(studentId) );

                    if (student != null) {
                        req.setAttribute("action", "edit");
                        req.setAttribute("studentId", studentId);
                        req.setAttribute("name", student.getName());
                        req.setAttribute("admissionMean", student.getAdmissionMean());
                        req.setAttribute("civilStatus", student.getCivilStatus());
                        req.setAttribute("gender", student.getGender());
                        req.setAttribute("age", student.getAge());
                        req.setAttribute("currentYear", student.getCurrentYear());
                        req.setAttribute("cnp", student.getCnp());
                        req.setAttribute("email", student.getEmail());
                        req.setAttribute("phoneNumber", student.getPhoneNumber());
                        req.setAttribute("faculty", student.getFaculty());
                        req.setAttribute("dormRef", student.getDormRef());

                        req.setAttribute("buttonLabel", "Update");
                    }
                } else {
                    req.setAttribute("action", "add");
                    req.setAttribute("buttonLabel", "Add");
                }
                req.getRequestDispatcher("/WebContent/students/form.jsp").forward(req,resp);
                break;
            case DELETE:
                String studentIdToDelete = req.getParameter("id");

                if (studentIdToDelete != null) {
                    studentService.deleteStudent( Integer.parseInt( studentIdToDelete ) );
                }

                list(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action == null) {
            action = LIST;
        }

        switch (action) {
            case LIST:
                list(req, resp);
                break;
            case ADD:
                Integer dormId = Integer.parseInt( req.getParameter("dormRef") );
                Dorm studentDorm = dormService.getDorm( dormId );

                if (studentDorm != null) {
                    String gender = req.getParameter("gender");

                    if (studentDorm.getDormType().equalsIgnoreCase(gender) || studentDorm.getDormType().equalsIgnoreCase("mixed")) {
                        Integer dormCapacity = studentDorm.getNumberOfRooms() * studentDorm.getRoomSize();
                        Integer dormCapacityOccupied = studentService.getStudentCountForDorm(dormId);

                        if (dormCapacityOccupied < dormCapacity) {
                            Student newStudent = new Student();
                            newStudent.setName(req.getParameter("name"));
                            newStudent.setAdmissionMean(Double.parseDouble(req.getParameter("admissionMean")));
                            newStudent.setCivilStatus(CivilStatus.valueOf(req.getParameter("civilStatus").toUpperCase()));
                            newStudent.setGender(gender);
                            newStudent.setAge(Integer.parseInt(req.getParameter("age")));
                            newStudent.setCurrentYear(Integer.parseInt(req.getParameter("currentYear")));
                            newStudent.setCnp(req.getParameter("cnp"));
                            newStudent.setEmail(req.getParameter("email"));
                            newStudent.setPhoneNumber(req.getParameter("phoneNumber"));
                            newStudent.setFaculty(req.getParameter("faculty"));
                            newStudent.setDormRef(dormId);

                            studentService.addStudent(newStudent);
                        } else {
                            req.setAttribute("errorMessage", "The dorm " + dormId + " - " + studentDorm.getName() + " is already full!");
                        }
                    } else {
                        req.setAttribute("errorMessage", "The dorm " + dormId + " - " + studentDorm.getName() + " is of type " + studentDorm.getDormType());
                    }
                } else {
                    req.setAttribute("errorMessage", "The dorm " + dormId + " does not exist!");
                }

                list(req, resp);
                break;
            case EDIT:
                Student updatedStudent = new Student();
                updatedStudent.setStudentId( Integer.parseInt( req.getParameter("studentId") ) );
                updatedStudent.setName( req.getParameter("name") );
                updatedStudent.setAdmissionMean( Double.parseDouble( req.getParameter("admissionMean") ) );
                updatedStudent.setCivilStatus( CivilStatus.valueOf( req.getParameter("civilStatus").toUpperCase() ) );
                updatedStudent.setGender( req.getParameter("gender") );
                updatedStudent.setAge( Integer.parseInt( req.getParameter("age") ) );
                updatedStudent.setCurrentYear( Integer.parseInt( req.getParameter("currentYear") ) );
                updatedStudent.setCnp( req.getParameter("cnp") );
                updatedStudent.setEmail( req.getParameter("email") );
                updatedStudent.setPhoneNumber( req.getParameter("phoneNumber") );
                updatedStudent.setFaculty( req.getParameter("faculty") );
                updatedStudent.setDormRef( Integer.parseInt( req.getParameter("dormRef") ) ); // TODO

                studentService.updateStudent(updatedStudent);

                list(req, resp);
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.getStudents();
        req.setAttribute(STUDENT_LIST, studentList);
        req.getRequestDispatcher("/WebContent/students/list.jsp").forward(req, resp);
    }

}
