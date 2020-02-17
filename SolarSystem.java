import java.util.Scanner;
import java.io.*;
/**
* Purpose: This main method can be used to create a simulation of particles
* which interract with each other through gravity in free space. It uses
* any particle with a given initial, position and velocity, and mass and calculates
* the trajectory of the particle using spatial kinematic techniques.
*
*@author Lewis Butcher
*@version 1.0
**/
public class SolarSystem
{
	public static void main(String [] args) throws IOException
	{
		//The .txt files where the data is stored.
		PrintWriter PV = new PrintWriter("Positions&Velocities.txt");
		PrintWriter Mom = new PrintWriter("Momentum.txt");
		PrintWriter E = new PrintWriter("Energy.txt");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for the Euler Method or 2 for the Euler-Cramer");
		int Method = sc.nextInt();
		System.out.println("Please enter the Time-step:");
		double timeStep = sc.nextDouble(); //interval for which the simulation collects its data.
		int TimeStepDay = (int)(86400./timeStep);
		System.out.println("Please enter number of days to be simulated:");
		double Days = sc.nextDouble()*86400; //number of days simulation runs for.
		long Counter = 0L;
		
		//The particles used in the simulation which contain each particles 3-D 
		// position (pi,pj,pk) in km, 3-D velocity (vi,vj,vk) in km/s, mass in kg and the name of the particle.
		// This information was taken from the NASA Horizons website on the 06/12/17.
		Particle Sun = new Particle(2.920248396549780E5,8.972132474121116E5,-1.852273805250082E4, -9.766021015197407E-3, 8.999107274274724E-3, 2.343058883707526E-4 , 1.988544E30, "Sun");
		Particle Mercury = new Particle(3.829319260184269E7,3.006579981572141E7,-1.121291495019559E6,-3.924482531869952E1,4.075261406219975E1,6.928932150005902E0, 3.302E23, "Mercury");
		Particle Venus = new Particle(-6.288713524018889E7,-8.711498473448260E7,2.420028410161521E6,2.819420158427912E1,-2.057574198728450E1,-1.909682490007154E0, 48.685E23, "Venus");
		Particle Earth = new Particle(4.140466469890121E7,1.424503995927281E8,-2.445535338269174E4,-2.908835936996451E1,8.209644361960233E0,-9.912014509612099E-4 , 5.97219E24, "Earth");
		Particle Moon = new Particle(4.129955128358053E7, 1.427943443576151E8,-4.029299392382056E4,-3.014009178777005E1,7.927886991734857E0,8.129352859572725E-2, 734.9E20, "Moon");
		Particle Mars = new Particle(-2.461494412318427E8,-8.135321860360315E6,5.840321737549835E6,1.782308233072359E0,-2.213417581488241E1,-5.077600037411356E-1, 6.4185E23, "Mars");
		Particle Jupiter = new Particle(-6.546426964798173E8,-4.808722956005415E8,1.663711488827327E7, 7.580054129332052E0,-9.908450611467071E0,-1.284402525644377E-1,1898.13E24, "Jupiter");
		Particle Saturn = new Particle(-1.334215714757109E7,-1.504394065313983E9,2.668798870954269E7,9.129211782543706E0,-1.178929428362886E-1,-3.607824250715662E-1, 5.68319E26, "Saturn");
		Particle Uranus = new Particle(2.658409446072430E9,1.342881443829036E9, -2.945261707595515E7,-3.120325134675427E0, 5.761001873658634E0,6.170745789759779E-2, 86.8103E24, "Uranus");
		Particle Neptune = new Particle(4.287271774704164E9,-1.297057972347536E9,-7.209406620702243E7,1.537407993825956E0,5.235166632803802E0,-1.425296174958979E-1, 102.41E24, "Neptune");
		Particle Pluto = new Particle(1.600580829670277E9,-4.741583382604813E9,4.439465334439969E7,5.257471750558029E0,5.829448912839446E-1,-1.601534403978083E0,1.307E22, "Pluto");
		
		//Places the particles into an array X.
		Particle[] X = {Sun, Mercury,Venus,Earth,Moon,Mars,Jupiter,Saturn,Uranus,Neptune,Pluto};
		
		//creates a physic vector with length equal to the number of paticles in the array.
		PhysicsVector[] ans = new PhysicsVector[X.length];
		
		//This if and else if statement allow the user inputting to the screen
		// to choose two different kinematic simulations
		if (Method ==1 )
		{
			System.out.println("Calculating using the Euler Method.");
		}
		else if (Method == 2)
		{
			System.out.println("Calculating using the Euler-Cramer Method.");
		}
		
		//This loop repeats by the value of the timepstep interval inputted by
		// the user each time to get the data.
		for (int i = 0; i<=Days; i+=timeStep)
		{
			ans = GravField.getg(X); //retrieves getg from the GravField class.
			
			for (int j = 0; j<X.length; j++)
			{
				X[j].upParticle(ans[j], timeStep, Method);
				if (Counter % TimeStepDay == 0)
				{	
					//prints the data to the appropriate .txt file.
					//with the appropriate day because of the counter
					PV.println("Day" + " " + (int)(Counter/TimeStepDay) + "," + " " + "using a time-step of" + " " + timeStep + "s" + ":");
					PV.println("The Position for" + " " + (X[j].GetName()) + " in km:" + " " + (X[j].GetPosition().getX()) + "i" + " " + "+" + " " + (X[j].GetPosition().getY()) + "j" + " " + "+" + " " + (X[j].GetPosition().getZ()) + "k");
					PV.println(" ");
					PV.println("The Velocity for" + " " + (X[j].GetName()) + " in km/s:" + " " + (X[j].GetVelocity().getX()) + "i" + " " + "+" + " " + (X[j].GetVelocity().getY()) + "j" + " " + "+" + " " + (X[j].GetVelocity().getZ()) + "k");
					PV.println(" ");
				}
			}
			if (Counter % TimeStepDay == 0)
			{			
				//prints the data to the appropriate .txt file.
				//with the appropriate day because of the counter
				Mom.println("Day" + " " + (int)(Counter/TimeStepDay) + " " + "using a time-step of" + " " + timeStep + "s" + ":");
				Mom.println("The total momentum for the system is: " + " " + (Particle.getMomentum(X)) + " kgm/s");
				Mom.println(" ");
				
				E.println("Day" + " " + (int)(Counter/TimeStepDay) + " " + "using a time-step of" + " " + timeStep + "s" + ":");
				E.println("The total KE for the system is: " + " " + (Particle.getKinetic(X)) + " J");
				E.println(" ");
				E.println("Day" + " " + (int)(Counter/TimeStepDay) + " " + "using a time-step of" + " " + timeStep + "s" + ":");
				E.println("The total PE for the system is: " + " " + (Particle.getPotential(X)) + " J");
				E.println(" ");
			}
			
			Counter++;
		}
		System.out.println("The data has been stored into seperate files.");
		System.out.println("Data for Positions and Velocities of the particles is stored in the File: Positions&Velocities.txt");
		System.out.println("Data for the total momentum is stored in the File: Momentum.txt");
		System.out.println("Data for total KE and PE is stored in the File: Energy.txt");
		
		PV.close(); //closes the .txt files.
		Mom.close();
		E.close();
	}
}
