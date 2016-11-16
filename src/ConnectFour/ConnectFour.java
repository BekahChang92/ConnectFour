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
public class ConnectFour /*extends JFrame*/{
    
    private JFrame connect4;
    private JPanel content, gamePanel, welcome, player1panel, player2panel;
    private char[][] board;
    private CardLayout cl;
    public Player player= Player.PlayerOne;
    public int turns =0;

    RoundButton[][] connect4board;
    Board boardObj = new Board();
    public ConnectFour(){
        connect4 = new JFrame("Connect Four");
        connect4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl = new CardLayout();
        char[][] board=boardObj.getCurrentBoard();
        connect4board = new RoundButton[board[0].length][board.length];
        content = new JPanel();
        content.setLayout(cl);
        //welcome screen or panel
        welcome = new JPanel();
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.PAGE_AXIS));
        JLabel welcomeText = new JLabel("Let's play Connect 4!");
        Font welcomeTextFont=new Font(welcomeText.getFont().getName(),welcomeText.getFont().getStyle(),50);
        welcomeText.setFont(welcomeTextFont);
        welcomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel startText = new JLabel("Press 'Start' to begin the game!");
        Font startTextFont=new Font(startText.getFont().getName(),startText.getFont().getStyle(),35);
        startText.setFont(startTextFont);
        startText.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton startButton = new JButton("Start");
        startButton.setMargin(new Insets(20, 40 , 20, 40));
        startButton.setFont(new Font(welcomeText.getFont().getName(),welcomeText.getFont().getStyle(),20));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.add(welcomeText);
        welcome.add(startText);
        welcome.add(startButton, "Start");
        content.add(welcome, "Welcome");
        
        //game  panel
        loadGamePanel();
        connect4.add(content);
        cl.show(content, "Welcome");
        connect4.setSize(800,800);
        connect4.setVisible(true);
        
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cl.show(content, "Game");
            }
        });
        
    }
    public void loadGamePanel(){
        gamePanel = new JPanel(new FlowLayout());
        player1panel = new JPanel();
        player2panel = new JPanel();
        player1panel.setLayout(new BoxLayout(player1panel, BoxLayout.PAGE_AXIS));
        player2panel.setLayout(new BoxLayout(player2panel, BoxLayout.PAGE_AXIS));
        JLabel player1label = new JLabel("PLAYER 1");
        if(turns%2==0){
            player1label.setBackground(Player.PlayerOne.color());
        }
        player1panel.add(player1label);
        JLabel player2label = new JLabel("PLAYER 2");
        if(turns%2==1){
            player2panel.setBackground(Player.PlayerTwo.color());
        }
        player2panel.add(player2label);
        board = boardObj.getCurrentBoard();
        JPanel gameBoard = new JPanel( new GridLayout(board[0].length, board.length));
        boolean winnerFound=false;
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j<board.length; j++){
                connect4board[i][j] = new RoundButton(String.valueOf(board[i][j]));
                connect4board[i][j].setActionCommand(String.valueOf(i)+String.valueOf(j));
                //give button a unique identifier
                connect4board[i][j].addActionListener(new chipHandler());
                gameBoard.add(connect4board[i][j]);
            }
        }
        gamePanel.add(player1panel, "PLAYER1");
        gamePanel.add(gameBoard, "BOARD");
        gamePanel.add(player2panel, "PLAYER2");
        content.add(gamePanel, "Game");
    }
    public void updateConnect4board(int column, Player player){
        //mark board and check for winner
        boolean winnerExist = boardObj.placeChipAndCheckWinner(column, turns);
        if(!winnerExist){
            loadGamePanel();
            connect4.add(content);
            cl.show(content, "Game");
            turns++;
        }
    }
    class chipHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //distinguish player
            Player player = turns%2==0 ?Player.PlayerOne : Player.PlayerTwo;
            //get column value from actionCommand
            int column = Integer.parseInt(String.valueOf(e.getActionCommand().charAt(1)));
            updateConnect4board(column, player);         
        }
        
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
        boolean winnerFound =false;

    }
} 

