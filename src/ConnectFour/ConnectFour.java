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
public class ConnectFour extends JFrame implements ActionListener {
    
    private Container contents;
    private JButton[][] connect4board;
    private JPanel welcome, gameBoard;
    private char[][] board;
    private JButton startbutton;
    public ConnectFour(char[][] board){
        super("Connect Four");
        this.board = board;
        contents = getContentPane();
        ButtonHandler bh = new ButtonHandler();
        //welcome screen or panel
        welcome = new JPanel();
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.PAGE_AXIS));
        JLabel welcometext = new JLabel("Let's play Connect 4!");
        JLabel startText = new JLabel("Press 'Start' to being the game!");
        JButton startbutton = new JButton("Start");
        startbutton.addActionListener(bh);
        welcome.add(welcometext);
        welcome.add(startText);
        welcome.add(startbutton);
        contents.add(welcome);
        setSize(500, 750);
        setVisible(true);
        
        /*JPanel panel1 = new JPanel();
        panel1.setSize(500, 750);
        //board will go in panel 2
        JPanel panel2 = new JPanel();
        panel2.setSize(750, 750);
        JPanel panel3 = new JPanel();
        panel3.setSize(500, 750);
        */
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startbutton){
            gameBoard = new JPanel( new GridLayout());
            
        }
    }
    public JButton[][] getBoard(){
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j<board.length; j++) {
                connect4board[i][j] = new JButton();
            }
        }
        return connect4board;
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
        ConnectFour connectFour = new ConnectFour(board);
    }
}

