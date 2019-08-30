package r1.pages;

import java.io.IOException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;

public class UserLogin extends BasePage {

	@FindBy(xpath = "//*[@id='nav-link-yourAccount']/span[2]")
	WebElementFacade signInLink;

	@FindBy(id = "dnn_ctr1029_Login_Login_DNN_txtUsername")
	WebElementFacade username;

	@FindBy(id = "dnn_ctr1029_Login_Login_DNN_txtPassword")
	WebElementFacade password;

	@FindBy(id = "dnn_ctr1029_Login_Login_DNN_cmdLogin")
	WebElementFacade signInButton;

	public void GoToSignInPage() {
		signInLink.click();
	}
	
	public boolean VerifyUsernameTextBox() {
		return username.isVisible();
	}

	public void EnterCredentials() throws IOException {
		String email = CommonMethods.LoadProperties("username");
		String passwd = CommonMethods.LoadProperties("password");
		username.type(email);
		password.type(passwd);
	}

	public void ClickLoginButton() {
		signInButton.click();
	}

}
