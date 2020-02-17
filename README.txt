-To run the simulation first compile SolarSystem.java, then run the file.
-The user should input which method they want to use in the calculation of the simulation.
-Inputting "1" will use the Euler method to perform the calculations.
Inputting "2" will use the Euler-Cramer method to perform the calculations.
-Next the user will be asked to input a time-step in seconds. This is how often the user wants the particle to be updated.
-Finally the user will be asked to input the number of full days they want the simulation to run for, for example if "5" is inputted,
the code will calculate data and print out, to a file, the positions and velocities of the particles for up to 5 days. As well as
the momentumentum, KE and GPE.
-Data will be saved in the appropriate .txt file which is found in the same folder as the .java files.

To add another particle to the system:
input the following into the SolarSytem.java file,

Particle 'Name' = new Particle(pi,pj,pk,vi,vj,vk,mass, "Name")
where 
pi is the x-component of the position in km which is a Double
pj is the y-component of the position in km which is a Double
pk is the z-component of the position in km which is a Double
vi is the x-component of the velocity in km/s which is a Double
vj is the y-component of the velocity in km/s which is a Double
vk is the z-component of the velocity in km/s which is a Double
mass is the mass of the particle which is a Double
and "Name" is a string and is the name you wish to call the particle.

Add this code below the other code similar to this as well as adding the Name to the Particle array X.

To add more particles into the system, use the file SolarSystem.java 

SolarSystem.java: This file contains the main method of the simulation, this includes the velocities, positions, mass and names of the particles
as well as the code for input and printing to a file.

GravField.java: This file contains the code for calculating the total accelerations for each particles due to the affect of gravity and sums up the total.

Particle.java: This file creates a particle which has a 3-D velocity, 3-D position, a mass and a name. The positions and velocities of the particles
are also updated in this file. There are several methods within this file to calculate the KE, GPE and momentum of the system. 
The file is also used to calculate distance between two particles.

PhysicsVector.java: This file creates a vectors and has several different methods for vector calculations. It is widely used within the other files.
