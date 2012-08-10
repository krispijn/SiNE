package sine;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class objectDetailsFrame extends JFrame {

    private mainFrame theMainFrame; //a reference to the mainFrame. Global options (such as DB connection) are stored here.
    private objectOverview theOverview;
    private JButton btnSave = new JButton();
    private JButton btnCancel = new JButton();
    private Integer mode = 1; //this defines how the "Save" action is handeled: 1 is for "Add", 2 is for "Edit". Default = 1
    private objectDetailPanel details;

    public objectDetailsFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        details = new objectDetailPanel();
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(1073, 634));
        this.setTitle( "Object Details" );
        btnSave.setText("Save");
        btnSave.setBounds(new Rectangle(745, 535, 125, 35));
        btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnSave_actionPerformed(e);
                }
            });
        btnCancel.setText("Cancel");
        btnCancel.setBounds(new Rectangle(900, 535, 125, 35));
        btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnCancel_actionPerformed(e);
                }
            });
        this.getContentPane().add(btnCancel, null);
        this.getContentPane().add(btnSave, null);
        this.add(details);
        this.setLocationRelativeTo(null);//center the frame
    }
    
    public void setMainFrame(mainFrame theMF){
        this.theMainFrame = theMF;
    }
    public void setOverview(objectOverview frame){
        this.theOverview = frame;
    }
    
    public void setModeAdd() {
        this.mode = 1;
    }
    public void setModeEdit(){
        this.mode = 2;
    }

    private void btnCancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
    public void setObject(SineObject obj){
        details.setObject(obj);
    }
    public SineObject getObject(){
        return details.getObject();
    }

    private void btnSave_actionPerformed(ActionEvent e) {
        dbConnection theConnection = this.theMainFrame.getDBconnection();
        
        switch (this.mode){
        case 1:
            //ADD
            dbQueries Queries = new dbQueries();
            try{
                Queries.createObject(this.details.getObject(),theConnection);
            }
            catch(Exception f) {
                JOptionPane.showMessageDialog(this,"An unknown error occurred.\n"+"Error: "+f.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            }
            
        case 2:
            //UPDATE
        }
        try{
            theOverview.getObjectsFromDB();
        }
        catch (Exception f){
        }
        
        //after saving, close window
        this.dispose();
    }
    
}
