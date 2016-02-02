package cz.morosystems.phase5.dao;

import java.util.List;
import cz.morosystems.phase5.entity.UserEntity;

public interface UserDAO {
	public UserEntity getUser(Integer id);
    public List<UserEntity> getAllUsers();
}