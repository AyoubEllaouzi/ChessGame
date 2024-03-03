package fr.norsys.chess;

import fr.norsys.chess.chessgame.Position;
import fr.norsys.chess.interfaces.ChessPiece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    Map<Position, ChessPiece> gameBoard = new HashMap<>();
    public Board(Position position, ChessPiece chessPiece) {
        gameBoard.put(position, chessPiece);
    }

    public boolean validMove(ChessPiece piece, int x, int y) {
        List<Position> possibleMoves = piece.possibleMoves();
        for (Position position:possibleMoves){
            if (position.getX() == x && position.getY()==y){
                System.out.println("========= " + position.getX()+" : "+position.getY());
                return true;
            }
        }
        System.out.println("you cant move :(");
            return false;
    }

    public boolean isBlocked(ChessPiece piece) {
        Position checkPosition = piece.isBlocked();
        System.out.println(";;;;;;;;" + checkPosition);
        System.out.println(";;;;;;;;" + gameBoard.toString());

        // Check if the position is occupied in the game board
        if (gameBoard.containsKey(checkPosition)) {
            ChessPiece blockingPiece = gameBoard.get(checkPosition);

            // Check if the blocking piece has the same color as the given piece
            if (blockingPiece.getColor() == piece.getColor()) {
                System.out.println("You are blocked by your own piece, you can't move.");
                return true;
            } /*else {
                System.out.println("You are blocked by an opponent's piece.");
                return true;
            }*/
        }

        System.out.println("You are not blocked, you can move.");
        return false;

    }

    public boolean validAttack(ChessPiece piece, ChessPiece target) {
        List<Position> possibleAttacks = piece.possibleAttacks();
        System.out.println("hi");
        for (Position position : possibleAttacks) {
            if (position.equals(target.getPosition())) {
                System.out.println("Piece at position " + target.getPosition() + " can be attacked.");
                return true;
            }
        }
        System.out.println("Piece cannot be attacked.");
        return false;
    }

    public void takeMove(ChessPiece piece, int x, int y){
     if (!isBlocked(piece)){
         Position newPosition = new Position(x, y);
         if (validMove(piece, x, y)){
             gameBoard.remove(piece.getPosition());
             //update the position of piece
             piece.setPosition(x, y);
             gameBoard.put(newPosition, piece);
         }
         if (validMove(piece, x, y)){
             gameBoard.remove(piece.getPosition());
             //update the position of piece
             piece.setPosition(x, y);
             gameBoard.put(newPosition, piece);
         }
     }
    }

    // Method to display the board
    public void displayBoard() {
        System.out.println("Board:");

        for (Map.Entry<Position, ChessPiece> entry : gameBoard.entrySet()) {
            Position position = entry.getKey();
            ChessPiece chessPiece = entry.getValue();

            System.out.println("Position: " + position.getX() +"-"+ position.getY() + ", Chess Piece: " + chessPiece.getPosition().getX()+"-"+chessPiece.getPosition().getY());
        }
    }

    public void displayPossibleMove() {
        System.out.println("Possible move : ");

    }
}
