package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
//   void add(Car car);
   List<User> listUsers();
   User getUserFromCar(String model, int series);
}
