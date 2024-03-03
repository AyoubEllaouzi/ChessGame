package fr.norsys.chess.chessgame;

import fr.norsys.chess.interfaces.ChessPiece;

import java.util.ArrayList;
import java.util.List;

//fil
public class Bishop implements ChessPiece {
    private Position position;
    private Position targetPosition;
    private PieceColor color;
    public Bishop(Position position, PieceColor color) {
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
        List<Position> listPossibleMove = new ArrayList<>();
        if (isWhite()) {
            int x = getPosition().getX();
            int y = getPosition().getY();
            while (x > 0 && y > 0) {
                x--;
                y--;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x < 7 && y > 0) {
                x++;
                y--;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x > 0 && y < 7) {
                x--;
                y++;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x < 7 && y < 7) {
                x++;
                y++;
                listPossibleMove.add(new Position(x, y));
            }
        }

        if (isBlack()) {
            int x = getPosition().getX();
            int y = getPosition().getY();
            while (x > 0 && y < 7) {
                x--;
                y++;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x < 7 && y < 7) {
                x++;
                y++;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x > 0 && y > 0) {
                x--;
                y--;
                listPossibleMove.add(new Position(x, y));
            }
            x = getPosition().getX();
            y = getPosition().getY();
            while (x < 7 && y > 0) {
                x++;
                y--;
                listPossibleMove.add(new Position(x, y));
            }
        }
        return listPossibleMove;
    }


    @Override
    public List<Position> possibleAttacks() {
        List<Position> possibleAttacks = new ArrayList<>();

        // Check diagonally towards the bottom-left
        int x = position.getX() - 1;
        int y = position.getY() - 1;
        while (x >= 0 && y >= 0) {
            possibleAttacks.add(new Position(x, y));
            x--;
            y--;
        }

        // Check diagonally towards the bottom-right
        x = position.getX() - 1;
        y = position.getY() + 1;
        while (x >= 0 && y < 8) {
            possibleAttacks.add(new Position(x, y));
            // Break the loop if there is an opponent's piece
            x--;
            y++;
        }

        // Check diagonally towards the top-left
        x = position.getX() + 1;
        y = position.getY() - 1;
        while (x < 8 && y >= 0) {
            possibleAttacks.add(new Position(x, y));
            // Break the loop if there is an opponent's piece
            x++;
            y--;
        }

        // Check diagonally towards the top-right
        x = position.getX() + 1;
        y = position.getY() + 1;
        while (x < 8 && y < 8) {
            possibleAttacks.add(new Position(x, y));
            x++;
            y++;
        }

        return possibleAttacks;
    }


    @Override
    public Position isBlocked() {
        if (targetPosition.getX() > getPosition().getX() && targetPosition.getY() > getPosition().getY())
            return new Position(getPosition().getX()+1, getPosition().getY()+1);

        else if (targetPosition.getX() > getPosition().getX() && targetPosition.getY() < getPosition().getY())
            return new Position(getPosition().getX()+1, getPosition().getY()-1);

        else if (targetPosition.getX() < getPosition().getX() && targetPosition.getY() > getPosition().getY())
            return new Position(getPosition().getX()-1, getPosition().getY()+1);

        else if (targetPosition.getX() < getPosition().getX() && targetPosition.getY() < getPosition().getY())
            return new Position(getPosition().getX()-1, getPosition().getY()-1);
        return null;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "position=" + position +
                ", color=" + color +
                '}';
    }
}
