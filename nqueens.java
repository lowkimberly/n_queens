import java.io.*;
import java.util.*;

public class nqueens {
    int n;
    int crow = 0;
    int ccol = 0;
    int queensleft;
    char[][] board;
    public nqueens(int x) {
	n=x;
	queensleft = x;
	board = new char[x][x];
	for (int i=0;i<x;i++) {
	    for(int j=0;j<x;j++) {
		board[i][j]=' ';
	    }
	}
    }
    public void solve(int r,int c) {
	if (!inpath(r,c)) {
	    board[r][c]='Q';
	    if (ccol == n) {
		ccol=0;
		crow++;
	    }
	    solve(crow,ccol);
	    if (queensleft > 0) {
		board[r][c]=' ';
		ccol++;
		solve(crow,ccol);
	    }
	}
	else if (inpath(r,c)) {
	    ccol++;
	    if (ccol == n) {
		ccol=0;
		crow++;
	    }
	    solve(crow,ccol);
	}
	if (queensleft == 0) {
	    return;
	}
	if (crow == n - 1 && ccol == n - 1 & queensleft > 0) {
	    return;
	}
    }
    public boolean inpath(int r, int c) {
	for (int i=r-1;i>=0;i--) {
	    if (board[i][c]=='Q') {
		return true;
	    }
	}
	for (int i=r+1;i<n;i++) {
	    if (board[i][c]=='Q') {
		return true;
	    }
	}
	for (int i=c-1;i>=0;i--) {
	    if (board[r][i]=='Q') {
		return true;
	    }
	}
	for (int i=c+1;c<n;c++) {
	    if (board[r][i]=='Q') {
		return true;
	    }
	}
	int i,j;
	for (i = r-1 && j=c-1;i>=0 && j>=0;i-- && j--) {
	    if (board[i][j]=='Q') {
		return true;
	    }
	}
	for (i=r-1 && j=c+1;i>=0&&j<n;i--&&j++) {
	    if (board[i][j]=='Q') {
		return true;
	    }
	}
	for (i=r+1 && j=c-1;i<n&&j>=0;i++&&j--) {
	    if (board[i][j]=='Q') {
		return true;
	    }
	}
	for (i=r+1 && j=c+1;i<n&&j<n;i=i+1 && j = j+1) {
	    if (board[i][j]=='Q') {
		return true;
	    }
	}
	return false;
    }
}
