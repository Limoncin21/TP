package es.ucm.fdi.tp.launcher;

import java.util.ArrayList;
import java.util.List;

import es.ucm.fdi.tp.base.console.ConsolePlayer;
import es.ucm.fdi.tp.base.model.GameAction;
import es.ucm.fdi.tp.base.model.GamePlayer;
import es.ucm.fdi.tp.base.model.GameState;
import es.ucm.fdi.tp.base.player.RandomPlayer;
import es.ucm.fdi.tp.base.player.SmartPlayer;
import es.ucm.fdi.tp.ttt.TttState;
import es.ucm.fdi.tp.was.WolfAndSheepState;

public class Main {

	public static void main(String[] args) {
		List<GamePlayer> players = new ArrayList<GamePlayer>();
		GameState<?,?> state = createInitialState(args[0]);
		players.add(createPlayer(args[0], args[1], "O"));
		players.add(createPlayer(args[0], args[2], "X"));
		playGame(state, players);
		
		
	}
	
	public static GameState <?,?> createInitialState(String gameName){
		if(gameName.equals("ttt")){
			return new TttState(3);
		}else if ( gameName.equals("was")){
			return new WolfAndSheepState();
		}else{
			return null;
		}
	}
	
	public static GamePlayer createPlayer(String gameName, String PlayerType, String playerName){
		/*if(PlayerType.equals("console")){
			return new ConsolePlayer(playerName, s);
		}else*/ if(PlayerType.equals("rand")){
			return new RandomPlayer(playerName);
		}else if(PlayerType.equals("smart")){
			return new SmartPlayer(playerName, 5);//Pongo 5 porque es lo que habia en el anterior main
		}else{
			return null;
		}
	}
	
	public static void match(GameState<?, ?> initialState, GamePlayer a, GamePlayer b, int times) {
		int va = 0, vb = 0;

		List<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(a);
		players.add(b);

		for (int i = 0; i < times; i++) {
			switch (playGame(initialState, players)) {
			case 0:
				va++;
				break;
			case 1:
				vb++;
				break;
			}
		}
		System.out.println("Result: " + va + " for " + a.getName() + " vs " + vb + " for " + b.getName());
	}
	
	public static <S extends GameState<S, A>, A extends GameAction<S, A>> int playGame(GameState<S, A> initialState,
			List<GamePlayer> players) {
		int playerCount = 0;
		for (GamePlayer p : players) {
			p.join(playerCount++); // welcome each player, and assign
									// playerNumber
		}
		@SuppressWarnings("unchecked")
		S currentState = (S) initialState;

		while (!currentState.isFinished()) {
			// request move
			A action = players.get(currentState.getTurn()).requestAction(currentState);
			// apply move
			currentState = action.applyTo(currentState);
			System.out.println("After action:\n" + currentState);

			if (currentState.isFinished()) {
				// game over
				String endText = "The game ended: ";
				int winner = currentState.getWinner();
				if (winner == -1) {
					endText += "draw!";
				} else {
					endText += "player " + (winner + 1) + " (" + players.get(winner).getName() + ") won!";
				}
				System.out.println(endText);
			}
		}
		return currentState.getWinner();
	}
}
