package observerPractice;

import java.util.ArrayList;

public class WeatherDataSubject implements Subject {
	private ArrayList<Observer> observers;

	private float temperature = 25.0f;
	private float rainfall = 0.0f;

	// default constructor
	public WeatherDataSubject() {
		this.observers = new ArrayList<Observer>();
	}

	public void setMeasurements(float temperature, float rainfall) {
		this.temperature = temperature;
		this.rainfall = rainfall;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void setRainfall(float rainfall) {
		this.rainfall = rainfall;
	}

	public void notifyDataSetChanged() {
		notifyObservers();
	}

	public void currentState() {
		System.out.printf(
				"===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
				temperature, rainfall);
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if (index >= 0) {
			observers.remove(index);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); ++i) {
			Observer observer = observers.get(i);
			observer.update(this.temperature, this.rainfall);
		}
	}
}
