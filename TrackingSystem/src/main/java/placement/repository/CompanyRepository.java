package placement.repository;

import java.util.List;

import placement.model.CompanyPojo;

public interface CompanyRepository {

    boolean addCompany(CompanyPojo c);

    List<CompanyPojo> getAllCompanies();

    int getTotalCompanies();   // ✅ ADDED
}