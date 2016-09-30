import java.io.*;
import java.util.Scanner;

public class Gabato_MP1{
	public static void main(String[] args){
		int i, j, size, lft, rght, cntr;
		Scanner in = new Scanner(System.in);

		do{
			System.out.println("PLEASE ENTER A SIZE: ");
			size = in.nextInt();
		}while(size <1 || size>100);
		int[][] A = new int[size+1][size+1];

		for(i=j=0; j<size; j++)
			A[i][j] = 0;
		A[0][size/2] = 1;

        for(i=0;i < size; i++){
            for(j=0; j < size; j++){
                if(j == 0)
                    lft = 0;
                else
                    lft = A[i][j-1];
                if(j == size-1)
                    rght = 0;
                else
                    rght = A[i][j+1];
                cntr = A[i][j];

                if((lft==0 && cntr==0 && rght==0)||(lft==1 && cntr==1 && rght==1)||(lft==1 && cntr==1 && rght==0)||(lft==1 && cntr==0 && rght==1))
                    A[i+1][j] = 0;
                else
                    A[i+1][j] = 1;
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
	}
}
