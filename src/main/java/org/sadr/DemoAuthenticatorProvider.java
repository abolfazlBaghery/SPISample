package org.sadr;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.FormMessage;

import javax.ws.rs.core.Response;
import java.util.Map;


public class DemoAuthenticatorProvider implements Authenticator {
    @Override
    public void authenticate(AuthenticationFlowContext authenticationFlowContext) {
        if(getConfig(authenticationFlowContext).containsKey("modalTitle") && getConfig(authenticationFlowContext).containsKey("modalMain")){
            //Response response = authenticationFlowContext.form().createInfoPage();
            Response response = authenticationFlowContext.form().addSuccess(new FormMessage("hiiiiiii")).createInfoPage();
            //authenticationFlowContext.challenge(response);
            authenticationFlowContext.success();
        }
    }

    private Map<String,String> getConfig(AuthenticationFlowContext context){
        AuthenticatorConfigModel configModel = context.getAuthenticatorConfig();
        if(configModel == null) return null;
        else return configModel.getConfig();
    }

    @Override
    public void action(AuthenticationFlowContext authenticationFlowContext) {

    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
        return false;
    }

    @Override
    public void setRequiredActions(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {

    }

    @Override
    public void close() {

    }
}
