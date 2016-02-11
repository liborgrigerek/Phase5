package cz.morosystems.phase5.service;

import java.util.List;

import cz.morosystems.phase5.entity.UserEntity;

public interface UserManager {
	public UserEntity getUser(Integer id);
	public UserEntity getUserWithLinks(Integer id);
    public List<UserEntity> getAllUsers();
}
