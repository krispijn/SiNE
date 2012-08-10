package sine;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class mainFrame extends JFrame {
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JLabel statusBar = new JLabel();
    private ImageIcon imageOpen = new ImageIcon(mainFrame.class.getResource("openfile.gif"));
    private ImageIcon imageClose = new ImageIcon(mainFrame.class.getResource("closefile.gif"));
    private ImageIcon imageHelp = new ImageIcon(mainFrame.class.getResource("help.gif"));
    private JMenu menuDatabase = new JMenu();
    private JMenuItem menuDatabaseConnection = new JMenuItem();
    private JMenuItem menuDatabaseObjects = new JMenuItem();
    
    //database defaults
    private dbConnection dbConnect = new dbConnection("localhost","root","KrisBee1981");
    private boolean connectionValid = false;
    private JMenuItem menuDatabaseScenarios = new JMenuItem();

    public mainFrame() {
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
        this.setSize(new Dimension(640, 480));
        this.setTitle( "SiNE" );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText( "Help" );
        menuHelpAbout.setText( "About" );
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        statusBar.setText( "" );
        statusBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        statusBar.setSize(new Dimension(1089, 16));
        statusBar.setPreferredSize(new Dimension(4, 16));
        statusBar.setMinimumSize(new Dimension(4, 16));
        statusBar.setMaximumSize(new Dimension(4, 16));
        menuDatabase.setText("Database");
        menuDatabaseConnection.setText("Connection");
        menuDatabaseConnection.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuDatabaseConnection_actionPerformed(e);
                }
            });
        menuDatabaseObjects.setText("Objects");
        menuDatabaseObjects.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuDatabaseObjects_actionPerformed(e);
                }
            });
        menuDatabaseScenarios.setText("Scenario's");
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        menuDatabase.add(menuDatabaseObjects);
        menuDatabase.add(menuDatabaseScenarios);
        menuDatabase.addSeparator();
        menuDatabase.add(menuDatabaseConnection);
        menuBar.add(menuDatabase);
        menuHelp.add(menuHelpAbout);
        menuBar.add(menuHelp);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
        this.getContentPane().add(panelCenter, BorderLayout.NORTH);
        //TODO this.setIconImage(image);

        try {
            testDBconnection(dbConnect);
            this.setConnectionValidity(true);
        } catch (Exception e) {
            this.setConnectionValidity(false);
            System.err.println(e.getMessage());
        }
    }            

    public void setConnectionValidity(boolean valid) {
        this.connectionValid = valid;
        
        if (this.connectionValid) {
            statusBar.setText("connected to: " + dbConnect.host);
        } else {
            statusBar.setText("not connected");
        }
    }

    public void setStatus(String message){
        this.statusBar.setText(message);
    }

    public void setDBconnection(dbConnection db) throws Exception {
        this.dbConnect = db;
    }
    
    public dbConnection getDBconnection(){
        return this.dbConnect;
    }
    
    public boolean testDBconnection(dbConnection db) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =
            (Connection)DriverManager.getConnection(
                              "jdbc:mysql://" + db.host + "/sine_object",
                              db.login, db.pw);

        try {
            Statement stmnt = (Statement)conn.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM object");
            //System.out.println( "number of columns: " + rs.getMetaData().getColumnCount() );

            rs.close();
            stmnt.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //sqle.printStackTrace();
            return false;
        }
        
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new mainFrame_AboutBoxPanel(), "About", JOptionPane.PLAIN_MESSAGE);
    }

    private void menuDatabaseObjects_actionPerformed(ActionEvent e) {
        objectOverview theFrame = new objectOverview();
        theFrame.setMainFrame(this);

        try {
            theFrame.getObjectsFromDB();
        } catch (Exception f) {
        }
        
        theFrame.setVisible(true);
    }

    private void menuDatabaseConnection_actionPerformed(ActionEvent e) {
        dbConnectionFrame theFrame = new dbConnectionFrame();
        theFrame.setMainFrame(this);
        theFrame.setDB(this.dbConnect);
        theFrame.setVisible(true);
    }
}
