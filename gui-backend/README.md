You are required to develop a program that implements a basic vehicle rental system.

You should implement a console system from where the manager can add new vehicles, delete if needed, edit the vehicle information, etc. (as 
described in detailed below).

You should implement a Graphical User Interface (GUI) from where a customer can see the list of vehicles and book available vehicles for 
specific dates.

In this assignment, you will be required to implement the following functionality:

1.	According to the Inheritance principle you have to design and implement a super class Vehicle (6 marks) and
	the subclasses Car and Motorbike. The classes should include appropriate methods in order to comply with the encapsulation
	principle and hold information about the Plate number, and the Make (You can add any other information that you consider
	appropriate for a rental vehicle system and you can implement additional classes with justification to make the code more
	robust or user friendly).
	
	In particular:
	
	•	The Car class should hold specific information and methods. You should add at least 2 instance 
		variables (attributes that you believe are important to be held in this class) and the relative get/set methods (5 marks).
	
	•	The Motorbike class should hold specific information and methods. You should add at least 2 
		instance variables (attributes) and the relative get/set methods (5 marks).
	
	•	You should implement a class Schedule to represent the time slot when a vehicle has been booked.
		The class should have a pick-up date and a drop-off date (to represent the date you can use either the class 
		provided during tutorials or you can use any java API). (5 marks).

2.	Design and implement a class called WestminsterRentalVehicleManager, which implements the interface 
	RentalVehicleManager (2 marks). WestminsterRentalVehicleManager maintains the list of the vehicle to rent and 
	provides all the methods for the system manager.

	The class should display in the console a menu containing the following management actions from which the manager 
	can select one.
	
	•	Add a new vehicle in the rental system. It should be possible to add a new vehicle, either a car or 
		a motorbike with all the relevant information. You should consider that in the rental car park there are max 
		50 parking lots (5 marks).
	
	•	Delete a vehicle from the system, selecting the plate number. Display a message with the information 
		of the vehicle that has been deleted (if it is a car or motorbike) and the number of available parking lots 
		in the garage (5 marks).
	
	•	Print the list of the vehicles in the system. For each vehicle, print the plate number, the type of 
		vehicle (if is a car, a van or a motorbike). The list should be ordered alphabetically according to the vehicle 
		make (5 marks).
	
	•	Write/Save the vehicle stock list in a file after any changes (5 marks).

	Create a Graphical User Interface (GUI) that can be opened selecting an option from the menu console (? marks).
	You should implement the GUI according the following specification:

		•	The user can visualise the list of vehicles in WestminsterRentalVehicle system (8 marks).

		•	The user can filter the vehicles according at least one parameter (e.g. the type of the vehicle, or
			the engine size, or the make, etc.) (4 marks).

		•	The user can check the availability of the vehicle in specific dates and can book make a reservation
			if it is available (8 marks).

	Note: You can choose how the GUI should look like and how to meet at the best these specifications.

3.	Testing and system validation:

	•	Write a test plan designed to ensure that the coded solution works as expected. The test plan will
		include specific instructions about the data and conditions the program will be tested with (5marks).
		
	•	Implement an automated testing (you can use JUnit or feel free to use any other tool or scripts for unit
		testing) that runs scenarios of each of the use cases you implemented in the console menu (10 marks).
		
	•	The following will be evaluated:
	
		o The robustness of the code through the use of error handling and input validation (5marks).
		o The quality of the code and the adherence to coding standards and conventions (5 marks).
