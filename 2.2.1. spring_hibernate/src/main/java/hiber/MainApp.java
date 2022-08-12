package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Petr", "Ivanov", "user1@mail.ru");
      Car car1 = new Car("GLS", 500);
      userService.add(user1.setCar(car1).setUser(user1));

      User user2 = new User("Kventin", "Tarantino", "user2@mail.ru");
      Car car2 = new Car("S", 320);
      userService.add(user2.setCar(car2).setUser(user2));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user+" "+user.getCar());
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println(user.getCar());
//         System.out.println();
      }

      System.out.println(userService.getUserFromCar("S", 320));

      context.close();
   }
}
