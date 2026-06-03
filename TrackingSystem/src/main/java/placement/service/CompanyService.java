package placement.service;

import java.util.List;

import placement.model.CompanyPojo;

public interface CompanyService {

    boolean addCompany(CompanyPojo c);

    List<CompanyPojo> getAllCompanies();

    int getTotalCompanies();   // ✅ MUST BE HERE

    boolean addCompany1(CompanyPojo c);
}