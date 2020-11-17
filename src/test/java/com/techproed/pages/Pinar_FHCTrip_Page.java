package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pinar_FHCTrip_Page {

    public Pinar_FHCTrip_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement passWord;

    @FindBy(xpath="//button")
    public WebElement loginButon;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Room reservations")
    public  WebElement roomReservation;

    @FindBy(className = "hidden-480")
    public WebElement addRoomReservationButton;

    @FindBy(id = "IDUser")
    public WebElement idUser;

    @FindBy(id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(id = "DateStart")
    public WebElement dateStart;

    @FindBy(id = "DateEnd")
    public WebElement dateEnd;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy(id = "ChildrenAmount")
    public  WebElement childrenAmount;

    @FindBy(id = "ContactNameSurname")
    public WebElement nameSurname;

    @FindBy(id = "ContactPhone")
    public  WebElement phone;

    @FindBy(id = "ContactEmail")
    public  WebElement contactEmail;

    @FindBy(id = "Notes")
    public WebElement notes;

    @FindBy(id = "Approved")
    public WebElement approved;

    @FindBy(id = "IsPaid")
    public WebElement isPaid;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(className = "bootbox-body")
    public WebElement successfulyMesaj;

    @FindBy(className = "btn btn-primary")
    public WebElement okButton;

    @FindBy(xpath = "(//label[@class='error'])[1]")
    public WebElement selectMenuErrorMesaj;

    @FindBy(xpath = "//label[@for='DateStart']")
    public WebElement dateStartMenuError;

    @FindBy(xpath = "//label[@for='DateEnd']")
    public WebElement dateEndMenuError;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement mikeButton;

    @FindBy(xpath = "//i[@class='icon-key']")
    public WebElement logoutButton;
}
