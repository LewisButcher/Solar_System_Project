/**
*Purpose: A class used to develop a simulation of particles, using 3-D spatial 
*coordiantes.
*
*@author Lewis Butcher
*@version 1.0
**/


public class Particle
{
	private double mass;
	private PhysicsVector position = new PhysicsVector();
	private PhysicsVector velocity = new PhysicsVector();
	private String Name;
	private static final double G = 6.67408E-20;
	/**
	* Constructor that takes 8 arguments to create an object which contains two
	* physics vectors, one for the position of the particle and one for the velocity
	* of the particle, as well as a double for the particles mass and a string for 
	* the particle name.
	*
	*@param pi is the x-component for the position of the particle.
	*@param pj is the y-component for the position of the particle.
	*@param pk is the z-component for the position of the particle.
	*@param vi is the x-component for the velocity of the particle.
	*@param vj is the y-component for the velocity of the particle.
	*@param vk is the z-component for the velocity of the particle.
	*@param m is the mass of the particle.
	*@param n is the name of the particle.
	**/
	public Particle(double pi, double pj, double pk, double vi, double vj, double vk, double m, String n)
	{
		position = new PhysicsVector(pi,pj,pk);
		velocity = new PhysicsVector(vi,vj,vk); 
		mass = m; 
		Name = n; 
	}
	/**
	* Method that calculates the distance between two particles using the 3-D vector
	* components of the positions from each particles.
	*
	*@param a first vector.
	*@param b second vector.
	*@return the scalar of the total distance between two particles.
	**/
	public static double Distance(PhysicsVector a, PhysicsVector b)
	{
		PhysicsVector DiffDistance = new PhysicsVector();
		DiffDistance.increaseBy(PhysicsVector.subtract(a,b));
		double DistanceMag = DiffDistance.magnitude();
		return DistanceMag;
	}
	/**
	* Method that calculates the total momentum in the system of each
	* particle.
	*
	* @param Z An array that will have the momentum for each of its components calculated 
	* individually.
	* @return the sum total of each particles momentum.
	**/
	public static double getMomentum(Particle[] Z)
	{
		double TotalMomentum = 0.0;
		//This for loop will calculate and then sum the individual momenta
		// for each particle in the array Z. Using the equation P=M*V.
		for(int i=0; i<Z.length; i++)
		{
			double speed = Z[i].GetVelocity().magnitude()*1000;
			double mass = Z[i].GetMass();
			TotalMomentum += speed*mass;
		}
		return TotalMomentum;
	}
	/**
	* Method that calculates the total kinetic energy in the system of
	* each particle.
	*
	* @param Z An array that will have the Kinetic energy for each of its components calculated
	* individually.
	* @return the sum total of each particles kinetic energy.
	**/
	public static double getKinetic(Particle[] Z)
	{
		double TotalKinetic = 0.0;
		//This for loop will calclate and then sum the individual kinetic 
		//energies for each particle in the array Z. Using the equation
		// KE=0.5*M*V^2
		for(int i=0; i<Z.length; i++)
		{
			double speed = Z[i].GetVelocity().magnitude()*1000;
			double mass = Z[i].GetMass();
			TotalKinetic += 0.5*mass*Math.pow(speed,2);
		}
		return TotalKinetic;
	}
	/** 
	* Method that calculates the total potential energy in the system of
	* each particle.
	*
	* @param Z An array that will have the potential energy for each of its components
	* calculated individually.
	* @return the sum total of each particles potential energy.
	**/
	public static double getPotential(Particle[] Z)
	{
		double TotalPotential = 0.0;
		//These for loops calculate and then sum the individual GPE for each
		//particle in the array Z. Using the equation
		// V = (-G*M*m)/r.
		for(int i=0; i<Z.length; i++)
		{
			double M = Z[i].GetMass();
			PhysicsVector position = new PhysicsVector();
			PhysicsVector DiffVec = new PhysicsVector();
			position = Z[i].GetPosition();
			
			for(int j=0; j<Z.length; j++)
			{
				if(j==i || j<i) continue;
				
				double m = Z[j].GetMass();
				DiffVec = PhysicsVector.subtract(position, Z[j].GetPosition());
				double d = (DiffVec.magnitude())*1000;
				
				TotalPotential += (-1*G*M*m)/d;
			}
		}
		return TotalPotential;
	}
	/**
	* Method that updates the position and velocity of each particle, either by
	* the Euler method or the Euler-cramer method, depending on the input of 
	* the user.
	*
	*@param g first vector.
	*@param t the time.
	*@param M the calculation method.
	**/
	public  void upParticle(PhysicsVector g, double t, int M)
	{
		//Allows the user to access two different kinematic simulations.
		if (M==1)
		{
			position.increaseBy(PhysicsVector.scale(t,velocity));
			velocity.increaseBy(PhysicsVector.scale(t,g));
		}
		else if (M==2)
		{
			velocity.increaseBy(PhysicsVector.scale(t,g));
			position.increaseBy(PhysicsVector.scale(t,velocity));
		}
	}
	/**
	* Method that returns the scalar mass of the particle
	*
	* @return the scalar mass of the particle
	**/
	public double GetMass() 
	{
		return mass;
	}
	/**
	* Method that returns the vector velocity of the particle
	*
	* @return the vector velocity of the particle
	**/
	public PhysicsVector GetVelocity()
	{
		return velocity;
	}
	/**
	* Method that returns the vector position of the particle
	*
	* @return the vector position of the particle
	**/
	public PhysicsVector GetPosition()
	{
		return position;
	}
	/**
	* Method that returns the name of the particle
	*
	* @return the name of the particle
	**/
	public String GetName()
	{
		return Name;
	}
	
}