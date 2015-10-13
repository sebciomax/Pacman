import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.*;



public class Pacman implements KeyListener,ActionListener{

	ImageIcon eblock=new ImageIcon("wall.png");
	ImageIcon blocks[]={new ImageIcon("wall.png"),
						new ImageIcon("pacman.gif"),
						new ImageIcon("walls.png"),
						new ImageIcon("ghost.png"),
						new ImageIcon("pellet.png"),
						new ImageIcon("powerup.png")

};
	JFrame window;
	JLabel block;
	double score=0;
	int lives=3;
	final int PACMAN=1;
	final int EMPTY=0;
	final int WALL=2;
	final int POWERUP=5;
	final int PELLET=4;
	final int GHOST=3;
	int grid[][]={
					{2,2,2,2,2,2,2,2},
					{2,5,4,4,4,4,5,2},
					{2,4,4,4,4,4,4,2},
					{2,4,4,4,4,4,4,2},
					{2,4,2,1,4,2,4,2},
					{2,4,4,4,4,4,4,2},
					{2,4,4,4,4,4,4,2},
					{2,4,2,4,4,2,4,2},
					{2,4,2,4,4,2,4,2},
					{2,4,2,4,4,2,4,2},
					{2,4,2,4,4,2,4,2},
					{2,4,2,4,4,2,4,2},
					{2,4,4,4,4,4,4,2},
					{2,4,4,4,4,4,4,2},
					{2,5,3,3,3,3,5,2},
					{2,2,2,2,2,2,2,2}


 
	};


JLabel pGrid[][];
int stinkyMoves[]={0,0,0,0,0,0,0,0,0,0,0,1};
int pinkyMoves[]={0,2,0,0,0,0,0,0,0,0,0,1};
int fuglyMoves[]={0,0,0,0,0,0,0,0,0,0,0,1};
int nerdyMoves[]={0,3,0,0,0,0,0,0,0,0,0,1};
Ghost pinky = new Ghost(14,2,0,grid,pinkyMoves);;
Ghost stinky = new Ghost(14,3,0,grid,stinkyMoves);
Ghost fugly = new Ghost(14,4,0,grid,fuglyMoves);;
Ghost nerdy = new Ghost(14,5,0,grid,nerdyMoves);;
Timer time;

public void actionPerformed(ActionEvent e){
	stinky.move();
	pinky.move();
	fugly.move();
	nerdy.move();
	stinky.chase();
	pinky.chase();
	fugly.chase();
	nerdy.chase();
	paintGrid();


}

public void keyTyped(KeyEvent e){



}
public void keyPressed(KeyEvent e){
		int value = e.getKeyCode();
		//System.out.println(value);
		if(value==38){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(grid[pacman_r-1][pacman_c]==0||grid[pacman_r-1][pacman_c]==4||grid[pacman_r-1][pacman_c]==5){
				if(grid[pacman_r-1][pacman_c]==PELLET){
					score++;
					SoundEffect.PELL.play();
					}				
				else if(grid[pacman_r-1][pacman_c]==EMPTY)score*=2000000;
				else if(grid[pacman_r-1][pacman_c]==POWERUP){
					score+=1000;
					SoundEffect.SUP.play();
				}
								else if(grid[pacman_r-1][pacman_c]==GHOST){

			lives--;
			if(lives==2)live1.setIcon(new ImageIcon("walls.png"));
			if(lives==1)live2.setIcon(new ImageIcon("walls.png"));
			if(lives==0){
				System.exit(0);
			}
			grid[3][4]=PACMAN;
						grid[pacman_r][pacman_c]=0;
								}

			grid[pacman_r-1][pacman_c]=1;
			grid[pacman_r][pacman_c]=0;
			}
		}else if(value==40){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(grid[pacman_r+1][pacman_c]==0||grid[pacman_r+1][pacman_c]==4||grid[pacman_r+1][pacman_c]==5){
				if(grid[pacman_r+1][pacman_c]==PELLET){
					score++;
					SoundEffect.PELL.play();
					}
				else if(grid[pacman_r+1][pacman_c]==EMPTY)score*=2000000;
				else if(grid[pacman_r+1][pacman_c]==POWERUP){
					score+=1000;
					SoundEffect.SUP.play();
				}
								else if(grid[pacman_r+1][pacman_c]==GHOST){
									lives--;
									System.out.println("Lives: " + lives);
			if(lives==2)live1.setIcon(new ImageIcon("walls.png"));
			if(lives==1)live2.setIcon(new ImageIcon("walls.png"));
			if(lives==0){
				System.exit(0);
			}
			grid[3][4]=PACMAN;
						grid[pacman_r][pacman_c]=0;
								}

			grid[pacman_r+1][pacman_c]=1;
			grid[pacman_r][pacman_c]=0;
			}
		}else if(value==37){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(grid[pacman_r][pacman_c-1]==0||grid[pacman_r][pacman_c-1]==4||grid[pacman_r][pacman_c-1]==5){
				if(grid[pacman_r][pacman_c-1]==PELLET){
					score++;
					SoundEffect.PELL.play();
					}
				else if(grid[pacman_r][pacman_c-1]==EMPTY)score*=2000000;
				else if(grid[pacman_r][pacman_c-1]==POWERUP){
					score+=1000;
					SoundEffect.SUP.play();
				}
				else if(grid[pacman_r][pacman_c-1]==GHOST){
					lives--;
			if(lives==2)live1.setIcon(new ImageIcon("walls.png"));
			if(lives==1)live2.setIcon(new ImageIcon("walls.png"));
			if(lives==0){
				System.exit(0);
			}
			grid[3][4]=PACMAN;
						grid[pacman_r][pacman_c]=0;
				}

			grid[pacman_r][pacman_c-1]=1;
			grid[pacman_r][pacman_c]=0;
			}
		}
		else if(value==39){
			int pacman_r=getPacManRow();
			int pacman_c=getPacManCol();
			if(grid[pacman_r][pacman_c+1]==0||grid[pacman_r][pacman_c+1]==4||grid[pacman_r][pacman_c+1]==5){
				if(grid[pacman_r][pacman_c+1]==PELLET){
					score++;
					SoundEffect.PELL.play();
					}
				else if(grid[pacman_r][pacman_c+1]==EMPTY)score*=2000000;
				else if(grid[pacman_r][pacman_c+1]==POWERUP){
					score+=1000;
					SoundEffect.SUP.play();
				}
				else if(grid[pacman_r][pacman_c+1]==GHOST){
					lives--;
			if(lives==2)live1.setIcon(new ImageIcon("walls.png"));
			if(lives==1)live2.setIcon(new ImageIcon("walls.png"));
			if(lives==0){
				System.exit(0);

			}
			grid[3][4]=PACMAN;
						grid[pacman_r][pacman_c]=0;

				}

			grid[pacman_r][pacman_c+1]=1;
			grid[pacman_r][pacman_c]=0;
			}
		}
		paintGrid();
		System.out.println("Score: "+score);
		if(score>=Double.POSITIVE_INFINITY){
			JOptionPane.showMessageDialog(null, "You are a cheater stop playing this game!");
			System.exit(0);
								SoundEffect.SUP.play();

		}
		else if(score>=2.6214403278458067E160){
			JOptionPane.showMessageDialog(null, "You are a winner stop playing this game!");
			System.exit(0);
								SoundEffect.SUP.play();

		}
	}
public void keyReleased(KeyEvent e){

}
public int getPacManRow(){
	for(int i = 0; i < 16; i ++){
		for(int j =0;j<8;j++){
			if(grid[i][j]==1)
				return i;
		}
	}
	return 0;

}
public int getPacManCol(){
	for(int i = 0; i < 16; i ++){
		for(int j =0;j<8;j++){
			if(grid[i][j]==1)
				return j;
	}
		}
	return 0;

}
public void paintGrid(){
score_txt.setText(""+score);
for(int i = 0; i < 16; i ++){
		for(int j =0;j<8;j++){
			pGrid[i][j].setIcon(blocks[grid[i][j]]);
			window.repaint();
		}
	}
}
JPanel body;
JPanel top;
JLabel score_lbl=new JLabel("Score");
JLabel score_txt=new JLabel("0000000");
JLabel live1=new JLabel();
JLabel live2=new JLabel();
JLabel live3=new JLabel();

	public Pacman(){

SoundEffect.init();
SoundEffect.volume = SoundEffect.Volume.HIGH;
	//ImageIcon eblock=new ImageIcon("wall.png");
	window=new JFrame("PacmanSwag");
	body=new JPanel();
	top=new JPanel();
	//window.setLayout(new GridLayout(16,8));
		top.setLayout(new GridLayout(1,8));
		top.add(score_lbl);
		top.add(score_txt);
		live1.setIcon(new ImageIcon("pacman.png"));
		live2.setIcon(new ImageIcon("pacman.png"));
		live3.setIcon(new ImageIcon("pacman.png"));
		top.add(live1);
		top.add(live2);
		top.add(live3);
	window.addKeyListener(this);
	body.setLayout(new GridLayout(16,8));
	block=new JLabel(eblock);
pGrid=new JLabel[16][8];
for(int i=0;i<16;i++){
for(int j=0;j<8;j++){
	pGrid[i][j]=new JLabel(blocks[grid[i][j]]);
	body.add(pGrid[i][j]);
}


}
	
window.add(body,BorderLayout.CENTER);
window.add(top,BorderLayout.NORTH);
window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
time = new Timer(1000, this);
time.start();



}
public static void main(String args[]){
new Pacman();

}


}


