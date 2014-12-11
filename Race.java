/*/**********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #15 problem #1
* LAST MODIFIED: 12/3/14
*************************************************
 ********************************************************************************
 * Race Class - extension of StatsCharacter that contains Race specific data.
 *	*Adds:
 *		*race (more like species - stored as a String)
 *		*hitDie (calculated stat)
 *		*age
 *
 *	*Aside from the usual setters and getters etc., there is a calcRaceBonus
 *	 method that looks at a character's race and applies bonuses to the base
 *	 stats.
 *******************************************************************************/

public class Race extends StatsCharacter{
	
/*DECLARATION SECTION***********************************************************/  	

	String race;
	int hitDie;
	int age;

/*CONSTRUCTORS SECTION**********************************************************/ 	

	//fully loaded
	Race (String race, int hitDie, int age)
	{
		super();
		this.hitDie = hitDie;
		this.race = race;
		this.age = age;
	}

	//blank / default
	Race()
	{
		super();
		race = "No race chosen yet.";
		hitDie = 0;
		age = 0;
	}
	
	//copy
	Race(Race other)
	{
		super();
		race = other.getRace();
		hitDie = other.getHitDie();
		age = other.getAge();
	}	

/*SETTERS SECTION***************************************************************/ 

	//setRace
	public void setRace(String race)
	{
		this.race = race;
	}	
	
	//setAge
	public void setAge(int age)
	{
		this.age = age;
	}	
		
	//setHitDie	
	public void setHitDie(int hitDie)
	{
		this.hitDie = hitDie;	
	}
	
	//calcRaceBonus
	public void calcRaceBonus(String temp)
	{
		if (temp.equalsIgnoreCase("human"))
		{
			strength +=1;
			wisdom +=1;
			intelligence +=1;
			dexterity +=1;
			constitution +=1;
			charisma +=1;
		}	
		if (temp.equalsIgnoreCase("mountain dwarf"))
		{
			constitution+=2;
			strength+=2;	
		}			
		if (temp.equalsIgnoreCase("hill dwarf"))
		{
			constitution+=2;
			wisdom+=1;	
		}				
		if (temp.equalsIgnoreCase("high elf"))
		{
			dexterity+=2;
			intelligence+=1;
		}	
		if (temp.equalsIgnoreCase("wood elf"))
		{
			dexterity+=2;	
			wisdom+=1;		
		}
		if (temp.equalsIgnoreCase("stout halfling"))
		{
			dexterity+=2;	
			constitution+=1;		
		}	
		if (temp.equalsIgnoreCase("lightfoot halfling"))
		{
			dexterity+=2;	
			charisma+=1;
		}	
	
	}	

/*GETTERS SECTION***************************************************************/

	//getRace
	public String getRace()
	{
		return race;
	}
	
	//getAge
	public int getAge()
	{
		int temp; temp = 0;
		temp = age;
		return temp;
	}	
	
	//getHitDie
	public int getHitDie()
	{
		int temp; temp = 0;
		temp = hitDie;
		return temp;
	}	

/*REQUIRED SECTION*************************************************************/	

	//toString
	public String toString()
	{
		return super.toString() + "\nRace: " + race + "\nHit Die: " + hitDie +
			"\nAge: " +age;
	}

	//equals
	public boolean equals(Race other)
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
		return (super.equals(other)) && (race.equals(other.race))
			&& (hitDie == other.getHitDie()) && (age == other.getAge());
	}
}
