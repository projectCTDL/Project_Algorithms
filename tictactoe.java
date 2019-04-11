import java.util.Scanner;
import java.util.Arrays;
public class tictactoe{
	public static int c1, c2;
	public static int c, r;
	public static Scanner scan= new Scanner(System.in);
	public static char [][] board;
	public static char turn = 'X';
	public static void main (String[] args){
		// create table
		char [][]board = new char [3][3];
		
		for (int i=0; i<3; i++){
			for (int j=0; j<3;j++){
				board[i][j]='_';
			}
		}
		
		for (int i=0; i<3; i++){
			System.out.println();
			for (int j=0; j<3;j++){
				if (j==0)
					System.out.print("| ");
				System.out.print(board[i][j]+ " | ");	
				
			}
			
		}
		System.out.print("\n");
		
		boolean playing = true;
		while (playing){
			System.out.println("Enter row & column: ");
			r = scan.nextInt() - 1;
			c = scan.nextInt() -1;
			board[r][c]=turn;
			
			if (turn =='X')
				c1++;
			else 
				c2++;
			
			for (int i=0; i<3; i++){
				System.out.println();
				for (int j=0; j<3;j++){
					if (j==0)
						System.out.print("| ");
					System.out.print(board[i][j]+ " | ");			
				}
			}
			if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[1][0] == board[1][1] && board[1][0] == board[1][2]&& board[1][0] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[2][0] == board[2][1] && board[2][0] == board[2][2]&& board[2][0] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			// check col
			if (board[0][0] == board[1][0] && board[0][0] == board[2][0]&& board[0][0] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[0][1] == board[1][1] && board[0][1] == board[2][1]&& board[0][1] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ "win!!!!!!");
				break;
			}
			if (board[0][2] == board[1][2] && board[0][2] == board[2][2]&& board[0][2] != '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			// check diagonal
			if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0]!= '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2]!= '_'){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (c1==5 && c2==4){
				System.out.println("Draw");
				break;
			}
			
			if (turn =='X')
				turn ='O';
			else 
				turn = 'X'; 
		}
	}
	
}


	


	
	