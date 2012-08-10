package sine;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;


public class mainFrame_AboutBoxPanel extends JPanel {
    private GridBagLayout layoutMain = new GridBagLayout();
    private Border border = BorderFactory.createEtchedBorder();
    private JTextPane jTextPane1 = new JTextPane();

    public mainFrame_AboutBoxPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( layoutMain );
        this.setBorder( border );
        this.setPreferredSize(new Dimension(400, 300));
        this.setMinimumSize(new Dimension(400, 300));
        this.setMaximumSize(new Dimension(400, 300));
        this.add(jTextPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 1, 1), 9, 50));
        
        jTextPane1.setPage(mainFrame_AboutBoxPanel.class.getResource("about.html"));
        jTextPane1.setBounds(new Rectangle(0, 0, 320, 240));
        jTextPane1.setMaximumSize(new Dimension(320, 240));
        jTextPane1.setMinimumSize(new Dimension(320, 240));
        jTextPane1.setPreferredSize(new Dimension(320, 240));
        jTextPane1.setBackground(SystemColor.menu);
        jTextPane1.setSize(new Dimension(400, 300));
    }
}
