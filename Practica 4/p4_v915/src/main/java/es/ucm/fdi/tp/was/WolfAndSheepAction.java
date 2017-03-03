package es.ucm.fdi.tp.was;

import es.ucm.fdi.tp.base.model.GameAction;


public class WolfAndSheepAction implements GameAction<WolfAndSheepState, WolfAndSheepAction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061739732232203112L;

	private int player;
	private int rowNew;
	private int colNew;
	private int rowOld;
	private int colOld;
	
	static final int EMPTY = -1;

	public WolfAndSheepAction(int player, int rowNew, int colNew, int rowOld, int colOld ) {
		this.player = player;
		this.rowNew = rowNew;
		this.colNew = colNew;
		this.rowOld = rowOld;
		this.colOld = colOld;
	}

	@Override
	public int getPlayerNumber() {
		return player;
	}

	@Override
	public WolfAndSheepState applyTo(WolfAndSheepState state) {
		if (player != state.getTurn()) {
			throw new IllegalArgumentException("Not the turn of this player");
		}
		// make move
		int[][] board = state.getBoard();
		board[rowNew][colNew] = player;
		board[rowOld][colOld] = EMPTY;
		// update state
		WolfAndSheepState next;
		if (WolfAndSheepState.isWinner(state, state.getTurn())) {
			next = new WolfAndSheepState(state, board, true, state.getTurn());
		} else {
			next = new WolfAndSheepState(state, board, false, -1);
		}
		return next;
	}

	/*public int getRow() {
		return rowOld;
	}*/

	/*public int getCol() {
		return colOld;
	}*/

	public String toString() {
		return "place " + player + " at (" + rowNew + ", " + colNew + ")";
	}

}
