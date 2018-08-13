package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Account;

/**
 * Created by 梦 on 2017/3/28.
 */
public interface AccountDAO {
    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);

//    void insertOnline(String username);
//
//    String getOnline();
//
//    void deleteOnline();
}
