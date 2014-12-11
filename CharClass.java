
/*/**********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #13 problem #1
* LAST MODIFIED: 12/3/14	
*************************************************
 ********************************************************************************
 * CharClass Class - final container for all values that build a D&D character.
 * Extension of Race class.
 *	*Adds:
 *		*characterClass (stored as a String). For an actual RPG I'd do a Class
 *			instead, but for the purposes of this program this is fine.
 *		*level
 *		*experience points (would be great to do this as a calculated value
 *		*so you could track your character's progress automatically
 *		*initiative - (after reading the rules it makes sense to leave this off
 *		*armor class - calculated
 *		*speed - based on race - could be built out to adjust for encumbrance
 *		*hit points - based on base stats, race bonuses, and class 
 *
 *	*Aside from normal setters and getters there are additional methods:
 *
 *	*setStatModifier - uses the formula from the rules to look at a given base
 *	 stat and figure out the stat modifier to be used in things like combat,
 *	 armor class, etc. Returns the stat modifier #. (stat-10)/2 - rounded 
 *	 down.  
 *
 *	*calcHitDie - calcuates a character's hit die based on their class. Needs
 *	 to be revisited to account for leveling up, etc.
 *
 *	*setRaceAgeHeightWeight - a big ugly mess that i pulled from CharacterGener-
 *	 ator to make it readable. Makes sense (to me anyway) to have all in one as 
 *	 the involved stats are all custom ranges based on race.  Could be pulled 
 *	 apart, but for the sake of this program and its purpose...it works.
 *
 *	*characterSheet - could have used toString and called it a day but the way
 *	 things are set up in the files it made sense to just make a custom printout.
 *
 *	*getBaseStatsToString - couldn't figure out how to get BaseCharacter to spit
 *	 out from the driver so a method to print out the base stats for the user to
 *	 get a look at before choosing race, class, etc.
 ********************************************************************************
 * ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *
 * Scanner = used for console input
 *
 *******************************************************************************/
import java.util.Scanner;

public class CharClass extends Race{
	
/*DECLARATION SECTION***********************************************************/ 

	String characterClass;
	int level;//level and XP will be calculated if time 
	int experiencePoints;
	
//calculated values
	int initiative;
	int armorClass;
	int speed;
	int hitPoints;
	
/*CONSTRUCTORS SECTION**********************************************************/ 	

	//fully loaded
	CharClass(String charClass, int lvl, int xp, int init, int ac, int speed, 
		int hp)
	{
		super();
		characterClass = charClass;
		level = level;
		experiencePoints = xp;
		initiative = init;
		setAC();
		speed = speed;
		setHP();
	}		

	//blank / default
	CharClass()
	{
		super();
		characterClass = "No class chosen yet.";
		level = 0;
		experiencePoints = 0;
		initiative = 0;//placeholder as this is rolled per-encounter
		setAC();
		speed = 0;
		setHP();
	}
		
	//copy
	CharClass(CharClass other)
	{
		super();
		characterClass = other.getCharClass();
		level = other.getLevel();
		experiencePoints = other.getXP();
		initiative = other.getInit();
		armorClass = other.getAC();
		speed = other.getSpeed();
		hitPoints = other.getHP();
	}
	
	CharClass(int level)
	{
		super();
		characterClass = "No class chosen yet.";
		level = level;
		experiencePoints = 0;
		initiative = 0;
		armorClass = 0;
		speed = 0;
		hitPoints = 0;	
	}	
	
/*SETTERS SECTION***************************************************************/ 

	//calcHitDie
	public void calcHitDie(String temp)//Set to handle level advancement
	{
		if (temp.equalsIgnoreCase("fighter"))
		{
		setHitDie(10*getLevel());
		}
		else if((temp.equalsIgnoreCase("rogue"))||
			(temp.equalsIgnoreCase("cleric")))
		{
		setHitDie(8*getLevel());
		}			
		else if (temp.equalsIgnoreCase("wizard"))
		{		
		setHitDie(6*getLevel());
		}
	}

	//setClass
	public void setClass(String charClass)
	{
		this.characterClass = charClass;
	}	
		
	//setLevel 
	public void setLevel(int lvl)
	{
		this.level = lvl;
	}
	
	//setXP
	public void setXP(int xp)
	{
		this.experiencePoints = xp;
	}	
	
	//setInit
	public void setInit(int init)
	{
		this.initiative = init;
	}	
	
	//setAC
	public void setAC()
	{					
		armorClass = 10+(setStatModifier(getDex()));
	}	
		
	//setSpeed
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}	
		
	//setHP
	public void setHP()
	{
		hitPoints = (getHitDie()+setStatModifier(getCon()));
	}//needs to be updated to scale with level
	
	//statModifier
	public int setStatModifier(int stat)
	{
	int modifier = 0;	
	modifier = (stat-10)/2;
	return modifier;		
	}	
	
	//sets race, then age, height and weight to custom ranges based on race.
	//currently sets speed manually as well, will prob end up moving it elsewhere.
	public void setRaceAgeHeightWeight()
	{
		//UI for setting race
		Scanner keytar = new Scanner(System.in);
		String[]races = {"Human", "Hill Dwarf", "Mountain Dwarf",
		"Wood Elf", "High Elf", "Stout Halfling", "Lightfoot Halfling"};
		int race; race = 0;
		race = CharClass.readInt("\n1. Human \n2. Hill Dwarf \n3." +
			" Mountain Dwarf \n4. Wood Elf" +
		 "\n5. High Elf \n6. Stout Halfling \n7. Lightfoot Halfling\n",keytar,1,7);
		setRace(races[race-1]);

		//UI for setting character class
		String[]classes = {"Cleric", "Wizard", "Rogue", "Fighter"};		
		int tehClasses;
		System.out.println("\nFighters need CON, Wizards need INT, Clerics need"+ 
			" WIS, and Rogues need DEX.");		
		tehClasses = CharClass.readInt("\n1. Cleric \n2. Wizard \n3. " +
			"Rogue \n4. Fighter\n", keytar,1,4);
		setClass(classes[tehClasses-1]);
	
		//UI for setting age, height and weight 
		int age; int heightFeet; int heightInches; int weight;
		age = 0; heightFeet = 0; heightInches = 0; weight = 0;
	
		if (race == 1)//if human
		{
		age = readInt
			("\nEnter an age for your human - 18 to 55:\n", keytar,18,55);
		weight = readInt
			("Enter a weight for your human - 100 to 300:\n", keytar, 100,300);
		heightFeet = readInt
			("Enter the main height in feet for your human 5 to 6:\n", keytar, 5,6);
		heightInches = readInt
			("Enter the remaining height in inches for your human, 0 to 11:\n", 
				keytar,0,11);
		setSpeed(30);
		}
	
		if ((race == 2)||(race == 3))//if dwarf 
		{
		age = readInt("\nEnter an age for your dwarf - 50 to 350:\n", keytar,50,350);
		weight = readInt("Enter a weight for your dwarf - 125 to 175:\n", 
			keytar, 125,175);
		heightFeet = readInt
			("Enter the main height in feet for your dwarf 3 to 4:\n", keytar, 3,4);
		heightInches = readInt
			("Enter the remaining height in inches for your dwarf, 0 to 11:\n", 
				keytar,0,11);
		setSpeed(25);
		}
		
		if ((race == 4)||(race == 5))	//if elf
		{
		age = readInt("\nEnter an age for your elf - 100 to 700:\n", keytar,100,700);
		weight = readInt("Enter a weight for your elf- 100 to 150:\n", keytar, 100,150);
		heightFeet = readInt
			("Enter the main height in feet for your elf, 4 to 5:\n", keytar, 4,5);
		heightInches = readInt
			("Enter the remaining height in inches for your elf, 0 to 11:\n", 
				keytar,0,11);
		setSpeed(30);
			//wood elf needs to be 35
		}	
			
		if((race == 6)|| (race == 7))//if halfling
		{
		age = readInt("\nEnter an age for your halfling - 18 to 90:\n", keytar,18,90);
		weight = readInt
			("Enter a weight for your halfling - 25 to 60:\n", keytar, 25,60);
		heightFeet = readInt
			("Enter the main height in feet for your halfling, 2 to 3:\n", 
				keytar, 2,3);
		heightInches = readInt
			("Enter the remaining height in inches for your halfling, 0 to 11:\n", 
				keytar,0,11);
		setSpeed(25);
		}
			setAge(age);
			setWeight(weight); 
			setHeightFeet(heightFeet);
			setHeightInches(heightInches);	
	}
	
/*GETTERS SECTION***************************************************************/

	//getClass
	public String getCharClass()
	{
		return characterClass;
	}	
	
	//getLevel 
	public int getLevel()
	{
		int temp; temp = 0;
		temp = level;
		return temp;
	}	
	
	//getXP
	public int getXP()
	{
		int temp; temp = 0;
		temp = experiencePoints;
		return temp;
	}		

	//getInit
		public int getInit()
	{
		int temp; temp = 0;
		temp = initiative;
		return temp;
	}	

	//getAC
	public int getAC()
	{
		int temp; temp = 0;
		temp  = armorClass;
		return armorClass;
	}	
	
	//getSpeed
	public int getSpeed()
	{
		int temp; temp = 0;
		temp = speed;
		return speed;
	}	
	
	//getHP
	public int getHP()
	{
		int temp; temp = 0;
		temp = hitPoints;
		return temp;
	}	

/*REQUIRED SECTION**************************************************************/	
	
	//toString
	public String toString()
	{
		return super.toString() + "\nLevel: " + level + "\nXP: " + experiencePoints +
		"\nInitiative: " + initiative + "\nAC: " + armorClass + "\nSpeed: " +speed + 
		"\nHP: " + hitPoints + "\nClass: " + characterClass;
	}
	
	//equals
	public boolean equals(CharClass other)
	{//class, level, xp, init, ac, speed, hp
	    if (other == null)
    	{
    		return false;
    	}	
    	else if (getClass() != other.getClass())
    	{
    		return false;
    	}		
    	else
		return (super.equals(other)) && (characterClass.equals
		(other.characterClass)) && (level == other.level) && (experiencePoints == 
		other.experiencePoints) && (initiative == other.initiative) && 
		(armorClass == other.armorClass) && (speed == other.speed) && 
		(hitPoints == other.hitPoints);
		}
		
		//baseStatsToString 
		public String getBaseStatsToString()
		{
		return "\nSTR: " + getStrength() +  "\nINT: " + getInt() + "\nWIS: " + 
			getWisdom() + "\nCON: " + getCon() + "\nDEX: " + getDex() + 
			"\nCHA: " + getCharisma(); 	 	
		}
				
		//printout of final character sheet after calculations, etc.
		public String characterSheet()
		{
			return "\nCharacter Name: " + getName()+ "\nSex: " + getSex() + 
			"\nClass: " + getCharClass() + "\nRace: " + getRace() + "\nAge: " + 
			getAge() + "\nHeight: " + getHeightFeet() + "\'" + getHeightInches()+ 
			"\"" + "\nWeight: " + getWeight() + " lbs" + "\nLevel: " + getLevel() + 
			"\n\nHP: " + getHP() + "\nAC: " + getAC() + "\nXP: " + getXP() + 
			"\n" + getBaseStatsToString() + "\n\nMain Align: " + 
			getMainAlignment() + "\nSub Align: " + getSubAlignment() + 
			"\n\nHit Dice: " + getHitDie() + "\nSpeed: " + getSpeed();
		}	
	
	//readInt - takes in a string from user input and parses to an int
	//  within set boundaries
	public static int readInt(String prompt, Scanner input,
								int lowerBound, int upperBound)
	{
		//declarations
		int result;
		String temp;
		boolean isNotValid;
		
		//input + processing
		do
		{
			System.out.print(prompt);
			temp = input.nextLine();
			result = Integer.parseInt(temp);
			isNotValid = (result < lowerBound) || (result > upperBound);
			
			if (isNotValid)
			{
				System.out.printf("ERROR: Please input number between " +
					"%d and %d%n", lowerBound, upperBound);
			}
		} while (isNotValid);
			
		return result;
	}

}	
		
