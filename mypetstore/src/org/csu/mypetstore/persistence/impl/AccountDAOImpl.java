package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 梦 on 2017/3/28.
 */
public class AccountDAOImpl implements AccountDAO {
    private static final String GET_ACOUNT_BY_USERNAME = "SELECT\n" +
            "          SIGNON.USERNAME,\n" +
            "          ACCOUNT.EMAIL,\n" +
            "          ACCOUNT.FIRSTNAME,\n" +
            "          ACCOUNT.LASTNAME,\n" +
            "          ACCOUNT.STATUS,\n" +
            "          ACCOUNT.ADDR1 AS address1,\n" +
            "          ACCOUNT.ADDR2 AS address2,\n" +
            "          ACCOUNT.CITY,\n" +
            "          ACCOUNT.STATE,\n" +
            "          ACCOUNT.ZIP,\n" +
            "          ACCOUNT.COUNTRY,\n" +
            "          ACCOUNT.PHONE,\n" +
            "          PROFILE.LANGPREF AS languagePreference,\n" +
            "          PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
            "          PROFILE.MYLISTOPT AS listOption,\n" +
            "          PROFILE.BANNEROPT AS bannerOption,\n" +
            "          BANNERDATA.BANNERNAME\n" +
            "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
            "    WHERE ACCOUNT.USERID = ?\n" +
            "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
            "      AND PROFILE.USERID = ACCOUNT.USERID\n";

    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT\n" +
            "      SIGNON.USERNAME,\n" +
            "      ACCOUNT.EMAIL,\n" +
            "      ACCOUNT.FIRSTNAME,\n" +
            "      ACCOUNT.LASTNAME,\n" +
            "      ACCOUNT.STATUS,\n" +
            "      ACCOUNT.ADDR1 AS address1,\n" +
            "      ACCOUNT.ADDR2 AS address2,\n" +
            "      ACCOUNT.CITY,\n" +
            "      ACCOUNT.STATE,\n" +
            "      ACCOUNT.ZIP,\n" +
            "      ACCOUNT.COUNTRY,\n" +
            "      ACCOUNT.PHONE,\n" +
            "      PROFILE.LANGPREF AS languagePreference,\n" +
            "      PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
            "      PROFILE.MYLISTOPT AS listOption,\n" +
            "      PROFILE.BANNEROPT AS bannerOption,\n" +
            "      BANNERDATA.BANNERNAME\n" +
            "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
            "    WHERE ACCOUNT.USERID = ?\n" +
            "      AND SIGNON.PASSWORD = ?\n" +
            "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
            "      AND PROFILE.USERID = ACCOUNT.USERID\n";

    private static final String UPDATA_ACCOUNT = "UPDATE ACCOUNT SET\n" +
            "      EMAIL = ?,\n" +
            "      FIRSTNAME = ?,\n" +
            "      LASTNAME = ?,\n" +
            "      STATUS = ?,\n" +
            "      ADDR1 = ?,\n" +
            "      ADDR2 = ?,\n" +
            "      CITY = ?,\n" +
            "      STATE = ?,\n" +
            "      ZIP = ?,\n" +
            "      COUNTRY = ?,\n" +
            "      PHONE = ?\n" +
            "    WHERE USERID = ?";

    private static final String INSERT_ACCOUNT = "INSERT INTO ACCOUNT\n" +
            "      (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID)\n" +
            "    VALUES\n" +
            "      (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATA_PROFILE = " UPDATE PROFILE SET\n" +
            "      LANGPREF = ?,\n" +
            "      FAVCATEGORY = ?,\n" +
            "      MYLISTOPT = ?,\n" +
            "      BANNEROPT = ?\n" +
            "    WHERE USERID = ?";

    private static final String INSERT_PROFILE = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID)\n" +
            "    VALUES (?, ?, ?)";

    private static final String UPDATA_SIGNON = " UPDATE SIGNON SET PASSWORD = ?\n" +
            "    WHERE USERNAME = ?";

    private static final String INSERT_SIGNON = "INSERT INTO SIGNON (PASSWORD,USERNAME)\n" +
            "    VALUES (?, ?)";

//    private static final String INSERT_ONLINE = "INSERT INTO ONLINE(ONLINEID) VALUES(?)";
//
//    private static final String GET_ONLINE = "SELECT * FROM ONLINE";
//
//    private static final String DELETE_ONLINE = "DELETE FROM ONLINE";
    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACOUNT_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                account = new Account();
                account.setUsername(resultSet.getString(1));
                account.setEmail(resultSet.getString(2));
                account.setFirstName(resultSet.getString(3));
                account.setLastName(resultSet.getString(4));
                account.setStatus(resultSet.getString(5));
                account.setAddress1(resultSet.getString(6));
                account.setAddress2(resultSet.getString(7));
                account.setCity(resultSet.getString(8));
                account.setState(resultSet.getString(9));
                account.setZip(resultSet.getString(10));
                account.setCountry(resultSet.getString(11));
                account.setPhone(resultSet.getString(12));
                account.setLanguagePreference(resultSet.getString(13));
                account.setFavouriteCategoryId(resultSet.getString(14));
                account.setListOption(resultSet.getInt(15) == 1 ? true:false);
                account.setBannerOption(resultSet.getInt(16) == 1 ? true:false);
                account.setBannerName(resultSet.getString(17));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account tempAccount = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tempAccount = new Account();
                tempAccount.setUsername(resultSet.getString(1));
                tempAccount.setEmail(resultSet.getString(2));
                tempAccount.setFirstName(resultSet.getString(3));
                tempAccount.setLastName(resultSet.getString(4));
                tempAccount.setStatus(resultSet.getString(5));
                tempAccount.setAddress1(resultSet.getString(6));
                tempAccount.setAddress2(resultSet.getString(7));
                tempAccount.setCity(resultSet.getString(8));
                tempAccount.setState(resultSet.getString(9));
                tempAccount.setZip(resultSet.getString(10));
                tempAccount.setCountry(resultSet.getString(11));
                tempAccount.setPhone(resultSet.getString(12));
                tempAccount.setLanguagePreference(resultSet.getString(13));
                tempAccount.setFavouriteCategoryId(resultSet.getString(14));
                tempAccount.setListOption(resultSet.getInt(15) == 1 ? true:false);
                tempAccount.setBannerOption(resultSet.getInt(16) == 1 ? true:false);
                tempAccount.setBannerName(resultSet.getString(17));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tempAccount;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getEmail());
            preparedStatement.setString(2,account.getFirstName());
            preparedStatement.setString(3,account.getLastName());
            preparedStatement.setString(4,account.getStatus());
            preparedStatement.setString(5,account.getAddress1());
            preparedStatement.setString(6,account.getAddress2());
            preparedStatement.setString(7,account.getCity());
            preparedStatement.setString(8,account.getState());
            preparedStatement.setString(9,account.getZip());
            preparedStatement.setString(10,account.getCountry());
            preparedStatement.setString(11,account.getPhone());
            preparedStatement.setString(12,account.getUsername());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            preparedStatement.setString(1,account.getLanguagePreference());
            preparedStatement.setString(2,account.getFavouriteCategoryId());
            preparedStatement.setString(3,account.getUsername());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIGNON);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATA_ACCOUNT);
            preparedStatement.setString(1,account.getEmail());
            preparedStatement.setString(2,account.getFirstName());
            preparedStatement.setString(3,account.getLastName());
            preparedStatement.setString(4,account.getStatus());
            preparedStatement.setString(5,account.getAddress1());
            preparedStatement.setString(6,account.getAddress2());
            preparedStatement.setString(7,account.getCity());
            preparedStatement.setString(8,account.getState());
            preparedStatement.setString(9,account.getZip());
            preparedStatement.setString(10,account.getCountry());
            preparedStatement.setString(11,account.getPhone());
            preparedStatement.setString(12,account.getUsername());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATA_PROFILE);
            preparedStatement.setString(1,account.getLanguagePreference());
            preparedStatement.setString(2,account.getFavouriteCategoryId());
            preparedStatement.setString(3,account.isListOption() == true ? "1" : "0");
            preparedStatement.setString(4,account.isBannerOption() == true ? "1" : "0");
            preparedStatement.setString(5,account.getUsername());


            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATA_SIGNON);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void insertOnline(String username) {
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ONLINE);
//            preparedStatement.setString(1,username);
//
//            preparedStatement.executeUpdate();
//
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String getOnline() {
//        String username = null;
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_ONLINE);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                username = resultSet.getString(1);
//            }
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return username;
//    }
//
//    @Override
//    public void deleteOnline() {
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ONLINE);
//
//            preparedStatement.executeUpdate();
//
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
