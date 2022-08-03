# blog-app-apis

first we did a setup of application properties, in which, we defined a port on which localhost will run.
Then, we made some DB configurations to connect with local mySQL DB, in which, we stated the DB name,
the access creds and driver-class-name.
after that, we made some JPA configuration so that we can write HQL.

## After that we started coding our first /user POST API :

first, we created an entities package in which we defined a User Class with required fields and using
HQL created a corresponding DB table for that entity, by writing required annotation with that class.

then, we created a repositories package, in which we wrote all the CRUD operations which can be
performed on that entity. For that instead of defining them manually, we extended JpaRepository
interface so that all the operations with given entity ID (integer) are available out of the box,
now we only need to write their implementation.

then, as User Entity is too much of a personal information, hence, we created a userDto class which
will be a wrapper of User Entity for when we will be interacting with controller layer.

now we will create a service layer interface for our User Entity by the name UserService, in which we will
define all the operations that will be provided to Controller by us.

now we will write an implementation class of service layer interface in which we will user UserRepo object
which automatically can make changes on DB level, because it extends JpaRepository which can do that.

now, Controller will listen to the requests and will call implemented service classes accordingly.

now, RUN the project and hit the request from postman, to see your changes getting reflected in mySQL GUI
table connected to your local SQL server.

### model mapper library
to take data from one model into another

### using Java Bean validation to validate data which need to be stored in DB
Java bean is validated with JSP 380 known as Bean validation 2.0. All properties of Bean meet a specific
criteria and data on which Bean validation is applied has to go through that validation check.

Hibernate Validator is an implementation of JSP 380 (validation api).

some common validation annotations are -
#### @NotNull @Size @Min @Max @Email @NotEmpty

