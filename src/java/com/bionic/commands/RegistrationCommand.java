package com.bionic.commands;

import com.bionic.entities.Account;
import com.bionic.entities.UserInformation;
import com.bionic.entities.Wallet;
import com.bionic.entities.AccountType;
import java.io.IOException;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eugene
 */
public class RegistrationCommand implements ICommand {

    EntityManager entityManager = null;
    Long id = null;
    Random random = new Random(Long.MAX_VALUE);
    Account account = null;
    Query queryAccount = null;
    Object queryResult = null;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("eWalletPU");
        entityManager = entityFactory.createEntityManager();
        EntityTransaction tr = entityManager.getTransaction();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String accountType = request.getParameter("account_type_id");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String currency = request.getParameter("wallet_currency");

        Long walletId = generateWalletID();
        Long accountId = generateAccountID();

        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setBalance(0.0);
        wallet.setCurrency(currency);

        UserInformation userInfo = new UserInformation();
        userInfo.setAccountId(accountId);
        userInfo.setEmail(email);
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);

        account = new Account();
        account.setLogin(login);
        account.setPassword(password);
        account.setAccountId(accountId);
        account.setWalletId(wallet);
        account.setAccountTypeId(new AccountType(accountType));
        account.setUserInformation(userInfo);

        tr.begin();
        entityManager.persist(wallet);
        entityManager.persist(userInfo);
        entityManager.persist(account);
        tr.commit();
        entityManager.close();
        entityFactory.close();
        return "/registrationsuccess.jsp";
    }

    public Long generateAccountID() {
        do {
            id = random.nextLong() >>> 1;
            queryResult = entityManager.find(Account.class, id);
        } while (queryResult != null);
        return id;
    }

    public Long generateWalletID() {
        do {
            id = random.nextLong() >>> 1;
            queryResult = entityManager.find(Wallet.class, id);
        } while (queryResult != null);
        return id;
    }

}
