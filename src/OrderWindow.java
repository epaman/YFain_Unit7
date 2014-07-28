
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderWindow extends JFrame {

	private BikeOrder order;
	private String selectedModel = "";
	private int selectedQuantity;

	public OrderWindow() {

		order = new BikeOrder();
		String[] bikeModels = { "", "Ukraina", "Aist", "Ardis", "Bergamont" };

		JPanel windowContent = new JPanel();

		//Set the layout manager for the panel
		GridLayout gl = new GridLayout(3, 2);
		windowContent.setLayout(gl);
		
		JLabel label1 = new JLabel("Select model: ", SwingConstants.CENTER);
		JComboBox model = new JComboBox(bikeModels);

		model.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox combo = (JComboBox) event.getSource();
				selectedModel = combo.getSelectedItem().toString();
			}
		});

		JLabel label2 = new JLabel("Quantity: ", SwingConstants.CENTER);
		JTextField quantity = new JTextField(20);

		JButton buttonOrder = new JButton("Order");
		JLabel label3 = new JLabel(" Order status: ");
	
		buttonOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (selectedModel == "") {
					label3.setText(" Please choose model!");
				}
				else try {
						selectedQuantity = Integer.parseInt(quantity.getText().toString());
						order.validateOrder(selectedModel, selectedQuantity);
						label3.setText(order.getOrder());
					}
				catch (NumberFormatException e) {
					label3.setText("You should provide quantity like integer number!");
				}
				catch (TooManyBikesException tmbe) {
					label3.setText(tmbe.getMessage());
				}
			}
		});

		//Add controls to the panel
		windowContent.add(label1);
		windowContent.add(model);
		windowContent.add(label2);
		windowContent.add(quantity);
		windowContent.add(buttonOrder);
		windowContent.add(label3);

		add(windowContent);

		setTitle("Place your order");
		setSize(800, 150);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new OrderWindow();
	}
}
