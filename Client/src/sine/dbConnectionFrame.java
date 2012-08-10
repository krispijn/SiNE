package sine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class dbConnectionFrame extends JFrame {
    @SuppressWarnings("compatibility:-8806215301504749552")
    private static final long serialVersionUID = 1L;
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JLabel labelPW = new JLabel();
    private JPasswordField databasePWfield = new JPasswordField();
    private JTextField databaseLoginField = new JTextField();
    private JLabel labelLogin = new JLabel();
    private JTextField databaseIPfield = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JButton acceptButton = new JButton();
    
    private mainFrame mainFramePtr;
    private JButton jButton1 = new JButton();

    public dbConnectionFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {

        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        
        this.setSize(new Dimension(319, 226));
        this.setTitle("Database Connection");
        labelPW.setText("Password");
        labelPW.setBounds(new Rectangle(10, 105, 85, 25));
        databasePWfield.setBounds(new Rectangle(95, 105, 200, 25));
        databasePWfield.setPreferredSize(new Dimension(4, 16));
        databasePWfield.setMinimumSize(new Dimension(4, 16));
        databasePWfield.setSize(new Dimension(200, 25));
        databaseLoginField.setBounds(new Rectangle(95, 75, 200, 25));
        databaseLoginField.setSize(new Dimension(200, 25));
        labelLogin.setText("Login");
        labelLogin.setBounds(new Rectangle(10, 75, 85, 25));
        labelLogin.setSize(new Dimension(85, 25));
        databaseIPfield.setBounds(new Rectangle(95, 15, 200, 25));
        databaseIPfield.setSize(new Dimension(200, 25));
        jLabel1.setText("Server");
        jLabel1.setBounds(new Rectangle(10, 15, 85, 25));
        jLabel1.setSize(new Dimension(85, 25));
        acceptButton.setText("Set");
        acceptButton.setBounds(new Rectangle(10, 150, 80, 24));
        acceptButton.setPreferredSize(new Dimension(56, 24));
        acceptButton.setSize(new Dimension(80, 24));
        acceptButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    acceptButton_actionPerformed(e);
                }
            });

        jButton1.setText("Close");
        jButton1.setBounds(new Rectangle(215, 150, 80, 24));
        jButton1.setPreferredSize(new Dimension(56, 24));
        jButton1.setSize(new Dimension(80, 24));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        panelCenter.add(jButton1, null);
        panelCenter.add(acceptButton, null);
        panelCenter.add(jLabel1, null);
        panelCenter.add(databaseIPfield, null);
        panelCenter.add(labelLogin, null);

        panelCenter.add(databaseLoginField, null);
        panelCenter.add(databasePWfield, null);
        panelCenter.add(labelPW, null);
        this.getContentPane().add( panelCenter, BorderLayout.CENTER );
        this.setLocationRelativeTo(null);//center the frame
    }
    public void setMainFrame (mainFrame main){
        this.mainFramePtr = main;
    }
    
    public void setDB (dbConnection db){
        this.databaseIPfield.setText(db.host);
        this.databaseLoginField.setText(db.login);
        this.databasePWfield.setText(db.pw);
    }

    private void acceptButton_actionPerformed(ActionEvent e) {
        dbConnection newDB = new dbConnection (this.databaseIPfield.getText(),
                                               this.databaseLoginField.getText(),
                                               new String(this.databasePWfield.getPassword()));
        try {
            
            this.mainFramePtr.testDBconnection(newDB);
            this.mainFramePtr.setDBconnection(newDB);
            this.mainFramePtr.setConnectionValidity(true);
            
            JOptionPane.showMessageDialog(this,"Succesfully connected to: "+ newDB.host);
            
        } catch (SQLException sqle) {     
            JOptionPane.showMessageDialog(this,"Error code: " + sqle.getErrorCode() + "\n" + sqle.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
            this.mainFramePtr.setConnectionValidity(false);
        } catch (Exception f){
            JOptionPane.showMessageDialog(this,"An unknown error occurred.","Error",JOptionPane.WARNING_MESSAGE);
        }
        
        this.mainFramePtr.repaint();
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
