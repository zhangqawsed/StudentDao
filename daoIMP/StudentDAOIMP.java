package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// ��Ӳ���
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id, name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //������ݿ�ľ������
	    try{
	        conn = new DataBaseConnection();
	        
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        //pstmt.setString(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  }
	      }

	    public void update(Student s){  
	    	String sql = "UPDATA student set id=?,name=?";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    //������ݿ�ľ������
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        pstmt.setLong(1,s.getID());
		        //pstmt.setString(1,s.getID());
		        pstmt.setString(2,s.getName());
		  
		        pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		        }
		     catch(Exception e){  }
	    }

                    public void delete(String iD){  
                    	String sql = "DELETE FROM student where id=?";
                	    PreparedStatement pstmt = null;
                	    DataBaseConnection conn = null;
                	    //������ݿ�ľ������
                	    try{
                	        conn = new DataBaseConnection();
                	        
                	        pstmt = conn.getConnection().prepareStatement(sql);
                	       
                	        pstmt.setString(1,iD);
                	 
                	  
                	        pstmt.executeUpdate();
                	        pstmt.close();
                	        conn.close();
                	        }
                	     catch(Exception e){  }
                    }
	    
	    public List<Student> findAll(){  
	    	String sql = "SELECT * FROM student";
		    PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    //������ݿ�ľ������
		    List<Student> studentlist=new ArrayList<Student>();
	        Student stu=new Student();
		    try{
		        conn = new DataBaseConnection();
		        
		        pstmt = conn.getConnection().prepareStatement(sql);
		        //pstmt.setLong(1,s.getID());
		        //pstmt.setString(1,s.getID());
		        //pstmt.setString(2,s.getName());
		        
		        
		        ResultSet rs=pstmt.executeQuery(sql);
		        
		        while(rs.next()) {
		        	stu.setID(rs.getLong("id"));
		        	stu.setName(rs.getString("name"));
		        	studentlist.add(stu);
		        }
		       
		        pstmt.close();
		        conn.close();
		        }
		     catch(Exception e){  }
		     return studentlist;
	    }

                    public Student findByID(long iD){  
                    	String sql = "SELECT * FROM student WHERE id=?";
                	    PreparedStatement pstmt = null;
                	    DataBaseConnection conn = null;
                	    //������ݿ�ľ������
                	    Student stu=new Student();
                	    try{
                	        conn = new DataBaseConnection();
                	        
                	        pstmt = conn.getConnection().prepareStatement(sql);
                	        pstmt.setLong(1,iD);
                	        //pstmt.setString(1,s.getID());
                	        //pstmt.setString(2,s.getName());
                	  
                	        ResultSet rs=pstmt.executeQuery(sql);
                	        stu.setID(rs.getLong("id"));
        		        	stu.setName(rs.getString("name"));
                	        pstmt.close();
                	        conn.close();
                	        }
                	     catch(Exception e){  }
                	    return stu;
                    }
                    
                  }
