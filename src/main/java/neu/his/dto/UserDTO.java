package neu.his.dto;

import neu.his.bean.User;

import java.util.List;

public class UserDTO {
    private List<User> users;
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
