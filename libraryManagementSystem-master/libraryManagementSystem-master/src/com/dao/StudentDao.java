package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

public class StudentDao {
	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private Connection conn;
	
	public boolean addStudent(Student st) {
		boolean f = false;
		try {
			String query = "insert into students(regno,password) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, st.getRegno());
			ps.setString(2, st.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public boolean editStudent(Student st) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("update students set password=? where regno=?");
			ps.setString(1, st.getPassword());
			ps.setString(2, st.getRegno());
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteStudent(String regno) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from students where regno=?");
			ps.setString(1,regno);
			int i = ps.executeUpdate();
			if(i>=1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Student viewStudent(String regno) {
		Student st = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select *from students where regno=?");
			ps.setString(1, regno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student();
				st.setRegno(rs.getString(2));
				st.setPassword(rs.getString(3));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public List<Student> getAllStudents(){
		List<Student> list = new ArrayList();
		Student st = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("select *from students");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student();
				st.setRegno(rs.getString(2));
				st.setPassword(rs.getString(3));
				list.add(st);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
