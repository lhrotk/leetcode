package leet.algorithm.q130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void markRegion(int x, int y, boolean[][] judge, char[][] board) {
		judge[x][y] = true;
		if(x-1>=0&&board[x-1][y]=='O'&&!judge[x-1][y]) {
			markRegion(x-1, y, judge, board);
		}
		
		if(x+1<board.length&&board[x+1][y]=='O'&&!judge[x+1][y]) {
			markRegion(x+1, y, judge, board);
		}
		
		if(y-1>=0&&board[x][y-1]=='O'&&!judge[x][y-1]) {
			markRegion(x, y-1, judge, board);
		}
		
		if(y+1<board[x].length&&board[x][y+1]=='O'&&!judge[x][y+1]) {
			markRegion(x, y+1, judge, board);
		}
	}

	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1)
			return;
		boolean[][] judge = new boolean[board.length][board[0].length];
		for (int j = 0; j < board[0].length; j++) {
			if(board[0][j]=='O')
				this.markRegion(0, j, judge, board);
		}

		for (int j = 0; j < board[0].length; j++) {
			if(board[board.length-1][j]=='O')
				this.markRegion(board.length-1, j, judge, board);
		}

		for (int i = 0; i < board.length; i++) {
			if(board[i][0]=='O')
				this.markRegion(i, 0, judge, board);
		}

		for (int i = 0; i < board.length; i++) {
			if(board[i][board[i].length-1]=='O')
				this.markRegion(i, board[i].length-1, judge, board);
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]=='O'&&!judge[i][j])
					board[i][j] = 'X';
			}
		}
	}
	
	public static void main(String[] args) {
		//char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] board = new char[][] {{'O', 'O'},{'O','O'}};
		Solution sol = new Solution();
		sol.solve(board);
		for(int i=0; i<board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
