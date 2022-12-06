package org.sadr;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.Arrays;
import java.util.List;

public class DemoAuthenticatorProviderFactory implements AuthenticatorFactory {
    @Override
    public String getDisplayType() {
        return "Demo Authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return null;
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {AuthenticationExecutionModel.Requirement.REQUIRED, AuthenticationExecutionModel.Requirement.DISABLED};
        return REQUIREMENT_CHOICES;
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
        return null;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        ProviderConfigProperty title = new ProviderConfigProperty();
        title.setName("modalTitle");
        title.setType(ProviderConfigProperty.STRING_TYPE);
        title.setLabel("A title for popup modal");

        ProviderConfigProperty main = new ProviderConfigProperty();
        main.setName("modalMain");
        main.setType(ProviderConfigProperty.STRING_TYPE);
        main.setLabel("A main Text for popup modal");
        ProviderConfigProperty[] config={title,main};
        return Arrays.asList(config);
    }

    @Override
    public Authenticator create(KeycloakSession keycloakSession) {
        return new DemoAuthenticatorProvider();
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "Demo-authenticator";
    }
}
