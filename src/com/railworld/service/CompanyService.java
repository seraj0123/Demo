package com.railworld.service;

import java.util.List;

import com.railworld.dao.CompanyDao;
import com.railworld.model.Company;




public class CompanyService {
	private CompanyDao companyDAO;
	
	public CompanyService(CompanyDao employeeDAO) {
		this.companyDAO = companyDAO;
	}

	public List<Company> getAllCompany(){
		return companyDAO.getAllCompany();
	}
	
	public void addCompany(Company company) {
		companyDAO.addCompany(company);
	}
	
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);
	}
	
	public void deleteCompany(int companyId) {
		companyDAO.deleteCompany(companyId);
	}
}
