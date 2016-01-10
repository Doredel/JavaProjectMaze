package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
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
	Image hint;
	Image goalPortal;
	
	/** 
	 * @param parent
	 * @param style
	 */
	public Maze2D(Composite parent ,int style){
	        super(parent, SWT.DOUBLE_BUFFERED);
	        solution = null;
	        clue = null;
	        setMovement(true);
	        try {
	        	winScreen = new Image(getDisplay(), new FileInputStream("resources/oh_no__you_won__game_over__by_nemodally.png"));
	        	walls = new Image(getDisplay(), new FileInputStream("resources/asteroids.jpg"));
	        	hint = new Image(getDisplay(), new FileInputStream("resources/pylon.jpg"));
	        	goalPortal = new Image(getDisplay(), new FileInputStream("resources/portal.gif"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
	    	setBackground(new Color(null, 0,0,0));
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
					   
					  
					   int w = (width)/mazeData[0].length;
					   int h = (height)/mazeData.length;
					   
					   if(!character.getPosition().equals(goal) && movement){
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
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(character.getX(),i,j))) {
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if(i == goal.getY() && j == goal.getZ() && goal.getX() == character.getX()){
										e.gc.drawImage(goalPortal, 0, 0, goalPortal.getBounds().width,  goalPortal.getBounds().height, x, y, w, h);
							          }
							          if(i==character.getY() && j==character.getZ()){
										   character.draw(e, x, y, w, h);
		   
							          }
									break;
	
								case Y:
									if (solution != null) {
										if (solution.getSolution().contains(new StateMaze3d(new Position(j,character.getY(),i)))) {
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(j,character.getY(),i))) {
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if(i == goal.getZ() && j == goal.getX() && goal.getY() == character.getY()){
										e.gc.drawImage(goalPortal, 0, 0, goalPortal.getBounds().width,  goalPortal.getBounds().height, x, y, w, h);
							          }
							           if(i==character.getZ() && j==character.getX()){
										   character.draw(e, x, y, w, h);
		   
							          }
									break;
								case Z:
									if (solution != null) {
										if (solution.getSolution().contains(new StateMaze3d(new Position(i,j,character.getZ())))) {
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if (clue != null) {
										if (clue.getState().equals(new Position(i,j,character.getZ()))) {
											e.gc.drawImage(hint, 0, 0, hint.getBounds().width,  hint.getBounds().height, x, y, w, h);
										}
									}
									if(i == goal.getX() && j == goal.getY() && goal.getZ() == character.getZ()){
										e.gc.drawImage(goalPortal, 0, 0, goalPortal.getBounds().width,  goalPortal.getBounds().height, x, y, w, h);
							        }
							        if(i==character.getX() && j==character.getY()){
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
					    	  setMovement(false);
							  return;
					      }
					   
					}
			});
	 }

	
	
}
