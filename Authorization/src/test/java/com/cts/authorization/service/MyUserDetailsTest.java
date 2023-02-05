package com.cts.authorization.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.authorization.model.User;

@SpringBootTest
class MyUserDetailsTest {
	
	

	@Test
	void testGetPassword() {
		User u=new User(1,"amruta","123");
		assertEquals("123",u.getPassword());
	}

	@Test
	void testGetUsername() {
		User u=new User(1,"amruta","123");
		assertEquals("amruta",u.getUsername());	
	}

}
