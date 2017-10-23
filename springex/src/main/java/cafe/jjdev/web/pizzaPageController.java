package cafe.jjdev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pizzaPageController {

	@RequestMapping(value="/pieChart")
	public String piePageChart() {	
		return "pieChart";
	}
}
