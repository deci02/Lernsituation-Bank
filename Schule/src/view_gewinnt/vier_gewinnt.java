package view_gewinnt;

import java.util.*;

public class vier_gewinnt {

	public boolean game_ended;
	private int[][] board;
	private int player;
	private int x_stone;
	private int y_stone;

	public vier_gewinnt() {
		this.board = new int[6][7];
		this.player = 1;
	}

	public void start_game() {
		while (!game_ended) {
			output_board();
			System.out.println("Gib eine Spalte ein: ");
			Scanner sc1 = new Scanner(System.in);
			int column = sc1.nextInt() - 1;
			turn(column);
//			sc1.close();
		}
	}

	public void check_win() {
		if (check_diagonal_win() || check_horizontal_win() || check_vertical_win()) {
			game_ended = true;
			System.out.println("Spieler " + player + " hat gewonnen!");
		}
	}

	private void turn(int spalte) {
		if (this.check_legal_move(spalte)) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][spalte] == 0) {
					board[i][spalte] = player;
					x_stone = i;
					y_stone = spalte;
					check_win();
					if (player == 1) {
						player = 2;
					} else {
						player = 1;
					}
					return;
				}
			}
		} else {
			return;
		}
	}

	public boolean check_legal_move(int column) {
		if (board[5][column] != 0) {
			System.out.println("Illegaler Move");
			if (check_any_moves_left()) {
				System.out.println("Keine Züge mehr möglich. Das Spiel ist zuende.");
				game_ended = true;
			}
			return false;
		} else {
			return true;
		}
	}

	public void output_board() {
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private boolean check_horizontal_win() {
		int last_stone = y_stone;
		for (int i = 1; i <= 4; i++) {
			if (y_stone + i > board[1].length || board[x_stone][y_stone + i] != player) {
				last_stone = (y_stone + i - 1);
				break;
			}
		}
		for (int i = 1; i < 4; i++) {
			if (last_stone - 3 < 0 || board[x_stone][last_stone - i] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean check_vertical_win() {
		int last_stone = x_stone;
		for (int i = 1; i <= 4; i++) {
			if (x_stone + i > board.length || board[x_stone + i][y_stone] != player) {
				last_stone = (x_stone + i - 1);
				break;
			}
		}
		for (int i = 1; i < 4; i++) {
			if (last_stone - 3 < 0 || board[last_stone - i][y_stone] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean check_diagonal_win() {
		int sum = (x_stone + y_stone);
		int diff = (x_stone - y_stone);
		int diag1 = 0;
		int diag2 = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i + j == sum) {
					if (board[i][j] == player) {
						diag1++;
						if (diag1 == 4) {
							return true;
						}
					} else {
						diag1 = 0;
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i - j == diff) {
					if (board[i][j] == player) {
						diag2++;
						if (diag2 == 4) {
							return true;
						}
					} else {
						diag2 = 0;
					}
				}
			}
		}
		return false;
	}

	private boolean check_any_moves_left() {
		for (int i = 0; i < board[5].length; i++) {
			if (board[5][i] == 0) {
				return false;
			}
		}
		return true;
	}
}
