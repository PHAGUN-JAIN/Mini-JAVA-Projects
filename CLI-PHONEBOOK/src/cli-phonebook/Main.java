import java.sql.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		Connection conn = null;
		
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:phonebook.db");
			System.out.println("Connection Obtained!");

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
			}
			catch(Exception e)
			{
		 		System.out.println(e);
				System.exit(0);
			}
		}
	}
}