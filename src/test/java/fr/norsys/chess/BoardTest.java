package fr.norsys.chess;

import fr.norsys.chess.chessgame.Bishop;
import fr.norsys.chess.chessgame.Pawn;
import fr.norsys.chess.chessgame.PieceColor;
import fr.norsys.chess.chessgame.Position;
import fr.norsys.chess.interfaces.ChessPiece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void testStartMovePawnOnce() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(1, 1);
        Position expectedPosition = new Position(1, 2);
        ChessPiece pawn = new Pawn(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, pawn);

        // Perform the move
        board.displayBoard();
        System.out.println("-----------------");
         board.takeMove(pawn, 1, 2);
        board.displayBoard();
    }

    @Test
    void testStartMovePawnTwice() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(1, 1);
        Position expectedPosition = new Position(3, 1);
        ChessPiece pawn = new Pawn(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, pawn);

        // Perform the move
        board.displayBoard();
        System.out.println("-----------------");
        board.takeMove(pawn, 1, 3);
        board.displayBoard();
    }

    @Test
    void testMovePawn() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(1, 1);
        Position expectedPosition = new Position(3, 1);
        ChessPiece pawn = new Pawn(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, pawn);

        // Perform the move
        board.displayBoard();
        System.out.println("-----------------");
        board.takeMove(pawn, 1, 3);
        board.displayBoard();
        board.takeMove(pawn, 1, 4);
        board.displayBoard();
    }

    @Test
    void testIfPawnIsBlocked() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(1, 1);

        ChessPiece pawn = new Pawn(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, pawn);

        ChessPiece pawn2 = new Pawn(new Position(1, 2), PieceColor.WHITE);
        // Perform the move
        board.displayBoard();
        board.gameBoard.put(new Position(1, 2), pawn2);
        board.takeMove(pawn, 1, 2);
        board.displayBoard();
    }

    @Test
    void testValidAttackForPawn() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(1, 1);

        ChessPiece pawn = new Pawn(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, pawn);

        ChessPiece target = new Pawn(new Position(0, 2), PieceColor.WHITE);
        // Perform the move
        board.displayBoard();
        board.gameBoard.put(new Position(0, 2), target);
        board.validAttack(pawn, target);
        board.displayBoard();
    }

    @Test
    void testBishopPossibleMove(){
        Bishop bishop = new Bishop(new Position(3, 3), PieceColor.WHITE);
        bishop.toString();
        List<Position> positions = bishop.possibleMoves();
        for (Position p:positions){
            System.out.println("x = "+p.getX()+" y = "+p.getY());
        }
    }

    @Test
    void testMoveBishop() {
        // Create some ChessPiece objects
        Position initialPosition = new Position(3, 3);
        ChessPiece bishop = new Bishop(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, bishop);

        // Perform the move
        board.displayBoard();
        System.out.println("-----------------");
        board.takeMove(bishop, 0, 0);
        board.displayBoard();
        board.takeMove(bishop, 3, 3);
        board.displayBoard();

    }
    @Test
    void testBishopIsBlocked(){
        Position initialPosition = new Position(3, 3);

        Position targetPosition = new Position(2, 2);
        Bishop bishop = new Bishop(initialPosition, PieceColor.WHITE);
        bishop.setTargetPosition(targetPosition);

        Board board = new Board(initialPosition, bishop);
        board.displayBoard();

        ChessPiece newPeice = new Bishop(targetPosition, PieceColor.WHITE);
        board.gameBoard.put(targetPosition, newPeice);

        // Perform the move
        System.out.println("-----------------");

        board.isBlocked(bishop);
        board.displayBoard();
    }

    @Test
    void testBishopIsNotBlocked(){
        Position initialPosition = new Position(3, 3);

        Position targetPosition = new Position(1, 1);
        Bishop bishop = new Bishop(initialPosition, PieceColor.WHITE);
        bishop.setTargetPosition(targetPosition);

        Board board = new Board(initialPosition, bishop);
        board.displayBoard();

        ChessPiece newPeice = new Bishop(targetPosition, PieceColor.WHITE);
        board.gameBoard.put(targetPosition, newPeice);

        // Perform the move
        System.out.println("-----------------");

        board.isBlocked(bishop);
        board.displayBoard();
    }

    @Test
    void testValidAttackForBishop() {
        Position initialPosition = new Position(3, 3);
        Position targetPosition = new Position(5, 5);

        ChessPiece bishop = new Bishop(initialPosition, PieceColor.WHITE);
        Board board = new Board(initialPosition, bishop);

        ChessPiece target = new Bishop(targetPosition, PieceColor.WHITE);
        // Perform the move
        board.displayBoard();
        board.gameBoard.put(targetPosition, target);
        board.validAttack(bishop, target);
        board.displayBoard();
    }


}
