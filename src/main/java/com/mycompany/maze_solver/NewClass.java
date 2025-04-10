/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;



import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author dache
 */
public class NewClass extends JFrame{
    
    private int[][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,1,1,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1}, //9-> destination  point 
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public List<Integer> path=new ArrayList<>(); //AL -> contains coordinates
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
//        System.out.println(path);
        
    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length;j++){ 
                Color color;
                color = switch (maze[i][j]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        for(int i=0;i<path.size();i+=2){ //i+=2 -> added x, y in path array list DF
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println("X coordinates"+pathx);
            System.out.println("Y coordinates"+pathy);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20,20); //line thickness
        }
    }
    public static void main(String[] args){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
