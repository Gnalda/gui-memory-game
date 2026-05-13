import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

//Viewklasse
public class MemoryGUI extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MemoryGUI();
			}
		});
	}

	public MemoryGUI() {
		setTitle("Memory");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 664);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cptMemory = new JLabel("Memory");
		cptMemory.setFont(new Font("Palace Script MT", Font.BOLD, 99));
		cptMemory.setBounds(479, 38, 254, 92);
		contentPane.add(cptMemory);

		JButton btn4x4 = new JButton("16 Karten");
		btn4x4.setForeground(new Color(253, 246, 238));
		btn4x4.setBackground(new Color(70, 40, 20));
		btn4x4.setFont(new Font("Algerian", Font.BOLD, 20));
		btn4x4.setBounds(165, 174, 214, 94);	
		btn4x4.addActionListener(new ActionHandler(this));	
		contentPane.add(btn4x4);
		
		JButton btn6x6= new JButton("36 Karten");
		btn6x6.setForeground(new Color(253, 246, 238));
		btn6x6.setBackground(new Color(70, 40, 20));
		btn6x6.setFont(new Font("Algerian", Font.BOLD, 20));
		btn6x6.setBounds(59, 314, 214, 94);
		btn6x6.addActionListener(new ActionHandler(this));
		contentPane.add(btn6x6);
		
		JButton btn8x8= new JButton("64 Karten");
		btn8x8.setBackground(new Color(70, 40, 20));
		btn8x8.setForeground(new Color(253, 246, 238));
		btn8x8.setFont(new Font("Algerian", Font.BOLD, 20));
		btn8x8.setBounds(165, 459, 214, 94);
		btn8x8.addActionListener(new ActionHandler(this)); 	
		contentPane.add(btn8x8);
		
		JLabel lblMen = new JLabel("Men\u00FC");
		lblMen.setHorizontalAlignment(SwingConstants.CENTER);
		lblMen.setFont(new Font("Algerian", Font.BOLD, 99));
		lblMen.setBounds(59, 27, 276, 92);
		contentPane.add(lblMen);
		
		JLabel lblSpielenMit = new JLabel("Spielen mit...");
		lblSpielenMit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpielenMit.setFont(new Font("Algerian", Font.BOLD, 20));
		lblSpielenMit.setBounds(127, 137, 154, 26);
		contentPane.add(lblSpielenMit);
	
		JLabel lblbackground = new JLabel();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/misc-img/menue.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1200, 700, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		lblbackground.setIcon(imageIcon);
		lblbackground.setBounds(0, 0, 1200, 700);
		contentPane.add(lblbackground);
	}	        
}
