package atelier2.model;


import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de déplacement et de prise de la reine est différent de celui du pion
 */
public class QueenModel extends AbstractPieceModel {
	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
	}

	//Vérifie si la pièce peut se déplacer ou non sur la case où l'utilisateur clique
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;
		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		if (Math.abs(ligDistance) == Math.abs(colDistance)) {
			ret = true;
		}
		return ret;
	}
}

