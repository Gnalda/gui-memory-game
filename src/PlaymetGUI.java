import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Viewklasse
public class PlaymetGUI extends JFrame {
	private JPanel contentPane;
	private JLabel lblWinner, lblP1Turn, lblP2Turn;
	private JLabel lblSpieler, lblSpieler2;
	private JLabel lblP1, lblP2;
	private JLabel lblPrchen, lblPrchen_1;	

	public PlaymetGUI() {
		setVisible(true);
		setTitle("Memory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWinner = new JLabel();
		lblWinner.setVisible(false);
		lblWinner.setForeground(new Color(253, 246, 238));
		lblWinner.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setBounds(getWidth()/2 - 400, 20, 800, 48);
		contentPane.add(lblWinner);
		
		lblP1Turn = new JLabel("Am Zug");
		lblP1Turn.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblP1Turn.setForeground(Color.green);
		contentPane.add(lblP1Turn);
		
		lblP2Turn = new JLabel("Am Zug");
		lblP2Turn.setVisible(false);
		lblP2Turn.setForeground(Color.green);
		lblP2Turn.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblP2Turn);		
		
		lblSpieler = new JLabel("Spieler 1");
		lblSpieler.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpieler.setForeground(new Color(253, 246, 238));
		lblSpieler.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblSpieler);
		
		lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setForeground(new Color(253, 246, 238));
		lblSpieler2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSpieler2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSpieler2);
		
		lblP1 = new JLabel("🧑");
		lblP1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 120));
		lblP1.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(lblP1);

		lblP2 = new JLabel("🧑");
		lblP2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 120));
		lblP2.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(lblP2);
				
		lblPrchen = new JLabel("P\u00E4rchen: 0");
		lblPrchen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrchen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrchen.setForeground(new Color(253, 246, 238));
		contentPane.add(lblPrchen);
		
		lblPrchen_1 = new JLabel("P\u00E4rchen: 0");
		lblPrchen_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrchen_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrchen_1.setForeground(new Color(253, 246, 238));
		contentPane.add(lblPrchen_1);		
	}

	public void updateFrame(boolean myturnP1, boolean myturnP2, String matchesP1, String matchesP2, boolean haswinner, String winner) {
		lblPrchen.setText("P\u00E4rchen: " + matchesP1);
		lblPrchen_1.setText("P\u00E4rchen: " + matchesP2);
							
		if(haswinner) {
			lblWinner.setText(winner);
			lblWinner.setVisible(haswinner);
		}		
		if(myturnP1) {
			lblP1Turn.setVisible(myturnP1);
			lblP2Turn.setVisible(false);	
		}else if(myturnP2){
			lblP2Turn.setVisible(myturnP2);
			lblP1Turn.setVisible(false);		
		}
	}

	public void positionPlayers(int fieldX, int fieldWidth) {
		int frameWidth = getWidth();
		int frameHeight = getHeight();
		int playerWidth = 300;
		int playerHeight = 450;
		int leftAreaWidth = fieldX;
		int rightAreaStart = fieldX + fieldWidth;
		int rightAreaWidth = frameWidth - rightAreaStart;
		int p1X = (leftAreaWidth - playerWidth) / 2;
		int p2X = rightAreaStart + ((rightAreaWidth - playerWidth) / 2);
		int playerY = (frameHeight - playerHeight) / 2;

		lblP1.setBounds(p1X, playerY, playerWidth, playerHeight);
		lblP2.setBounds(p2X, playerY, playerWidth, playerHeight);
		int baseY = playerY + playerHeight + 5;
		lblSpieler.setBounds(p1X, baseY, playerWidth, 30);
		lblPrchen.setBounds(p1X, baseY + 35, playerWidth, 20);
		lblPrchen.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpieler2.setBounds(p2X, baseY, playerWidth, 30);
		lblPrchen_1.setBounds(p2X, baseY + 35, playerWidth, 20);
		lblPrchen_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1Turn.setBounds(p1X, playerY + playerHeight + 100, playerWidth, 40);
		lblP2Turn.setBounds(p2X, playerY + playerHeight + 100, playerWidth, 40);
		lblP1Turn.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2Turn.setHorizontalAlignment(SwingConstants.CENTER);

		revalidate();
		repaint();
	}
}