import javax.swing.*;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class GradingSystem extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9,l10;
	JTextField t1, t2, t3, t5, t6, t7, t8, t9;
	JButton b1, b2, b3, b4;
	int Regno, Tamil, English, Mathematics, Science, SocialScience,Total;
	String Name,School;

	GradingSystem() {
		setTitle("SSLC GRADING SYSTEM");
		setLayout(null);
		l1 = new JLabel("Register Number");
		l1.setFont(new Font("Default",Font.BOLD,15)); 
		l2 = new JLabel("Student Name");
		l2.setFont(new Font("Default",Font.BOLD,15));
		l3 = new JLabel("School Name");
		l3.setFont(new Font("Default",Font.BOLD,15));
		l4 = new JLabel("ENTER THE MARKS :");
		l4.setFont(new Font("TimesNewRoman",Font.BOLD,20));
		l5 = new JLabel("Tamil");
		l5.setFont(new Font("Default",Font.BOLD,15));
		l6 = new JLabel("English");
		l6.setFont(new Font("Default",Font.BOLD,15));
		l7 = new JLabel("Mathematics");
		l7.setFont(new Font("Default",Font.BOLD,15));
		l8 = new JLabel("Science");
		l8.setFont(new Font("Default",Font.BOLD,15));
		l9 = new JLabel("Social Science");
		l9.setFont(new Font("Default",Font.BOLD,15));
		l10 = new JLabel("- LOHITH M R");
		l10.setFont(new Font("SansSerif",Font.BOLD,20));
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();
		
		b1 = new JButton("Insert");
		b2 = new JButton("Update");
		b3 = new JButton("Delete");
		b4 = new JButton("Clear");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		

		l1.setBounds(100, 100, 150, 30);
		l2.setBounds(100, 150, 150, 30);
		l3.setBounds(100, 200, 150, 30);
		l4.setBounds(100, 280, 700, 40);
		l5.setBounds(100, 350, 180, 40);
		l6.setBounds(100, 400, 150, 40);
		l7.setBounds(100, 450, 150, 40);
		l8.setBounds(100, 500, 150, 40);
		l9.setBounds(100, 550, 150, 40);
		l10.setBounds(1000,690,300,60);

		t1.setBounds(250, 100, 150, 30);
		t2.setBounds(250, 150, 150, 30);
		t3.setBounds(250, 200, 350, 30);
		t5.setBounds(250, 355, 100, 30);
		t6.setBounds(250, 405, 100, 30);
		t7.setBounds(250, 455, 100, 30);
		t8.setBounds(250, 505, 100, 30);
		t9.setBounds(250, 555, 100, 30);
		
		b1.setBounds(100, 700, 100, 30);
		b2.setBounds(250, 700, 100, 30);
		b3.setBounds(400, 700, 100, 30);
		b4.setBounds(550, 700, 100, 30);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		
		add(t1);
		add(t2);
		add(t3);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(t9);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
	}
class MyTextField extends JTextField{
	MyTextField(int len){
		super(len);
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
				if(key==KeyEvent.VK_ENTER)
					transferFocus();
			}
		});
	}
}

	public static void main(String[] args) {
		JFrame f1 = new GradingSystem();
		Color color=new Color(182,208,226);
		f1.getContentPane().setBackground(color);
		f1.setSize(500, 600);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		Regno = Integer.parseInt(t1.getText());
		Name = t2.getText();
		School = t3.getText();
		Tamil = Integer.parseInt(t5.getText());
		English = Integer.parseInt(t6.getText());
		Mathematics = Integer.parseInt(t7.getText());
		Science = Integer.parseInt(t8.getText());
		SocialScience = Integer.parseInt(t9.getText());
		Total=Tamil+English+Mathematics+Science+SocialScience;
		
		//INSERT
		
		if(e.getSource()==b1)
		{
			t1.setText("");
            t2.setText("");
            t3.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t1.requestFocus();
            if(Tamil>=45&English>=45&Mathematics>=45&Science>=45&SocialScience>=45)
            {
			JOptionPane.showMessageDialog(null,"Congratulations  "+Name+": PASS");
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Sorry  "+Name+": FAIL");
            }
			 String url="jdbc:mysql://localhost:3306/lohith";
	            String username="root";
	            String password="H@cking004";
	            try {
	                Connection con=DriverManager.getConnection(url,username,password);
	                System.out.println("connection success");
	                java.sql.Statement s=con.createStatement();
	                String sq ="INSERT into gradingsystem VALUES('"+Regno+"','"+Name+"','"+School+"','"+Tamil+"','"+English+"','"+Mathematics+"','"+Science+"','"+SocialScience+"','"+Total+"');";
	                s.executeUpdate(sq);    
	            }
	            catch(Exception e1){
	                System.out.println(e1.toString());

	            }
	        }
		
		//UPDATE
		
	        else if(e.getSource()==b2)
	        {
	            
	          
	            String url="jdbc:mysql://localhost:3306/lohith";
	            String username="root";
	            String password="*******";
	            try {
	                Connection con=DriverManager.getConnection(url,username,password);
	                System.out.println("connection success");
	                java.sql.Statement st=con.createStatement();
	                int res =st.executeUpdate("update gradingsystem Set Name='"+Name+"',School='"+School+"',Tamil='"+Tamil+"',English='"+English+"',Mathematics='"+Mathematics+"',Science='"+Science+"',SocialScience='"+SocialScience+"',Total='"+Total+"' where Regno='"+Regno+"'");
	                if(res>0)
	                	JOptionPane.showMessageDialog(null, "Successfully Updated");
	                else
	                	JOptionPane.showMessageDialog(null, "Not Updated");
	                st.close();
	                con.close();
	            }
	            catch(Exception e1){
	                System.out.println(e1.toString());
	        }
	    }
		
		//DELETE
			
	        else if(e.getSource()==b3)
	        {
	            
	          
	            String url="jdbc:mysql://localhost:3306/lohith";
	            String username="root";
	            String password="*******";
	            try {
	                Connection con=DriverManager.getConnection(url,username,password);
	                System.out.println("connection success");
	                java.sql.Statement st=con.createStatement();
	                int res =st.executeUpdate("delete from gradingsystem where Regno='"+Regno+"'");
	                if(res>0)
	                	JOptionPane.showMessageDialog(null, "Successfully deleted");
	                else
	                	JOptionPane.showMessageDialog(null, "Not deleted");
	                st.close();
	                con.close();
	            }
	            catch(Exception e1){
	                System.out.println(e1.toString());
	        }
	    }
		
		//CLEAR
		
	        else {
	        	if(e.getSource()==b4)
	        	{
	        	t1.setText("");
	            t2.setText("");
	            t3.setText("");
	            t5.setText("");
	            t6.setText("");
	            t7.setText("");
	            t8.setText("");
	            t9.setText("");
	            t1.requestFocus();
	        	}
	        }


	}
}