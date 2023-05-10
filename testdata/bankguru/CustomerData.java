package bankguru;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class CustomerData {

	public static CustomerData getCustomerData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.DATA_PATH + "Customer.json"), CustomerData.class);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	static class Register {
		@JsonProperty("customerName")
		private String customerName;

		@JsonProperty("dateOfBirth")
		private String dateOfBirth;

		@JsonProperty("address")
		private String address;

		@JsonProperty("city")
		private String city;

		@JsonProperty("state")
		private String state;

		@JsonProperty("pinNumber")
		private String pinNumber;

		@JsonProperty("telephoneNumber")
		private String telephoneNumber;

		@JsonProperty("email")
		private String email;

		@JsonProperty("password")
		private String password;
	}

	@JsonProperty("Register")
	private Register register;

	public String getCustomerName() {
		return register.customerName;
	}

	public String getDateOfBirth() {
		return register.dateOfBirth;
	}

	public String getAddress() {
		return register.address;
	}

	public String getCity() {
		return register.city;
	}

	public String getState() {
		return register.state;
	}

	public String getPinNumber() {
		return register.pinNumber;
	}

	public String getTelephoneNumber() {
		return register.telephoneNumber;
	}

	public String getEmail() {
		return register.email;
	}

	public String getPassword() {
		return register.password;
	}

	static class Login {
		@JsonProperty("loginEmail")
		private String loginEmail;

		@JsonProperty("loginUserID")
		private String loginUserID;

		@JsonProperty("loginPassword")
		private String loginPassword;
	}

	@JsonProperty("Login")
	private Login login;

	public String getLoginEmail() {
		return login.loginEmail;
	}

	public String getLoginUserID() {
		return login.loginUserID;
	}

	public String getLoginPassword() {
		return login.loginPassword;
	}
}
