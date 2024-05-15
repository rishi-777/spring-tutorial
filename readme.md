Whenever code says alien, spring has to create an object of alien class which is a part of 
alien -> com.example.Second.Alien package

## Behind the scene

Even if we do not declare any reference of a class then also spring will create its object if we use @Component annotation because it indicates that spring is responsible for creating its object during runtime, so spring will automatically create the object of all those classes before running the program whose object creation responsibility is assigned to spring.