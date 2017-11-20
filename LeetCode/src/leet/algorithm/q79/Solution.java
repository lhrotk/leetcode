package leet.algorithm.q79;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean overlap(List<Integer> path, int y, int x) {
		for (int i = 0; i < path.size(); i += 2) {
			if (path.get(i) == y && path.get(i + 1) == x) {
				return true;
			}
		}
		return false;
	}

	public boolean exit(char[][] board, List<Integer> path, String word) {
		if (word.equals("")) {
			return true;
		} else {
			int currentX = path.get(path.size() - 1);
			int currentY = path.get(path.size() - 2);
			if (currentX + 1 < board[0].length) {
				if (board[currentY][currentX + 1] == word.charAt(0) && !overlap(path, currentY, currentX + 1)) {
					path.add(currentY);
					path.add(currentX + 1);
					if (exit(board, path, word.substring(1, word.length())))
						return true;
					else {
						path.remove(path.size() - 1);
						path.remove(path.size() - 1);
					}
				}
			}

			if (currentX - 1 >= 0) {
				if (board[currentY][currentX - 1] == word.charAt(0) && !overlap(path, currentY, currentX - 1)) {
					path.add(currentY);
					path.add(currentX - 1);
					if (exit(board, path, word.substring(1, word.length())))
						return true;
					else {
						path.remove(path.size() - 1);
						path.remove(path.size() - 1);
					}
				}
			}

			if (currentY + 1 < board.length) {
				if (board[currentY + 1][currentX] == word.charAt(0) && !overlap(path, currentY + 1, currentX)) {
					path.add(currentY + 1);
					path.add(currentX);
					if (exit(board, path, word.substring(1, word.length())))
						return true;
					else {
						path.remove(path.size() - 1);
						path.remove(path.size() - 1);
					}
				}
			}

			if (currentY - 1 >= 0) {
				if (board[currentY - 1][currentX] == word.charAt(0) && !overlap(path, currentY - 1, currentX)) {
					path.add(currentY - 1);
					path.add(currentX);
					if (exit(board, path, word.substring(1, word.length())))
						return true;
					else {
						path.remove(path.size() - 1);
						path.remove(path.size() - 1);
					}
				}
			}

			return false;
		}
	}

	public boolean exist(char[][] board, String word) {

		if (word == null || word.length() == 0) {
			return true;
		}
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
			return false;
		}

		List<Integer> path = new ArrayList<Integer>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					path.add(i);
					path.add(j);
					if (exit(board, path, word.substring(1, word.length()))) {
						return true;
					} else {
						path.remove(1);
						path.remove(0);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] board = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
		System.out.println(sol.exist(board, "AAAAAAAAAAAAA"));
	}
}
