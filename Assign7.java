// For Assignment 7 also download Player.java and NBADATA.txt
// Creating a package is up to you
// Complete the methods in this class following drections in the comments
// Do not change the main or method signatures
//-------------------------------------------------------------------------------


/****************************************************/
   //UPLOAD THE ENTIRE PACKAGE FOLDER.
/**************************************************** */
import java.util.Iterator;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Comparator;
import java.time.DateTimeException;
import java.util.ArrayList;


public class Assign7 {
	// global array to store player details
	// will not need to be passed
   public static Player[] players;  
   public static String[] strCurrArrPlayer;
   public static ArrayList<String> strArrList = new ArrayList<String>();
   public static String[] strPlayer;
   public String strCurrPlayer = "";
	//must derclare string arraylist obj with global arrays of player type??
   //----------------------------------------
   public static void testing() {
   
   }
   //--------------------------------------
   public static ArrayList readData() { //write this method first.
      try {
         Scanner sc = new Scanner(new File("NBADATA.txt"));
         while(sc.hasNextLine() == true) {
            strArrList.add(sc.next());
         }
         sc.close(); //Closing Scanner Object.
         return strArrList;
      }
      catch (Exception e) {
         System.out.print("ERROR: File Not Found; Exiting Program");
         System.exit(1);
      }
      return strArrList;
   }

   
   public static void main(String[] args) {
      int numPlayers = countPlayers();
      System.out.println("Number of players is " + numPlayers);
   	// Create the array so it has no wasted space
      players = new Player[numPlayers]; 
      System.out.println("Adding the players...");
      fillPlayers();
   
      System.out.println("Player at index 123 is " + players[123]);
   	// Prints the following
   	// Jalen Brunson, Position: PG, Games Played: 68, MinsPG: 35
   	// RebsPG: 3.5, AsstsPG: 6.2, StsPG: 0.9, BlksPG: 0.2, PtsPG: 24
   		
      System.out.println("Josh Richardson played " + getMins("Josh Richardson") + " minutes per game.");
   		
      System.out.println("How many players played Center? " + totalPlayersPosition("C"));
      System.out.println("Most efficient scorer (points per minute, minimum 15 minutes per game) " + mostEfficientScorer());
   		
      System.out.println("List of players who averaged at least 2 blocks");
      //System.out.println(moreBlocksThan(2).toString());
   		
      whoPlayedMostTotalMinutes();
   		
   }
   //------------------------------------------
   public static int getDataRowsLen() {///this might be a method to make data reading work.
      return -1; 
   }//-------------------------------------------------
   

	// Process the NBADATA.txt file to calculate and return how many records in the file
	// No need to create Objects yet
   //--------------------------------------------
   //****************************************************
   public static int countPlayers() {
      int toReturnCount = 0;
      int length = (int)((strPlayer.length - 1));
      if(length >= 1) {
         length--;
      }
      else {
         int len = (int)((length))--;
         String Str = "";
         String[] StrArr = new String[len];
         while(len < players.length) {
            String Strlen = players[len].toString();
            ++len;
         }
         len = 0;
         for (int r = len; r > 0; --r) {
            if (players[len] == null)
               break;
            ++toReturnCount;
         }
         return toReturnCount;
      }
      return -1;
   }

	// Read in information from the NBADATA.txt file and create Player objects
	// that are placed into the players array
	// Try to read one line at a time and then use the String.split method
   public static void fillPlayers() {
      String localFullName = "";
      int localGamePlayed = 0;
      String localPos = "";
      int localMin = 0;
      int localSteal = 0;
      int localBlocks = 0;
      int localAssists = 0;
      int localRebounds = 0;
      int localPoints = 0;
      
      
      
      // Put in the Players
      //-----------------------------------------------------------
      String currPlayer = ""; 
      int col = 100;
      for(int i = 0; i < col; i++) {
         //strCurrPlayer = players[i].toString(); //-------------------------------
         break;
      }
      try {
      //must read data here
         String Prt = "Hi Sandro";
         currPlayer = Prt;
         for (int row = 0; row <= 30; row++) {
            for (int j = 0; j <= 10; j++) {
               strPlayer[row] = currPlayer;
            }
         }
         //***************************************************************************************************
         strArrList = readData();
         //players = strArrList.toArray();
         //--------------------------------
         //WHILE NEXT PLAYER EXISTS
         //---------------------------------
         for(int i = 0; i < strArrList.size(); i++) {
            //players[i] = strArrList.get(i);
            strPlayer[i] = strArrList.get(i);
         }
         
      } catch (IllegalStateException e) {
         System.out.println(e);
      }
   }//------------------------------------------------------------------------
	// Returns the mins per game for a player 
   public static double getMins(String s) {
      String toReturnFlag;
      for (int i = 0; i < 30; i++) {
         for (int j = 0; j < 10; j++) {
            if ((players[i])== null)
               break;
            toReturnFlag = (players[i]).getFullName();
            if (toReturnFlag.equals(s)) 
               return players[i].getMinutes();
         }
      }
      return -1.00;
   }			


	// Returns the number of players who played at a certain
	// position during the season
	// Should include players who played that position
	// all of the time or some of the time
   public static int totalPlayersPosition(String pos) {
      int toReturn = 0;
      //count loop for inputted string within global player arr.
      for(int i = 0; i < players.length; i++) {
         if(players[i].equals(pos)) ++toReturn;
      }
   
      return toReturn;
   }

	// Returns the name of the most efficient scorer - the player with the 
	// highest points per minute with minimum 15 minutes per game
   public static String mostEfficientScorer() {
      //filter high score array with parrallel array of game time data
      //find highest score(points per min) within array of scores.
      int[] minArr = new int[100];
      int[] scoreArr = new int[100];
      int avgHighScore = 0;
      int avgHighScoreEle = 0;
      //int i = 0;
      for (int ele = 0; ele <= scoreArr.length; ele++) {
         if((minArr[ele] > 15) && ((scoreArr[ele] / minArr[ele]) > avgHighScore)) {
            avgHighScore = scoreArr[ele] / minArr[ele];
            avgHighScoreEle = ele;
            //++i;
         }
      }
      //player get name..........
      
      return players[avgHighScoreEle].getFullName();
      
   
      //return "";
   }					


	// Return an ArrayList that contains the names of the players
	// who had more than a certain number of blocks per game
   //---------------------------------------------------------------------------------
   static boolean globalTrueFlag = false;
   public static void moreBlocksThan(int limit) {
   
      for(int i = 0; i < strArrList.size(); i++) {
         if(players[i].getBlocks() > limit) {
            globalTrueFlag = true;
         }
      }
   ///reset bool?
   }
//-------------------------------------------------------------------------------------


	// Calculate and print the number and total minutes of the player
	// who played the most minutes in the whole season
   public static void whoPlayedMostTotalMinutes() {
      //filter the arraylist of time played data and then print the player name that exists at that index from a parrallel name ARRLIST
      int[] gameTime = new int[100];
      //players.
      String[] Names = new String[100];
      String MostTimePlayed = "";
      int eleOfMostTimePlayed = 0;
      for(int ele : gameTime) {
         if(gameTime[ele] > eleOfMostTimePlayed) {
            eleOfMostTimePlayed = ele;
         }
      }
      MostTimePlayed = Names[eleOfMostTimePlayed];
   
   
   
   }					
		//----------------------------------------------------------------------
      /*
         analize CVS file. Comma delmitor. do sandro's methods.
      */
      // *******************************************************************************





}	   //-----------------------------------------------------------------------
