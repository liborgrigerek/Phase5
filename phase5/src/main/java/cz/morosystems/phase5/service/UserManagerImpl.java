package cz.morosystems.phase5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase5.dao.UserDAO;
import cz.morosystems.phase5.entity.UserEntity;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
    private UserDAO userDAO;

	@Transactional
	public List<UserEntity> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public UserEntity getUser(Integer id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public UserEntity getUserWithLinks(Integer id) {
		return userDAO.getUserWithLinks(id);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
