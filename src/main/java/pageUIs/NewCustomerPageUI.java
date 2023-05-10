package pageUIs;

public class NewCustomerPageUI {

	public static final String DYNAMIC_TEXTBOX_BY_NAME = "XPATH=//*[@name='%s']";
	public static final String DYNAMIC_VALAIDATE_MSG = "XPATH=//*[@name='%s']/following-sibling::label";

	public static final String RESET_BTN = "NAME=res";
	public static final String SUBMIT_BTN = "NAME=sub";

	public static final String REGISTER_SUCCESSFUL_MSG = "XPATH=//table[@id='customer']//p[@class='heading3']";
	
	public static final String CUSTOMER_ID_TEXTBOX = "XPATH=//td[text()='Customer ID']//following-sibling::td";
}
