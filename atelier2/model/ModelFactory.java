package atelier2.model;

import java.util.Collection;
import java.util.LinkedList;

import atelier2.nutsAndBolts.PieceSquareColor;

public class ModelFactory {

	public static Collection<PieceModel> createPieceModelCollection() {
		
		Collection<PieceModel> pieces = new LinkedList<PieceModel>();
		// Collection<PieceModel> pieces = new ArrayList<PieceModel>();
		// Collection<PieceModel> pieces = new HashSet<PieceModel>();
		// Collection<PieceModel> pieces = new TreeSet<PieceModel>();
				
		// Cr�ation des pion blancs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.WHITE_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
		}

		// Cr�ation des pions noirs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
		}
		return pieces;
	}

	public static QueenModel createQueen(Coord coord, PieceSquareColor color)
	{
		QueenModel queen = new QueenModel(coord, color);
		return queen;
	}
}
