/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ReadData {
    public int id, nim, age;
    public String name;
    int totalData;
    String data[][] = new String[100][4];
    
    Connector connector = new Connector();
    
    JFrame window = new JFrame("Read Data Student");
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object columnName[] = {
        "ID", "NIM", "Name", "Age"
    };
    
    JButton btnAdd = new JButton("ADD");
    JButton btnRefresh = new JButton("REFRESH");
        
    public ReadData(){
        tableModel = new DefaultTableModel(columnName, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
      
        window.setLayout(null);
        window.setSize(550, 600);
//        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(scrollPane);
        window.add(btnAdd);
        window.add(btnRefresh);
        scrollPane.setBounds(20, 35, 500, 300);
        btnAdd.setBounds(20, 350, 90, 20);
        btnRefresh.setBounds(120, 350, 120, 20);
        
        data = connector.readData();
        
        tabel.setModel((new JTable(data, columnName)).getModel());
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = tabel.getSelectedRow();
                int column = tabel.getSelectedColumn();
                
                int id = Integer.parseInt(tabel.getValueAt(row,0).toString());
                String name = tabel.getValueAt(row,2).toString();
                
                int input = JOptionPane.showConfirmDialog(null,
                            "do you want to delete " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                
                if(input == 0){
                    connector.deleteData(id);
                }else{
                    input = JOptionPane.showConfirmDialog(null,
                            "do you want to update " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if(input == 0){
                        UpdateData updateData = new UpdateData(id);
                    }
                }
            }
        });
        
        btnAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            InputData inputData = new InputData();
         }
        });
        
        btnRefresh.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            window.dispose();
//            new ReadData();
             data = connector.readData();
        
            tabel.setModel((new JTable(data, columnName)).getModel());
         }
        });
    }
}
