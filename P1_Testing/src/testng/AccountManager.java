package testng;
public class AccountManager 
{
	AccountModel accountModel;
	private RegistrationForm registrationForm;
	
	AccountManager ( AccountModel accountModel )
	{
		this.accountModel = accountModel;
	}
	
	/*----- ABEER -----*/ 
	void createRegistrationForm (String t, String fN, String lN, String uN, String e, String bd, 
	          String pw, String g, String s)
	{
		RegistrationForm registrationForm = new RegistrationForm(t, fN, lN, uN, e, 
				 bd, pw, g, s);
	/*-----------------*/
		
		validateFormContent ( registrationForm );
		
		if (registrationForm.type.equals("Teacher"))
		{
			Teacher teacher = new Teacher(fN, lN, uN, e, bd, pw, g, s);
			accountModel.addTeacher(teacher);
		}
		else
		{
			Student student = new Student(fN, lN, uN, e, bd, pw, g, s);
			accountModel.addStudent(student);
		}
		
		registrationForm.createdSuccessfullyMessage();
	}
	
	void validateFormContent ( RegistrationForm registrationForm )
	{
		this.registrationForm = registrationForm;
		while ( accountModel.checkUsernameExist(registrationForm.username) )
		{
			registrationForm.usernameExistMessage();
			registrationForm.insertUsername();
		}
		
		while ( accountModel.checkEmailExist(registrationForm.email) )
		{
			registrationForm.emailExistMessage();
			registrationForm.insertEmail();
		}
	}
	
	void addTournamentToAccount ( String username, Tournament tournament )
	{
		accountModel.insertTournament(username, tournament);
	}
	
	void addGameToAccount ( String username, Game game )
	{
		accountModel.insertGame(username, game);
	}
	
	void addScoreToAccount ( String username, int score )
	{
		accountModel.insertScore(username, score);
		
	}
	
	boolean checkIfTeacher(String  email , String password)
	{
		for(int i = 0 ; i < accountModel.teachers.size() ; i++)
		{
			if(email.equals(accountModel.teachers.get(i).getEmail()) && password.equals(accountModel.teachers.get(i).getPassword()))
				{
				  return true;
				}
		}
		
		return false;
	}
	
	
}
