package cucumber.hello;

import static com.google.common.truth.Truth.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

final class IsItFriday {
	private final String today;

	IsItFriday(String today) {
		this.today = today;
	}

	String isItFriday() {
		return "Friday".equals(today) ? "TGIF" : "Nope";
	}

}

public class StepDefinitions {
	private String today;
	private String actualAnswer;

	@Given("today is Sunday")
	public void today_is_Sunday() {
		today = "Sunday";
	}

	@Given("today is Friday")
	public void todayIsFriday() {
		today = "Friday";
	}

	@Given("today is {string}")
	public void today_is(String string) {
		today = string;
	}

	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_Friday_yet() {
		actualAnswer = new IsItFriday(today).isItFriday();
	}

	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAnswer) {
		assertThat(expectedAnswer).isEqualTo(actualAnswer);
	}

}
