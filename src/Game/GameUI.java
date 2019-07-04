package Game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameUI extends JFrame {
	
	MyMouseAdapter myMouseAdapter;
	
	JPanel startwin, gamewin, finishwin;
	
	// for start window
	JLabel button_roleChoice1, button_roleChoice2, button_start;
	
	// for game window
	JLabel label_nextPlayer;
	JLabel c1, c2, c3, c4, c5, c6, c7, c8, c9;
	
	// for finish window
	JLabel button_continue, button_exit;
	
	TicTacToe game;
	Players firstPlayer = Players.mage; 
	
	private enum Windows {
		start_window, game_window, finish_window_no_winner, finish_window_mage_win, finish_window_paladin_win
	}
	
	public GameUI() {
		initUI();
		game = new TicTacToe(firstPlayer);
	}
	
	private void startGame() {
		game.setNextPlayer(firstPlayer);
		goToWindow(Windows.game_window);
	}
	
	private void finishGame(States state) {
		if(state == States.mage_win) {
			goToWindow(Windows.finish_window_mage_win);
		}
		else if(state == States.paladin_win) {
			goToWindow(Windows.finish_window_paladin_win);
		}
		else {
			goToWindow(Windows.finish_window_no_winner);
		}
	}
	
	private void initUI() {
		// listener for all label
		myMouseAdapter = new MyMouseAdapter();
		
		// show the start window
		goToWindow(Windows.start_window);
		
		// set the frame
		this.setTitle("TicTacToe");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void goToWindow(Windows win) {				
		// JPanel with GridLayout
		if(win == Windows.start_window) {
			// change to startWindow			
	    	startwin = new JPanelWithBG(Resources.startWinBG);
	    	startwin.setSize(600, 600);
	    	startwin.setLayout(new GridLayout(6,1));
	    	
	    	this.add(startwin, BorderLayout.CENTER);
			
	    	// empty label
			JLabel e1 = new JLabel();
			JLabel e2 = new JLabel();
			JLabel e3 = new JLabel();
	    	
			// three button implied with label
			ImageIcon img = new ImageIcon(Resources.roleChoice1);
			button_roleChoice1 = new JLabel(img);
			button_roleChoice1.addMouseListener(myMouseAdapter);
			
			img = new ImageIcon(Resources.roleChoice2);
			button_roleChoice2 = new JLabel(img);
			button_roleChoice2.addMouseListener(myMouseAdapter);
			
			img = new ImageIcon(Resources.start);
			button_start = new JLabel(img);
			button_start.addMouseListener(myMouseAdapter);
			
			startwin.add(e1);
			startwin.add(e2);
			startwin.add(e3);
			startwin.add(button_roleChoice1);
			startwin.add(button_roleChoice2);
			startwin.add(button_start);
			
			System.out.println("start window showed");
		}
		
		else if(win == Windows.game_window) {
			// change to GameWindow
			if(startwin != null) this.remove(startwin);
			if(finishwin != null) this.remove(finishwin);
			
						
			gamewin = new JPanelWithBG(Resources.gameWinBG);
			gamewin.setSize(600, 600);
			gamewin.setLayout(new GridLayout(5, 5));
			
			this.add(gamewin, BorderLayout.CENTER);
			
			// empty label			
			JLabel g1 = new JLabel();
			JLabel g2 = new JLabel();
			JLabel g3 = new JLabel();
			JLabel g4 = new JLabel();
			JLabel g5 = new JLabel();
			JLabel g6 = new JLabel();
			JLabel g7 = new JLabel();
			JLabel g8 = new JLabel();
			JLabel g9 = new JLabel();
			JLabel g10 = new JLabel();
			JLabel g11 = new JLabel();
			JLabel g12 = new JLabel();
			JLabel g13 = new JLabel();
			JLabel g14 = new JLabel();
			JLabel g15 = new JLabel();
			
			// nextPlayer button and nine chess position
			label_nextPlayer = new JLabel();
			
			c1 = new JLabel();
			c2 = new JLabel();
			c3 = new JLabel();
			c4 = new JLabel();
			c5 = new JLabel();
			c6 = new JLabel();
			c7 = new JLabel();
			c8 = new JLabel();
			c9 = new JLabel();
			
			c1.addMouseListener(myMouseAdapter);
			c2.addMouseListener(myMouseAdapter);
			c3.addMouseListener(myMouseAdapter);
			c4.addMouseListener(myMouseAdapter);
			c5.addMouseListener(myMouseAdapter);
			c6.addMouseListener(myMouseAdapter);
			c7.addMouseListener(myMouseAdapter);
			c8.addMouseListener(myMouseAdapter);
			c9.addMouseListener(myMouseAdapter);
			
			gamewin.add(g1);
			gamewin.add(g2);
			gamewin.add(g3);
			gamewin.add(g4);
			gamewin.add(label_nextPlayer);
			gamewin.add(g5);
			gamewin.add(c1);
			gamewin.add(c2);
			gamewin.add(c3);
			gamewin.add(g6);
			gamewin.add(g7);
			gamewin.add(c4);
			gamewin.add(c5);
			gamewin.add(c6);
			gamewin.add(g8);
			gamewin.add(g9);
			gamewin.add(c7);
			gamewin.add(c8);
			gamewin.add(c9);
			gamewin.add(g10);
			gamewin.add(g11);
			gamewin.add(g12);
			gamewin.add(g13);
			gamewin.add(g14);
			gamewin.add(g15);
			
			changeNextPlayerUI();
			
			System.out.println("game window showed");
		}
		else {
			// change to finish window
			gamewin.setVisible(false);
			
			if(win == Windows.finish_window_mage_win)
				finishwin = new JPanelWithBG(Resources.finishWinBG_mage);
			else if(win == Windows.finish_window_paladin_win)
				finishwin = new JPanelWithBG(Resources.finishWinBG_paladin);
			else
				finishwin = new JPanelWithBG(Resources.finishWinBG_draw);
			
			finishwin.setSize(600, 600);
			finishwin.setLayout(new GridLayout(5, 1));
			
			this.add(finishwin, BorderLayout.CENTER);
			
			// empty label			
			JLabel f1 = new JLabel();
			JLabel f2 = new JLabel();
			
			// score label and two buttons
			JLabel label_socre = new JLabel(game.getScores(), SwingConstants.CENTER);
			label_socre.setFont(new Font("TimesRoman", Font.BOLD, 18));
			
			ImageIcon img = new ImageIcon(Resources.nextround);
			button_continue = new JLabel(img);
			button_continue.addMouseListener(myMouseAdapter);
			
			img = new ImageIcon(Resources.exitgame);
			button_exit = new JLabel(img);
			button_exit.addMouseListener(myMouseAdapter);
			
			finishwin.add(f1);
			finishwin.add(f2);
			finishwin.add(label_socre);
			finishwin.add(button_continue);
			finishwin.add(button_exit);
			
			System.out.println("finish window showed");
		}
	}
	
	private void changeNextPlayerUI() {
		String path = "";
		if(game.getNextPlayer() == Players.mage) path = Resources.magehead;
		else path = Resources.paladinhead;
		
		ImageIcon img = new ImageIcon(path);
		label_nextPlayer.setIcon(img);
		System.out.println("set next player icon");
	}

	private void addEmptyLabel(int num) {
		// empty label
		for(int i = 0 ; i < num ; i++) {
			JLabel s1;
			s1 = new JLabel();
			this.add(s1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameUI();
	}
	
	class MyMouseAdapter extends  MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			// draw a circle on the choice and record the choice
			if(e.getSource() == button_roleChoice1) {
				ImageIcon img = new ImageIcon(Resources.roleChoice1_select);
				button_roleChoice1.setIcon(img);
				img = new ImageIcon(Resources.roleChoice2);
				button_roleChoice2.setIcon(img);
				
				firstPlayer = Players.mage;
				System.out.println("mage go first");
			}
			// draw a circle on the choice and record the choice
			else if(e.getSource() == button_roleChoice2) {
				ImageIcon img = new ImageIcon(Resources.roleChoice1);
				button_roleChoice1.setIcon(img);
				img = new ImageIcon(Resources.roleChoice2_select);
				button_roleChoice2.setIcon(img);
				
				firstPlayer = Players.paladin;
				System.out.println("paladin go first");
			}
			// start the game or next round
			else if(e.getSource() == button_start || e.getSource() == button_continue) {
				System.out.println("start");
				startGame();
			}
			// put one chess
			else if(e.getSource() == c1 || e.getSource() == c2 || e.getSource() == c3 || e.getSource() == c4 || e.getSource() == c5 || 
					e.getSource() == c6 || e.getSource() == c7 || e.getSource() == c8 || e.getSource() == c9) {
				System.out.println(e.getSource().toString());
				
				// record the chess owner
				Players currentPlayer = game.getNextPlayer();
				
				// enter one step
				States state = States.no_meaning;
				if(e.getSource() == c1) state = game.enterStep(1);
				else if (e.getSource() == c2) state = game.enterStep(2);
				else if (e.getSource() == c3) state = game.enterStep(3);
				else if (e.getSource() == c4) state = game.enterStep(4);
				else if (e.getSource() == c5) state = game.enterStep(5);
				else if (e.getSource() == c6) state = game.enterStep(6);
				else if (e.getSource() == c7) state = game.enterStep(7);
				else if (e.getSource() == c8) state = game.enterStep(8);
				else if (e.getSource() == c9) state = game.enterStep(9);
				
				// game finish
				if(state == States.mage_win) {
					System.out.println("mage_win finish");
					finishGame(state);
				}
				else if(state == States.paladin_win) {
					System.out.println("paladin_win finish");
					finishGame(state);
				}
				else if(state == States.no_winner) {
					System.out.println("no_winner finish");
					finishGame(state);
				}
				// game continue
				else if(state == States.continue_game) {
					// put one chess
					if(currentPlayer == Players.mage) {
						ImageIcon img = new ImageIcon(Resources.magechess);
						JLabel label = (JLabel) e.getSource();
						label.setIcon(img);
					}
					else {
						ImageIcon img = new ImageIcon(Resources.paladinchess);
						JLabel label = (JLabel) e.getSource();
						label.setIcon(img);
					}
					
					// change the label of next player
					changeNextPlayerUI();
				}
				// for debug
				else if(state == States.illegal_position) {
					System.out.println("illegal position");
				}
			}
			// exit the game
			else if(e.getSource() == button_exit) {
				System.exit(0);
			}
		}
		
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == button_start) {
				ImageIcon img = new ImageIcon(Resources.start_select);
				button_start.setIcon(img);
			}
			else if(e.getSource() == button_continue) {
				ImageIcon img = new ImageIcon(Resources.nextround_select);
				button_continue.setIcon(img);
			}
			else if(e.getSource() == button_exit) {
				ImageIcon img = new ImageIcon(Resources.exitgame_select);
				button_exit.setIcon(img);
			}
		}
		
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == button_start) {
				ImageIcon img = new ImageIcon(Resources.start);
				button_start.setIcon(img);
			}
			else if(e.getSource() == button_continue) {
				ImageIcon img = new ImageIcon(Resources.nextround);
				button_continue.setIcon(img);
			}
			else if(e.getSource() == button_exit) {
				ImageIcon img = new ImageIcon(Resources.exitgame);
				button_exit.setIcon(img);
			}
		}
	}
}
