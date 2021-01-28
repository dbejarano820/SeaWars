/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Game.Casilla;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PERSONAL
 */
public class PantallaCliente extends javax.swing.JFrame {

    
    public Cliente refCliente;
    String nombreTurno;
    
    public PantallaCliente() {
        initComponents();
        nombreTurno = ""; 

    }
    
    public void setCliente(Cliente refCliente){
        this.refCliente = refCliente;
    }
    
    public void setNombreTurno(String player){
        this.nombreTurno = player;
    }
    
    public void pintarTurno(String player){
        this.nombreTurno = player;
        lblTurnoPlayer.setText(player);
    }

    public void generarTablero(){

        for(int row = 0; row < refCliente.tableroCliente.length; row++){  //refCliente.tableroCliente.length
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){ //refCliente.tableroCliente[row].length
                refCliente.tableroCliente[row][col] = new Casilla();  
                JLabel labelTmp = refCliente.tableroCliente[row][col].generateLabel();
                this.jPanel1.add(labelTmp);
                labelTmp.setLocation(((col*20)), ((row*20))); 
            }
        }
    }
    
    
    public void colorMatriz(){
        
        for(int row = 0; row < refCliente.tableroCliente.length; row++)
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){
                
                if(refCliente.tableroCliente[row][col].heroOwner.equals(lblHero1Name.getText()))
                    refCliente.tableroCliente[row][col].refLabel.setBackground(Color.cyan); 
                else if(refCliente.tableroCliente[row][col].heroOwner.equals(lblHero2Name.getText()))
                    refCliente.tableroCliente[row][col].refLabel.setBackground(Color.orange);
                else if(refCliente.tableroCliente[row][col].heroOwner.equals(lblHero3Name.getText()))
                    refCliente.tableroCliente[row][col].refLabel.setBackground(Color.gray);      
            }  
    }
    
    
    public void mostrarVivas(){
        
        for(int row = 0; row < refCliente.tableroCliente.length; row++)
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++)
                if(refCliente.tableroCliente[row][col].vida == 0 && !refCliente.tableroCliente[row][col].activeVolcano && !refCliente.tableroCliente[row][col].activeWhirlpool)
                    refCliente.tableroCliente[row][col].refLabel.setText("X");
    }
    
    
    
    public void mostrarVolcanesRemolinos(String pathVolcan, String pathWhirlpool){
        
        for(int row = 0; row < refCliente.tableroCliente.length; row++)
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){
                
                 if(refCliente.tableroCliente[row][col].activeVolcano){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathVolcan).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                 }
                 else if(refCliente.tableroCliente[row][col].activeWhirlpool){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathWhirlpool).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                 }
            }
    }
    
    public void addHistory(String msj){
        txtBitacora.append(msj + "\n");
    }
    
    
    public void addLastPlay(String msj){
        txtLastPlay.setText("");
        txtLastPlay.setText(msj + "\n"); 
    }
    
    public void addConsolaMsj(String msj){
        txtConsole.append(msj + "\n");
    }
    
    public void updateVida(int life){
        lblHealthNum.setText(life + "");
    }
    
    public void updateMuertas(int muertas){
        lblCasillasDestroyedNum.setText(muertas + "");
    }    
    
    public void addHeroInfo1(String nombre, String msj){
        lblHero1Name.setText(nombre);
        txtHero1.setText(msj);
    }
    
    public void updateHero1Info(String info){
        txtHero1.setText(info);
    }
    
    public void setInfoHero1Tablero(String nombre, String info){
        lblHero1Tablero.setText(nombre);
        txtHero1Tablero.append(info);
    }
    
    public void addInfoHero1Tablero(String info){
        txtHero1Tablero.setText("");
        txtHero1Tablero.setText(info);
    }
   
    public void addHero1Image(String path){
        lblHero1.setSize(140, 150);
        lblHero1.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT)));
    }
    
     public void addHeroInfo2(String nombre, String msj){
        lblHero2Name.setText(nombre);
        txtHero2.setText(msj);
    }   
     
     
    public void updateHero2Info(String info){
        txtHero2.setText(info);
    }
     
     public void addHero2Image(String path){
        lblHero2.setSize(140, 150);
        lblHero2.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT)));
    }
     
     public void setInfoHero2Tablero(String nombre, String info){
        lblHero2Tablero.setText(nombre);
        txtHero2Tablero.append(info);
    }    
     
    public void addInfoHero2Tablero(String info){
        txtHero2Tablero.setText("");
        txtHero2Tablero.setText("");
        txtHero2Tablero.setText(info);
    }
     
     public void setInfoHero3Tablero(String nombre, String info){
        lblHero3Tablero.setText(nombre);
        txtHero3Tablero.append(info);
    }    
     
    public void addInfoHero3Tablero(String info){
        txtHero3Tablero.setText("");
        txtHero3Tablero.setText(info);
    } 
     
     public void addHeroInfo3(String nombre, String msj){
        lblHero3Name.setText(nombre);
        txtHero3.setText(msj);
    }  
     
    public void updateHero3Info(String info){
        txtHero3.setText(info);
    }
        
     public void addHero3Image(String path){
        lblHero3.setSize(140, 150);
        lblHero3.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCasillasDestroyed = new javax.swing.JLabel();
        lblHealthNum = new javax.swing.JLabel();
        lblCasillasDestroyedNum = new javax.swing.JLabel();
        lblHealt = new javax.swing.JLabel();
        lblHero3Name = new javax.swing.JLabel();
        lblHero2Name = new javax.swing.JLabel();
        lblHero1Name = new javax.swing.JLabel();
        lblHero3Tablero = new javax.swing.JLabel();
        lblHero2Tablero = new javax.swing.JLabel();
        lblHero1Tablero = new javax.swing.JLabel();
        txtHero3Tablero = new java.awt.TextArea();
        txtHero1Tablero = new java.awt.TextArea();
        txtHero2Tablero = new java.awt.TextArea();
        txtHero1 = new java.awt.TextArea();
        txtHero2 = new java.awt.TextArea();
        txtHero3 = new java.awt.TextArea();
        jPanel1 = new javax.swing.JPanel();
        txtConsole = new java.awt.TextArea();
        txtFieldConsole = new java.awt.TextField();
        btnSend = new javax.swing.JButton();
        txtLastPlay = new java.awt.TextArea();
        txtBitacora = new java.awt.TextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblHero3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblHero1 = new javax.swing.JLabel();
        lblHero2 = new javax.swing.JLabel();
        jLabel609 = new javax.swing.JLabel();
        jLabel610 = new javax.swing.JLabel();
        lblTurnoPlayer = new javax.swing.JLabel();
        lblTurn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1813, 1050));
        getContentPane().setLayout(null);

        lblCasillasDestroyed.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCasillasDestroyed.setForeground(new java.awt.Color(0, 0, 0));
        lblCasillasDestroyed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCasillasDestroyed.setText("Casillas destroyed:");
        getContentPane().add(lblCasillasDestroyed);
        lblCasillasDestroyed.setBounds(1050, 460, 230, 30);

        lblHealthNum.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblHealthNum.setForeground(new java.awt.Color(0, 0, 0));
        lblHealthNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHealthNum.setText("100%");
        getContentPane().add(lblHealthNum);
        lblHealthNum.setBounds(670, 460, 70, 30);

        lblCasillasDestroyedNum.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCasillasDestroyedNum.setForeground(new java.awt.Color(0, 0, 0));
        lblCasillasDestroyedNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCasillasDestroyedNum.setText("0");
        getContentPane().add(lblCasillasDestroyedNum);
        lblCasillasDestroyedNum.setBounds(1280, 460, 60, 30);

        lblHealt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblHealt.setForeground(new java.awt.Color(0, 0, 0));
        lblHealt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHealt.setText("Health:");
        getContentPane().add(lblHealt);
        lblHealt.setBounds(580, 460, 90, 30);

        lblHero3Name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero3Name.setForeground(java.awt.Color.gray);
        lblHero3Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero3Name);
        lblHero3Name.setBounds(1590, 400, 160, 30);

        lblHero2Name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero2Name.setForeground(java.awt.Color.orange);
        lblHero2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero2Name);
        lblHero2Name.setBounds(1590, 220, 160, 30);

        lblHero1Name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero1Name.setForeground(java.awt.Color.cyan);
        lblHero1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero1Name);
        lblHero1Name.setBounds(1590, 40, 180, 30);

        lblHero3Tablero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero3Tablero.setForeground(java.awt.Color.gray);
        lblHero3Tablero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero3Tablero);
        lblHero3Tablero.setBounds(1170, 490, 180, 30);

        lblHero2Tablero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero2Tablero.setForeground(java.awt.Color.orange);
        lblHero2Tablero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero2Tablero);
        lblHero2Tablero.setBounds(890, 490, 180, 30);

        lblHero1Tablero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHero1Tablero.setForeground(java.awt.Color.cyan);
        lblHero1Tablero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblHero1Tablero);
        lblHero1Tablero.setBounds(600, 490, 180, 30);
        getContentPane().add(txtHero3Tablero);
        txtHero3Tablero.setBounds(1170, 520, 180, 70);
        getContentPane().add(txtHero1Tablero);
        txtHero1Tablero.setBounds(600, 520, 180, 70);
        getContentPane().add(txtHero2Tablero);
        txtHero2Tablero.setBounds(890, 520, 180, 70);
        getContentPane().add(txtHero1);
        txtHero1.setBounds(1590, 80, 180, 130);
        getContentPane().add(txtHero2);
        txtHero2.setBounds(1590, 260, 180, 130);
        getContentPane().add(txtHero3);
        txtHero3.setBounds(1590, 440, 180, 140);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(680, 50, 600, 400);
        getContentPane().add(txtConsole);
        txtConsole.setBounds(580, 620, 1200, 330);
        getContentPane().add(txtFieldConsole);
        txtFieldConsole.setBounds(570, 970, 1130, 20);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend);
        btnSend.setBounds(1720, 970, 70, 25);
        getContentPane().add(txtLastPlay);
        txtLastPlay.setBounds(20, 720, 520, 260);
        getContentPane().add(txtBitacora);
        txtBitacora.setBounds(20, 70, 520, 530);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("2");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(660, 90, 20, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("1");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(660, 70, 20, 20);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("3");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(660, 110, 20, 20);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("4");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(660, 130, 20, 20);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("5");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(660, 150, 20, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("6");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(660, 170, 20, 20);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("7");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(660, 190, 20, 20);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("8");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(660, 210, 20, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("9");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(660, 230, 20, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("10");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(660, 250, 20, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("11");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(660, 270, 20, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("12");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(660, 290, 20, 20);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("13");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(660, 310, 20, 20);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("14");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(660, 330, 20, 20);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("15");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(660, 350, 20, 20);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("16");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(660, 370, 20, 20);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("0");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(660, 50, 20, 20);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("18");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(660, 410, 20, 20);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("17");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(660, 390, 20, 20);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("19");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(660, 430, 20, 20);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText(" 0   1   2   3   4   5   6   7   8   9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(680, 30, 600, 20);

        lblHero3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblHero3);
        lblHero3.setBounds(1420, 400, 140, 150);

        jLabel2.setToolTipText("");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 610, 1220, 350);

        jLabel7.setToolTipText("");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(570, 20, 810, 440);

        lblHero1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblHero1);
        lblHero1.setBounds(1420, 40, 140, 150);

        lblHero2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblHero2);
        lblHero2.setBounds(1420, 220, 140, 150);

        jLabel609.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel609.setForeground(new java.awt.Color(0, 0, 0));
        jLabel609.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel609.setText("Last play");
        getContentPane().add(jLabel609);
        jLabel609.setBounds(170, 680, 180, 40);

        jLabel610.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel610.setForeground(new java.awt.Color(0, 0, 0));
        jLabel610.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel610.setText("Bitacora");
        getContentPane().add(jLabel610);
        jLabel610.setBounds(180, 30, 180, 40);

        lblTurnoPlayer.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTurnoPlayer.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTurnoPlayer);
        lblTurnoPlayer.setBounds(160, 620, 340, 40);

        lblTurn.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTurn.setForeground(new java.awt.Color(0, 0, 0));
        lblTurn.setText("Turn:");
        getContentPane().add(lblTurn);
        lblTurn.setBounds(30, 620, 160, 40);

        jLabel1.setToolTipText("");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 610, 540, 380);

        jLabel3.setToolTipText("");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 20, 540, 650);

        jLabel4.setToolTipText("");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 20, 810, 580);

        jLabel5.setToolTipText("");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 20, 810, 580);

        jLabel6.setToolTipText("");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1390, 20, 400, 580);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoCliente.jpg"))); // NOI18N
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 1800, 1000);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        
        try{
            
            txtConsole.append("> " + txtFieldConsole.getText() + "\n");
            refCliente.hiloPlayer.writer.writeInt(2);
            refCliente.hiloPlayer.writer.writeUTF(refCliente.nombre);
            refCliente.hiloPlayer.writer.writeUTF(txtFieldConsole.getText());
            txtFieldConsole.setText("");
            
        } catch (IOException ex){
            
        }
        
        
    }//GEN-LAST:event_btnSendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel609;
    private javax.swing.JLabel jLabel610;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCasillasDestroyed;
    private javax.swing.JLabel lblCasillasDestroyedNum;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblHealt;
    private javax.swing.JLabel lblHealthNum;
    private javax.swing.JLabel lblHero1;
    private javax.swing.JLabel lblHero1Name;
    private javax.swing.JLabel lblHero1Tablero;
    private javax.swing.JLabel lblHero2;
    private javax.swing.JLabel lblHero2Name;
    private javax.swing.JLabel lblHero2Tablero;
    private javax.swing.JLabel lblHero3;
    private javax.swing.JLabel lblHero3Name;
    private javax.swing.JLabel lblHero3Tablero;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JLabel lblTurnoPlayer;
    private java.awt.TextArea txtBitacora;
    private java.awt.TextArea txtConsole;
    private java.awt.TextField txtFieldConsole;
    private java.awt.TextArea txtHero1;
    private java.awt.TextArea txtHero1Tablero;
    private java.awt.TextArea txtHero2;
    private java.awt.TextArea txtHero2Tablero;
    private java.awt.TextArea txtHero3;
    private java.awt.TextArea txtHero3Tablero;
    private java.awt.TextArea txtLastPlay;
    // End of variables declaration//GEN-END:variables
}
