package pattern.proxy;

public class Client {

	public static void main(String[] args) {
		IVehicle car = new Car();
		VehicleProxy proxy = new VehicleProxy(car);

		IVehicle proxyObj = proxy.create();
		proxyObj.run();
	}

}
