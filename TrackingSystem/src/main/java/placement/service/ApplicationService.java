package placement.service;

import java.util.List;

import placement.model.ApplicationPojo;

public interface ApplicationService {

    boolean apply(ApplicationPojo a);

    List<ApplicationPojo> getAll();

    boolean updateStatus(int id, String status);

    int getTotalApplications();          // ✅

    int getCountByStatus(String status); // ✅
}