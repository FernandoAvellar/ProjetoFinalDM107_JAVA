
package br.inatel.pos.dm107.services;

import java.io.IOException;
import java.util.Base64;

import br.inatel.pos.dm107.DAO.UserDAO;

public class AuthenticationService {
	
    public boolean authenticate(String credentials) {

        if (credentials == null)
            return false;
        // extraindo o valor vindo do header "Basic encodedstring" for Basic
        final String encodedUserPassword = credentials.replaceFirst("Basic"+ " ", "");
        String usernameAndPassword = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        final String splittedUsernameAndPassword[] = usernameAndPassword.split(":");
        final String username = splittedUsernameAndPassword[0];
        final String password = splittedUsernameAndPassword[1];

        boolean authenticationStatus = UserDAO.recuperaSenhaDeUmUsuario(username).equals(password);
        return authenticationStatus;
    }

}