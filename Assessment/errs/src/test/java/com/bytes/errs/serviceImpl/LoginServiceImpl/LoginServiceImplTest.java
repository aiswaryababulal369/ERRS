//package com.bytes.errs.serviceImpl.LoginServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.bytes.errs.dao.UserRepository;
//import com.bytes.errs.model.User;
//import com.bytes.errs.service.UserService;
//
//class LoginServiceImplTest {
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//    public void testFindByUsername() {
//        // Mocking UserRepository
//        UserRepository userRepositoryMock = mock(UserRepository.class);
//
//        // Creating a test user
//        User testUser = new User();
//        testUser.setUserName("aiswarya.b@bytestrone.com");
//        testUser.setUserPassword("aishu");
//
//        // Mocking the behavior of userRepository.findByUserName
//        when(userRepositoryMock.findByUserName(testUser.getUserName())).thenReturn(testUser);
//
//        // Creating an instance of UserService and setting the mock UserRepository
//        UserService userService = new UserService();
//        userService.setUserRepository(userRepositoryMock);
//
//        // Calling the method to be tested
//        User foundUser = userService.findByUsername(testUser.getUserName());
//
//        // Verifying the result
//        assertEquals("testuser", foundUser.getUserName());
//        assertEquals("testpassword", foundUser.getUserPassword());
//    }
//
//}
