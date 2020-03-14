package ro.siit.dormmanager;

import ro.siit.dormmanager.model.Dorm;

public interface DormOperations {

    Dorm create(int roomSize, char dormType, int nrOfPers, int id, String studentList);
}
