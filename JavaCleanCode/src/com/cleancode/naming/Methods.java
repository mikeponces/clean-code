package com.cleancode.naming;

import java.time.LocalDateTime;

public class Methods {
	
	private UserRepository userRepository;
	
	private EmailService emailService;

	// 1. vague name "process"
	public boolean processUser(User user) {
        // 2. multiple responsibilities: validate, save, email
        if (user == null || user.getEmail() == null) {
            return false;
        }

        // 3. side-effect: mutate user object unexpectedly
        user.setLastLoginTime(LocalDateTime.now());

        userRepository.save(user);

        emailService.sendWelcomeEmail(user.getEmail());

        return true;
    }
	
	public void registerNewUser(User user) {
		if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Invalid user data");
        }
		
		userRepository.save(user);

        emailService.sendWelcomeEmail(user.getEmail());
	}
	
	class EmailService {

		public void sendWelcomeEmail(Object email) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class UserRepository {

		public void save(User user) {
			
		}
		
	}
	
	class User {

		public Object getEmail() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setLastLoginTime(LocalDateTime now) {
			// TODO Auto-generated method stub
			
		}

		public Object getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
