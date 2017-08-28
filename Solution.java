package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Item;
import model.User;
public class Solution{

	public static void main(String[] args) throws IOException, SQLException {
		String uName;
		String uPassword;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Item[] item=new Item[50];
		item[0]=new Item();
		item[0].setiName("PASTE");
		item[0].setPrice(74);
		item[0].setQuantity(15);
		item[0].seteDate("29-9-2017");
		item[0].setmDate("29-9-2015");
		session.save(item[0]);
		item[1]=new Item();
		item[1].setiName("SHAMPOO");
		item[1].setPrice(56);
		item[1].setQuantity(30);
		item[1].seteDate("22-9-2017");
		item[1].setmDate("29-6-2016");
		session.save(item[1]);		
		User[] user=new User[3];
		user[0]=new User();
		user[0].setUserName("anbu");
		user[0].setPassword("0344");
		session.save(user[0]);
		user[1]=new User();
		user[1].setUserName("arasan");
		user[1].setPassword("4403");
		
		session.save(user[1]);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Enter the user name:");
		uName=bf.readLine();
		System.out.println("Enter the password:");
		uPassword=bf.readLine();
		
		User users=new User();
		users.setUserName(uName);
		users.setPassword(uPassword);
		try {
			if (Authentication.check(users)) {
				System.out.println("LOGIN SUCCESS");
				boolean flag = false;
				while (true) {
					System.out.print(" 1.Create\n 2.Retrieve\n 3.Update\n 4.Delete\n Choice:");
					int ch=Integer.parseInt(bf.readLine());
					System.out.println(ch);
					switch(ch){
					case 1:
						Operations.insert();
						System.out.println("INSERTED");
						break;
					case 2:
						Operations.retrieve();
						break;
					case 3:
						Operations.update();
						System.out.println("INSERTED");
						break;
					case 4:
						Operations.delete();
						System.out.println("DELETED");
						break;
					default:
						flag=true;
						break;
					}
					if(flag){
					break;
				}
			}
				
		}
			else{
				System.out.println("INVALID LOGIN");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		
	}
		
}

}
