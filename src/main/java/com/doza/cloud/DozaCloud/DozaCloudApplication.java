package com.doza.cloud.DozaCloud;

import com.doza.cloud.DozaCloud.models.Completion;
import com.doza.cloud.DozaCloud.repository.CompletionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DozaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DozaCloudApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(CompletionRepository repo) {
		return args -> {
			repo.save(new Completion("GO", "Gasoline", Completion.Type.ENGINE));
			repo.save(new Completion("DT", "Diesel", Completion.Type.ENGINE));
			repo.save(new Completion("GAS", "Gas", Completion.Type.ENGINE));
			repo.save(new Completion("AT", "Auto", Completion.Type.GEARBOX));
			repo.save(new Completion("RB", "Robot", Completion.Type.GEARBOX));
			repo.save(new Completion("MT", "Manual", Completion.Type.GEARBOX));
			repo.save(new Completion("CV", "Crossover", Completion.Type.BODYTYPE));
			repo.save(new Completion("SD", "Sedan", Completion.Type.BODYTYPE));
			repo.save(new Completion("HB", "Hatchback", Completion.Type.BODYTYPE));
			repo.save(new Completion("LT", "Leather", Completion.Type.INTERIOR));
			repo.save(new Completion("CT", "Clothes", Completion.Type.INTERIOR));
			repo.save(new Completion("CB", "Combo", Completion.Type.INTERIOR));
			repo.save(new Completion("Y", "Yes", Completion.Type.PANORAMICROOF));
			repo.save(new Completion("N", "No", Completion.Type.PANORAMICROOF));
		};
	}
}
