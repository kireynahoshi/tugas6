/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.database;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author II
 */
public class Lihat extends JFrame{
    JLabel ljudul = new JLabel("judul");
    JTextField fjudul = new JTextField();
    JLabel ltipe = new JLabel("tipe");
    JTextField ftipe = new JTextField();
    JLabel lep = new JLabel("episode");
    JTextField fep = new JTextField();
    JLabel lstatus = new JLabel("status");
    String status[] = { "selesai", "belum selesai" };
    JComboBox cmbStatus = new JComboBox(status);
    JLabel lgenre = new JLabel("genre");
    JTextField fgenre = new JTextField();
    JLabel lrating = new JLabel("rating");
    JTextField frating = new JTextField();
    
    JTextField fsearch = new JTextField();
    JButton btnSearch = new JButton("search");
    
    JButton btnUpdate = new JButton("update");
    JButton btnRefresh = new JButton("refresh");
    JButton btnAdd = new JButton("add");
    JButton btnDelete = new JButton("delete");
    JButton btnExit = new JButton("exit");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"#","id film","judul","tipe","episode","genre","status","rating"};
    
    public Lihat(){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 580, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(ljudul);
        ljudul.setBounds(20, 250, 40, 20);
        add(fjudul);
        fjudul.setBounds(20, 270, 300, 20);
        add(ltipe);
        ltipe.setBounds(20, 290, 40, 20);
        add(ftipe);
        ftipe.setBounds(20, 310, 100, 20);
        add(lep);
        lep.setBounds(150, 290, 100, 20);
        add(fep);
        fep.setBounds(150, 310, 100, 20);
        add(lrating);
        lgenre.setBounds(20, 330, 40, 20);
        add(frating);
        fgenre.setBounds(20, 350, 100, 20);
        add(lstatus);
        lstatus.setBounds(150, 330, 100, 20);
        add(cmbStatus);
        cmbStatus.setBounds(150, 350, 100, 20);
        add(lgenre);
        lrating.setBounds(20, 370, 100, 20);
        add(fgenre);
        frating.setBounds(20, 390, 300, 20);
        
        add(fsearch);
        fsearch.setBounds(350, 270, 100, 20);
        add(btnSearch);
        btnSearch.setBounds(460, 270, 100, 20);
        add(btnRefresh);
        btnRefresh.setBounds(350, 390, 80, 20);
        add(btnAdd);
        btnAdd.setBounds(440, 390, 60, 20);
        add(btnDelete);
        btnDelete.setBounds(510, 390, 70, 20);
        add(btnUpdate);
        btnUpdate.setBounds(590, 390, 90, 20);   
        add(btnExit);
        btnExit.setBounds(690, 390, 70, 20);        
       }
 
     public String getjudul(){
         return fjudul.getText();
     }       
     public String gettipe(){
         return ftipe.getText();
     }
     public String getstatus(){
         return cmbStatus.getSelectedItem().toString();
     }
     public String getep(){
         return fep.getText();
     }
     public String getgenre(){
         return fgenre.getText();
     }
     public String getrating(){
         return frating.getText();
     }
      public String getsearch(){
         return fsearch.getText();
     }
}
