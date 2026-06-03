//package placement.repository;
//
//import placement.model.placementpojo;
//
//public interface placementrepository {
//
//	boolean isAdd(placementpojo p);
//
//	boolean loginCheck(String email, String password);
//
//	boolean AdminCheck(String username, String password);
//
//}

package placement.repository;

import java.util.List;

import placement.model.placementpojo;

public interface placementrepository {

    boolean isAdd(placementpojo p);

    boolean loginCheck(String email, String password);

    boolean adminCheck(String username, String password);

	List<placementpojo> getByStatus(String status);
    placementpojo getStudentByEmail(String email);

	boolean updateStudent(placementpojo p);

}
