package com.solarwindsmsp.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.CAPTURE) {
            throw new UnsupportedOperationException("Need to implement Pawn.Move() for CAPTURE");
        }

        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }

        int directionOfTravel = pieceColor == PieceColor.BLACK ? -1 : +1;

        if (newX == xCoordinate && newY == yCoordinate + directionOfTravel) {
            chessBoard.getPieces()[newX][newY] = this;
            chessBoard.getPieces()[xCoordinate][yCoordinate] = null;
            xCoordinate = newX;
            yCoordinate = newY;
        }
    }

    @Override
    public String toString() {
        return pieceColor == PieceColor.BLACK ? "p" : "P";
    }

    protected String CurrentPositionAsString() {
        return String.format("%d,%d:%s pawn", xCoordinate, yCoordinate, pieceColor);
    }
}
