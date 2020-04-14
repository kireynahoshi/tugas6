/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.database;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author II
 */
public class Login {
        public static void main(String[] args) {
        Login login = new Login();
   }
}

class Login extends JFrame {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
   final JTextField fuser = new JTextField(10);
   final JTextField fpass = new JTextField(10);
   
   JLabel ltitle = new JLabel(" LOGIN ");
   JLabel luser = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   
   JButton btnLogin = new JButton("LOGIN");

        Login() { 
        
        koneksi conn = new koneksi();
        conn.config();
        con = conn.con;
        stat = conn.stm;
                
        setTitle("LOGIN");
	setSize(350,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        
        add(ltitle);
	add(luser);
	add(fuser);
        add(lpass);
	add(fpass);
	add(btnLogin);  
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                sql = "SELECT * FROM admin WHERE username='"+fuser.getText()+"' AND password='"+fpass.getText()+"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                    if(fuser.getText().equals(rs.getString("username")) && fpass.getText().equals(rs.getString("password"))){
                        JOptionPane.showMessageDialog(null, "berhasil login");
                        Set Set;
                        Set = new Set();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                    }
                }catch (Exception ex){
                     JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        setVisible(true);
        ltitle.setBounds(150,15,140,20);
	luser.setBounds(10,50,120,20);
	fuser.setBounds(130,50,150,20);
	lpass.setBounds(10,75,120,20);
	fpass.setBounds(130,75,150,20);
	btnLogin.setBounds(100,110,120,20);
	
   }
}
