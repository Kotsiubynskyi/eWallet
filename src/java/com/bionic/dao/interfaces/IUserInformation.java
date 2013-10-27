/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.dao.interfaces;

import com.bionic.entities.UserInformation;
import java.util.Map;

/**
 *
 * @author Eugene
 */
public interface IUserInformation {

    public void add(UserInformation clientInfo);

    public String getFirstName(Long accountId);

    public String getSecondName(Long accountId);

    public String getLastName(Long accountId);

    public String getEmail(Long accountId);

    public Map getUserInformation(Long accountId);
}
