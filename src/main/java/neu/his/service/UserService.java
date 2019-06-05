package neu.his.service;

import neu.his.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void deletebyID(int id);
}
