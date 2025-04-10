package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        if(rows <1 || columns <1){
            throw new BoardException("ERROR CREATING BOARD: There must be at least one row and one column while creatinh the board");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public Piece piece(int rows, int columns){
        if(positionExists(rows,columns)){
            throw new BoardException("Positon not on the board");
        }
        return pieces[rows][columns];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on the position : "+position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Piece not on the board!");
        }
        if(piece(position)== null){
            return null;
        }
        Piece aux = piece(position);
        aux.position =null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
   }

    public boolean positionExists(int rows, int columns){
        return rows>=0 && rows<this.rows && columns>=0 && columns < this.columns;
    }
    public boolean positionExists(Position position){
        if (position != null){
            return true;
        }
        return false;
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

}
