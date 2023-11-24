package com.railworld.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.railworld.model.Company;

public class CompanyDao {

	private static final String url = "jdbc:mysql://locallhost:3306/security";
	private static final String username = "root";
	private static final String password = "root";
	
	private Connection connection;
	
	public CompanyDao() {
		try {
			connection = DriverManager.getConnection(url,username,password);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<Company> getAllCompany(){
		List<Company> company = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM company";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Company company1 = new Company(resultSet.getInt("companyId"), resultSet.getString("companyName"),
							resultSet.getInt(" noOfEmployess" ),resultSet.getInt("employed"));
					company.add(company1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return company;
		
}
	
     public void createComapny(Company company) {
		try (Connection connection=DriverManager.getConnection(url,username,password);
				Statement stmt=connection.createStatement();)
		{
		String query = "CREATE TABLE Company(ID int ,Name varchar(500),Primary key(ID))";
		stmt.executeUpdate(query);
		System.out.println("Table Created");
		}catch(Exception e) {
			System.out.println("Table is not created");
			e.printStackTrace();
		}
			
		
	}
	

	
	
	
	public void addCompany(Company company) {
		
		try {
			
			String query = "INSERT INTO company(companyName,noOfEmployess,employed) VALUES(?, ?, ?)";
			
			
			try (PreparedStatement stmt = connection.prepareStatement(query)){
				stmt.setString(1, company.getCompanyName());
				stmt.setInt(2, company.getNoOfEmployess());
				//stmt.setInt(3, company.getCompanyId());
				stmt.setInt(3, company.getEmployed());
				stmt.executeUpdate();
			}	
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	
	public void updateCompany(Company company) {
		
		try {
		String query = "UPDATE company SET companyName = ? WHERE companyId = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, company.getCompanyName());
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter companyName :");
			String companyName = br.readLine();
			
			  if (companyName != null && !companyName.isEmpty()) {
	                stmt.setString(1, companyName);
	            }
			  
			  stmt.setInt(2, company.getCompanyId());
			
			
			
			stmt.executeUpdate();
			
			System.out.println("UPdateCompanyName..........");
			
			stmt.close();
			
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteCompany(int companyId) {
		try {
			String query = "DELETE FROM Company WHERE companyId = ?";
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				//stmt.setInt(1, companyId);
               
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				stmt.executeUpdate();
				
				//buffer reader 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
