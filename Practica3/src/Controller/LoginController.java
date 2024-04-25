
package Controller;

import Model.LoginModel;


public class LoginController {
    LoginModel model = new LoginModel();
    
    public boolean checkCredentials(String user, String pass){

        return model.login(user, pass);
    }
    
    
}
