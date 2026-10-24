package pageUIs.orangehrm.pim.employee;

public class ContactDetailsPageUIs {
    public static final String STREET_1_TEXTBOX = "xpath=//label[text()='Street 1']/parent::div//following-sibling::div//input";
    public static final String STREET_2_TEXTBOX = "xpath=//label[text()='Street 2']/parent::div//following-sibling::div//input";
    public static final String CITY_TEXTBOX = "xpath=//label[text()='City']/parent::div//following-sibling::div//input";
    public static final String STATE_TEXTBOX = "xpath=//label[text()='State/Province']/parent::div//following-sibling::div//input";
    public static final String ZIP_CODE_TEXTBOX = "xpath=//label[text()='Zip/Postal Code']/parent::div//following-sibling::div//input";
    public static final String COUNTRY_DROPDOWN_PARENT = "xpath=//label[text()='Country']/parent::div//following-sibling::div//i";
    public static final String COUNTRY_DROPDOWN_CHILD = "xpath=//label[text()='Country']/parent::div//following-sibling::div//div[contains(@class, 'oxd-select-option')]/span";
    public static final String COUNTRY_DROPDOWN_SELECTED_VALUE = "xpath=//label[text()='Country']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String HOME_TELEPHONE_TEXTBOX = "xpath=//label[text()='Home']/parent::div//following-sibling::div//input";
    public static final String MOBILE_TEXTBOX = "xpath=//label[text()='Mobile']/parent::div//following-sibling::div//input";
    public static final String WORK_TELEPHONE_TEXTBOX = "xpath=//label[text()='Work']/parent::div//following-sibling::div//input";
    public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text()='Work Email']/parent::div//following-sibling::div//input";
    public static final String SAVE_BUTTON = "xpath=//button[contains(string(), 'Save')]";

}
