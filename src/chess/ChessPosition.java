package chess;

import boardgame.Piece;
import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row){
        if (column>'h' || column < 'a' || row > 8 || row < 1){
            throw new ChessException("Error on instantiating position. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    protected Position toPosition(){
        return new Position(8-row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
    }

    public String toString(){
        return ""+ column+row;
    }
}