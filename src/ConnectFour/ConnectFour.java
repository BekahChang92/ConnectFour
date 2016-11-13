package ConnectFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConnectFour.Board;
/**
 *
 * @author rebekah
 */
public class ConnectFour extends JFrame {
    
    private Container contents;
    private char[][] board;
    
    public ConnectFour(char[][] board){
        super("Connect Four");
        contents = getContentPane();
        this.board = board;
    }
    public static void main(String[] args){
        Board board1 = new Board();
        char[][]board = board1.getCurrentBoard();
        ConnectFour connectFour = new ConnectFour(board);
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");
        }
        System.out.println("");
}
    }
    
}
