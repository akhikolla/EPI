
public class ChangeMaking {
   public int changemaking(int change) {
	   int[] coins = {1,2,5};
	   int[] cache= new int[change+1];
	   for(int i = 0; i <= change ; i++) {
		   cache[i] = change+1;
	   }
	   cache[0] = 0;
	   for(int i = 1 ; i <= change ; i++) {
		   for(int j = 0 ; j <= coins.length ; j++) {
			   if(i - j >= 0) {
				   cache[i] = Math.min(cache[i-1]+1, i-j);
			   }
		   }
	   }
	   return cache[change];
   }
}
