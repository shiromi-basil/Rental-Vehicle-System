# Rental Vehicle System
A web application that implements a basic rental vehicle system. A console system from where the manager can add new vehicles, delete and edit vehicle information. A Graphical User Interface (GUI) from where a customer can see the list of vehicles and book vehicles for specific dates.

## Table of Contents
- [Getting Started](#getting-started)
- [Features](#features)
- [Screenshots](#screenshots)
- [Tests](#tests)
- [Built With](#built-with)
- [Authors](#authors)
- [License](#license)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* [JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Node.js](https://nodejs.org/en/download/)
* [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
* [@angualr/cli](https://www.npmjs.com/package/@angular/cli)
* [MySQL](https://www.mysql.com/downloads/)

### Installation

#### Clone Repository:
  
    git clone https://github.com/SafiyyahR/ARC-R3ACT.git

#### To setup database:

    CREATE DATABASE rental-vehicle-system
    
When running the project for the first time, change the line below in the `rental-vehicle-system\console-system\src\main\resources\META-INF\persistence.xml` file.
    
    <property name="hibernate.hbm2ddl.auto" value="create"/>
    
To add demo data into the database, execute the SQL queries in file `rental-vehicle-system\rental-vehicle-system.sql`.

#### To install dependencies:

    cd gui-frontend
    npm install

#### To start server:

    npm start

#### To visit app:

    localhost:4200/ 

## Features
* Add a new vehicle to the system.
* Delete a vehicle from the system using the vehicle plate number.
* Display the list of vehicles in the system.
* Save the vehicle list to the database after any changes.
* Book available vehicles for specific dates.

## Screenshots

## Tests
To execute automated testing using JUnit run the files in `rental-vehicle-system\console-system\src\test\java`.

## Built With
* [Java](https://docs.oracle.com/en/java/)
* [TypeScript](https://www.typescriptlang.org/docs/)
* [HTML](https://www.w3.org/html/)
* [CSS](https://www.w3.org/Style/CSS/Overview.en.html)
* [JavaScript](https://devdocs.io/javascript/)

## Authors
* Shiromi Basil - [shiromi-basil](https://github.com/shiromi-basil)

See also the list of [contributors](https://github.com/SafiyyahR/ARC-R3ACT/graphs/contributors) who participated in this project.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
