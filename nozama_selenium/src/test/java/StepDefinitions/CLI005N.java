package StepDefinitions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CLI005N {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Given("^Linternaute demande a commande le contenu de son panier$")
	public void linternaute_demande_a_commande_le_contenu_de_son_panier() {
		System.setProperty("webdriver.gecko.driver", "S:\\TESTEUR INFORMATIQUE\\7_SELENIUM\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.get("http://127.0.0.1/nozama/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@id=\'block-uc_catalog-0\']/div/div/ul/li/a")));
		}
		driver.findElement(By.linkText("Jeux vidéo (5)")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//a[contains(text(),\'Playstation\')])[2]")));
		}
		driver.findElement(By.linkText("Playstation")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//form[@id=\'uc-catalog-buy-it-now-form-16\']/div/input[2]")));
		}
		driver.findElement(By.id("edit-submit-16")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id=\'content-messages-inner\']/div")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@id=\'update-checkout-buttons\']/input[3]")));
		}
		driver.findElement(By.id("edit-checkout")).click();
	}

	@When("^Linternaute sidentifie avec son \"([^\"]*)\" et son \"([^\"]*)\"$")
	public void linternaute_sidentifie_avec_son_et_son(String login, String mdp) {
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//fieldset[@id=\'customer-pane\']/div/div/a")));
		}

		driver.findElement(By.xpath(
				"/html/body/div/div/div[5]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/form/div/fieldset[2]/div/div[1]/a"))
				.click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-name\']")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-pass\']")));
		}
		driver.findElement(By.id("edit-name")).click();
		driver.findElement(By.xpath("//input[@id=\'edit-name\']")).sendKeys(login);
		driver.findElement(By.id("edit-pass")).click();
		driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).sendKeys(mdp);
		driver.findElement(By.id("edit-submit")).click();
		
		/*
		 * VERIFICATION DE LA CORRESPONDANCE VARIABLES UTILISATEUR LOGE ET UTILISATEUR
		 * AFFICHE on clique sur compte et on assert text l'élément utilisateur
		 */
		driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/div/div/ul/li[3]/a")).click();
		System.out.println("Début de la vérification du Xpath");
		driver.findElement(By.xpath("/html/body/div/div/div[5]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/h1"));
		System.out.println("Vérification du Xpath OK");
		
		System.out.println("#######################################");
		WebElement verifLogin = driver.findElement(By.xpath("/html/body/div/div/div[5]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/h1"));
		assertEquals(verifLogin.getText(), login);		
		System.out.println("##################"+verifLogin.getText()+"#####################");
		
		// FIN DE LA VERIF
		
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//fieldset[@id=\'customer-pane\']/div/div[2]/a")));
		}
		driver.findElement(By.cssSelector("#delivery-pane a")).click();

	}

	@When("^linternaute saisit son \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void linternaute_saisit_son(String nom, String prenom, String rue, String ville, String codepostal) {
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-delivery-delivery-first-name\']")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-delivery-delivery-last-name\']")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-delivery-delivery-street1\']")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-delivery-delivery-postal-code\']")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-delivery-delivery-city\']")));
		}
		driver.findElement(By.id("edit-panes-delivery-delivery-first-name")).click();
		driver.findElement(By.id("edit-panes-delivery-delivery-first-name")).sendKeys(prenom);
		driver.findElement(By.id("edit-panes-delivery-delivery-last-name")).click();
		driver.findElement(By.id("edit-panes-delivery-delivery-last-name")).sendKeys(nom);
		driver.findElement(By.id("edit-panes-delivery-delivery-street1")).click();
		driver.findElement(By.id("edit-panes-delivery-delivery-street1")).sendKeys(rue);
		driver.findElement(By.id("edit-panes-delivery-delivery-city")).click();
		driver.findElement(By.id("edit-panes-delivery-delivery-city")).sendKeys(ville);
		driver.findElement(By.id("edit-panes-delivery-delivery-postal-code")).click();
		driver.findElement(By.id("edit-panes-delivery-delivery-postal-code")).sendKeys(codepostal);
		driver.findElement(By.cssSelector("#billing-pane a")).click();
	}

	@When("^linternaute coche la case pour les selection automatique pour les donnees de facturation$")
	public void linternaute_coche_la_case_pour_les_selection_automatique_pour_les_donnees_de_facturation() {
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[@id=\'edit-panes-billing-copy-address-wrapper\']/label/input")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id=\'edit-panes-billing-copy-address\']")));
		}
		driver.findElement(By.id("edit-panes-billing-copy-address")).click();
	}

	@When("^linternaute saisit ses informations bancaire avec \"([^\"]*)\", \"([^\"]*)\",  \"([^\"]*)\"$")
	public void linternaute_saisit_ses_informations_bancaire_avec(String numerocarte, String datecarte,
			String codecrypto) {
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//fieldset[@id=\'quotes-pane\']/legend/a")));
		}
		driver.findElement(By.cssSelector("#quotes-pane a")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//fieldset[@id=\'payment-pane\']/legend/a")));
		}
		driver.findElement(By.cssSelector("#payment-pane > .collapse-processed > a")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id=\'edit-cc-number-wrapper\']/input")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id=\'edit-cc-cvv-wrapper\']/input")));
		}
		driver.findElement(By.id("edit-cc-number")).click();
		driver.findElement(By.id("edit-cc-number")).sendKeys(numerocarte);
		driver.findElement(By.id("edit-cc-exp-year")).click();
		{
			WebElement dropdown = driver.findElement(By.id("edit-cc-exp-year"));
			dropdown.findElement(By.xpath("//option[. = '2024']")).click();
		}
		driver.findElement(By.id("edit-cc-exp-year")).click();
		driver.findElement(By.id("edit-cc-cvv")).click();
		driver.findElement(By.id("edit-cc-cvv")).sendKeys(codecrypto);
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\'edit-panes-payment-next\']")));
		}
		driver.findElement(By.id("edit-panes-payment-next")).click();
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\'edit-panes-payment-next\']")));
		}
		driver.findElement(By.id("edit-continue")).click();
	}

	@When("^linternaute valide sa commande$")
	public void linternaute_valide_sa_commande() {
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\'edit-submit\']")));
		}
		driver.findElement(By.id("edit-submit")).click();
	}

	@Then("^la commande est validee$")
	public void la_commande_est_validee() {
		{
			WebDriverWait wait = new WebDriverWait(driver, 0);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/div/ul/li/a")));
		}
		driver.findElement(By.linkText("Se déconnecter")).click();
		driver.close();
	}
}
