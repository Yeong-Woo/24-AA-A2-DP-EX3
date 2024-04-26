package observerPractice;

public class ClothingStore implements Observer {
	private static final int SUMMER_CLOTHS = 1;
	private static final int WINTER_CLOTHS = 2;

	private int state;
	private Subject weatherData;

	public ClothingStore(Subject weatherData) {
		this.state = SUMMER_CLOTHS;
		this.weatherData = weatherData;
	}

	public void kindOfSellingCloths() {
		System.out.println("Selling " + ((state == SUMMER_CLOTHS) ? "Summer" : "Winter") + " cloths !");
	}

	@Override
	public void update(float temperature, float rainfall) {
		if (temperature >= 15.0f) // when temperature exceeds 15.0'c
			state = SUMMER_CLOTHS; // selling summer cloths
		else // when temperature < 15.0
			state = WINTER_CLOTHS;
		kindOfSellingCloths();
	}
}
