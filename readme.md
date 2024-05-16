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

=> NOTE: In singleton, whether you ask for the object or not spring container will create one object for you, but in case of prototype if you ask for the object then only the object of that class will be created by spring container.

4. Value Attribute
Bean is the object of the class created by spring at runtime.
If our class is a bean then every variable present inside it will be known as property of that bean.
We can assign default values to those properties by using Bean Configuration file also(instead of using constructor...so spring will take care of assigning the default values to the properties of your class's object)
But if we are using Bean Configuration file to assign value to our object, then it is mandatory that our class has a setter method present for that specific property or else it wont work.

 5. Ref Attribute
Previously we are assigning value to a primitive property of object(bean) using attribute value of property.
 		```<bean id="alien" class="com.example.Second.Alien">
			<property name="age" value="10"></property>
		</bean>```
What if we have a reference type then how will we assign ?
We need to use the ref attribute and assign its value equal to the id of that bean/object which it will be referring to. 
```<bean id="alien" class="com.example.Second.Alien">
		<property name="age" value="10"></property>
		<property name="lap" ref="laptop"></property> 
	</bean>
	<bean id="laptop" class="com.example.Second.Laptop">
	</bean>
```

6. Constructor Injection
If we use constructor-arg (means parameterized constructor) then it becomes constructor injection.
<bean id="alien" class="com.example.Second.Alien">
	<constructor-arg value="12"></constructor-arg>
</bean> 

7. Setter Injection
When we use property tag then it becomes setter injection for that bean
<bean id="alien" class="com.example.Second.Alien">
	<property name="age" value="12"></property> 
</bean>

When to use which? -> 
Whenever in a class you have a property that is compulsory to be assigned then for that property we need to constructor injection.
And for the property that is optional you can go for setter injection. Don't use constructor when variable/property assignment is optional.

8. Autowire

When we have a bean/class that is dependent on some other class/bean and we have the same name of class property on which our current class is dependent on with the bean name of that dependent class, then there is no need of explicitly assigning the property of our current class to that bean we can use autowire in that bean.

Autowire can go byName or byType.
When we say byName it will match the class property/variable with the name of the bean(its id)



     
