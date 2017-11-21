package br.com.theoldpinkeye.mvpexample.login;

/**
 * Created by Just Us on 20/11/2017.
 */

public class MemoryRepository implements LoginRepository {
    private User user;


    @Override
    public User getUser() {
        if (user == null){
            User user = new User("Gretchen", "Miranda");
            user.setId(0);
            return user;
        } else {
            return user; //retornará user jpa salvo nessa instância do MemoryRepository        }
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null){
            user = getUser();
        }
        this.user = user;
    }
}
