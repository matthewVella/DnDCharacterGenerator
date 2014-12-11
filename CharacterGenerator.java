/***********************************************
* AUTHOR: Matt Vella
* COURSE: CS 111 Intro to CS I
* SECTION: Tues / Thurs + 11:30-1:30
* HOMEWORK #15 problem #1
* LAST MODIFIED: 12/3/14	
*************************************************
 ********************************************************************************
 * Character Generator - driver for creating a D&D character quickly and easily.
 *
 * At some point I would like to extend it to be something that could generate 
 * in-game characters.
 *
 * Psuedocode:
 *	do{
	 *	Printheader describing what this program does
	 * 	Create character object	
	 *	UI for choosing name
	 *	UI for choosing sex
	 *	UI for choosing alignment
	 *	Pretend to roll stats right then, and display them for the user
	 *	Set age
	 *	Set level
	 *	Set XP (do in class - would be nice to automate with leveling up)
	 *	Calculate hit die (do in class)
	 *	Calculate race bonus based on user input for race
	 *	Print out character sheet
	 *	Ask if user wants to roll another character.
 *
 *	}while goAgain == t;
 *
 ********************************************************************************
 * ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *
 * Scanner = used for console input
 *
 *******************************************************************************/

import java.util.Scanner;

public class CharacterGenerator {

	public static void main(String[] args) {
		
/*DECLARATION SECTION***********************************************************/  	

	Scanner keyboard = new Scanner(System.in);
	String charName; charName = null;//compiler complained w/o this
	char sex;
	int mf, alignMain, alignSub, goAgain;
	
	mf = 0; alignMain = 0; alignSub = 0; goAgain = 0;
	
/*PROCESSING SECTION************************************************************/  	

	printHeader(15, 1, "December 3, 2014.");
	printGenHeader();
	
	do{
		CharClass frankenshtein = new CharClass();
		frankenshtein.setName(charName);
		frankenshtein.setSex(mf);
		frankenshtein.setAlignmentBoth();
		printStatsHeader();
		System.out.println(frankenshtein.getBaseStatsToString());
		System.out.println("\nCarefully examine your stats.");
		System.out.print("Based on the highest stats and / or "); 
		System.out.println("your RP style, choose your character race and class.");
		frankenshtein.setRaceAgeHeightWeight();
		frankenshtein.setLevel(1);
		frankenshtein.calcHitDie(frankenshtein.getCharClass());
		frankenshtein.calcRaceBonus(frankenshtein.getRace());
		frankenshtein.setHP();//redo in the CharClass file
		System.out.println("\nPrinting character sheet for your new level 1 " +
			"character: ");
		System.out.println(frankenshtein.characterSheet());
		goAgain = CharClass.readInt("Go again? 1 for yes, 2 for no.\n"
			,keyboard,1,2);
		
		}while (goAgain < 2);
	}
	
/*LOCAL METHODS SECTION*********************************************************/ 	

/********************************************************************************
 * DESCRIPTION:	Print out a blurb on on what the prog is about.
 ********************************************************************************
 * PRE-CONDITIONS:	All parameters are given a value
 ********************************************************************************
 * POST-CONDITIONS:	Outputs text to console
 *******************************************************************************/	
 	
	//print out a blurb on what the prog is about
	public static void printGenHeader()
	{	
	System.out.println("Welcome to D&D Character Creator v1.0...");
	System.out.println("\nBased on D&D Basic Rules v.1, July 2014");
	System.out.println("\nThis program will allow you create a level 1");
	System.out.println("character in a matter of seconds.");
	System.out.println("It makes use of:\n *Class Building\n *Inheritance\n " + 
		"*Random Generator\n *Arrays"+ "\n *Do/While\n *If/Else\n   "+
			"and\n *NerdMath(tm)");
	}
	
/********************************************************************************
 * DESCRIPTION:	Print out a blurb on looking at your player stats before making 
 *	more choices
 ********************************************************************************
 * PRE-CONDITIONS:	All parameters are given a value
 ********************************************************************************
 * POST-CONDITIONS:	Outputs text to console
 *******************************************************************************/	

	public static void printStatsHeader()
	{
	System.out.println("\nLet's roll your stats and see what kind of race and " +
		"class will be the best fit for you.");	
	System.out.println("\nPlease hold, rolling 3d6 each for str, int, wis, dex "+
		" & cha\n");
	}

/********************************************************************************
 * DESCRIPTION:	Print author information for start of program
 ********************************************************************************
 * PRE-CONDITIONS:	All parameters are given a value
 ********************************************************************************
 * POST-CONDITIONS:	Outputs author info to console
 *******************************************************************************/
 
	public static void printHeader(int homework, int problem, 
		String lastModified) 
	{
		//constants
		final String NAME = "Matt Vella";
		final String COURSE = "CS 111 Intro to CS I";
		final String SECTION = "TuTh 11:30am-3:20pm";
		
		//output
		System.out.println("/*****************************************");
		System.out.println("* AUTHOR:        " + NAME);
		System.out.println("* COURSE:        " + COURSE);
		System.out.println("* SECTION:       " + SECTION);
		System.out.println("* HOMEWORK #:    " + homework);
		System.out.println("* PROBLEM #:     " + problem);
		System.out.println("* LAST MODIFIED: " + lastModified);
		System.out.println("*****************************************/");
	}
}
