package atelier2.model;

import atelier2.nutsAndBolts.PieceSquareColor;

import java.util.LinkedList;
import java.util.List;

public class AbstractPieceModel implements PieceModel {
    Coord coord;
    PieceSquareColor pieceColor;
    public AbstractPieceModel(Coord coord, PieceSquareColor pieceColor) {
        super();
        this.coord = coord;
        this.pieceColor = pieceColor;
    }
    @Override
    public char getColonne() {
        return this.coord.getColonne();
    }

    @Override
    public int getLigne() {
        return this.coord.getLigne();
    }

    @Override
    public boolean hasThisCoord(Coord coord) {
        return this.coord.equals(coord);
    }

    @Override
    public void move(Coord coord) {
        this.coord = coord;
    }

    @Override
    public PieceSquareColor getPieceColor() {
        return this.pieceColor;
    }

    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
        return false;
    }

    @Override
    public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
        List<Coord> coordsOnItinery = new LinkedList<Coord>();
        int initCol = this.getColonne();
        int initLig = this.getLigne();
        int colDistance = targetCoord.getColonne() - this.getColonne();
        int ligDistance = targetCoord.getLigne() - this.getLigne();
        int deltaLig = (int) Math.signum(ligDistance);
        int deltaCol = (int) Math.signum(colDistance);

        // Vérif déplacement en diagonale
        if (Math.abs(colDistance) == Math.abs(ligDistance)){
            // recherche coordonnées des cases traversées
            for (int i = 1; i < Math.abs(colDistance); i++) {
                Coord coord = new Coord((char) (initCol + i*deltaCol), initLig + i*deltaLig);
                coordsOnItinery.add(coord);
            }
        }
        return coordsOnItinery;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return " ["+this.pieceColor.toString().charAt(0) + this.coord + "]";
    }

}