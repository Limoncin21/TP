package es.ucm.fdi.tp.was;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.tp.base.model.GameState;

public class WolfAndSheepState extends GameState<WolfAndSheepState, WolfAndSheepAction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4280611954114406267L;

	private final int turn;
	private final boolean finished;
	private final int[][] board;
	private final int winner;

	final static int LOBO = 0;
	final static int OVEJA = 1;
	final static int DIM = 8;
	final static int EMPTY = -1;

	public WolfAndSheepState() {
		super(2);

		board = new int[DIM][DIM];
		for (int fila = 0; fila < DIM; fila++) {
			for (int colum = 0; colum < DIM; colum++) {
				if (fila == 0 && colum % 2 == 1) {
					board[fila][colum] = OVEJA;
				} else if (fila == DIM - 1 && colum == 0) {
					board[fila][colum] = LOBO;
				} else {
					board[fila][colum] = EMPTY;
				}
			}
		}
		this.turn = 0;
		this.winner = -1;
		this.finished = false;
	}

	public WolfAndSheepState(WolfAndSheepState prev, int[][] board, boolean finished, int winner) {
		super(2);

		this.board = board;
		this.turn = (prev.turn + 1) % 2;
		this.finished = finished;
		this.winner = winner;
	}

	public int at(int row, int col) {
		return board[row][col];
	}

	@Override
	public int getTurn() {
		return turn;
	}
	@Override
	public List<WolfAndSheepAction> validActions(int playerNumber) {
		ArrayList<WolfAndSheepAction> valid = new ArrayList<>();
		if (finished) {
			return valid;
		}
		for (int fila = 0; fila < DIM; fila++) {
			for (int colum = 0; colum < DIM; colum++) {
				if(at(fila, colum) != EMPTY && playerNumber == at(fila, colum) ){
					valid.addAll(posicionesValidas(fila, colum, board, playerNumber));
				}
			}
		}
		return valid;
	}
	private boolean controlarDimensiones(int f, int c){
		boolean valido = false;
		if (f >= 0 && f < DIM && c >= 0 && c < DIM){
			valido = true;
		}
		return valido;
	}
	private List<WolfAndSheepAction> posicionesValidas(int f, int c, int[][] board, int turn) {
		ArrayList<WolfAndSheepAction> valid = new ArrayList<WolfAndSheepAction>();
		if (turn == LOBO) {
			if (controlarDimensiones(f-1, c-1) && at(f - 1, c - 1) == EMPTY) {
				valid.add(new WolfAndSheepAction(turn, f - 1, c - 1, f, c));
			}
			if (controlarDimensiones(f-1, c+1)&& at(f - 1, c + 1) == EMPTY) {
				valid.add(new WolfAndSheepAction(turn, f - 1, c + 1, f, c));
			}
		}
		if (controlarDimensiones(f+1, c-1) && at(f + 1, c - 1) == EMPTY) {
			valid.add(new WolfAndSheepAction(turn, f + 1, c - 1, f ,c));
		}
		if (controlarDimensiones(f+1, c+1) && at(f + 1, c + 1) == EMPTY) {
			valid.add(new WolfAndSheepAction(turn, f + 1, c + 1, f, c));
		}

		return valid;
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public int getWinner() {
		return winner;
	}
	
	private static boolean comprobarLoboWin(int [][] board,int turn){
		boolean won = false;
		int i = 0;
		while(i < DIM  && !won){
			if(board[0][i] == LOBO){
				won = true;
			}
			i++;
		}
		return won;
	}
	public static boolean isWinner (WolfAndSheepState wasS, int playerNumber){
		boolean won = false;
		if(playerNumber == LOBO){//Si el lobo llega a la primera fila
			won = comprobarLoboWin(wasS.board, playerNumber);
		}
		/*else if((wasS.validActions(OVEJA)).isEmpty() && !wasS.validActions(LOBO).isEmpty()){
			won = true;
		}*/
		else if(wasS.validActions(LOBO).isEmpty()){ // el lobo no puede moverse
				won = true;
		}
		return won;
	}
	/**
	 * @return a copy of the board
	 */
	public int[][] getBoard() {
		int[][] copy = new int[board.length][];
		for (int i = 0; i < board.length; i++)
			copy[i] = board[i].clone();
		return copy;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			sb.append("|");
			for (int j = 0; j < board.length; j++) {
				sb.append(board[i][j] == EMPTY ? "   |" : board[i][j] == 0 ? " O |" : " X |");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
