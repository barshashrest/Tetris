public class Check
{
    public Check()
    {
    }

//get the current GridPosition()
    public int[] getCurrentGridPosition()
    {
	int[] myint = {1,2};
	System.out.println("What " +myint[0]);
	return myint;

    }
 public static void main(String[] args)

    {
	Check myCheck = new Check();
	myCheck.getCurrentGridPosition();
    }
}