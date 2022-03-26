package io.kodlama.Northwind.business.concretes;

import io.kodlama.Northwind.business.abstracts.UserService;
import io.kodlama.Northwind.core.dataAccess.UserDao;
import io.kodlama.Northwind.core.entities.User;
import io.kodlama.Northwind.core.utilities.results.DataResult;
import io.kodlama.Northwind.core.utilities.results.Result;
import io.kodlama.Northwind.core.utilities.results.SuccessDataResult;
import io.kodlama.Northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
       this.userDao.save(user);
       return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
       return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
    }
}
