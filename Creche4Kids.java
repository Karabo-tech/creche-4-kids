/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.creche;

import ac.za.tut.kid.Kid;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import jdk.nashorn.internal.scripts.JS;

/**
 *
 * @author Student
 */
public class Creche4Kids extends JFrame{

    //JPanels
    private JPanel namePnl;
    private JPanel genderPnl;
    private JPanel inputPnl;
    private JPanel scrollPnl;
    private JPanel btnsPnl;
    private JPanel mainPnl;
   
    //JLables
    private JLabel nameLbl;
    private JLabel genderLbl;
    
    //text field
    private JTextField nameTxtFld;
    
    //group
    private ButtonGroup btnGrp;
    
    //radiobuttons
    private JRadioButton maleRadBtn;
    private JRadioButton femaleRadBtn;
    
    //buttons
    private JButton registerBtn;
    private JButton displayBtn;
    
    //textArea
    private JTextArea txtArea;
    private JScrollPane scrollArea;
    
    private ArrayList<Kid> kids;
    
    public Creche4Kids() {
        setSize(500, 450);
        setTitle("CRECHE 4 YOUR KIDDIE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        kids=new ArrayList<>();
        //JPanels
        namePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPnl=new JPanel(new GridLayout(3, 1, 1, 1));
        btnsPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        scrollPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPnl=new JPanel(new BorderLayout());
        
        //Labels
        nameLbl=new JLabel("Name: ");
        genderLbl=new JLabel("Gender: ");
        
        //textField
        nameTxtFld=new JTextField(10);
        
        //buttons
        registerBtn=new JButton("Register kiddie");
        registerBtn.addActionListener(new RegisterBtnListener());
        
        displayBtn=new JButton("Display kiddie");
        displayBtn.addActionListener(new DisplayBtn());
        
        //Radio Buttons
        btnGrp=new ButtonGroup();
        maleRadBtn=new JRadioButton("Male");
        femaleRadBtn=new JRadioButton("female");
        btnGrp.add(maleRadBtn);
        btnGrp.add(femaleRadBtn);
        
        //TEXTAREA
        txtArea=new JTextArea(10, 30);
        scrollArea=new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollArea.setEnabled(false);
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(maleRadBtn);
        genderPnl.add(femaleRadBtn);
        
        btnsPnl.add(registerBtn);
        btnsPnl.add(displayBtn);
        
        inputPnl.add(namePnl);
        inputPnl.add(genderPnl);
        inputPnl.add(btnsPnl);
        inputPnl.add(btnsPnl);
        //inputPnl.add(scrollArea);
        
        scrollPnl.add(scrollArea);
        
        mainPnl.add(inputPnl, BorderLayout.NORTH);
        mainPnl.add(scrollPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        setVisible(true);
        pack();
        
    }
    
    private class RegisterBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name=nameTxtFld.getText();
            String gender="Male";
            
            if(femaleRadBtn.isSelected()){
                gender="Female";
            }
            
            Kid kid=new Kid(name, gender);
            
            kids.add(kid);
            
            nameTxtFld.setText("");
            btnGrp.clearSelection();
        }
        
    }
    private class DisplayBtn implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String str="";
            //str="";
            for (int i = 0; i < kids.size(); i++) {
                str +=kids.get(i).toString() +"\n";
                txtArea.setText(str);
            }
        }
        
    }
    
}
