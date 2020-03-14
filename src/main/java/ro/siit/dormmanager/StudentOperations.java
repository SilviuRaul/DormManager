package ro.siit.dormmanager;

import ro.siit.dormmanager.model.Student;

public interface StudentOperations {

    Student create(String name, double admissionMean, String civileStatus,
                   String gender, int age, int currentYear, String cnp, String email, String phoneNumber,
                   String faculty);

}

