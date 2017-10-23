package cafe.jjdev.web;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 메서드에서 리턴할 때 json을 리턴
@RestController
public class pizzaController {
	//private PizzaDao pizzaDao();
	
	@RequestMapping(value="/pieChartData")
	public ArrayList<Pizza> pieChart() {
		//ArrayList<Pizza> list = pizzaDao .selectPizza();
		ArrayList<Pizza> list = new ArrayList<Pizza>();
		list.add(new Pizza("Mushrooms", 3));
		list.add(new Pizza("Onions", 1));
		list.add(new Pizza("Olives", 1));
		list.add(new Pizza("Zucchini", 1));
		list.add(new Pizza("Pepperoni", 2));
		return list;
	}
	
	class Pizza{
		private String topping;
		private int slices;
		
		public Pizza(String s, int i){
			super();
			setTopping(s);
			setSlices(i);
		}
		public String getTopping() {
			return topping;
		}
		public void setTopping(String topping) {
			this.topping = topping;
		}
		public int getSlices() {
			return slices;
		}
		public void setSlices(int slices) {
			this.slices = slices;
		}
	}
}
