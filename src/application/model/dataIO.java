package application.model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dataIO {
	
	public static void writeUser(user u) {
		try {
			File fileOut = new File("data/user.csv");
			FileWriter out = new FileWriter(fileOut);
			
			String outString = u.getUsername() + "," + u.getPassword() + "," + u.getName() + ",";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<user> loadUsers (String fileName) {
		ArrayList<user> userList = new ArrayList<user>();
		
		try {
			Scanner in = new Scanner (new File("data/" + fileName));
			
			while (in.hasNext()) {
				String line = in.nextLine();
				String members[] = line.split(",");
				
				user toAdd = new user(members[0], members[1], members[2]);
				
				userList.add(toAdd);
			}
			
			in.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
		return userList;
		
	}
	

}
