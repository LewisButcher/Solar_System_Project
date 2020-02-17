/**
* Purpose: This programme takes N number of particles which have a set velocity 
* and position and calculates the total acceleration of each particle due to the
* affect of gravity caused by the other particles in the system.
*
*@author Lewis Butcher
*@version 1.0
**/


public class GravField
{
	private static final double G = 6.67408E-20; //Newtons Gravitational Constant.
/**
* Method that takes in an array of Particles and then calculates the total acceleration
* due to gravity which acts on a particle caused by the other particles.
*
*@param X An array containing the particles
*@return Totg An array which contains the values of acceleration for each
*particle correspnding to the array X.
*
**/
	public static PhysicsVector[] getg(Particle[] X)
	{
		
		PhysicsVector[] Totg = new PhysicsVector[X.length]; //creates an array of Physics vectors.
		for (int i=0; i<X.length; i++)
		{
			PhysicsVector g = new PhysicsVector(); //creates a physics vector g to store the accelerations.
			for (int j=0; j<X.length; j++)
			{
				
				if(j !=i)
				{
				// Uses PhysicsVector class to calculate the acceleraation
				// due to gravy for each particle in the array X.
					double D = Particle.Distance(X[i].GetPosition(), X[j].GetPosition());
					double gmr = ((-1*G*(X[j].GetMass()))/(Math.pow(D,2)));
					PhysicsVector x = new PhysicsVector(PhysicsVector.subtract((X[i].GetPosition()), (X[j].GetPosition())));
					PhysicsVector Unit = (x.getUnitVector());
					Unit.scale(gmr);
					g.increaseBy(Unit);
				}
				Totg[i] = g;
			}
		
		}
		return Totg;
		
	}
}