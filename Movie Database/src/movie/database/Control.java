/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.database;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author II
 */
public class Control {
    Conn conn;
    Model model;
    Lihat lihat;
    
    /**
     *
     * @param model
     * @param lihat
     */
    public Control(Model model, Lihat lihat) {
    this.model = model;
    this.lihat = lihat;
    
    if(0 != model.getBanyakData()){
        String dataFilm[][] = model.readFilm();
        lihat.table.setModel((new JTable(dataFilm, lihat.namaKolom)).getModel());
        
    } else{
        JOptionPane.showMessageDialog(null, "Data Tidak Ada");
    }
    
    lihat.btnAdd.addActionListener((ActionEvent e) -> {
            if(lihat.getjudul().equals("")
                    || lihat.getjudul().equals("")
                    || lihat.gettipe().equals("")
                    || lihat.getep().equals("")
                    || lihat.getgenre().equals("")
                    || lihat.getstatus().equals("")
                    || lihat.getrating().equals("")
                    ) {
                JOptionPane.showMessageDialog(null, "Field tdk boleh kosong");
            } else{
                
                String judul = lihat.getjudul();
                String tipe = lihat.gettipe();
                String ep = lihat.getep();
                String genre = lihat.getgenre();
                String status = lihat.getstatus();
                String rating = lihat.getrating();
                
                model.insertFilm(judul, tipe, ep, genre, status, rating);
                String dataFilm[][] = model.readFilm();
                lihat.table.setModel(new JTable(dataFilm, lihat.namaKolom).getModel());
            }
    });
        
    lihat.btnRefresh.addActionListener((ActionEvent e) -> {
        lihat.fjudul.setText("");
        lihat.fep.setText("");
        lihat.fgenre.setText("");
        lihat.ftipe.setText("");
        lihat.frating.setText("");
    });  
       
    lihat.btnDelete.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ex) {
            int baris = lihat.table.getSelectedRow();
            int kolom = lihat.table.getSelectedColumn();

            String dataterpilih = lihat.table.getValueAt(baris, 2).toString();
           
            System.out.println(dataterpilih);
            model.deleteFilm(dataterpilih);
            String dataFilm[][] = model.readFilm();
            lihat.table.setModel(new JTable(dataFilm, lihat.namaKolom).getModel());
        }
    });
    
    //search belum keluar hasil searching nya
    lihat.btnSearch.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            int baris = lihat.table.getSelectedRow();
            int kolom = lihat.table.getSelectedColumn();
            
            String search = lihat.getsearch();
            System.out.println(search);
            model.searchFilm(search);
            String dataFilm[][] = model.readFilm();
            lihat.table.setModel(new JTable(dataFilm, lihat.namaKolom).getModel());
        }
    });  

    lihat.table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
            int baris = lihat.table.getSelectedRow();
            int kolom = lihat.table.getSelectedColumn();
            
            String judul = lihat.table.getValueAt(baris, 2).toString();
            lihat.fjudul.setText(judul);
            String tipe = lihat.table.getValueAt(baris, 3).toString();
            lihat.ftipe.setText(tipe);
            String ep = lihat.table.getValueAt(baris, 4).toString();
            lihat.fep.setText(ep);
            String genre = lihat.table.getValueAt(baris, 5).toString();
            lihat.fgenre.setText(genre);
            String status = lihat.table.getValueAt(baris, 6).toString();
            lihat.cmbStatus.setSelectedItem(status);
            String rating = lihat.table.getValueAt(baris, 7).toString();
            lihat.frating.setText(rating);
            
            lihat.btnUpdate.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){ 
                    String judul = lihat.getjudul();
                    String tipe = lihat.gettipe();
                    String ep = lihat.getep();
                    String genre = lihat.getgenre();
                    String status = lihat.getstatus();
                    String rating = lihat.getrating();
                    model.updateFilm(judul, tipe, ep, genre, status,rating);
                
                String dataFilm[][]= model.readFilm();
                lihat.table.setModel(new JTable(dataFilm, lihat.namaKolom).getModel());

            }            
         });
      }
        
    });
    
      
    lihat.btnExit.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    }
}
