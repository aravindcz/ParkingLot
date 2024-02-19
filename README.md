# Parking Lot Management System

This project implements a Parking Lot Management System, providing an automated ticketing system for a parking lot without human intervention.

## Tradeoffs Made

One of the tradeoffs made in this implementation is the utilization of hash maps for efficient data retrieval. While hash maps offer constant time complexity for key-based operations, they consume additional memory. This tradeoff is made to optimize time complexity for essential operations like finding registration numbers based on color or slot numbers based on car registration.

## Requirements

The parking lot system supports the following functionalities:

1. **Create Parking Lot**: Initialize the parking lot with a specified number of slots.
2. **Delete Parking Lot**: Clear the parking lot and release all slots.
3. **Park Car**: Allocate a parking slot for a car, considering proximity to the entry point.
4. **Leave Parking Lot**: Mark a parking slot as free when a car leaves.
5. **Status**: Display the current status of the parking lot, including occupied slots.
6. **Registration Numbers for Cars with Colour**: Retrieve registration numbers for cars of a specific color.
7. **Slot Number for Car with Registration Number**: Retrieve the slot number for a car with a given registration number.
8. **Slot Numbers for Cars with Colour**: Retrieve slot numbers for cars of a specific color.
9. **Exit**: Terminate the program.

## High-Level Design

The high-level design of the system includes the following components:

- **ParkingLotManager**: Manages the overall functionality of the parking lot.
- **Car**: Represents a car with registration number and color.
- **ParkingSlot**: Represents a parking slot containing a reference to a car.
- **MinHeap**: A min heap for efficient retrieval of the nearest parking slot.
- **IParkingLotManager**: Interface for defining parking lot manager methods.

## Low-Level Design

The low-level design includes details about the class interactions, data structures used, and method implementations. Refer to the Java source files for detailed information on each class's responsibilities.

## How to Run the Code

1. Clone the repository: `git clone https://github.com/aravindcz/ParkingLot.git`
2. Navigate to the project directory: `cd ParkingLot`
3. Compile the Java files: `javac *.java`
4. Run the main class: `java ParkingLotMain`

Follow the on-screen prompts to interact with the parking lot system.

## Contact Information

For any discussions or clarifications, feel free to reach out via email: aravindcnair24@gmail.com
