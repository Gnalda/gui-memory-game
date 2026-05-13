import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Controllerklasse
public class ActionHandler implements ActionListener {
	private Card card;
	private Player playerA, playerB;
	private Game memoryGame;
	private PlaymetGUI playmetGUI;
	private MemoryGUI memoryGUI;
	
	public ActionHandler(MemoryGUI memoryGUI) {
	    this.memoryGUI = memoryGUI; 	        
	}
	
	public ActionHandler(Card card, Player playerA, Player playerB, Game memoryGame, PlaymetGUI playmetGUI) {
		this.card = card;
		this.playerA = playerA;
		this.playerB = playerB;
		this.memoryGame = memoryGame;
		this.playmetGUI = playmetGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Eventtrigger aus dem Menue.	
		if(e.getActionCommand().equals("16 Karten")|e.getActionCommand().equals("36 Karten")| e.getActionCommand().equals("64 Karten")) {	
			memoryGUI.setVisible(false);	
				
			//Neues Spiel und View wird erzeugt.
			playmetGUI = new PlaymetGUI();			
			memoryGame = new Game();
			memoryGame.setNumberCards(Integer.valueOf(e.getActionCommand().substring(0,2)));
			try {
				playmetGUI.getContentPane().add(memoryGame.createGameFrame((int) Math.sqrt(Integer.parseInt(e.getActionCommand().substring(0,2))), (int) Math.sqrt(Integer.parseInt(e.getActionCommand().substring(0,2))), playmetGUI));
			}catch (Exception e1) {
				e1.printStackTrace();
			}			
	    //Eventtrigger aus den Memorykarten.
		}else {	
			//Spieler 1 ist am Zug und dreht Karten um. View wird aktualisiert.
			if(playerA.isMyturn() == true && card.isFlipped() == false) {
				try {
					playerA.selectCard(card);
					playmetGUI.updateFrame(playerA.isMyturn(), playerB.isMyturn(), String.valueOf(playerA.getMatches()), String.valueOf(playerB.getMatches()), false, ""); 					
				}catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}		
				//Spielerwechsel. View wird aktualisiert.
				if(playerA.isMyturn() == false) {
					playerB.setMyturn(true);
					playmetGUI.updateFrame(playerA.isMyturn(), playerB.isMyturn(), String.valueOf(playerA.getMatches()), String.valueOf(playerB.getMatches()), false, ""); 
				}
			//Spieler 2 ist am Zug und dreht Karten um. View wird aktualisiert.
			}else if(playerB.isMyturn() == true && card.isFlipped() == false) {
				try {
					playerB.selectCard(card);
				    playmetGUI.updateFrame(playerA.isMyturn(), playerB.isMyturn(), String.valueOf(playerA.getMatches()), String.valueOf(playerB.getMatches()), false, ""); 	
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				//Spielerwechsel. View wird aktualisiert.
				if(playerB.isMyturn() == false) {
					playerA.setMyturn(true);
					playmetGUI.updateFrame(playerA.isMyturn(), playerB.isMyturn(), String.valueOf(playerA.getMatches()), String.valueOf(playerB.getMatches()), false, ""); 
				}
			}
			
			//Spiel ist beendet. View wird aktualisiert.
			if(playerA.getMatches() + playerB.getMatches() == memoryGame.getNumberCards() / 2 ) {
				playmetGUI.updateFrame(playerA.isMyturn(), playerB.isMyturn(), String.valueOf(playerA.getMatches()), String.valueOf(playerB.getMatches()), true, memoryGame.evaluateGameResult(playerA, playerB)); 			
			}			
		}		
	}	
}