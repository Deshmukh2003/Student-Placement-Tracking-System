package placement.service;

import java.util.List;

import placement.model.placementpojo;
import placement.repository.placementrepository;
import placement.repository.placementrepositoryImpl;

public class PlacementServiceImpl implements Placementservice {

    private placementrepository prepo = new placementrepositoryImpl();

    @Override
    public boolean isAdd(placementpojo p) {
        return prepo.isAdd(p);
    }

    @Override
    public boolean loginCheck(String email, String password) {
        return prepo.loginCheck(email, password);
    }

    @Override
    public boolean adminCheck(String username, String password) {
        return prepo.adminCheck(username, password);
    }

    @Override
    public List<placementpojo> getByStatus(String status) {
        return prepo.getByStatus(status);
    }

    @Override
    public void updateStatus(int id, String status) {
        // not needed now
    }

    // ================= PROFILE =================
    @Override
    public placementpojo getStudentByEmail(String email) {
        return prepo.getStudentByEmail(email);
    }

    // ================= UPDATE PROFILE (FIXED) =================
    @Override
    public boolean updateStudent(placementpojo p) {
        return prepo.updateStudent(p);
    }
}