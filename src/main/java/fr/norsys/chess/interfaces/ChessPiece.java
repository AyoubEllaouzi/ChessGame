package fr.norsys.chess.interfaces;

import fr.norsys.chess.chessgame.Position;

import java.util.List;

public interface ChessPiece {
    public Position getPosition();

    void setPosition(int x, int y);

    public boolean isBlack();
    public boolean isWhite();
    public void move(int x, int y);
    public List<Position> possibleMoves();
    public List<Position> possibleAttacks();
    public Position isBlocked();
}
