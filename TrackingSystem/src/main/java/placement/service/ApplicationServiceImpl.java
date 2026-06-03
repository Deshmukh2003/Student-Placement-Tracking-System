package placement.service;

import java.util.List;

import placement.model.ApplicationPojo;
import placement.repository.ApplicationRepository;
import placement.repository.ApplicationRepositoryImpl;

public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository repo = new ApplicationRepositoryImpl();

    @Override
    public boolean apply(ApplicationPojo a) {
        return repo.apply(a);
    }

    @Override
    public List<ApplicationPojo> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean updateStatus(int id, String status) {
        return repo.updateStatus(id, status);
    }

    @Override
    public int getTotalApplications() {
        return repo.getTotalApplications(); // ✅ FIXED
    }

    @Override
    public int getCountByStatus(String status) {
        return repo.getCountByStatus(status); // ✅ FIXED
    }
}