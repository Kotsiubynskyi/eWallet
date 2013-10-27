/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.commands;

/**
 *
 * @author Eugene
 */
public class CommandFactory {

    private static final String LOGIN = "login";
    private static final String REGISTRATION = "registration";
    private static final String TRANSFER = "transfer";
    private static final String ACCOUNT_INFO = "accountInfo";

    public static ICommand getInstance(String value) {
        if (value.equals(LOGIN)) {
            return new LoginCommand();
        } else if (value.equals(REGISTRATION)) {
            return new RegistrationCommand();
        } else if (value.equals(ACCOUNT_INFO)) {
            return new AccInfoCommand();
        }
        return new LoginCommand();
    }
}
