package fr.norsys.chess.chessgame;

import fr.norsys.chess.interfaces.ChessPiece;

import java.util.List;

//baid9
public class Pawn implements ChessPiece {
    private Position position;
    private PieceColor color;

    public Pawn(Position position, PieceColor color) {
        this.color = color;
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public void setPosition(int x, int y) {
         this.position.setX(x);
         this.position.setY(y);
    }
    @Override
    public boolean isBlack() {
        return color == PieceColor.BLACK;
    }

    @Override
    public boolean isWhite() {
        return color == PieceColor.WHITE;
    }

    @Override
    public void move(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    @Override
    public List<Position> possibleMoves() {
        if (color == PieceColor.WHITE) {
            if (position.getY() == 1) {
                return List.of(new Position(position.getX(), position.getY() + 1), new Position(position.getX(), position.getY() + 2));
            } else {
                return List.of(new Position(position.getX(), position.getY() + 1));
            }
        } else {
            if (position.getY() == 6) {
                return List.of(new Position(position.getX(), position.getY() - 1), new Position(position.getX(), position.getY() - 2));
            } else {
                return List.of(new Position(position.getX(), position.getY() - 1));
            }
        }
    }

    @Override
    public List<Position> possibleAttacks() {
        if (color == PieceColor.WHITE) {
            return List.of(new Position(position.getX() + 1, position.getY() + 1), new Position(position.getX() - 1, position.getY() + 1));
        } else {
            return List.of(new Position(position.getX() + 1, position.getY() - 1), new Position(position.getX() - 1, position.getY() - 1));
        }
    }

    @Override
    public Position isBlocked(){
        if (isWhite()){
            position = new Position(position.getX(), position.getY() + 1);
            System.out.println("my position is"+position.getX()+" : "+position.getY());
            return position;
        }

        else if (isBlack()){
            position = new Position(position.getX(), position.getY() - 1);
            return position;
        }
        return null;
    }

    @Override
    public PieceColor getColor() {
        return null;
    }
}
