import java.io.*;
import java.util.Scanner;

public class Gabato_MP5 extends Thread{

    private int x;
    private int y;
    private int[][] Z;
    //private int index;

    public Gabato_MP5(int x, int y, int[][] A){
        this.x = x;
        this.y = y;   
        Z = A;
    }

	public void run(){
        int lft=0, rght=0, cntr=0;
        if(x != 0) x -= 1;
         for(int i=x; i < y; i++){
            for(int j=0; j != Z.length; j++){

                if(j == 0){lft = 0;}
                else{lft = Z[i][j-1];}
                if(j == Z.length-1){rght = 0;}
                else{rght = Z[i][j+1];}
                cntr = Z[i][j];

                if((lft==0 && cntr==0 && rght==0)||(lft==1 && cntr==1 && rght==1)||(lft==1 && cntr==1 && rght==0)||(lft==1 && cntr==0 && rght==1))
                    Z[i+1][j] = 0;
                else
                    Z[i+1][j] = 1;      
                System.out.print(Z[i][j]);  
            }
            System.out.println();
        }
	}
}
