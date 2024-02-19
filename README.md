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
2. Navigate to the project directory: `cd com/aravindcz/parkinglot/`
3. Compile the Java files: `javac model/*.java service/*.java ParkingLotCommandProcessor.java ParkingLotMain.java`
4. Run the main class: `java ParkingLotMain`

Follow the on-screen prompts to interact with the parking lot system.

## Example Usage

Assuming a parking lot with 6 slots, the following commands can be used:

1. **Create Parking Lot:**
    ```bash
    $ create_parking_lot 6
    ```
    Output: 
    ```
    Created a parking lot with 6 slots
    ```

2. **Park Cars:**
    ```bash
    $ park KA-01-HH-1234 White
    Allocated slot number: 1

    $ park KA-01-HH-9999 White
    Allocated slot number: 2

    $ park KA-01-BB-0001 Black
    Allocated slot number: 3
    ```

3. **Check Parking Lot Status:**
    ```bash
    $ status
    ```
    Output:
    ```
    Slot No. Registration No Colour
    1 KA-01-HH-1234 White
    2 KA-01-HH-9999 White
    3 KA-01-BB-0001 Black
    ```

4. **Retrieve Registration Numbers for Cars with Colour:**
    ```bash
    $ registration_numbers_for_cars_with_colour White
    ```
    Output:
    ```
    Registration No Colour
    KA-01-HH-1234   White
    KA-01-HH-9999   White
    ```

5. **Retrieve Slot Number for Car with Registration Number:**
    ```bash
    $ slot_number_for_car_with_registration_number KA-01-HH-1234
    ```
    Output:
    ```
    Registration No Slot Number
    KA-01-HH-1234   1
    ```

6. **Retrieve Slot Numbers for Cars with Colour:**
    ```bash
    $ slot_numbers_for_cars_with_colour White
    ```
    Output:
    ```
    Color Slot Number
    White   1, 2
    ```

7. **Leave Parking Lot:**
    ```bash
    $ leave 2
    Slot number 2 is free
    ```

8. **Exit:**
    ```bash
    $ exit
    ```
    Output:
    ```
    Exiting the program.
    ```

Feel free to modify and run these commands to explore the parking lot system.


## Contact Information

For any discussions or clarifications, feel free to reach out via email: aravindcnair24@gmail.com
