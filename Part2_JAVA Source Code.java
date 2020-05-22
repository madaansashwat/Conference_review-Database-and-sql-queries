import java.sql.*;

public class test {

	
//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/tt";

//  Database credentials
static final String USER = "root";
static final String PASS = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello");



Connection conn = null;
Statement stmt = null;
try{
   //STEP 2: Register JDBC driver
   Class.forName("com.mysql.jdbc.Driver");

   //STEP 3: Open a connection
   System.out.println("Connecting to database...");
   conn = DriverManager.getConnection(DB_URL, USER, PASS);

   //STEP 4: Execute a query
   System.out.println("Creating database...");
   stmt = conn.createStatement();
   
   String sql = "CREATE DATABASE STUDENTS";
   stmt.executeUpdate(sql);
   System.out.println("Database created successfully...");


System.out.println("Creating table in given database...");
stmt = conn.createStatement();

String author = "CREATE TABLE author " +
        "(email_id VARCHAR(100) not NULL, " +
        " first_name CHAR(50), " + 
        " last_name CHAR(50), " +  
        " PRIMARY KEY ( email_id ))"; 
stmt.executeUpdate(author);
System.out.println("Created table author in given database...");

String paper = "CREATE TABLE paper " +
        "(paper_id INTEGER not NULL, " +
        " email_id VARCHAR(100) not NULL, " +
        " title CHAR(50), " + 
        " abstract VARCHAR(10000), " + 
        " file_name CHAR(50), " +
        " PRIMARY KEY ( paper_id ))";
stmt.executeUpdate(paper);
System.out.println("Created table paper author in given database...");

String reviewer = "CREATE TABLE reviewer " +
        "(reviewer_id INTEGER not NULL, " +
        "email_id VARCHAR(100) not NULL, " +
        " first_name CHAR(50), " + 
        " last_name CHAR(50), " +  
        " phone_no INTEGER(10), " + 
        " affiliation CHAR(50), " + 
        " author_feedback CHAR(100), " +
        " committee_feedback CHAR(100), " +
        " PRIMARY KEY ( reviewer_id ))";
stmt.executeUpdate(reviewer);
System.out.println("Created table reviewer paper author in given database...");

String review = "CREATE TABLE review " +
        "(rv_id INTEGER not NULL, " +
        " paper_id INTEGER not NULL, " +
        " reviewer_id INTEGER not NULL, " +
        " recommendation CHAR(100), " + 
        " merit_score INTEGER, " +  
        " readibility_score INTEGER, " + 
        " originality_score INTEGER, " + 
        " relevance_score INTEGER, " +
         " PRIMARY KEY ( rv_id ))";
stmt.executeUpdate(review);
System.out.println("Created table review paper author in given database...");

#Selecting a paper and author details through author's primary key that is email_id
String query1= "SELECT paper_id, title, abstract,email_id,first_name, last_name from  author inner join paper on author.email_id = paper.email_id";
      ResultSet rs = stmt.executeQuery(query1);
      
      while(rs.next()){
         //Retrieve by column name
         int paper_id = rs.getInt("paper_id");
         String title = rs.getString("title");
         String abstract = rs.getString("abstract");
         String email_id = rs.getString("email_id");
         String first_name = rs.getString("first_name");
         String last_name = rs.getString("last_name");

         //Display values
         System.out.print("Paper_ID: " + paper_id);
         System.out.print(", Title: " + title);
         System.out.print(", Abstract: " + abstract);
         System.out.println(", Email_id: " + email_id);
         System.out.println(", First Name: " + first_name);
         System.out.println(", Last Name: " + last_name);
         
#Getting all the reviews for a paper through paper_id from the review table
String query2= "SELECT rv_ id, paper_id, reviewer_id,recommendation, merit_score, readibility_score, originality_score, relevance_score from review";
      ResultSet rs = stmt.executeQuery(query2);
      
      while(rs.next()){
         //Retrieve by column name
         int rv_id = rs.getInt("rv_id");
         int paper_id = rs.getInt("paper_id");
         int reviewer_id = rs.getInt("reviewer_id");
         String recommendation = rs.getString("recommendation");
         int merit_score= rs.getInt("merit_score");
         int readibility_score= rs.getInt("readibility_score");
         int originality_score= rs.getInt("originality_score");
         int relevance_score = rs.getInt("relevance_score");

         //Display values
         System.out.print("REVIEW_ID: " + rv_id);
         System.out.print("Paper_ID: " + paper_id);
         System.out.print(", Reviewer_ID: " + reviewer_id;
         System.out.print(", Recommendation: " + recommendation);
         System.out.println(", Merit Score: " + merit_score);
         System.out.println(", Readibility Score: " + readibility_score);
         System.out.println(", Originality Score: " + originality_score);
         System.out.println(", Relevance Score: " + relevance_score);

//Inserting a new paper details in both the tables.
paper = "INSERT INTO paper " +
                   "VALUES(104, 'ka@gmail.com', 'Question paper Generator', 'Question paper generator is solution for schools/colleges and other educational institutes', 'QPG')";
      stmt.executeUpdate(paper);
      System.out.println("Inserted records into the table paper...");
      
author = "INSERT INTO author " +
                   "VALUES('ka@gmail.com', 'Kevin', 'Andrews')";
      stmt.executeUpdate(author);
      System.out.println("Inserted records into the table author...");

//Deleting a author row in the author table
String query3 = "DELETE FROM author " +
                   "WHERE id = 101";
      stmt.executeUpdate(query3);

}
catch(SQLException se){
   //Handle errors for JDBC
   se.printStackTrace();
}catch(Exception e){
   //Handle errors for Class.forName
   e.printStackTrace();
}finally{
   //finally block used to close resources
   try{
      if(stmt!=null)
         stmt.close();
   }catch(SQLException se2){
   }// nothing we can do
   try{
      if(conn!=null)
         conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }//end finally try
}//end try
	
	}

}
