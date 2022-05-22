package model;

import model.*;
import model.AutomotiveDealerController;

public class Init {
	public Init(AutomotiveDealerController controller) {
		
		Electric test = new Electric(100000000, "ford", "2011", 1, 1, 2222, "SES85B", 4, 'Y', 1, 1, 222, 0); //1.2E8
        controller.vehicles.add(test);
        controller.garage.addVehicle(test);

        Gasoline test2 = new Gasoline(10000, "bmw", "2014", 2, 4, 232323, "SES86B", 3, 'N', 1, 1, 5, 0.2);
        controller.vehicles.add(test2);
        controller.garage.addVehicle(test2);
        
        Motorcycle test3 = new Motorcycle(4234, "ferrari", "2002", 2, 4, 424, "SES87B", 2, 4, 0.2);
        controller.vehicles.add(test3);
        controller.garage.addVehicle(test3);
	}
}
