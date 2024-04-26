package observerPractice;

public class IceCreamStore implements Observer {
    private boolean sellingState;
    private Subject weatherData;

    public IceCreamStore(Subject weatherData) {
        this.sellingState = false;
        this.weatherData = weatherData;
    }

    public void isSelling() {
        System.out.println("Icecream " + ((sellingState) ? "" : "Not ") + "Sale !");
    }

    @Override
    public void update(float temperature, float rainfall) {
        if (temperature >= 20.0f) {
            sellingState = true;
        } else {
            sellingState = false;
        }
        isSelling();
    }
}
