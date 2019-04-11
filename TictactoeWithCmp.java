import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class TictactoeWithCmp{
	public static int step = 0;
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
				board[i][j]=' ';
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
			if(turn=='X'){
			System.out.println("Enter row & column: ");
			r = scan.nextInt() - 1;
			c = scan.nextInt() -1;
			board[r][c]=turn;
			}
			else{
				switch(step){
					case 0:
						firstMove(board);
						break;
					case 1:
						if(board[1][1] == 'X')
							move(board,'X');
						else 
							moveHorizontal(board,'X');
						break;
					default:
						if(board[1][1] == 'X'){
							move(board,'O');
						}
						else if (board[1][1] == 'O'){
							moveHorizontal(board,'O');
						}
						break;
				}
				step++;
				for (int i=0; i<3; i++){
					System.out.println();
					for (int j=0; j<3;j++){
						if (j==0)
							System.out.print("| ");
						System.out.print(board[i][j]+ " | ");			
					}
				}
			}
			if (turn =='X')
				c1++;
			else 
				c2++;
	
			
			if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[1][0] == board[1][1] && board[1][0] == board[1][2]&& board[1][0] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[2][0] == board[2][1] && board[2][0] == board[2][2]&& board[2][0] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			// check col
			if (board[0][0] == board[1][0] && board[0][0] == board[2][0]&& board[0][0] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[0][1] == board[1][1] && board[0][1] == board[2][1]&& board[0][1] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ "win!!!!!!");
				break;
			}
			if (board[0][2] == board[1][2] && board[0][2] == board[2][2]&& board[0][2] != ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			// check diagonal
			if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0]!= ' '){
				playing=false;
				System.out.println("Congrats! Player " + turn+ " win!!!!!!");
				break;
			}
			if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2]!= ' '){
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
	
	public static void firstMove(char[][] arr){
		if (arr[1][1]==' '){
			arr[1][1]='O';
		}
		else{
			int[] select = {0,2};
			Random rd = new Random();
			int a = rd.nextInt(select.length);
			int m = select[a];
			int b = rd.nextInt(select.length);
			int n = select[b];
			arr[m][n]='O';
		}
	}
	
	public static void move(char[][] board, char player){
		int[] arr = {0,2};
		int a,b, j=0;
		for(int i = 1; i>=0; i--){
			a = arr[i];
			b = arr[j];
			if(board[a][a] == player && board[b][b] == ' '){
				board[b][b] = 'O';
			return ;
			}
			if(board[a][b] == player && board[b][a] == ' '){
				board[b][a] = 'O';
			return;
			}
			j++;
		}
		moveHorizontal(board,player);
	}

	public static void moveHorizontal(char[][] board, char player){
		for (int i = 0; i < 3; i++){
			int tmp=0,c=0,s=0;
			for (int j = 0; j<3; j++){
				if ( board[i][j] == player )
					c++;
				if ( board[i][j] == ' ' ){
					s++;
					tmp = j;
				}
			}
			if ( c==2 && s == 1){
				board[i][tmp] = 'O';
				return;
			}
		}
		moveVertical(board,player);
	}

	public static void moveVertical(char[][] board, char player){
		for (int i = 0; i<3;i++){
			int tmp=0,c=0,s=0;
			for ( int j = 0; j<3; j++){
				if(board[j][i] == player)
					c++;
				if ( board[j][i] == ' ' ){
					s++;
					tmp = j;
				}
			}
			if ( c==2 && s == 1){
				board[tmp][i] = 'O';
				return;
			}
		}
		if(player=='O' && step!=1)
			move(board,'X');
		else randomMove(board);
	}
	public static void randomMove(char[][] arr){
		for (int i = 0; i<3;i++){
			for ( int j = 0; j<3; j++){
				if(arr[i][j]==' '){
					arr[i][j]='O';
					return;
				}
			}
		}
	}
}