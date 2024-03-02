package fr.norsys.chess;

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
}
