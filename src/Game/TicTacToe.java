package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TicTacToe {

	private
		
		Players nextPlayer;
		int magescore, paladinscore; 
		List<Integer> chess, chess1, chess2;
		List<List<Integer>> chessWin;
	
	public TicTacToe(Players firstPlayer) {
		magescore = 0;
		paladinscore = 0;
		chess1 = new ArrayList();
		chess2 = new ArrayList();
		chess = new ArrayList();
		nextPlayer = firstPlayer;
		
		ChessWin temp = new ChessWin();
		chessWin = temp.returnChessWin();
	}
	
	// enter one step for one player
	public States enterStep(int position) {
		if(chess.contains(position)) {
			return States.illegal_position;
		}
		
		if(nextPlayer == Players.mage) {
			chess1.add(position);
			System.out.println("chess1 " + chess1.toString());
			
			nextPlayer = Players.paladin;
		}
		else if(nextPlayer == Players.paladin) {
			chess2.add(position);
			System.out.println("chess2 " + chess2.toString());
			
			nextPlayer = Players.mage;
		}
		// record positions occupied
		chess.add(position);
		
		States state = isGameFinished();
		return state;
	}
	
	public void setNextPlayer(Players p) {
		nextPlayer = p;
	}
	
	public Players getNextPlayer() {
		return nextPlayer;
	}
	
	public String getScores() {
		return paladinscore + " : " + magescore;
	}
	
	private States isGameFinished() {
		if(chess.isEmpty()) {
			return States.continue_game;
		}
		
		// which player gets the step list that can win
		for(int i = 0 ; i < 8 ; i++) {
			if(chess1.containsAll(chessWin.get(i))) {
				System.out.println("mage win");
				
				magescore++;
				
				chess.clear();
				chess1.clear();
				chess2.clear();
				
				return States.mage_win;
			}
			else if(chess2.containsAll(chessWin.get(i))){
				System.out.println("paladin win");
				
				paladinscore ++;
				
				chess.clear();
				chess1.clear();
				chess2.clear();
				
				return States.paladin_win;
			}
		}
		
		// all positions are occupied
		if(chess.size() == 9) {
			System.out.println("no winner");
			
			chess.clear();
			chess1.clear();
			chess2.clear();
			
			return States.no_winner;
		}
		
		return States.continue_game;
	}
	
}

