public class Gabato_Rule30 extends Thread{
	public int[] array1;
	public int start;
	public int row;
	public int end;
	public int[] array2;

	public Gabato_Rule30(int start, int end, int[] array1){
		this.start = start;
		this.end = end;
		this.array1 = array1;
		array2 = new int[end-start+1];
	}

	public void run(){

        for(int i=start, j=0; i <= end; i++, j++){
        	int lft = i-1 >= 0 ? array1[i-1] : 0;
        	int rght = i+1 < array1.length-1 ? array1[i+1] : 0;
        	int cntr = array1[i]; 

        	if((lft==1 && cntr==1) || (lft==1 && rght==1) || (lft!=1 && cntr!=1 && rght!=1))
				array2[j] = 0;
            else
                array2[j] = 1;        
        }
	}

	public void swap(int[] array){
		for (int j=start, i=0; j <= end; j++, i++) {
            array[j] = array2[i];
        }
	}

	public void outPut(int[] array){
		String row = "";
        for(int i = 0; i < array.length; i++){
                row += array[i];           
        }
        System.out.println(row);
	}

	  public String toString() {
        String row = "";
        for (int i = start; i <= end; i++) {
     		row += array1[i];
        }
        return row;
    }
}