/***********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #15 problem #1
* LAST MODIFIED: 12/3/14
*************************************************
 ********************************************************************************
 * Roll Dice - standalone class that simulates die rolls and other game related
 * random necessities.
 ********************************************************************************
 * Simulates rolling of: d4, d6, d8, d10, d12, d20.
 * Also simulates:
 *	* d6 x 3 (for stats roll)
 *	* % roll (1 to 100)
 * This class could be useful for any RPG type game, or board game simulator...
 * perhaps other types as well.  Perhaps for a DM running a D&D (or other) 
 * campaign.
 *
 * Right now only using the stats roll, but figured building the whole thing out
 * to handle future circumstances was the right thing to do.
  *******************************************************************************
 * ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *
 * Random = used for simulating die rolls.
 *******************************************************************************/

import java.util.Random;

public class RollDice{

/*DECLARATION SECTION***********************************************************/  	

	Random randomGenerator = new Random();
	
	int d4;
	int d6;
	int d8;
	int d10;
	int d12;
	int d20;
	
	int rollStat;
	int rollPercent;

/*CONSTRUCTORS SECTION**********************************************************/ 	

	//loaded
	RollDice(int d4, int d6, int d8, int d10, int d20, int rollStat, 
		int rollPercent)
	{
		d4 = d4;//do these through readInt, set ranges
		d6 = d6;
		d8 = d8;
		d10 = d10;
		d12 = d12;
		d20 = d20;
		rollStat = rollStat;//leave off since calculated
		rollPercent = rollPercent;
	}
	
	//blank / default
	RollDice()
	{
		d4 = 0;
		d6 = 0;
		d8 = 0;
		d10 = 0;
		d12 = 0;
		d20 = 0;
		rollStat = 0;
		rollPercent = 0;
	}	
		
/*SETTERS SECTION***************************************************************/   	

	//rolls a d4
	private void setD4(int d4)
	{
		this.d4 = rollD4();
	}	
	//rolls a d6
	private void setD6(int d6)
	{
		this.d6 = rollD6();
	}	
	//rolls a d8
	private void setD8(int d8)
	{
		this.d8 = rollD8();
	}	
	//rolls a d10
	private void setD10(int d10)
	{
		this.d10 = rollD10();
	}	
		
	//rolls a d12
	private void setD12(int d12)
	{
		this.d12 = rollD12();
	}	
		
	//rolls a d20	
	private void setD20(int d20)
	{
		this.d20 = rollD20();
	}	
		
	//sets a local instance of rollStat - only needed locally
	private void setRollStat(int stat)
	{
		this.rollStat = rollStat();
	}	
		
	//sets a local instance of rollPercent - only needed locally	
	private void setRollPercent(int percent)
	{
		this.rollPercent = rollPercentile();
	}		

/*GETTERS SECTION***************************************************************/  

	private int getD4()
	{
		return d4;
	}	
	
	private int getD6()
	{
		return d6;
	}		
	
	private int getD8()
	{
		return d8;
	}		

	private int getD10()
	{
		return d10;
	}	
		
	private int getD12()
	{
		return d12;
	}	

	private int getD20()
	{
		return d20;
	}		
		
	private int getStat()
	{
		return rollStat;
	}		
	
	private int getPercent()
	{
		return rollPercent;
	}	

//processing / public access to roll methods

	//simulates rolling a four sided die - returns a random # betw 1 and 4
	public int rollD4()
	{
		int die;
		die = 0;
		die = randomGenerator.nextInt(4)+1;
		return die;
	}	

	//simulates rolling a six sided die - returns a random # betw 1 and 6
	public int rollD6()
	{
		int die;
		die = 0;
		die = randomGenerator.nextInt(6)+1;
		return die;
	}	
	
	//simulates rolling an eight sided die - returns a random # betw 1 and 8
	public int rollD8()
	{	int die;
		die = 0;
		die = randomGenerator.nextInt(8)+1;
		return die;	
	}
	
	//simulates rolling a 10 sided die - returns a random # betw 1 and 10
	public int rollD10()
	{	int die;
		die = 0;
		die = randomGenerator.nextInt(10)+1;
		return die;	
	}
	
	//simulates rolling a 12 sided die - returns a random # betw 1 and 12
	public int rollD12()
	{	int die;
		die = 0;
		die = randomGenerator.nextInt(12)+1;
		return die;	
	}
	
	//simulates rolling a 20 sided die - returns a random # betw 1 and 20
	public int rollD20()
	{
		int die;
		die = 0;
		die = randomGenerator.nextInt(20)+1;
		return die;
	}	

	//simulates rolling 3*d6 to set a main character stat for D&D	
	public int rollStat()
	{
		int die;
		die = 0;
		die = randomGenerator.nextInt(16)+3;
		return die;
	}

	//simulates a 2d10 roll for percentage (sort of) - returns a # betw 1 & 100
	public int rollPercentile()
	{
		int percentile; percentile = 0;
		percentile = randomGenerator.nextInt(100)+1;
		return percentile;
	}

/*REQUIRED SECTION*************************************************************/		

//toString
	public String toString(RollDice other)
	{
		return "d4: " + d4 + "d6: " + d6 + "d8: " + d8 + "d10: " + d10 + "d12: " 
			+ d12 +"d20: " + d20 + "Stat Roll: " + rollStat + "Percentile: " +
			rollPercent;
	}

//equals
	public boolean equals(RollDice other)
	{
		return (d4 == other.d4) && (d6 == other.d6) && (d8 == other.d8) &&
			(d10 == other.d10) && (d12 == other.d12) && (d20 == other.d20) && 
			(rollStat == other.rollStat) && (rollPercent == other.rollPercent);
	}	

}	
