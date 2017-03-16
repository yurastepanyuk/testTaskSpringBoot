package yu.stepanyuk.ra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yu.stepanyuk.ra.config.JpaConfig;
import yu.stepanyuk.ra.controller.DataController;
import yu.stepanyuk.ra.entity.Data;
import yu.stepanyuk.ra.service.DataService;

import java.util.Random;

@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner {

	@Autowired
	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {TestTaskApplication.class, JpaConfig.class}, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			dataService.addNewData(new Data(random.nextLong(), "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A"));
			dataService.addNewData(new Data(random.nextLong(), "Other browsers", "All others", "-", "-", "U"));
			dataService.addNewData(new Data(random.nextLong(), "Presto", "Opera for Wii", "Wii", "-", "A"));
		}

	}
}
