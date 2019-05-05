/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * ConnectFourEnum contains the enumerator for ConnectFourGame
 *
 * @author Solan
 */
public enum ConnectFourEnum {
    IN_PROGRESS("Game in Progress"), RED("Red"), BLACK("Black"), DRAW("It's a draw!"), EMPTY(" ");

    private String value;

    ConnectFourEnum(String value) {
        this.value = value;
    }
}
