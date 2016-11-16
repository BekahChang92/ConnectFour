/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectFour;

import java.awt.Color;

/**
 *
 * @author rebekah
 */
public enum Player{
    PlayerOne(Color.RED, 'X'),
    PlayerTwo(Color.BLUE, 'O');
            
    private Color color;
    private char chip;
    Player(Color color, char chip){
        this.color = color;
        this.chip = chip;
    }
    public Color color(){
        return color;
    }
    public char chip(){
        return chip;
    }
             
}