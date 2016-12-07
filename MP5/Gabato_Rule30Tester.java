public class Gabato_Rule30Tester{
	public static final int THREAD_COUNT = 10;

	public static void main(String[] args){
		Gabato_Rule30[] worker = new Gabato_Rule30[THREAD_COUNT];

		int size = 500, intPerThread = size/THREAD_COUNT;
		int[] array = new int[size];
		
		array[size/2] = 1;

		long startTime = System.currentTimeMillis();
		
		for(int a=0; a<size; a++){
			int start = 0;
			int end = start + intPerThread - 1;
			for(int b=0; b < THREAD_COUNT; b++){
				if(end > size)
					end = size - 1;
				worker[b] = new Gabato_Rule30(start, end, array);
				start = end + 1;
				end = start + intPerThread - 1;
			}

			worker[0].outPut(array);

			for(int c=0; c < THREAD_COUNT; c++){
				worker[c].start();
			}

			for(int d=0; d < THREAD_COUNT; d++){
				while (worker[d].isAlive()) {
                    try {
                        worker[d].join();
                    } catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
			}

			for(int e=0; e < THREAD_COUNT; e++){
				worker[e].swap(array);
			}
		}
		System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));	
	}
}