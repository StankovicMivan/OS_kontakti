package probaaa;

import javax.swing.*;

import com.model.Drzava;
import com.model.SvetskoPrvenstvo;

import javax.*;
import javax.crypto.CipherInputStream;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class proba {
	public static void main(String []args) {
	
		JFrame frame = new JFrame("Svetska Prvenstva");
		ImageIcon img = new ImageIcon("pic.jpg");
		frame.setIconImage(img.getImage());
		frame.setVisible(true);
		frame.setSize(1024, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, -2, 0, 0);
		frame.setBackground(Color.yellow);
		panel.setBackground(Color.WHITE);
		JLabel label = new JLabel("Glavni Meni");
		
		c.gridx = -2;
		c.gridy = -10;
		panel.add(label,c);
		//		panel.add(label, c);
		JButton button1 = new JButton("Prikaz svih Drzava");
		button1.setForeground(Color.BLACK);
		button1.setBackground(Color.red);
		c.gridx = -2;
		c.gridy = 1;
		panel.add(button1,c );

		//	JLabel label1 = new JLabel("Test");
		JButton button2 = new JButton("Prikaz svih prvenstava");
		c.gridx = -2;
		c.gridy =2;
		//	panel.add(label1,c);
		button2.setForeground(Color.BLACK);
		button2.setBackground(Color.green);
		panel.add(button2, c);

		frame.add(panel);



		JButton button3 = new JButton("Rad sa Drzavama");
		c.gridx = -2;
		c.gridy =3;
		button3.setForeground(Color.WHITE);
		button3.setBackground(Color.BLUE);
		panel.add(button3,c);

		
		ImageIcon lupa = new ImageIcon("piclupe.jpg");
		JButton button4 = new JButton(lupa);
		c.gridx = -2;
		c.gridy =3;
		
		panel.add(button4,c);
		button1.addActionListener(new Action1());
	}

	static class Action1 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JFrame frame2 = new JFrame("Prikaz svih drzava");
			frame2.setVisible(true);
			frame2.setSize(250,550);
			
			ImageIcon img = new ImageIcon("pic2.png");
			frame2.setIconImage(img.getImage());
			JLabel label = new JLabel("Drzave\n");
			JPanel panel = new JPanel();
			frame2.add(panel);
			panel.setBackground(Color.WHITE);
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(10, 10, 10, 10);
			c.gridx = 0;
			c.gridy =0;
			panel.add(label,c);
			ArrayList<Drzava> drzave = test1();
			int index =1;
			c.gridx = 0;
			c.gridy =2;
			for(int i =0;i<drzave.size();i++) {
				String drzava = drzave.get(i).getId() + " " +drzave.get(i).getNaziv() + "\n";
				JLabel temp = new JLabel(drzava + "");
				temp.setBackground(Color.GREEN);
//				JTextField temp = new JTextField(drzava);
//				temp.setBounds(10, index, 10, 10);
				for(int j =0;j<drzave.size();j++) {
					c.gridx =0;
					c.gridy =i;
					index++;
					panel.add(temp);
				}
	
			}
			
		}
	}

	public static ArrayList<Drzava> test1() {
		ArrayList<Drzava> drzave = new ArrayList<>();
		Connection conn;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prvenstva?useSSL=false", "root","root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			return null;
		}
		Statement stmt = null;
		ResultSet rset = null;

		JLabel label ;
		try {
			String query = "SELECT * FROM drzava";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			// citanje rezultata upita i punjenje liste
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);

		
				Drzava drzava = new Drzava(id,naziv);
				drzave.add(drzava);
				

			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		}  finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
		return drzave;
	}

	static void prikaz2(Connection conn) {
		//		List<SvetskoPrvenstvo> prvenstvo = new ArrayList<>(); // imamo vec gore static listu

		
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT * FROM prvenstvo";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			// citanje rezultata upita i punjenje liste
			while (rset.next()) {
				int index = 1;
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacin = rset.getInt(index++);
				int osvajac = rset.getInt(index++);

				Drzava dom = null;
				Drzava osv = null;
				
				

				}
				
		//		SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(godina, naziv, dom, osv);
		//		
			

		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		}  finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
	}



}