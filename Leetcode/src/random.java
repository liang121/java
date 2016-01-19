package bloomberg;

public class random {
	int i;
	do
	{
	  i = 5 * (rand5() - 1) + rand5();  // i is now uniformly random between 1 and 25
	} while(i > 21);
	// i is now uniformly random between 1 and 21
	return i % 7 + 1;  // result is now uniformly random between 1 and 7
	
	
	int rand7()
	{
	    int vals[5][5] = {
	        { 1, 2, 3, 4, 5 },
	        { 6, 7, 1, 2, 3 },
	        { 4, 5, 6, 7, 1 },
	        { 2, 3, 4, 5, 6 },
	        { 7, 0, 0, 0, 0 }
	    };

	    int result = 0;
	    while (result == 0)
	    {
	        int i = rand5();
	        int j = rand5();
	        result = vals[i-1][j-1];
	    }
	    return result;
	}

}
