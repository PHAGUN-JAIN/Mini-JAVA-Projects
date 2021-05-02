import java.sql.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:phonebook.db");
			stmt = conn.createStatement();
			System.out.println("Connection Obtained!");


			Scanner sc = new Scanner(System.in);
			System.out.println("What do you want to do?"+ "\n"+ "Choose: " + "\n"+"1 for inserting contact!" + "\n"+"2 for retriving contact");
			int x = sc.nextInt();
			sc.close();

			if(x==1)
			{
				PreparedStatement psmt=conn.prepareStatement("INSERT INTO contacts (name,phno ) values(?,?)");
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter name :");
				String name= br.readLine();

				System.out.println("Enter Phno");
           			String phno = br.readLine();
				psmt.setString(1,name );
				psmt.setInt(2,Integer.parseInt(phno));

				psmt.executeUpdate();
				System.out.println("Inserted Successfully...");
			}
			else
			{
				ResultSet rs = stmt.executeQuery( "SELECT * FROM contacts;" );

			     	while ( rs.next() )
			      	{
        				int   Id = rs.getInt("id");
      			        	String name = rs.getString("name");
     					int  phno  = rs.getInt("phno");
   			  
     				 	System.out.println( "ID = " + Id );
    				 	System.out.println( "NAME = " + name );
     					System.out.println( "PhNO = " + phno );
					System.out.println("");
     			       }
			}
			
		}
		catch(Exception e)
		{
		 	System.out.println(e);
			System.exit(0);
		}
		finally
		{
			try
			{
				conn.close();
				stmt.close();
			}
			catch(Exception e)
			{
		 		System.out.println(e);
				System.exit(0);
			}
		}
	}
}