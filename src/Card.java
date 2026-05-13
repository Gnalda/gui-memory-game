import java.awt.Image;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//Modelklasse
public class Card extends JButton{
	private  char frontSign;
	private  boolean flipped;
	private int cardSize;

	public char getFrontSign() {
		return frontSign;
	}

	public boolean isFlipped() {
		return flipped;
	}

	public Card(char frontSign, boolean flipped, int cardSize) {
		this.frontSign = frontSign;
		this.flipped = flipped;
		this.cardSize = cardSize;
	}

	public void flipCard(boolean uncover) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (uncover) {
			String path;
			if (frontSign == 92) {
				path = resolveImagePath("/assets/card-img/exception");
			} else {
				path = resolveImagePath("/assets/card-img/" + frontSign);
			}
			ImageIcon imageIconFront = new ImageIcon(getClass().getResource(path));
			Image newimg = imageIconFront.getImage().getScaledInstance(cardSize, cardSize, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(newimg));
			flipped = true;
		} else {
			ImageIcon imageIconBack = new ImageIcon(getClass().getResource("/assets/misc-img/coverBackside.jpg"));
			Image newimg2 = imageIconBack.getImage().getScaledInstance(cardSize, cardSize, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(newimg2));
			flipped = false;
		}
	}
	
	//Hilfsmethode
	private String resolveImagePath(String basePath) {
		if (getClass().getResource(basePath + ".jpg") != null) return basePath + ".jpg";
		if (getClass().getResource(basePath + ".JPG") != null) return basePath + ".JPG";
		return basePath + ".jpg"; // Fallback
	}
}