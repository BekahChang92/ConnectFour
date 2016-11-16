package ConnectFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConnectFour.Board;
import java.util.Scanner;
/**
 *
 * @author rebekah
 */
public class ConnectFour extends JFrame{
    
    private JPanel content;
    private char[][] board;
    private CardLayout cl;
    public ConnectFour(){
        super("Connect Four");
        Board boardObj = new Board();
        cl = new CardLayout();
        char[][] board=boardObj.getCurrentBoard();
        JButton[][] connect4board = new JButton[board[0].length][board.length];
        content = new JPanel();
        content.setLayout(cl);
        //welcome screen or panel
        JPanel welcome = new JPanel();
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.PAGE_AXIS));
        JLabel welcomeText = new JLabel("Let's play Connect 4!");
        JLabel startText = new JLabel("Press 'Start' to being the game!");
        JButton startButton = new JButton("Start");
        
        welcome.add(welcomeText);
        welcome.add(startText);
        welcome.add(startButton, "Start");
        content.add(welcome, "Welcome");
        
        //game screen or panel
        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel player1panel, player2panel;
        player1panel = new JPanel();
        player2panel = new JPanel();
        player1panel.setLayout(new BoxLayout(player1panel, BoxLayout.PAGE_AXIS));
        player2panel.setLayout(new BoxLayout(player2panel, BoxLayout.PAGE_AXIS));
        JLabel player1label = new JLabel("PLAYER 1");
        player1panel.add(player1label);
        JLabel player2label = new JLabel("PLAYER 2");
        player2panel.add(player2label);
        JPanel gameBoard = new JPanel( new GridLayout(board[0].length, board.length));
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j<board.length; j++) {
                connect4board[i][j] = new JButton(String.valueOf(board[i][j]));
                connect4board[i][j].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        boardObj.placeChip(j, player);
                        ae.getSource();                 
                    }
                });
                gameBoard.add(connect4board[i][j]);
            }
        }
        gamePanel.add(player1panel, "PLAYER1");
        gamePanel.add(gameBoard, "BOARD");
        gamePanel.add(player2panel, "PLAYER2");
        content.add(gamePanel, "Game");
        getContentPane().add(content);
        cl.show(content, "Welcome");
        setSize(800,800);
        setVisible(true);
        
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cl.show(content, "Game");
            }
        });
        boolean winnerNotFound=true;
    }
    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Connect Four!");
        System.out.println("Please type the name of player 1: ");
        player1 = sc.next();
        System.out.println("Please type the name of player 2: ");
        player2 = sc.next(); */
        Board board1 = new Board();
        char[][]board = board1.getCurrentBoard();
        ConnectFour connectFour = new ConnectFour();
    }
} 

