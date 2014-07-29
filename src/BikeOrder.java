
public class BikeOrder {

	private String order = "";
	
	public String getOrder() {
		return order;
	}
	
	public String Okay(String bikeModel, int quantity){
		order = "Your order is valid: Model - " + bikeModel + ", Quantity - " + quantity;
		return order;
	}
	
	public void validateOrder(String bikeModel, int quantity) throws TooManyBikesException {
		
		if ((bikeModel == "Ukraina") && (quantity <=4)) {
			Okay(bikeModel, quantity);
		}
		else if ((bikeModel == "Aist") && (quantity <=5)) {
			Okay(bikeModel, quantity);
		}
		else if ((bikeModel == "Ardis") && (quantity <=7)) {
			Okay(bikeModel, quantity);
		}
		else if ((bikeModel == "Bergamont") && (quantity <=6)) {
			Okay(bikeModel, quantity);
		}
		else {
			throw new TooManyBikesException(" Can't ship package. Max Ukraina:4, Aist:5, Ardis:7, Bergamont:6.");
		}
	}	
}
