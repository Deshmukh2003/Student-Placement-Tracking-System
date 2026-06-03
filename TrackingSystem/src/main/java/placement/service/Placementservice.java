//package placement.service;
//
//import placement.model.placementpojo;
//
//public interface placementservice {
//
//	boolean isAdd(placementpojo p);
//
//	boolean loginCheck(String email, String password);
//
//	boolean AdminCheck(String username, String password);
//}

package placement.service;

import java.util.List;

import placement.model.placementpojo;

public interface Placementservice {

    boolean isAdd(placementpojo p);

    boolean loginCheck(String email, String password);

    boolean adminCheck(String username, String password);

    // ⭐ ADD THIS FOR PLACEMENT MODULE
    List<placementpojo> getByStatus(String status);

	void updateStatus(int id, String status);

	placementpojo getStudentByEmail(String email);

	boolean updateStudent(placementpojo p);
}