package racers.vo;

public class RacerVo {
	private String firstName;
	private String lastName;
	private String gender;
	private String minutes;
	private String seconds;

	public RacerVo(String firstName, String lastName, String gender, String minutes, String seconds) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return "{ firstName: " + firstName +
				", lastName: " + lastName +
				", gender: " + gender +
				", minutes: " + minutes +
				", seconds: " + seconds + " }";
	}
}