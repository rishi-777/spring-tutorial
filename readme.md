Whenever code says alien, spring has to create an object of alien class which is a part of 
alien -> com.example.Second.Alien package

## Behind the scene

1.Even if we do not declare any reference of a class then also spring will create the object of that class, why?
It is because when we run java program our main function gets executed and inside it we are creating an object of ClassPathXmlApplicationContext using
``ApplicationContext factory=new ClassPathXmlApplicationContext("spring.xml");``
It creates a container inside our JVM, and since
inside it we are passing a Bean Configuration file(spring.xml), which contains the number of beans and its types, thats why whatever beans are there defined inside it, the objects of those beans gets created whether we are using them inside our program or not, it does not matter.

2.By default spring uses Singleton Design pattern for beans, so using code like this wont create two objects of alien class, spring container will give the same reference of one object both time.
  	```Alien obj1=(Alien)factory.getBean("alien");
    obj1.age=15;
    System.out.println("Age "+obj1.age);
    Alien obj2=(Alien)factory.getBean("alien");
    System.out.println("Age "+obj2.age);```
   
   	and obj1 and obj2 reference will point to same object of alien.
 
3. What if we want don`t want to follow the Singleton pattern for spring beans, what if we want to create a different object every time we call getBean method?
So for this inside the Bean Configuration file(spring.xml) we can specify the scope attribute of every bean, by default it is set to singleton, if we don't want spring container to create only one object use that same copy, we can change this attribute to prototype.
Prototype -> Every-time when getBean function is encountered a new copy of object will be created. 

 
        


     
