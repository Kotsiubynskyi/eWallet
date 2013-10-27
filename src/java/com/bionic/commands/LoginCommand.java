package com.bionic.commands;

import com.bionic.entities.Account;
import com.bionic.entities.UserInformation;
import java.io.IOException;
import java.util.List;
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
public class LoginCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eWalletPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Account.findByLogin").setParameter("login", login);
        List acc = query.getResultList();
        if (!acc.isEmpty()) {
            Account account = (Account) acc.get(0);
            UserInformation userInfo = account.getUserInformation();
            if (account.getPassword().equals(password)) {
                request.setAttribute("accInfo", account);
                request.setAttribute("userInfo", userInfo);
                return "/main.jsp";
            }
        } else {
            return "/loginerror.jsp";
        }
        return "/error.jsp";
    }
}
