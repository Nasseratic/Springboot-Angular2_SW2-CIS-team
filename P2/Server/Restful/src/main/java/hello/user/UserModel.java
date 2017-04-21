package hello.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static hello.user.UserService.logger;

@Service
public class UserModel {
	

	ArrayList<User> users = new ArrayList<>();

    public UserModel(){

        this.users.add(new User("0","Mohamed","mhmeeaad@gmail.com","000","teacher"));
    }

    public boolean isValidNewEmail(String email){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(email) )return false;
        }
        return true;
    }

    public User authUser(String email , String pw){

        for (int i = 0; i < this.users.size(); i++) {
            logger.info("user :" + users.get(i).getPw()+ "test");
            if(this.users.get(i).getEmail().equals(email) && this.users.get(i).getPw().equals(pw) )
                return this.users.get(i);
        }
        return null;
    }
	
	public void addUser(User user){

        users.add(user);
	}

}
