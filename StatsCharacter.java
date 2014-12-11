/***********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #15 problem #1
* LAST MODIFIED: 12/3/14
*************************************************
 ********************************************************************************
 * Stats Character Class - extension of Base Character class - contains variables 
 * that are the basics of a D&D character - 
 *	* STR INT WIS CON DEX CHA
 *		* These stats are rolled on a 3 - 18 basis via the RollDice class and
 *		* set in the character automatically.
/*******************************************************************************/  	

public class StatsCharacter extends BaseCharacter{

/*DECLARATION SECTION***********************************************************/  

	int strength;
	int intelligence;
	int wisdom;
	int constitution;
	int dexterity;
	int charisma;
	
	RollDice dice = new RollDice();//used to roll player stats automagically

/*CONSTRUCTORS SECTION**********************************************************/ 	
	
	//fully loaded
	StatsCharacter(int str, int intel, int wis, int con, int dex, int cha)
	{
		super();
		strength = dice.rollStat();//stats are automatically generated
		intelligence = dice.rollStat();//could easily make this a manual 
		wisdom = dice.rollStat();	   //or externally driven process	
		constitution = dice.rollStat();
		dexterity = dice.rollStat();
		charisma = dice.rollStat();
	}
		
	//blank / default
	StatsCharacter()
	{
		super();
		strength = dice.rollStat();
		intelligence = dice.rollStat();
		wisdom = dice.rollStat();
		constitution = dice.rollStat();
		dexterity = dice.rollStat();
		charisma = dice.rollStat();
	}
	
	//copy
	StatsCharacter(StatsCharacter other)
	{
		super();
		strength = other.getStrength();
		intelligence = other.getInt();
		wisdom = other.getWisdom();
		constitution = other.getCon();
		dexterity = other.getDex();
		charisma = other.getCharisma();
	}

/*SETTERS SECTION***************************************************************/ 
	//setStrength
	public void setStrength(int str)
	{
		strength = str;
	}
		
	//setIntelligence
	public void setIntelligence(int intel)
	{
		intelligence = intel;
	}
	
	//setWisdom
	public void setWisdom(int wis)
	{
		wisdom = wis;
	}
	
	//setConstitution
	public void setConstitution(int con)
	{
		constitution = con;
	}	
	
	//setDexterity
	public void setDexterity(int dex)
	{
		dexterity = dex;
	}	
	
	//setCharisma
	public void setCharisma(int cha)
	{
		charisma = cha;
	}	
  
/*GETTERS SECTION***************************************************************/
 
	//getStrength
	public int getStrength()
	{
		int temp; temp =0;
		temp = strength;
		return temp;
	}
	
	//getIntelligence
	public int getInt()
	{
		int temp; temp =0;
		temp = intelligence;
		return temp;
	}
	
	//getWisdom
	public int getWisdom()
	{
		int temp; temp =0;
		temp = wisdom;
		return temp;
	}
	
	//getConstitution
	public int getCon()
	{
		int temp; temp =0;
		temp = constitution;
		return temp;
	}
	
	//getDexterity
	public int getDex()
	{
		int temp; temp =0;
		temp = dexterity;
		return temp;
	}
	
	//getCharisma
 	public int getCharisma()
	{
		int temp; temp =0;
		temp = charisma;
		return temp;
	}
 
/*REQUIRED SECTION*************************************************************/	

	//toString
    public String toString()
    {
    	return super.toString()+ "\nSTR: "+ strength + "\nINT: " + intelligence +
    		"\nWIS: " + wisdom + "\nCON: " + constitution + "\nDEX: " + dexterity 
 				+ "\nCHA: " + charisma;
    }	
    	
    //equals
    public boolean equals(StatsCharacter other)
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
		return (super.equals(other)) && (strength == 
			other.strength) && (intelligence == other.intelligence) &&
			(wisdom == other.wisdom) && (constitution == other.constitution)
			&& (dexterity == other.dexterity) && (charisma == other.charisma);
    }
    
}
