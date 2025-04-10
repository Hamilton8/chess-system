package application;

import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source");
            ChessPosition source = UI.readChessPosition(input);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(input);


            ChessPiece capturedPiece = chessMatch.performChessMove(source,target);
        }

    }
}
