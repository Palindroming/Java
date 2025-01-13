package kr.book.Controller;

import kr.book.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> userList = new ArrayList<>();


    public User addUser(String id, String username) {

       User user = findUser(id, username);
       if(user == null) {
           user = new User(id, username);
           userList.add(user);
           return user;
       }
       return null;

   }

   public User findUser(String userId, String userName){

    for(User user: userList){
        if(user.getId().equals(userId)){
            return user;
        }
    }
    return null;

   }

   public void RemoveUser(String userId){
        for(User user: userList){
            if(user.getId().equals(userId)){
                userList.remove(user);
            }
        }
   }

}
