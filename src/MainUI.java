package accentureutils.myte;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;

public class MainUI extends JFrame{
	private JTextField txtUsername;
	private JTextField txtPassword;
	public MainUI() {
		constructOuterBox();
	}
	
	public void constructOuterBox() {
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, 500, 200, 50, 50));
		//setLocationRelativeTo(null);
		
		getContentPane().add(constructCredsBox());
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblUsername = new JLabel("Username");
		getContentPane().add(lblUsername, "4, 6, right, default");
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		getContentPane().add(txtUsername, "6, 6, fill, default");
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		getContentPane().add(lblPassword, "4, 8, right, default");
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		getContentPane().add(txtPassword, "6, 8, fill, default");
		txtPassword.setColumns(10);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public CredsBox constructCredsBox() {
		return new CredsBox();
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
	
	class CredsBox extends JPanel {

	    @Override
	    protected void paintComponent(Graphics g) {
	        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	    }
	}

}
