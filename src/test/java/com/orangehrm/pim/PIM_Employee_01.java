package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.*;

public class PIM_Employee_01 extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private AddNewEmployeePO addNewEmployeePage;
    private PersonalDetailsPO personalDetailsPage;
    private EmployeeListPO employeeListPage;
    private ContactDetailsPO contactDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private  String employeeID, firstName, lastName, firstNameUpdate, lastNameUpdate  ;
    private String nationlity, driverLicense, licenseExpiryDate, gender, marital, dateOfBirth;
    private String avatarImageName = "xpath0.png";
    private String street1, street2, city, state, zipCode, country, homeTelephone, mobile, workTelephone, workEmail;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        firstName = "nguyen";
        lastName = "uyen" + generateRandomNumber();

        firstNameUpdate = "Nguyễn";
        lastNameUpdate = "Oén" + generateRandomNumber();
        driverLicense = "23031997";
        licenseExpiryDate = "2024-04-25";
        nationlity = "Vietnamese";
        marital = "Single";
        dateOfBirth = "2000-04-04";
        gender = "Male";
        street1 = "Số 68";
        street2 = "Ngõ 68, Nhà Trung Thiên - Nguyễn Uyến";
        city = "Hà Nội";
        state = "Hoà Lạc";
        zipCode = "100000";
        country = "Viet Nam";
        homeTelephone = "0987654321";
        mobile = "0385782504";
        workTelephone = "0123456789";
        workEmail = "thienuyen" + generateRandomNumber() + "@gmail.com";

        loginPage.enterToUsername("nguyenuyen");
        loginPage.enterToPassword("4tbLxgFMyx64npLs9!");
        dashboardPage = loginPage.clickToLoginButton();

    }
    @Test
    public void Employee_01_Add_New() {
          employeeListPage = dashboardPage.clickPIMPage();

          addNewEmployeePage = employeeListPage.clickAddNewEmployee();
          addNewEmployeePage.enterToFirstNameTextbox(firstName);
          addNewEmployeePage.enterToLastNameTextbox(lastName);
          employeeID = addNewEmployeePage.getEmployeeID();
          personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();

        System.out.println("employeeID: " + employeeID);
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToAvatarImage();

        // Lấy ra height và width của element (avatar) >> A
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);

        personalDetailsPage.clickToSaveButtonAtChangeProfilePicture();

        Assert.assertTrue(personalDetailsPage.isSuccesMessageIsDisplayed(driver));// "Successfully Updated"

        // không viết hàm này vào trong hàm clickToSave mà phải gọi ra hàm riêng vì sau khi click btn Save thì hệ thống hiển thị như sau:
        //1. Message upload success trước
        //2. Sau đó mới mất icon loadding
            // >> nếu mà cho đoạn wait vào hàm clickToSave thì sẽ không handle được case  check message, vì lúc đó message đã ko hiển thị nữa rồi
        //3. Sau khi mất loading icon >> ảnh mới được update
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        //Chỗ này verify dựa vào sự thay đổi kích thước của ảnh trước và sau khi upload
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdatedSucces(beforeUpload));

    }

    @Test
    public void Employee_03_Personal_Details() {
        // Update thông tin trong Personal Detail Page

        personalDetailsPage.openPersonalDetailsPage();
        personalDetailsPage.enterToFirstNameTextbox(firstNameUpdate);
        personalDetailsPage.enterToLastNameTextbox(lastNameUpdate);
        personalDetailsPage.enterToDriverLicenseTextbox(driverLicense);
        personalDetailsPage.enterToLicenseExpiryDate(licenseExpiryDate);
        personalDetailsPage.selectNationlityDropdown(nationlity);
        personalDetailsPage.selectMaritalDropdown(marital);
        personalDetailsPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailsPage.selectGenderMaleRadioButton(gender);
        personalDetailsPage.clickToSaveButtonAtPersonalDetailContainer();
        // Vì hàm isSuccesMessageIsDisplayed xuất hiện ở hầu hết các màn hình sau khi click Save
        // Nên >> chuyển thành hàm common trong BasePage để dùng lại nhiều lần
        Assert.assertTrue(personalDetailsPage.isSuccesMessageIsDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        //Verify
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(), firstNameUpdate);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(), lastNameUpdate);
        Assert.assertEquals(personalDetailsPage.getEmployeeId(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(), driverLicense);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryTextboxValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getNationlityDropdownValue(), nationlity);
        Assert.assertEquals(personalDetailsPage.getMaritalDropdownValue(), marital);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelected(gender));

    }

    @Test
    public void Employee_04_Contact_Details() {
       contactDetailsPage = personalDetailsPage.openContactDetailsPage();
        contactDetailsPage.enterTopStreet1Textbox(street1);
        contactDetailsPage.enterToStreet2Textbox(street2);
        contactDetailsPage.enterToCityTextbox(city);
        contactDetailsPage.enterToStateTextbox(state);
        contactDetailsPage.enterToZipTextbox(zipCode);
        contactDetailsPage.selectCountryDropdown(country);
        contactDetailsPage.enterToHomeTelephoneTextbox(homeTelephone);
        contactDetailsPage.enterToMobileTextbox(mobile);
        contactDetailsPage.enterToWorkTelephoneTextbox(workTelephone);
        contactDetailsPage.enterToWorkEmailTextbox(workEmail);
        contactDetailsPage.clicktoSaveButton();
        Assert.assertTrue(contactDetailsPage.isSuccesMessageIsDisplayed(driver));
        contactDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify
        Assert.assertEquals(contactDetailsPage.getStreet1TextboxValue(), street1);
        Assert.assertEquals(contactDetailsPage.getStreet2TextboxValue(), street2);
        Assert.assertEquals(contactDetailsPage.getCityTextboxValue(), city);
        Assert.assertEquals(contactDetailsPage.getStateTextboxValue(), state);
        Assert.assertEquals(contactDetailsPage.getZipCodeTextboxValue(), zipCode);
        Assert.assertEquals(contactDetailsPage.getCountryDropdownValue(), country);
        Assert.assertEquals(contactDetailsPage.getHomeTelephoneTextboxValue(), homeTelephone);
        Assert.assertEquals(contactDetailsPage.getMobileTextboxValue(), mobile);
        Assert.assertEquals(contactDetailsPage.getWorkTelephoneTextboxValue(), workTelephone);
        Assert.assertEquals(contactDetailsPage.getWorkEmailTextboxValue(), workEmail);

    }

    @Test
    public void Employee_05_Emergency_Details() {

    }

    @Test
    public void Employee_06_Assigned_Dependents() {

    }

    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
