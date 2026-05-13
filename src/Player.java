import java.io.IOException;
import java.util.Observable;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Modelklasse
public class Player extends Observable {
	private String name;
	private boolean myturn;
	private int maxFlip, matches;
	private Card firstSelection, secondSelection;
	
	public void selectCard(Card card) throws UnsupportedAudioFileException, IOException, LineUnavailableException {	
		if(maxFlip < 2) { 																				
			if(maxFlip == 0) { //Erste Karte wird umgedreht.											
				card.flipCard(true);
				firstSelection = card;
				maxFlip += 1;
			}else if(maxFlip == 1) { //Zweite Karte wird umgedreht.		
				card.flipCard(true);
				secondSelection = card;
				maxFlip += 1;
				
				if(firstSelection.getFrontSign() == card.getFrontSign()) { //Beide Karten identisch - Match.
					matches += 1;
					maxFlip = 0;  		        
				}else {
					myturn = false;
					maxFlip = 0;
					//Klasse Game (Observer) wird darueber informiert, dass die beiden ausgewaehlten Karten vom Spieler wieder umgedreht werden sollen.
					setChanged();
					notifyObservers(firstSelection);
					setChanged();
					notifyObservers(secondSelection);				
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public boolean isMyturn() {
		return myturn;
	}

	public void setMyturn(boolean myturn) {
		this.myturn = myturn;
	}

	public int getMatches() {
		return matches;
	}

	public int getMaxFlip() {
		return maxFlip;
	}

	public Player(String name, boolean myturn, int matches, int maxFlip, Card firstSelection, Card secondSelection) {
		this.name = name;
		this.myturn = myturn;
		this.matches = matches;
		this.maxFlip = maxFlip;
		this.firstSelection = firstSelection;
		this.secondSelection = secondSelection;
	}
}