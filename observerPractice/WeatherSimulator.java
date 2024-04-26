package observerPractice;

public class WeatherSimulator {
	public static void main(String[] args) {
		WeatherDataSubject wdSubject = new WeatherDataSubject();

		// observer objects
		UmbrellaStore umbrellaStore = new UmbrellaStore(wdSubject);
		ClothingStore clothingStore = new ClothingStore(wdSubject);
		IceCreamStore icecreamStore = new IceCreamStore(wdSubject);

		// subject object
		wdSubject.registerObserver(umbrellaStore);
		wdSubject.registerObserver(clothingStore);
		wdSubject.registerObserver(icecreamStore);
		wdSubject.currentState();
		wdSubject.notifyObservers();

		// whether changed : temperature = 10.0'c, rainfall = 10.0mm
		System.out.println();
		wdSubject.setMeasurements(10.0f, 10.0f);
		wdSubject.currentState();
		wdSubject.notifyObservers();

		// whether changed : temperature = 16.0'c, rainfall = 1.0mm
		System.out.println();
		wdSubject.setMeasurements(16.0f, 1.0f);
		wdSubject.currentState();
		wdSubject.notifyObservers();
	}
}
