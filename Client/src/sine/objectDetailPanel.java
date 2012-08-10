package sine;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import javax.swing.JTextField;

import javax.swing.SwingConstants;

import oracle.jdeveloper.layout.PaneLayout;
import oracle.jdeveloper.layout.VerticalFlowLayout;
import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class objectDetailPanel extends JPanel {
    private JTabbedPane tabbedPaneResources = new JTabbedPane();
    private JPanel sensorPanel = new JPanel();
    private JPanel weaponPanel = new JPanel();
    private JPanel cargoPanel = new JPanel();
    private JPanel crewPanel = new JPanel();
    private JPanel propulsionPanel = new JPanel();
    private JPanel commsPanel = new JPanel();
    private JPanel generalPanel = new JPanel();
    private JPanel navigationPanel = new JPanel();
    private JLabel labelDomain = new JLabel();
    private JLabel labelType = new JLabel();
    private JLabel labelName = new JLabel();
    private JLabel labelObjectID = new JLabel();
    private XYLayout xYLayout1 = new XYLayout();
    private JTextField tfObjectNo = new JTextField();
    private JTextField tfName = new JTextField();
    private JComboBox cbDomain = new JComboBox();
    private JComboBox cbType = new JComboBox();
    private JSeparator jSeparator1 = new JSeparator();
    private JLabel labelLength = new JLabel();
    private JNrTextField tfLength = new JNrTextField();
    private JLabel labelWidth = new JLabel();
    private JNrTextField tfWidth = new JNrTextField();
    private JLabel labelHeight = new JLabel();
    private JNrTextField tfHeight = new JNrTextField();
    private JLabel labelDraught = new JLabel();
    private JNrTextField tfDraught = new JNrTextField();
    private JLabel labelDiameter = new JLabel();
    private JNrTextField tfDiameter = new JNrTextField();
    private JLabel labelWeight = new JLabel();
    private JNrTextField tfWeight = new JNrTextField();
    private transient SineObject sourceObject = new SineObject();
    private JLabel labelMaxSpeed = new JLabel();
    private JNrTextField tfMaxSpeed = new JNrTextField();
    private JComboBox cbLengthUnits = new JComboBox();
    private JLabel labelMinSpeed = new JLabel();
    private JNrTextField tfMinSpeed = new JNrTextField();
    private JComboBox cbMinSpeedUnits = new JComboBox();
    private JLabel labelCruisingSpeed = new JLabel();
    private JNrTextField tfCruisingSpeed = new JNrTextField();
    private JComboBox cbCruisingSpeedUnits = new JComboBox();
    private JComboBox cbMaxSpeedUnits = new JComboBox();
    private JComboBox cbWidthUnits = new JComboBox();
    private JComboBox cbHeightUnits = new JComboBox();
    private JComboBox cbDraughtUnits = new JComboBox();
    private JComboBox cbDiameterUnits = new JComboBox();
    private JComboBox cbWeightUnits = new JComboBox();
    private JLabel labelDisplacement = new JLabel();
    private JNrTextField tfDisplacement = new JNrTextField();
    private JComboBox cbDisplacementUnits = new JComboBox();
    private JLabel labelMaxAltitude = new JLabel();
    private JNrTextField tfMaxAltitude = new JNrTextField();
    private JLabel labelMinAltitude = new JLabel();
    private JNrTextField tfMinAltitude = new JNrTextField();
    private JComboBox cbMaxAltitudeUnits = new JComboBox();
    private JComboBox cbMinAltitudeUnits = new JComboBox();
    private JLabel labelMaxRange = new JLabel();
    private JNrTextField tfMaxRange = new JNrTextField();
    private JComboBox cbMaxRangeUnits = new JComboBox();
    private JLabel labelMinRange = new JLabel();
    private JNrTextField tfMinRange = new JNrTextField();
    private JComboBox cbMinRangeUnits = new JComboBox();

    public objectDetailPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(1046, 532));
        tabbedPaneResources.setBounds(new Rectangle(15, 10, 1015, 500));
        generalPanel.setLayout(xYLayout1);
        labelDomain.setText("Domain");
        labelDomain.setSize(new Dimension(80, 16));
        labelType.setText("Type");
        labelType.setSize(new Dimension(80, 16));
        labelName.setText("Name");
        labelName.setSize(new Dimension(175, 32));
        labelName.setHorizontalAlignment(SwingConstants.LEFT);
        labelObjectID.setText("Object No.");
        labelObjectID.setSize(new Dimension(170, 32));
        tfObjectNo.setSize(new Dimension(240, 32));
        tfObjectNo.setEditable(false);
        tfName.setSize(new Dimension(240, 32));
        generalPanel.add(cbMinRangeUnits, new XYConstraints(365, 395, 65, 25));
        generalPanel.add(tfMinRange, new XYConstraints(190, 395, 175, 25));
        generalPanel.add(labelMinRange, new XYConstraints(20, 395, 170, 25));
        generalPanel.add(cbMaxRangeUnits, new XYConstraints(365, 365, 65, 25));
        generalPanel.add(tfMaxRange, new XYConstraints(190, 365, 175, 25));
        generalPanel.add(labelMaxRange, new XYConstraints(20, 365, 170, 25));
        generalPanel.add(cbMinAltitudeUnits, new XYConstraints(365, 320, 65, 25));
        generalPanel.add(cbMaxAltitudeUnits, new XYConstraints(365, 290, 65, 25));
        generalPanel.add(tfMinAltitude, new XYConstraints(190, 320, 175, 25));
        generalPanel.add(labelMinAltitude, new XYConstraints(20, 320, 170, 25));
        generalPanel.add(tfMaxAltitude, new XYConstraints(190, 290, 175, 25));
        generalPanel.add(labelMaxAltitude, new XYConstraints(20, 290, 170, 25));
        generalPanel.add(cbDisplacementUnits, new XYConstraints(885, 305, 65, 25));
        generalPanel.add(tfDisplacement, new XYConstraints(650, 305, 235, 25));
        generalPanel.add(labelDisplacement, new XYConstraints(515, 305, 170, 25));
        generalPanel.add(cbWeightUnits, new XYConstraints(885, 270, 65, 25));
        generalPanel.add(cbDiameterUnits, new XYConstraints(885, 235, 65, 25));
        generalPanel.add(cbDraughtUnits, new XYConstraints(885, 200, 65, 25));
        generalPanel.add(cbHeightUnits, new XYConstraints(885, 165, 65, 25));
        generalPanel.add(cbWidthUnits, new XYConstraints(885, 130, 65, 25));
        generalPanel.add(cbMaxSpeedUnits, new XYConstraints(365, 185, 65, 25));
        generalPanel.add(cbCruisingSpeedUnits, new XYConstraints(365, 245, 65, 25));
        generalPanel.add(tfCruisingSpeed, new XYConstraints(190, 245, 175, 25));
        generalPanel.add(labelCruisingSpeed, new XYConstraints(20, 245, 170, 25));
        generalPanel.add(cbMinSpeedUnits, new XYConstraints(365, 215, 65, 25));
        generalPanel.add(tfMinSpeed, new XYConstraints(190, 215, 175, 25));
        generalPanel.add(labelMinSpeed, new XYConstraints(20, 215, 170, 25));
        generalPanel.add(cbLengthUnits, new XYConstraints(885, 95, 65, 25));
        generalPanel.add(tfMaxSpeed, new XYConstraints(190, 185, 175, 25));
        generalPanel.add(labelMaxSpeed, new XYConstraints(20, 185, 170, 25));
        generalPanel.add(tfWeight, new XYConstraints(650, 270, 235, 25));
        generalPanel.add(labelWeight, new XYConstraints(515, 270, 170, 25));
        generalPanel.add(tfDiameter, new XYConstraints(650, 235, 235, 25));
        generalPanel.add(labelDiameter, new XYConstraints(515, 235, 170, 25));
        generalPanel.add(tfDraught, new XYConstraints(650, 200, 235, 25));
        generalPanel.add(labelDraught, new XYConstraints(515, 200, 170, 25));
        generalPanel.add(tfHeight, new XYConstraints(650, 165, 235, 25));
        generalPanel.add(labelHeight, new XYConstraints(515, 165, 170, 25));
        generalPanel.add(tfWidth, new XYConstraints(650, 130, 235, 25));
        generalPanel.add(labelWidth, new XYConstraints(515, 130, 170, 25));
        generalPanel.add(tfLength, new XYConstraints(650, 95, 235, 25));
        generalPanel.add(labelLength, new XYConstraints(515, 95, 170, 25));
        generalPanel.add(jSeparator1, new XYConstraints(10, 75, 965, 5));
        generalPanel.add(cbType, new XYConstraints(190, 95, 240, 25));
        generalPanel.add(cbDomain, new XYConstraints(190, 135, 240, 25));
        generalPanel.add(tfName, new XYConstraints(505, 30, 445, 25));
        generalPanel.add(tfObjectNo, new XYConstraints(190, 30, 110, 25));
        generalPanel.add(labelObjectID, new XYConstraints(20, 30, 170, 25));
        generalPanel.add(labelName, new XYConstraints(335, 30, 170, 25));
        generalPanel.add(labelType, new XYConstraints(20, 95, 170, 25));
        generalPanel.add(labelDomain, new XYConstraints(20, 135, 170, 25));
        tabbedPaneResources.addTab("General", generalPanel);
        tabbedPaneResources.addTab("Sensors", sensorPanel);
        tabbedPaneResources.addTab("Weapons", weaponPanel);
        tabbedPaneResources.addTab("Cargo", cargoPanel);
        tabbedPaneResources.addTab("Crew", crewPanel);
        tabbedPaneResources.addTab("Propulsion", propulsionPanel);
        tabbedPaneResources.addTab("Comms", commsPanel);
        tabbedPaneResources.addTab("Navigation", navigationPanel);
        this.add(tabbedPaneResources, null);
        labelLength.setText("Length");
        labelLength.setSize(new Dimension(128, 25));
        labelLength.setHorizontalAlignment(SwingConstants.LEFT);
        tfLength.setHorizontalAlignment(JTextField.RIGHT);
        labelWidth.setText("Width");
        labelWidth.setSize(new Dimension(128, 25));
        labelWidth.setHorizontalAlignment(SwingConstants.LEFT);
        tfWidth.setHorizontalAlignment(JTextField.RIGHT);
        labelHeight.setText("Height");
        labelHeight.setSize(new Dimension(128, 25));
        labelHeight.setHorizontalAlignment(SwingConstants.LEFT);
        tfHeight.setHorizontalAlignment(JTextField.RIGHT);
        labelDraught.setText("Draught");
        labelDraught.setSize(new Dimension(128, 25));
        labelDraught.setHorizontalAlignment(SwingConstants.LEFT);
        tfDraught.setHorizontalAlignment(JTextField.RIGHT);
        labelDiameter.setText("Diameter");
        labelDiameter.setSize(new Dimension(128, 25));
        labelDiameter.setHorizontalAlignment(SwingConstants.LEFT);
        tfDiameter.setHorizontalAlignment(JTextField.RIGHT);
        labelWeight.setText("Weight");
        labelWeight.setSize(new Dimension(128, 25));
        labelWeight.setHorizontalAlignment(SwingConstants.LEFT);
        tfWeight.setHorizontalAlignment(JTextField.RIGHT);
        labelMaxSpeed.setText("Max Speed");
        labelMaxSpeed.setSize(new Dimension(128, 25));
        labelMaxSpeed.setHorizontalAlignment(SwingConstants.LEFT);
        tfMaxSpeed.setHorizontalAlignment(JTextField.RIGHT);
        labelMinSpeed.setText("Min Speed");
        labelMinSpeed.setSize(new Dimension(128, 25));
        labelMinSpeed.setHorizontalAlignment(SwingConstants.LEFT);
        tfMinSpeed.setHorizontalAlignment(JTextField.RIGHT);
        labelCruisingSpeed.setText("Cruising Speed");
        labelCruisingSpeed.setSize(new Dimension(128, 25));
        labelCruisingSpeed.setHorizontalAlignment(SwingConstants.LEFT);
        tfCruisingSpeed.setHorizontalAlignment(JTextField.RIGHT);
        
        //set comboboxes
        cbDomain.setModel(new DefaultComboBoxModel(Enum.Domain.values()));
        cbType.setModel(new DefaultComboBoxModel(Enum.Type.values()));
        
        cbMinSpeedUnits.setModel(new DefaultComboBoxModel(Enum.SpeedUnits.values()));
        cbCruisingSpeedUnits.setModel(new DefaultComboBoxModel(Enum.SpeedUnits.values()));
        cbMaxSpeedUnits.setModel(new DefaultComboBoxModel(Enum.SpeedUnits.values()));
        
        cbLengthUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbWidthUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbHeightUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbDraughtUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbDiameterUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbWeightUnits.setModel(new DefaultComboBoxModel(Enum.MassUnits.values()));
        cbDisplacementUnits.setModel(new DefaultComboBoxModel(Enum.MassUnits.values()));

        labelMaxAltitude.setText("Max Altitude");
        labelMaxAltitude.setSize(new Dimension(128, 25));
        labelMaxAltitude.setHorizontalAlignment(SwingConstants.LEFT);
        tfMaxAltitude.setHorizontalAlignment(JTextField.RIGHT);
        labelDisplacement.setText("Displacement");
        labelDisplacement.setSize(new Dimension(128, 25));
        labelDisplacement.setHorizontalAlignment(SwingConstants.LEFT);
        tfDisplacement.setHorizontalAlignment(JTextField.RIGHT);
        labelMinAltitude.setText("Min Altitude");
        labelMinAltitude.setSize(new Dimension(128, 25));
        labelMinAltitude.setHorizontalAlignment(SwingConstants.LEFT);
        tfMinAltitude.setHorizontalAlignment(JTextField.RIGHT);
        labelMaxRange.setText("Max Range");
        labelMaxRange.setSize(new Dimension(128, 25));
        labelMaxRange.setHorizontalAlignment(SwingConstants.LEFT);
        tfMaxRange.setHorizontalAlignment(JTextField.RIGHT);
        labelMinRange.setText("Min Range");
        labelMinRange.setSize(new Dimension(128, 25));
        labelMinRange.setHorizontalAlignment(SwingConstants.LEFT);
        tfMinRange.setHorizontalAlignment(JTextField.RIGHT);
        
        cbMaxAltitudeUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbMinAltitudeUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbMaxRangeUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        cbMinRangeUnits.setModel(new DefaultComboBoxModel(Enum.LengthUnits.values()));
        
    }

    private void jButton3_actionPerformed(ActionEvent e) {
    }
    
    public void setObject (SineObject obj){
        // sets an object as data source
        this.sourceObject = obj;
        updateFieldsFromObject();
        this.repaint();
    }
    public SineObject getObject () {
        // returns object (updated from fields)
        updateObjectFromFields();
        return this.sourceObject;
    }
    private void updateFieldsFromObject(){
        tfObjectNo.setText(sourceObject.idObject.toString());
        tfName.setText(sourceObject.name);
        
        tfMaxSpeed.setFloat(sourceObject.maxSpeed);
        tfMinSpeed.setFloat(sourceObject.minSpeed);
        tfCruisingSpeed.setFloat(sourceObject.cruisingSpeed);
        
        tfMaxAltitude.setFloat(sourceObject.maxAltitude);
        tfMinAltitude.setFloat(sourceObject.minAltitude);
        
        tfMaxRange.setFloat(sourceObject.maxRange);
        tfMinRange.setFloat(sourceObject.minRange);
        
        //updates all fields from the current source object
        tfLength.setFloat(sourceObject.structure.length);
        tfWidth.setFloat(sourceObject.structure.width);
        tfHeight.setFloat(sourceObject.structure.height);
        tfDraught.setFloat(sourceObject.structure.draught);
        tfDiameter.setFloat(sourceObject.structure.diameter);
        tfWeight.setFloat(sourceObject.structure.weight);
        tfDisplacement.setFloat(sourceObject.structure.displacement);
        
        cbDomain.setSelectedItem(sourceObject.domain);
        cbType.setSelectedItem(sourceObject.type);
    }
    private void updateObjectFromFields(){
        this.sourceObject.name = this.tfName.getText();
        this.sourceObject.domain = (Enum.Domain)this.cbDomain.getSelectedItem();
        this.sourceObject.type = (Enum.Type)this.cbType.getSelectedItem();
        this.sourceObject.cruisingSpeed = this.tfCruisingSpeed.getFloat(); // in m/s (convert for display purposes
        this.sourceObject.maxSpeed = this.tfMaxSpeed.getFloat(); // in m/s
        this.sourceObject.minSpeed = this.tfMinSpeed.getFloat(); // in m/s
        this.sourceObject.maxAltitude = this.tfMaxAltitude.getFloat(); // in m
        this.sourceObject.minAltitude = this.tfMinAltitude.getFloat(); // in m
        this.sourceObject.maxRange = this.tfMaxRange.getFloat(); // in m
        this.sourceObject.minRange = this.tfMinRange.getFloat(); // in m
        
        this.sourceObject.ID = null; //TODO;
        this.sourceObject.description =  null; //TODO;
        
        this.sourceObject.structure.length = this.tfLength.getFloat(); // length in m
        this.sourceObject.structure.width = this.tfWidth.getFloat(); // in m
        this.sourceObject.structure.height = this.tfHeight.getFloat(); // in m
        this.sourceObject.structure.draught = this.tfDraught.getFloat(); // in m
        this.sourceObject.structure.diameter = this.tfDiameter.getFloat(); // in m
        this.sourceObject.structure.weight = this.tfWeight.getFloat(); // in kg
        this.sourceObject.structure.displacement = this.tfDisplacement.getFloat(); 
        
    }
}
