package fr.norsys.chess.chessgame;

import fr.norsys.chess.interfaces.ChessPiece;

import java.util.List;

//fil
public class Bishop implements ChessPiece {

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
        List<Position> listPossibleMove = null;
        if(isWhite()){
            while (getPosition().getX()!=0){
                listPossibleMove.add(new Position(getPosition().getX()-1,getPosition().getY()+1));
            }
            while (getPosition().getY()!=0){
                listPossibleMove.add(new Position(getPosition().getX()+1,getPosition().getY()-1));
            }
        }

        if(isBlack()){
            while (getPosition().getX()!=7){
                listPossibleMove.add(new Position(getPosition().getX()-1,getPosition().getY()+1));
            }
            while (getPosition().getY()!=7){
                listPossibleMove.add(new Position(getPosition().getX()+1,getPosition().getY()-1));
            }
        }
        return listPossibleMove;
    }

    @Override
    public List<Position> possibleAttacks() {
        return null;
    }

    @Override
    public Position isBlocked() {
        return null;
    }
}
