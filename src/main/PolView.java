package main;

import java.awt.*;

import java.awt.event.ActionListener;

import javax.swing.*;



public class PolView extends JFrame {

    private JTextField firstPolinom = new JTextField(30);
    private JTextField secondPolinom = new JTextField(30);
    private JTextField calcResult = new JTextField(30);
    private JTextField calcRest = new JTextField(30);
    private JLabel labelP1=new JLabel("Polinom1 :");
    private JLabel labelP2=new JLabel("Polinom2 :");
    private JLabel resultLabel=new JLabel("Result :");
    private JLabel labelRest=new JLabel("Rest :");
    private JLabel opLabel=new JLabel("Select Operation :");
    private JButton addBtn = new JButton("+");
    private JButton subBtn = new JButton("-");
    private JButton mulBtn = new JButton("∗");
    private JButton divBtn = new JButton("∶");
    private JButton derivBtn = new JButton("Differentiate");
    private JButton integBtn = new JButton("Integrate");

  PolView(){
        //initialising components
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setBackground(new Color(48,213,200));

       calcResult.setEditable(false);
        calcRest.setEditable(false);
        firstPolinom.setMaximumSize( firstPolinom.getPreferredSize() );
        secondPolinom.setMaximumSize( secondPolinom.getPreferredSize() );
       calcResult.setMaximumSize( secondPolinom.getPreferredSize() );
        calcRest.setMaximumSize( secondPolinom.getPreferredSize() );

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BoxLayout(pPrincipal,BoxLayout.Y_AXIS));
        add( pPrincipal );

        JPanel pStDr=new JPanel();
        JPanel pVertSt = new JPanel();
        JPanel pVertDr = new JPanel();
        JPanel pOrizontal= new JPanel();
        pStDr.setLayout(new BoxLayout(pStDr,BoxLayout.X_AXIS));
        pVertSt.setLayout(new BoxLayout(pVertSt,BoxLayout.Y_AXIS));
        pVertDr.setLayout(new BoxLayout(pVertDr, BoxLayout.Y_AXIS));
        pOrizontal.setLayout(new BoxLayout(pOrizontal, BoxLayout.X_AXIS));

        pStDr.add(pVertSt);
        pStDr.add( Box.createRigidArea(new Dimension(20,0)) );
        pStDr.add(pVertDr);

        pPrincipal.add( Box.createRigidArea(new Dimension(0,20)) );
        pPrincipal.add( pStDr);
        pPrincipal.add( Box.createRigidArea(new Dimension(0,20)) );
        pPrincipal.add( pOrizontal );
        pPrincipal.add( Box.createRigidArea(new Dimension(0,20)) );

        pVertSt.add(labelP1);
        pVertSt.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertSt.add(labelP2);
        pVertSt.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertSt.add(resultLabel);
        pVertSt.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertSt.add(labelRest);

        pVertDr.add(firstPolinom);
        pVertDr.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertDr.add(secondPolinom);
        pVertDr.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertDr.add(calcResult);
        pVertDr.add( Box.createRigidArea(new Dimension(0,20)) );
        pVertDr.add(calcRest);

        pOrizontal.add(opLabel);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(addBtn);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(subBtn);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(mulBtn);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(divBtn);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(derivBtn);
        pOrizontal.add( Box.createRigidArea(new Dimension(20,0)) );
        pOrizontal.add(integBtn);

        this.setContentPane(pPrincipal);
        this.setTitle("Calculator polinoame");
        this.setVisible(true);
    }

    //getters/setters
    public String getFirstPolinom() {
        return firstPolinom.getText();
    }

    public String getSecondPolinom() {
        return secondPolinom.getText();
    }

    public void setCalcResult(String calcResult) {
        this.calcResult.setText(calcResult);
    }

    public void setCalcRest(String calcRest) {
        this.calcRest.setText(calcRest);
    }

    //action listener
    void addAddBtnListener(ActionListener l) {
        addBtn.addActionListener(l);
    }
    void addSubBtnListener(ActionListener l) {
        subBtn.addActionListener(l);
    }
    void addMulBtnListener(ActionListener l) {
        mulBtn.addActionListener(l);
    }
    void addDivBtnListener(ActionListener l) {
        divBtn.addActionListener(l);
    }
    void addDerivBtnListener(ActionListener l) {
        derivBtn.addActionListener(l);
    }
    void addIntegBtnListener(ActionListener l) {
        integBtn.addActionListener(l);
    }




}
