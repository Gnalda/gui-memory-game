import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

//Modelklasse
public class Game implements Observer {
	private ArrayList<Character> tempShuffleHelper = new ArrayList<Character>();
	private int numberCards;
	
	public int getNumberCards() {
		return numberCards;
	}

	public void setNumberCards(int matchLength) {
		this.numberCards = matchLength;
	}

	public JPanel createGameFrame(int xLen, int yLen, PlaymetGUI playmetGUI) {
		int frameWidth = playmetGUI.getWidth();
		int frameHeight = playmetGUI.getHeight();
		int sideSpace = 450;
		int topBottomSpace = 200;
		int availableWidth = frameWidth - (sideSpace * 2);
		int availableHeight = frameHeight - topBottomSpace;
		int cardWidth = availableWidth / xLen;
		int cardHeight = availableHeight / yLen;
		int cardSize = Math.min(cardWidth, cardHeight);

		JPanel cardpanel = new JPanel();
		cardpanel.setBounds(0, 0, (cardSize * xLen), (cardSize * yLen));
		cardpanel.setLayout(null);

		char img = 65;
		int btnX = 0;
		int btnY = 0;

		Player playerA = new Player("Spieler 1", true, 0, 0, null, null);
		Player playerB = new Player("Spieler 2", false, 0, 0, null, null);

		playerA.addObserver(this);
		playerB.addObserver(this);

		shuffleCards(img, false, xLen, yLen);

		ImageIcon coverIcon = new ImageIcon(getClass().getResource("/assets/misc-img/coverBackside.jpg"));
		Image coverScaled = coverIcon.getImage().getScaledInstance(cardSize, cardSize, Image.SCALE_SMOOTH);
		ImageIcon coverFinal = new ImageIcon(coverScaled);

		Card[][] card = new Card[xLen][yLen];
		for (int x = 0; x < xLen; x++) {
			for (int y = 0; y < yLen; y++) {
				card[x][y] = new Card(shuffleCards(img, true, xLen, yLen), false, cardSize);
				card[x][y].setBounds(btnX, btnY, cardSize, cardSize);
				card[x][y].addActionListener(new ActionHandler(card[x][y], playerA, playerB, this, playmetGUI));
				card[x][y].setIcon(coverFinal);
				cardpanel.add(card[x][y]);

				btnX += cardSize;
				if (btnX == (cardSize * xLen)) {
					btnX = 0;
					btnY += cardSize;
				}
			}
    	}
		centerPlaymet(cardpanel, playmetGUI.getWidth(), playmetGUI.getHeight());
		playmetGUI.positionPlayers(cardpanel.getX(), cardpanel.getWidth());
		return cardpanel;
	}
	
	public void centerPlaymet(JPanel cardpanel, int widthFrame, int heightFrame) {
		int calcX = (widthFrame - cardpanel.getWidth()) / 2;
		int calcY = (heightFrame - cardpanel.getHeight()) / 2;
		cardpanel.setBounds(calcX, calcY, cardpanel.getWidth(), cardpanel.getHeight());
	}

	public char shuffleCards(char cover, boolean shufflePrepared, int xlength, int ylength) {
		char tempImg = cover;
		int tempCounter = 1;
			
		if(shufflePrepared) { //Bereits gemischte Hilfsarrayliste stellt jedem neu erzeugten Katenobjekt sein Kartensymbol bereit. Das zugewiesene Symbol wird anschliessend aus der Liste entfernt.	
			cover = tempShuffleHelper.get(0);					
			tempShuffleHelper.remove(0);

		}else { //Symbole der Karten werden in der Hilfsarrayliste vorab gespeichert und gemischt.
			for(int i = 0; i < xlength * ylength; i++) {			
				tempShuffleHelper.add(tempImg);	
							
				if(tempCounter % 2 == 0) {
						tempImg++;
				}	
				tempCounter++;						 
			}	 			
		Collections.shuffle(tempShuffleHelper);
		}
		return cover;
	}
		
	public String evaluateGameResult(Player playerA, Player playerB) {		
		// Spielauswertung		
		if (playerA.getMatches() > playerB.getMatches()) {
			return playerA.getName() + " hat gewonnen! Herzlichen Glueckwunsch!";		
		} else if (playerA.getMatches() < playerB.getMatches()) {
			return playerB.getName() + " hat gewonnen! Herzlichen Glueckwunsch!";		
		} else {			
			return "Das Spiel endet unentschieden!";
		}
	}

	@Override
	public void update(Observable o, Object card) {
		//Game Klasse wird vom Spieler informiert, welche Karten wieder umgedreht werden sollen.
		Card observedCard = (Card) card;
			
		ActionListener turnover = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					observedCard.flipCard(false);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}				    
			}
		};	
		//Event mit Zeitzerzoegerung fuer das bessere Wahrnehmen der letzten umgedrehten Karte, bevor sie wieder umgedreht wird.
		Timer timer = new Timer(500, turnover);
		timer.setRepeats(false);
		timer.start();		
	}		
}