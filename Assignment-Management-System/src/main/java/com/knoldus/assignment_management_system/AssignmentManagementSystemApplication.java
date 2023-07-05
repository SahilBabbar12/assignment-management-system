package com.knoldus.assignment_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The main class that starts the Assignment
 * Management System application.
 */
@SpringBootApplication
public class AssignmentManagementSystemApplication {
	/**
	 * The entry point of the Assignment
	 * Management System application.
	 * @param args The command line arguments.
	 */
	public static void main(final String[] args) {
		SpringApplication
				.run(AssignmentManagementSystemApplication.class,
						args);
	}
}
