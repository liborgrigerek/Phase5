package cz.morosystems.phase5.dao;

import java.util.List;

import cz.morosystems.phase5.entity.AccountEntity;
import cz.morosystems.phase5.entity.UserEntity;

public interface AccountDAO {
	public AccountEntity getAccount(Integer accountId);
    public List<AccountEntity> getAllAccounts(Integer userId);
    public void addAccount(AccountEntity account);
    public void editAccount(AccountEntity account);
    public void deleteAccount(Integer accountId);
}