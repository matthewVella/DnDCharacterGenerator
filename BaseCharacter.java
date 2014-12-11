/***********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #15 problem #1
* LAST MODIFIED: 12/3/14	
*************************************************
 ********************************************************************************
 * Base Character Class - contains stats for basic character that will be set
 * via user input including height, weight, and alignment.
 ********************************************************************************
 * ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *
 * Scanner = used for console input
 *
 *******************************************************************************/

import java.util.Scanner;
 
public class BaseCharacter{

/*DECLARATION SECTION***********************************************************/  

	String name;// Name (user input)
	char sex;// Sex mf (user input)
	
	int heightFeet;// Height (in feet)
	int heightInches;	//Height (in inches)
	int weight;//Weight (in pounds)
	char alignmentMain;// Alignment (choose one of each main and sub from a list)
	char alignmentSub;	

/*CONSTRUCTORS SECTION**********************************************************/ 		
	//fully loaded
	BaseCharacter(String name, char sex, int height1, int height2, int weight,
		char alignMain, char alignSub)
	{
		name = name;
		sex = sex;
		height1 = heightFeet;
		height2 = heightInches;
		weight = weight;
		alignmentMain = alignMain;
		alignmentSub = alignSub;
	}
	
	//blank
	BaseCharacter()
	{
		name = "No name selected yet.";
		sex = 'M';
		heightFeet = 0;
		heightInches = 0;
		weight = 0;
		alignmentMain = 'N';
		alignmentSub = 'N';
	}
		
	//copy
	BaseCharacter(BaseCharacter other)
	{
		name = other.getName();
		sex = other.getSex();
		heightFeet = other.getHeightFeet();
		heightInches = other.getHeightInches();
		weight = other.getWeight();
		alignmentMain = other.getMainAlignment();
		alignmentSub = other.getSubAlignment();
	}

/*SETTERS SECTION***************************************************************/   
	
	//setName
	public void setName(String name)
	{	
		Scanner keytar = new Scanner(System.in);			
		System.out.println("\nPlease enter your character's name now:\n");
		name = keytar.nextLine();
		this.name = name;
	}
		
	//setSex	
	public void setSex(int mf)
	{
	int sexo; sexo = 0;
	Scanner keytar = new Scanner(System.in);			
	System.out.println("\nPlease choose your character's gender.");
	sexo = CharClass.readInt("\n1 for male, 2 for female.\n",keytar,1,2);
		if (sexo == 1)
		{
			sex = ('M');
		}
		else if (sexo == 2)
		{
			sex = ('F');
		}
	}		
		
	//setHeightFeet
	public void setHeightFeet(int feet)
	{
		this.heightFeet = feet;
	}	
	
	//setHeightInches
	public void setHeightInches(int inches)
	{
		this.heightInches = inches;
	}	
	
	//setWeight
	public void setWeight(int weight)
	{
		this.weight = weight;
	}	
	
	//setAlignmentMain
	public void setMainAlignment(char main)
	{
		this.alignmentMain = main;
	}
	
	//setAlignmentSub
	public void setSubAlignment(char sub)
	{
		this.alignmentSub = sub;
	}
	
	//method to set both alignment types via user input
	public void setAlignmentBoth()
	{		
		System.out.println
			("\nPlease choose your character's main alignment.");
	
		int alignMain; alignMain = 0;
		int alignSub; alignSub = 0;
		Scanner keytar = new Scanner(System.in);			
		char[]mainAlignment = {'L', 'N', 'C'};	
		alignMain = CharClass.readInt
			("\n1. Lawful \n2. Neutral \n3. Chaotic\n",keytar,1,3);
		setMainAlignment(mainAlignment[alignMain-1]);
		
		System.out.println
			("\nPlease choose your character's secondary alignment.");
		char[]subAlignment = {'G', 'N', 'E'};	
		alignSub = CharClass.readInt
			("\n1. Good \n2. Neutral \n3. Evil\n",keytar,1,3);	
		setSubAlignment(subAlignment[alignSub-1]);	
	}
		
/*GETTERS SECTION***************************************************************/

	//getName
	public String getName()
	{
		return name;
	}	
		
	//getSex
	public char getSex()
	{
		char temp; temp = 'a';
		temp = this.sex;
		return temp;
	}
	
	//getHeightFeet
	public int getHeightFeet()
	{
		int temp; temp = 0;
		temp = this.heightFeet;
		return temp;
	}
	
	//getHeightInches
	public int getHeightInches()
	{
		int temp; temp = 0;
		temp = this.heightInches;
		return temp;
	}
	
	//getWeight
	public int getWeight()
	{
		int temp; temp = 0;
		temp = this.weight;
		return temp;
	}
	
	//getAlignmentMain
	public char getMainAlignment()
	{
		char temp; temp = 'a';
		temp = this.alignmentMain;
		return temp;
	}	
	
	//getAlignmentSub
	public char getSubAlignment()
	{
		char temp; temp = 'a';
		temp = this.alignmentSub;
		return temp;
	}
		
/*REQUIRED SECTION*************************************************************/	

	//equals
	public boolean equals(BaseCharacter other)
	{
	    if (other == null)
    	{
    		return false;
    	}	
    	else if (getClass() != other.getClass())
    	{
    		return false;
    	}		
    	else	
		return (name.equalsIgnoreCase(other.getName())) && (sex == other.sex) 
		&& (weight == other.weight) && (heightFeet == other.heightFeet) && 
		(heightInches == other.heightInches) &&(alignmentMain == 
		other.alignmentMain) &&	(alignmentSub == other.alignmentSub);
	}
	
	//toString
	public String toString()
	{
		return "Name: " + name + "\nSex: " +sex + "\nHeight: " + heightFeet + 
			"'" +heightInches +"\"" + "\nWeight: " + weight + "\nAlign Main: "
			+ alignmentMain + "\nAlign Sub: " + alignmentSub;
	}

}
