package com.example.RestAPIProject;

import com.example.RestAPIProject.Model.User;
import com.example.RestAPIProject.Model.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestApiProjectApplicationTests {

	@Autowired
	UserRepository userRepo;

	@Test
	@Order(1)
	void test_createUser() {
		User user = new User();
		user.setFirstName("Mahdi");
		user.setLastName("Bagheri");
		user.setEmail("Bagheri.Almas@gmail.com");
		user.setPassword("123");
		userRepo.save(user);

		assertNotNull(userRepo.findById(2).get());
	}


	@Test
	@Order(2)
	void test_getAllUsers(){
		List<User> usersList = userRepo.findAll();
		assertThat(usersList).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	void test_getUserByID(){
		User user = userRepo.findById(1).get();
		assertNotNull(userRepo.findById(user.getId()).get());
		//assertEquals("TNAME",user.getVendorName());
	}

	@Test
	@Order(4)
	void test_updateUser(){
		User user = userRepo.findById(1).get();
		user.setFirstName("Mahdi_Update");
		user.setLastName("Bagheri_Update");
		userRepo.save(user);
		assertNotNull(userRepo.findById(1).get());
//		assertNotEquals("TPHONEs",repo.findById("T1").get().getVendorPhoneNumber());
	}

	@Test
	@Order(5)
	void test_deleteUser(){
		userRepo.deleteById(1);
		assertThat(userRepo.existsById(1)).isFalse();
	}
}
