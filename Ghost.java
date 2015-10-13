public class Ghost{
	int ghostrow;
	int ghostcolumn;
	int direction;
	int grid[][];
	int lastSpot;
	int pacman_r;
	int pacman_c;
final int LEFT=2;
final int RIGHT=3;
final int UP=0;
final int DOWN=1;
final int PACMAN=1;
final int EMPTY=0;
final int WALL=2;
final int POWERUP=5;
final int PELLET=4;
final int GHOST=3;
int moves[];
int movesLength;


	public Ghost(int r,int c,int d,int g[][], int m[]){
		ghostrow=r;
		ghostcolumn=c;
		grid=g;
		direction=d;
		lastSpot= EMPTY;
		moves=m;
		movesLength=0;
	}
	public void move(){
		if (movesLength!=moves.length){
			direction=moves[movesLength];
			movesLength++;
		}
		if(direction==UP){
			if(grid[ghostrow-1][ghostcolumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=EMPTY;

			}
			if(grid[ghostrow-1][ghostcolumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow-1][ghostcolumn]==POWERUP){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow-1][ghostcolumn] = GHOST;
				lastSpot=POWERUP;
			} 
			ghostrow--;
		}
		if(direction==DOWN){
			if(grid[ghostrow+1][ghostcolumn] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow+1][ghostcolumn]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow+1][ghostcolumn]==POWERUP){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow+1][ghostcolumn] = GHOST;
				lastSpot=POWERUP;
			} 
ghostrow++;

		}
		if(direction==LEFT){
			if(grid[ghostrow][ghostcolumn-1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow][ghostcolumn-1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow][ghostcolumn-1]==POWERUP){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn-1] = GHOST;
				lastSpot=POWERUP;
			} 
			ghostcolumn--;
		}
		if(direction==RIGHT){
			if(grid[ghostrow][ghostcolumn+1] == EMPTY){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=EMPTY;
			}
			if(grid[ghostrow][ghostcolumn+1]==PELLET){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=PELLET;
			}
			if(grid[ghostrow][ghostcolumn+1]==POWERUP){
				if(lastSpot==EMPTY){
					grid[ghostrow][ghostcolumn]=EMPTY;
				}
				if(lastSpot==PELLET){
					grid[ghostrow][ghostcolumn]=PELLET;
				}
				if(lastSpot==POWERUP){
					grid[ghostrow][ghostcolumn]=POWERUP;
				}
				grid[ghostrow][ghostcolumn+1] = GHOST;
				lastSpot=POWERUP;
			} 
			ghostcolumn++;
		}

}
public void chase(){
	System.out.println("CHASE");
	if(ghostrow==pacman_r){
		if(ghostcolumn<=pacman_c){
			for(int i=ghostcolumn+1;i<pacman_c;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=RIGHT;
					}
			}
		}else if(pacman_c<=ghostcolumn){
			for(int i=ghostcolumn-1;i<pacman_c;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=LEFT;
					}
			}
		}

	}
	if(ghostcolumn==pacman_c){
		if(ghostrow<=pacman_r){
			for(int i=ghostrow+1;i<pacman_r;i++){
				if(grid[i][ghostcolumn]==WALL){
					return;
				}else{
				direction=DOWN;
			}
		}
	}
			else if(pacman_r<=ghostrow){
			for(int i=ghostrow-1;i<pacman_r;i++){
				if(grid[ghostrow][i]==WALL)return;
				else{
					direction=LEFT;
					}
			}
		}
			
		
	}
}
	public int getPacManRow(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return i;
		}
	}return 0;
}

public int getPacManCol(){
	for(int i=0;i<16;i++){
		for(int j=0;j<8;j++){
			if(grid[i][j]==1)
				return j;
		}
	}return 0;
}
}
		
	
