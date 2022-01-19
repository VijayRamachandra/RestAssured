package com.genericUtils;

public interface IpathConstant {
	
	String DATABASE_URL = "jdbc:mysql://localhost:3306/projects";
	
	String ADD_PROJECT = "/addProject";
	String GET_ALLPROJECTS = "/projects";
	String GET_SINGLEPROJECT = "/projects/{projectId}";
	String UPDATE_PROJECT = "/projects/{projectId}";
	String DELETE_PROJECT = "/projects/{projectId}";
	
	
	
	
	
}
