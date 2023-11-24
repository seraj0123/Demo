package com.railworld.main;

import java.util.Scanner;

import com.railworld.dao.CompanyDao;
import com.railworld.service.CompanyService;

public class CompanyMain {
	private static Scanner sc = new Scanner(System.in);
	private static CompanyService companyService;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDao comapnyDAO = new CompanyDao();
		companyService = new CompanyService(companyDAO);
		
		

	}

}
