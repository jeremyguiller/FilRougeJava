package atelier2.model;


import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;

public class PawnModel extends AbstractPieceModel implements Promotable{
	private Coord coord;
	private PieceSquareColor pieceColor;
	private int direction;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
	}

	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);

		// Cas d'un déplacement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){

			// sans prise
			if (!isPieceToCapture) {
				if (deltaLig == this.direction && Math.abs(colDistance) == 1) {
					ret = true;
				}
			} else { // avec prise
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
		return ret;
	}

	public boolean isPromotable()
	{
		boolean ret = false;
		if(this.getPieceColor() == PieceSquareColor.WHITE)
		{
			if(this.getLigne() == 10)
			{
				ret = true;
			}
		}
		if (this.getPieceColor() == PieceSquareColor.BLACK)
		{
			if(this.getLigne() == 1)
			{
				ret = true;
			}
		}
		return ret;
	}

	public void promote()
	{
		this.coord = null;
	}

}

