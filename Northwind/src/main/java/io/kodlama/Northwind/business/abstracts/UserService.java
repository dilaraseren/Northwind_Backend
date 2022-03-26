package io.kodlama.Northwind.business.abstracts;

import io.kodlama.Northwind.core.entities.User;
import io.kodlama.Northwind.core.utilities.results.DataResult;
import io.kodlama.Northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);
    DataResult<User>findByEmail(String email);

}
