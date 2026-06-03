package placement.repository;

import java.util.List;

import placement.model.ApplicationPojo;

public interface ApplicationRepository {

    boolean apply(ApplicationPojo a);

    List<ApplicationPojo> getAll();

    boolean updateStatus(int id, String status);

    int getTotalApplications();                 // ✅ ADDED

    int getCountByStatus(String status);        // ✅ ADDED
}