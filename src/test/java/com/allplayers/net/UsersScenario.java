package com.allplayers.net;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class UsersScenario {
    @Given("^the email ([^\"]*)$")
    public void the_email(String email) {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^the password ([^\"]*)$")
    public void the_password(String password) {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^the User logs in$")
    public void the_User_logs_in() {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^they should have email ([^\"]*)$")
    public void they_should_have_email(String email) {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^they should have a UUID$")
    public void they_should_have_a_UUID() {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
