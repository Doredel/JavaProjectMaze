package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;
import algorithms.search.StateMaze3d;


public class Maze2D extends Maze3dDisplayer{	

	Image walls;
	Image winScreen;
	
	
	
	public Maze2D(Composite parent ,int style){
	        super(parent, style);
	        solution = null;
	        clue = null;
	        try {
	        	winScreen = new Image(getDisplay(), new FileInputStream("resources/oh_no__you_won__game_over__by_nemodally.png"));
	        	walls = new Image(getDisplay(), new FileInputStream("resources/Wall.jpg"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
	    	setBackground(new Color(null, 255, 255, 255));
	    	addPaintListener(new PaintListener() {
				
				@Override
				public void paintControl(PaintEvent e) {
					   e.gc.setForeground(new Color(null,0,0,0));
					   e.gc.setBackground(new Color(null,0,0,0));

					   int width=getSize().x;
					   int height=getSize().y;

					   if(mazeData == null){
						   e.gc.fillRectangle(0,0,width,height);
						   return;
					   }
					   
					   int w=width/mazeData[0].length;
					   int h=height/mazeData.length;
					   if(!character.getPosition().equals(goal)){
						   for(int i=0;i<mazeData.length;i++)
						      for(int j=0;j<mazeData[i].length;j++){
						          int x=j*w;
						          int y=i*h;
						          if(mazeData[i][j]!=0)
						              e.gc.drawImage(walls, 0, 0, walls.getBounds().width,  walls.getBounds().height, x, y, w, h);
						          switch (cross) {
								case X:
									if (solution != null) {
										if (solution.getSolution().contains(new StateMaze3d(new Position(character.getX(),i,j)))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(character.getX(),i,j))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if(i == goal.getY() && j == goal.getZ() && goal.getX() == character.getX()){
							        	  	e.gc.setBackground(new Color(null,0,255,0));
							        	  	e.gc.fillRectangle(x,y,w,h);
							          }
							          if(i==character.getY() && j==character.getZ()){
										   e.gc.setBackground(new Color(null,200,0,0));
										   character.draw(e, x, y, w, h);
		   
							          }
									break;
	
								case Y:
									if (solution != null) {
										if (solution.getSolution().contains(new StateMaze3d(new Position(j,character.getY(),i)))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(j,character.getY(),i))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if(i == goal.getZ() && j == goal.getX() && goal.getY() == character.getY()){
							        	  e.gc.setBackground(new Color(null,0,255,0));
							        	  e.gc.fillRectangle(x,y,w,h);
							          }
							           if(i==character.getZ() && j==character.getX()){
										   e.gc.setBackground(new Color(null,200,0,0));
										   character.draw(e, x, y, w, h);
		   
							          }
									break;
								case Z:
									if (solution != null) {
										if (solution.getSolution().contains(new StateMaze3d(new Position(i,j,character.getZ())))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(i,j,character.getZ()))) {
											e.gc.setBackground(new Color(null,150,150,150));
								        	e.gc.fillRectangle(x,y,w,h);
										}
									}
									if(i == goal.getX() && j == goal.getY() && goal.getZ() == character.getZ()){
							        	  e.gc.setBackground(new Color(null,0,255,0));
							        	  e.gc.fillRectangle(x,y,w,h);
							        }
							        if(i==character.getX() && j==character.getY()){
							        		e.gc.setBackground(new Color(null,200,0,0));
							        		character.draw(e, x, y, w, h);
		   
							        }
									break;
						          }
						          if(solution != null){
						        	  if(solution.getSolution().contains(new StateMaze3d(character.getPosition()))){
						        		  solution.getSolution().remove(new StateMaze3d(character.getPosition()));
						        	  }
						          }
						          if(clue != null){
						        	  if(clue.getState().equals(character.getPosition())){
						        		  clue = null;
						        	  }
						          }
						      }
					      }else{
					    	  e.gc.drawImage(winScreen, 0, 0, winScreen.getBounds().width,  winScreen.getBounds().height, 0, 0, width, height);
							  return;
					      }
					   
					}
			});
	 }

	
	
}
