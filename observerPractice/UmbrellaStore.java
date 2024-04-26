package observerPractice;

public class UmbrellaStore implements Observer {
	private boolean sellingState;
	private Subject weatherData;

	// default constructor
	public UmbrellaStore(Subject weatherData) {
		this.sellingState = false;
		this.weatherData = weatherData;
	}

	public void isSelling() {
		System.out.println("Umbrella " + ((sellingState) ? "" : "Not ") + "Sale !");
	}

	@Override
	public void update(float temperature, float rainfall) {
		if (rainfall >= 5.0f)// when rainfall exceeds 5.0mm
			sellingState = true;
		else // when rainfall < 5.0
			sellingState = false;

		isSelling();
	}
}
