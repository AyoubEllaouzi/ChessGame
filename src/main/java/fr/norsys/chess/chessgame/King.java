package fr.norsys.chess.chessgame;

import fr.norsys.chess.interfaces.ChessPiece;

import java.util.List;

public class King implements ChessPiece {
    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public boolean isBlack() {
        return false;
    }

    @Override
    public boolean isWhite() {
        return false;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public List<Position> possibleMoves() {
        return null;
    }

    @Override
    public List<Position> possibleAttacks() {
        return null;
    }

    @Override
    public Position isBlocked() {
        return null;
    }
//infinity
}
