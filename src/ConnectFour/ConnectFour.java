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
public class ConnectFour extends JFrame {
    
    private Container contents;
    private JButton[][] connect4board;
    private char[][] board;
    private String player1;
    private String player2;
    public ConnectFour(char[][] board){
        super("Connect Four");
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        contents = getContentPane();
        //welcome screen or panel
        JPanel welcome = new JPanel();
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.PAGE_AXIS));
        JLabel welcometext = new JLabel("Let's play Connect 4!");
        JLabel startText = new JLabel("Press 'Start' to being the game!");
        JButton startbutton = new JButton("Start");
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
        JLabel player1name = new JLabel(this.player1);
        
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
    

