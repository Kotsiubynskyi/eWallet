package com.bionic.servlet;

import com.bionic.commands.AccInfoCommand;
import com.bionic.commands.ErrorCommand;
import com.bionic.commands.ICommand;
import com.bionic.commands.LoginCommand;
import com.bionic.commands.RegistrationCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class ServletHelper {

    private static ServletHelper instance = null;
    private final String LOGIN = "login";
    private final String REGISTRATION = "registration";
    private final String ACCOUNT_INFO = "accountInfo";
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    public static ServletHelper getInstance() {
        if (instance == null) {
            instance = new ServletHelper();
        }
        return instance;
    }

    public ServletHelper() {
        commands.put(LOGIN, new LoginCommand());
        commands.put(REGISTRATION, new RegistrationCommand());
        commands.put(ACCOUNT_INFO, new AccInfoCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new ErrorCommand();
        }
        return command;
    }
}
