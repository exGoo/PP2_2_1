package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Anton", "Antonov", "antonov@gmail.com");
      User user2 = new User("Magomed", "Magomedov", "magomedov@gmail.com");
      User user3 = new User("Ivan", "Ivanov", "antonov@gmail.com");
      User user4 = new User("Andrey", "Andreev", "andrey@gmail.com");

      Car car1 = new Car("Audi", "RS5");
      Car car2 = new Car("BMW", "M60");
      Car car3 = new Car("Mercedes", "W214");
      Car car4 = new Car("BMW", "X5");

      user1.setCarInfo(car1);
      user2.setCarInfo(car2);
      user3.setCarInfo(car3);
      user4.setCarInfo(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      User user = userService.getUsersOfCar("BMW", "M60");
      System.out.println(user);

      context.close();
   }
}
