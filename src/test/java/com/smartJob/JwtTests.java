package com.smartJob;

import com.smartJob.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JwtTests {

	@InjectMocks
	private JwtUtil jwtUtil;

	private Long expiration = 604800L;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		ReflectionTestUtils.setField(jwtUtil, "expiration", expiration);
	}

	@Test
	void testGenerateToken() {
		String token = jwtUtil.generateToken("testUser");
		assertNotNull(token);
	}
}
