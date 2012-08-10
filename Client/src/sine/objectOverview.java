package sine;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class objectOverview extends JFrame {
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JLabel statusBar = new JLabel();
    private JButton buttonAddObject = new JButton();
    private JButton buttonEditObject = new JButton();
    private JButton buttonRemoveObject = new JButton();
    private mainFrame theMainFrame;
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable objectListTable = new JTable();
    private JButton btnClose = new JButton();

    public objectOverview() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        this.setSize(new Dimension(1054, 504));
        this.setTitle( "Objects in database" );
        this.setResizable(false);
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        statusBar.setText( "" );
        buttonAddObject.setText("Add");
        buttonAddObject.setBounds(new Rectangle(5, 406, 81, 20));
        buttonAddObject.setActionCommand("addObject");
        buttonAddObject.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonAddObject_actionPerformed(e);
                }
            });
        buttonEditObject.setText("Edit");
        buttonEditObject.setBounds(new Rectangle(95, 406, 80, 20));
        buttonEditObject.setActionCommand("editObject");
        buttonEditObject.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonEditObject_actionPerformed(e);
                }
            });
        buttonRemoveObject.setText("Remove");
        buttonRemoveObject.setBounds(new Rectangle(185, 406, 81, 20));
        buttonRemoveObject.setActionCommand("removeObject");
        buttonRemoveObject.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonRemoveObject_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(5, 10, 1035, 385));
        jScrollPane1.setSize(new Dimension(1040, 385));
        btnClose.setText("Close");
        btnClose.setBounds(new Rectangle(965, 406, 75, 20));
        btnClose.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnClose_actionPerformed(e);
                }
            });
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        this.getContentPane().add( statusBar, BorderLayout.SOUTH );
        jScrollPane1.getViewport().add(objectListTable, null);
        panelCenter.add(btnClose, null);
        panelCenter.add(jScrollPane1, null);
        panelCenter.add(buttonRemoveObject, null);
        panelCenter.add(buttonEditObject, null);
        panelCenter.add(buttonAddObject, null);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);//center the frame
    }

    public void setMainFrame(mainFrame theMF){
        this.theMainFrame = theMF;
    }

    public void getObjectsFromDB() throws Exception {
        dbConnection theConnection = this.theMainFrame.getDBconnection();
        
        //This method repopulates the JTable with results from our database
        Connection con;
        Statement stmnt;
        String query;
        ResultSet rs;
        
        String url,user,pass;
        
        url = "jdbc:mysql://" + theConnection.host + "/sine_object";
        user = theConnection.login;
        pass = theConnection.pw;
                
        Object rowData[][] = {{"R1C1","R1C2","R1C3","R1C4","R1C5"}};
        Object columnNames[] = {"ID","Name","Type","Domain","Description"};
        
        DefaultTableModel defTableModel = new DefaultTableModel(rowData,columnNames);
        objectListTable.setModel(defTableModel);
        
        //attempt data connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection)DriverManager.getConnection(url, user, pass);
        
        //the overview query
        query = "SELECT IDOBJECT, NAME, TYPE, DOMAIN, DESCRIPTION FROM object";
        stmnt = (Statement)con.createStatement();      
        rs = stmnt.executeQuery(query);
        
        //now we build our table
        defTableModel.removeRow(0);
        Object[] rows;
        while (rs.next()) {
            rows = new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
            defTableModel.addRow(rows);
        }
     
     
    }
    void fileExit_ActionPerformed(ActionEvent e) {
        this.dispose(); // not a system.exit; this will exit main app
    }

    private void buttonAddObject_actionPerformed(ActionEvent e) {
        objectDetailsFrame objectDetails = new objectDetailsFrame();
        objectDetails.setMainFrame(this.theMainFrame);
        objectDetails.setOverview(this);
        objectDetails.setVisible(true);
    }

    private void buttonEditObject_actionPerformed(ActionEvent e) {
        dbQueries dbq = new dbQueries();
        SineObject editObj;
        int objID;
        int row;
        
        row = this.objectListTable.getSelectedRow();
        objID = Integer.decode((String)this.objectListTable.getValueAt(row, 0));


        try {
            editObj = dbq.selectObject(objID, theMainFrame.getDBconnection());
        } catch (Exception f) {
            //Cannot fetch object
            return;
        }
        
        objectDetailsFrame objectDetails = new objectDetailsFrame();
        objectDetails.setMainFrame(this.theMainFrame);
        objectDetails.setOverview(this);
        objectDetails.setModeEdit();
        objectDetails.setObject(editObj);
        objectDetails.setVisible(true);
    }

    private void btnClose_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void buttonRemoveObject_actionPerformed(ActionEvent e) {
        //get object id from table, then remove
        int objID;
        dbQueries dbq = new dbQueries();


        int noObjToDelete = this.objectListTable.getSelectedRowCount();
        
        if (noObjToDelete > 0) {
            if (JOptionPane.showConfirmDialog(this,"This will delete "+ noObjToDelete + " object(s) from the database. Continue?","Warning",  
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                
                int rows[] = this.objectListTable.getSelectedRows();

                for (int index : rows){
                    objID = Integer.decode((String)this.objectListTable.getValueAt(index, 0));
                
                    try {
                        dbq.removeObject(objID, this.theMainFrame.getDBconnection());
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(this,"Removing of object no. "+ objID + " failed.\n"+"Error: "+f.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                try {
                    getObjectsFromDB();
                } catch (Exception f) {
                }
            }
        }
    }
}
