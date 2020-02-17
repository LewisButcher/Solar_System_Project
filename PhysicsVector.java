/**
* A 3-dimensional vector class to be used in the development of
* computer simulations of various physical systems.
*
* The 3-dimensional vector represents a standard Cartesian vector
* given by x<b>i</b> + y<b>j</b> +z<b>k</b> 
* where <b>i</b>, <b>j</b>, and <b>k</b> are unit
* vectors in the x, y, and z directions respectively.
*
* @author Iain A. Bertram
* @author Ian Bailey
* @version 1.5
**/
public class PhysicsVector {
	// Fix the dimension of the array representing the vectors 
	private static final int  vectorSize=3;
	
	// In this case we have a three dimensional vector, the x component is [0] with y[1] and z[2]
	private double[]  vectorComponents = new double[vectorSize];
	
	/**
	* Default constructor that creates a PhysicsVector with zero magnitude
	**/
	public PhysicsVector()
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] =0.;
		}
	}
	
	/**
	* Constructor that takes two arguments to create a PhysicsVector
	* with the first argument x giving the component in the <b>i</b>
	* direction and the second argument y giving the component in the
	* <b>j</b> direction. The z component is set to zero.
	*
	* @param x <code>x-component</code> of the vector
	* @param y <code>y-component</code> of the vector
	**/
	public PhysicsVector(double x, double y)
	{
		vectorComponents[0] = x;
		vectorComponents[1] = y;
		vectorComponents[2] = 0.;
	}
	
	/**
	* Constructor that takes three arguments to create a PhysicsVector
	* with the first argument giving the component in the <b>i</b>
	* direction, the second argument giving the component in the
	* <b>j</b> direction and the third argument giving the component
	* in the <b>k</b> direction.
	*
	* @param x <code>x-component</code> of the vector
	* @param y <code>y-component</code> of the vector
	* @param z <code>z-component</code> of the vector	
	**/
	public PhysicsVector(double x, double y, double z)
	{
		vectorComponents[0] = x;
		vectorComponents[1] = y;
		vectorComponents[2] = z;
	}
	
	/**
	* Constructor that takes an array of length 3 and sets the components of
	* the vector to the values stored in the array.
	* If array length = 2 it sets only the x and y components.
	* Returns a default vector if the array is not 
	* length 2 or 3 and prints a warning message.
	* (NB It would be better to 'throw an exception' here
	* if you know how to do it!)
	*
	* @param x array whose components will be transferred to the vector
	**/
	public PhysicsVector(double [] x)
	{
		if (x.length == vectorSize){
			for (int i=0; i<vectorComponents.length; i++)
				{vectorComponents[i] = x[i];}
		}
		else if (x.length == vectorSize-1 ) {
			for (int i=0; i<x.length; i++)
				{vectorComponents[i] = x[i];}
			vectorComponents[vectorComponents.length-1] = 0.;
		}
		else {this.setVector(new PhysicsVector());
			System.out.println(
				"WARNING: PhysicsVector(double [] x) " +
				"requires an array of length " + vectorSize);
		}
	}
	
	/**
	* Constructor that creates a vector with the same value as the
	* PhysicsVector passed as an argument.
	* @param v vector to be replicated
	**/
	public PhysicsVector(PhysicsVector v)
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] = v.vectorComponents[i];
		}
	}
	
	/**
	* Method to return a String which represents the vector in 2D and has
	* the form x<b>i</b> + y<b>j</b>.
	* @return String with the form xi + yj 
	**/
	public String return2DString()
	{
		String text = ""+vectorComponents[0]+"i ";
		
		if (vectorComponents[1] < 0)
			{text += " -"+(-1*vectorComponents[1]);}
		else{text += " +"+(vectorComponents[1]);}
		text+="j ";
		
		return text;
	}
	
	/**
	* Method to return a String which represents the vector in 2D and has
	* the form "x y"(I.e. coordinates separated by spaces).
	* @return String with the form "x y"
	**/
	public String returnSimple2DString()
	{
		String text = "";
		text += vectorComponents[0] +" ";
		text += vectorComponents[1] +" ";
		return text;
	}
	
	/**
	* Method to return a String which represents the vector in 3D and has
	* the form x<b>i</b> + y<b>j</b> +z<b>k</b>.
	* @return String with the form "xi + yj + zk"
	**/
	public String returnString()
	{
		String text = ""+vectorComponents[0]+"i ";
		
		if (vectorComponents[1] < 0)
			{text += " -"+(-1*vectorComponents[1]);}
		else{text += " +"+(vectorComponents[1]);}
		text+="j ";
		
		if (vectorComponents[2] < 0)
			{text += " -"+(-1*vectorComponents[2]);}
		else{text += " +"+(vectorComponents[2]);}
		text+="k ";
		
		return text;
	}
	
	/**
	* Method to return a String which represents the vector in 3D and has
	* the form "x y z" (I.e. coordinates separated by spaces).
	* @return String <b>"x y z"</b>
	**/
	public String returnSimpleString()
	{
		String text = "";
		for (int i=0; i<vectorComponents.length; i++)
		{
			text+=vectorComponents[i]+" ";
		}
		return text;
	}
	
	/**
	* prints the 2D vector to 'standard out'. Note: it will include
	* a carriage return. Prints:  "xi + yj" for coordinates x and y.
	**/
	public void print2D()
	{
		String text = this.return2DString();
		System.out.println(text);
	}
	
	/**
	* prints the 3D vector to 'standard out'. Note: it will include
	* a carriage return. Prints: "xi + yj + zk" for coordinated x,y and z.
	**/
	public void print()
	{
		String text = this.returnString();
		System.out.println(text);
	}
	
	/**
	* Change the value of the vector to x<b>i</b> + y<b>j</b> + z<b>k</b>
	*
	* @param x new x-component of the vector
	* @param y new y-component of the vector
	* @param z new z-component of the vector	
	**/
	public void setVector(double x, double y, double z)
	{
		vectorComponents[0] = x;
		vectorComponents[1] = y;
		vectorComponents[2] = z;
	}
	
	/**
	* Change the value of the vector to x<b>i</b> + y<b>j</b>. 
	* The z-component is set to zero. 
	*
	* @param x new x-component of the vector
	* @param y new y-component of the vector
	**/
	public void setVector(double x, double y)
	{
		vectorComponents[0] = x;
		vectorComponents[1] = y;
		vectorComponents[2] = 0.;
	}
	
	/**
	* Modify the vector so that it is equal to vector <b>v</b>
	*
	* @param v the vector whose values are copied to <code>this</code> vector.
	**/
	public void setVector(PhysicsVector v)
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] = v.vectorComponents[i];
		}
	}
	
	/**
	* Add a vector <b>v</b> to <code>this</code> vector. Normal vector
	* addition is carried out. I.e. the x-components are added and
	* the y components are added, etc.
	*
	* @param v vector to be added to original vector. 
	**/
	public void increaseBy(PhysicsVector v)
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] += v.vectorComponents[i];
		}
	}
	
	/**
	* Subtract a vector <b>v</b> from the original vector. Normal vector
	* subtraction is carried out. I.e. the x-components are subtracted and
	* the y components are subtracted, etc.
	*
	* @param v vector to be subtracted from the original vector. 
	**/
	public void decreaseBy(PhysicsVector v)
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] -= v.vectorComponents[i];
		}
	}
	
	/**
	* returns the magnitude of the vector. If the vector is given by
	* x<b>i</b> +y<<b>j</b> +z<b>k</b> 
	* then the magnitude is sqrt(x^2 + y^2+ z^2).
	*
	* @return a scalar with the magnitude of the original vector.
	**/
	public double magnitude()
	{
		double mag = dot(this,this);
		mag = Math.sqrt(mag);
		return mag;
	}
	
	/**
	* Return the x-component of the vector
	*
	* @return x-component
	**/
	public double getX()
	{
		return vectorComponents[0];
	}
	
	/**
	* Return the y-component of the vector
	*
	* @return y-component
	**/
	public double getY()
	{
		return vectorComponents[1];
	}
	
	/**
	* Return the z-component of the vector
	*
	* @return z-component
	**/
	public double getZ()
	{
		return vectorComponents[2];
	}
	
	/**
	* Returns a vector with a magnitude of 1 and the original
	* direction of <code>this</code> vector.
	* I.e. scale the vector by 1/magnitude.
	* If the vector is a zero vector then it returns the zero length vector.
	*
	* @return unit vector with the same direction of the original vector
	**/
	public PhysicsVector getUnitVector()
	{
		PhysicsVector unit = new PhysicsVector(this);
		double magnitude = this.magnitude();
		
		if (Math.abs(magnitude) > 1.e-34)
			
			{unit.scale(1/magnitude);}
		else 
			{unit = new PhysicsVector();}
		return unit;
	}
	
	/**
	* Scale the components of the vector by a scalar. I.e. If the
	* scalar is s and the vector is x<b>i<\b>+y<b>j<\b>+z<b>k<\b>
	* then the vector transforms to xs<b>i<\b>+ys<b>j<\b>+zs<b>k<\b>
	*
	* @param x the factor to scale the vector by.  
	**/
	public void scale(double x)
	{
		for (int i=0; i<vectorComponents.length; i++)
		{
			vectorComponents[i] *= x;
		}
	}
	
	/**
	* Scale the components of the vector by a scalar. I.e. If the
	* scalar is s then the vector x<b>i<\b>+y<b>j<\b>+z<b>k<\b>
	* transfoms to xs<b>i<\b>+ys<b>j<\b>+zs<b>k<\b>
	* 
	* @param x the factor to scale the vector by.  
	* @param v the vector to scale.
	* @return a vector equal to the scaled original vector
	**/
	public static PhysicsVector scale(double x, PhysicsVector v)
	{
		PhysicsVector scaled = new PhysicsVector(v);
		for (int i=0; i<(scaled.vectorComponents).length; i++)
		{
			scaled.vectorComponents[i] *=x;
		}
		return scaled;
	}
	
	/**
	* Standard vector scalar product. If x<b>i<\b>+y<b>j<\b>+z<b>k<\b>
	* and r<b>i<\b>+s<b>j<\b>+t<b>k<\b> then the dot product returns 
	* xr+ys+zt
	*
	* @param u first vector in product
	* @param v second vector in product
	* @return the scalar product between u and v
	**/
	public static double dot(PhysicsVector u, PhysicsVector v)
	{
		double product = 0.;
		
		for(int i=0; i<(u.vectorComponents).length; i++)
		{
			product += u.vectorComponents[i]*v.vectorComponents[i];
		}
		return product;
	}
	
	/**
	* Standard vector (cross) product between two 3D vectors:
	* <b>u</b> and <b>v</b>.
	* The result is a vector which is perpendicular to the original vectors
	* with a magnitude equal to |u||v|Sin(t) where 't' is the angle between 
	* the vectors.
	*
	* @param u first vector
	* @param v second vector
	* @return the vector product of u and v
	**/
	public static PhysicsVector vectorProduct(PhysicsVector u, PhysicsVector v)
	{
		PhysicsVector product = new PhysicsVector();
		
		product.vectorComponents[0] = 
		u.vectorComponents[1]*v.vectorComponents[2]
		- u.vectorComponents[2]*v.vectorComponents[1];
		product.vectorComponents[1] = 
		u.vectorComponents[2]*v.vectorComponents[0]
		- u.vectorComponents[0]*v.vectorComponents[2];
		product.vectorComponents[2] = 
		u.vectorComponents[0]*v.vectorComponents[1]
		- u.vectorComponents[1]*v.vectorComponents[0];
		
		return product;
	}
	
	/**
	* Standard vector addition. If the two vectors are
	* x<b>i<\b>+y<b>j<\b>+z<b>k<\b> and
	* r<b>i<\b>+s<b>j<\b>+t<b>k<\b>, then the method returns a vector
	* (x+r)<b>i<\b>+(y+s)<b>j<\b>+(z+t)<b>k<\b>
	*
	* @param u first vector in sum
	* @param v second vector in sum
	* @return summed vector
	**/
	public static PhysicsVector add(PhysicsVector u, PhysicsVector v)
	{
		PhysicsVector sum = new PhysicsVector(u);
		sum.increaseBy(v);
		return sum;
	}
	
	/**
	* Vector subtraction. If the two vectors are
	* x<b>i<\b>+y<b>j<\b>+z<b>k<\b> and
	* r<b>i<\b>+s<b>j<\b>+t<b>k<\b> respectively
	* then the method returns a vector
	* (x-r)<b>i<\b>+(y-s)<b>j<\b>+(z-t)<b>k<\b>
	*
	* @param u first vector in sum
	* @param v second vector in sum
	* @return resultant vector
	**/
	public static PhysicsVector subtract(PhysicsVector u, PhysicsVector v)
	{
		PhysicsVector sum = new PhysicsVector(u);
		sum.decreaseBy(v);
		return sum;
	}
}