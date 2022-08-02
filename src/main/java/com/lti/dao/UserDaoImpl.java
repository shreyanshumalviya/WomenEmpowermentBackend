package com.lti.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.Document;
import com.lti.entity.Family;
import com.lti.entity.User;
import com.lti.service.EmailService;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	EmailService emailService;

	private User registerDtoToUserMapper(UserRegisterDto user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setMiddleName(user.getMiddleName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setContactNo(user.getContactNo());
		newUser.setAadhaarNo(user.getAadhaarNo());
		newUser.setPanNo(user.getPanNo());
		newUser.setDob(user.getDob());
		newUser.setGender(user.getGender());
		newUser.setJobStatus(user.getJobStatus());
		newUser.setJobTitle(user.getJobTitle());
		newUser.setSalary(user.getSalary());
		newUser.setResidenceArea(user.getResidenceArea());
		newUser.setMaritalStatus(user.getMaritalStatus());
		newUser.setDisabled(user.getDisabled());

		return newUser;
	}

	private User updateDtoToUserMapper(UpdateUserDto user) {
		User newUser = em.find(User.class, user.getUserId());
		newUser.setUserId(user.getUserId());
		newUser.setFirstName(user.getFirstName());
		newUser.setMiddleName(user.getMiddleName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setContactNo(user.getContactNo());
		newUser.setAadhaarNo(user.getAadhaarNo());
		newUser.setPanNo(user.getPanNo());
		newUser.setDob(user.getDob());
		newUser.setGender(user.getGender());
		newUser.setJobStatus(user.getJobStatus());
		newUser.setJobTitle(user.getJobTitle());
		newUser.setSalary(user.getSalary());
		newUser.setResidenceArea(user.getResidenceArea());
		newUser.setMaritalStatus(user.getMaritalStatus());
		newUser.setDisabled(user.getDisabled());

		return newUser;
	}

	@Transactional
	public UserProfileDto addUser(UserRegisterDto user) {
		User user2 = em.merge(registerDtoToUserMapper(user));

		Document user2Doc = new Document();
		user2Doc.setUser(user2);
		user2Doc.setAadhaarNo(user.getAadhaarNo());
		user2Doc.setPanNo(user.getPanNo());
		user2Doc.setAadhaarLink(user.getAadhaarLink());
		user2Doc.setPanLink(user.getPanLink());
		user2Doc = em.merge(user2Doc);

		return new UserProfileDto(user2);
	}

	@Transactional
	public UserProfileDto updateUser(UpdateUserDto user) {
		return new UserProfileDto(em.merge(updateDtoToUserMapper(user)));
	}
	
	@Transactional
	public Document updateAadhaar(int documentId, String link) {
		Document document = em.find(Document.class, documentId);
		document.setAadhaarLink(link);
		return em.merge(document);
	}
	
	@Transactional
	public Document updatePan(int documentId, String link) {
		Document document = em.find(Document.class, documentId);
		document.setPanLink(link);
		return em.merge(document);
	}

	public UserProfileDto searchUserById(int userId) {
		return new UserProfileDto(em.find(User.class, userId));
	}

	public boolean login(int userId, String password) {
		return em.find(User.class, userId).getPassword().equals(password);
	}

	@Transactional
	public boolean changePassword(int userId, String password, String newPassword) {
		User user = em.find(User.class, userId);

		if (user.getPassword().equals(password)) {
			user.setPassword(newPassword);
			em.merge(user);
			return true;
		}

		return false;
	}

	@Transactional
	public boolean resetPassword(int userId) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedPassword = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		User user = em.find(User.class, userId);

		user.setPassword(generatedPassword);

		try {
			em.merge(user);
			try {
				emailService.sendEmailForSignup(user.getEmail(),
						"Password reset Successfull!\nYour User Id is: " + user.getUserId() + "\nYour new password is: "
								+ user.getPassword() + "\nChange your password after login",
						"Password Reset Requested");
			} catch (Exception e) {
				System.out.println(e);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	@Transactional
	public Family addFamilyOrUpdate(Family familyMember) {
		return em.merge(familyMember);
	}

	public List<Family> getFamilyDetails(int userId) {
		return em.find(User.class, userId).getFamilyMenbers();
	}

	public User getUserById(int userId) {
		return em.find(User.class, userId);
	}

}
