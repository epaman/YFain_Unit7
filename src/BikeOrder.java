
public class BikeOrder {

	private String order = "";
	
	public String getOrder() {
		return order;
	}
	
	public void validateOrder(String bikeModel, int quantity) throws TooManyBikesException {
		
		if ((bikeModel == "Ukraina") && (quantity <=4)) {
			order = "Your order is valid: Model - " + bikeModel + ", Quantity - " + quantity;
		}
		else if ((bikeModel == "Aist") && (quantity <=5)) {
			order = "Your order is valid: Model - " + bikeModel + ", Quantity - " + quantity;
		}
		else if ((bikeModel == "Ardis") && (quantity <=7)) {
			order = "Your order is valid: Model - " + bikeModel + ", Quantity - " + quantity;
		}
		else if ((bikeModel == "Bergamont") && (quantity <=6)) {
			order = "Your order is valid: Model - " + bikeModel + ", Quantity - " + quantity;
		}
		else {
			throw new TooManyBikesException(" Can't ship package. Max Ukraina:4, Aist:5, Ardis:7, Bergamont:6.");
		}
	}	
}
