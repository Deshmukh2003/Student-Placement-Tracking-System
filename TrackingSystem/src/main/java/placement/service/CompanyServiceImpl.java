package placement.service;

import java.util.List;

import placement.model.CompanyPojo;
import placement.repository.CompanyRepository;
import placement.repository.CompanyRepositoryImpl;

public class CompanyServiceImpl implements CompanyService {

    CompanyRepository repo = new CompanyRepositoryImpl();

    @Override
    public boolean addCompany(CompanyPojo c) {
        return repo.addCompany(c);
    }

    @Override
    public List<CompanyPojo> getAllCompanies() {
        return repo.getAllCompanies();
    }

    @Override
    public boolean addCompany1(CompanyPojo c) {
        return repo.addCompany(c);
    }

    @Override
    public int getTotalCompanies() {
        return repo.getTotalCompanies();   // ✅ FIXED
    }
}