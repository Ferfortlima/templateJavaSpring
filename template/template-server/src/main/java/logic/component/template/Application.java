package logic.component.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.SQLException;

@SpringBootApplication
@EntityScan
public class Application {


    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);


    }

}
