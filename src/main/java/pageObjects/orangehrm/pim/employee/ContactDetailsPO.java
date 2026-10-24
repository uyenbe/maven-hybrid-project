package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.ContactDetailsPageUIs;

public class ContactDetailsPO extends EmployeeTab {
    private WebDriver driver;
    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterTopStreet1Textbox(String street1) {
        waitForElementVisible(driver, ContactDetailsPageUIs.STREET_1_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.STREET_1_TEXTBOX, street1);
    }

    public void enterToStreet2Textbox(String street2) {
        waitForElementVisible(driver, ContactDetailsPageUIs.STREET_2_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.STREET_2_TEXTBOX, street2);
    }

    public void enterToCityTextbox(String city) {
        waitForElementVisible(driver, ContactDetailsPageUIs.CITY_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.CITY_TEXTBOX, city);
    }

    public void enterToStateTextbox(String state) {
        waitForElementVisible(driver, ContactDetailsPageUIs.STATE_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.STATE_TEXTBOX, state);
    }

    public void enterToZipTextbox(String zipCode) {
        waitForElementVisible(driver, ContactDetailsPageUIs.ZIP_CODE_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.ZIP_CODE_TEXTBOX, zipCode);
    }

    public void selectCountryDropdown(String country) {
        waitForElementClickable(driver, ContactDetailsPageUIs.COUNTRY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ContactDetailsPageUIs.COUNTRY_DROPDOWN_PARENT, ContactDetailsPageUIs.COUNTRY_DROPDOWN_CHILD, country);
    }

    public void enterToHomeTelephoneTextbox(String homeTelephone) {
        waitForElementVisible(driver, ContactDetailsPageUIs.HOME_TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.HOME_TELEPHONE_TEXTBOX, homeTelephone);
    }

    public void enterToMobileTextbox(String mobile) {
        waitForElementVisible(driver, ContactDetailsPageUIs.MOBILE_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.MOBILE_TEXTBOX, mobile);
    }

    public void enterToWorkTelephoneTextbox(String workTelephone) {
        waitForElementVisible(driver, ContactDetailsPageUIs.WORK_TELEPHONE_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.WORK_TELEPHONE_TEXTBOX, workTelephone);
    }

    public void enterToWorkEmailTextbox(String workEmail) {
        waitForElementVisible(driver, ContactDetailsPageUIs.WORK_EMAIL_TEXTBOX);
        sendKeysToElement(driver, ContactDetailsPageUIs.WORK_EMAIL_TEXTBOX, workEmail);
    }

    public void clicktoSaveButton() {
        waitForElementVisible(driver, ContactDetailsPageUIs.SAVE_BUTTON);
        clickToElement(driver, ContactDetailsPageUIs.SAVE_BUTTON);
    }

    public String getStreet1TextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.STREET_1_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.STREET_1_TEXTBOX, "value");
    }

    public String getStreet2TextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.STREET_2_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.STREET_2_TEXTBOX, "value");
    }

    public String getCityTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.CITY_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.CITY_TEXTBOX, "value");
    }

    public String getStateTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.STATE_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.STATE_TEXTBOX, "value");
    }

    public String getZipCodeTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.ZIP_CODE_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.ZIP_CODE_TEXTBOX, "value");
    }

    public String getCountryDropdownValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.COUNTRY_DROPDOWN_SELECTED_VALUE);
        return getElementText(driver, ContactDetailsPageUIs.COUNTRY_DROPDOWN_SELECTED_VALUE);
    }

    public String getHomeTelephoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.HOME_TELEPHONE_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.HOME_TELEPHONE_TEXTBOX, "value");
    }

    public String getMobileTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.MOBILE_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.MOBILE_TEXTBOX, "value");
    }

    public String getWorkTelephoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.WORK_TELEPHONE_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.WORK_TELEPHONE_TEXTBOX, "value");
    }

    public String getWorkEmailTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPageUIs.WORK_EMAIL_TEXTBOX);
        return getDOMPropertiesAttributeValue(driver, ContactDetailsPageUIs.WORK_EMAIL_TEXTBOX, "value");
    }
}
