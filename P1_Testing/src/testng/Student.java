package testng;


/*----- ABEER -----*/
/* Made Student extend from Account because it doesn't make sense that 
 * it extends Teacher. */
public class Student extends Account 
{
	String educationalStage;
	
	Student(String fN, String lN, String uN, String e, String bd, String pw, String g, String s) {
		super(fN, lN, uN, e, bd, pw, g);
		educationalStage = s;
	}
	
}

