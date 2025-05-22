package lab7;

public class MYLanguageChecker{
	/*
	 * if the string contains a star and the string after the star is the reverse of the string before the star
	 * return true, else return false;
	 * 
	 */
	public static boolean lan1(String input) {//string must contain a * along with a 
		//reversed copy of the substring before the * after the *
		
		if(input.length() == 0) return false;
		else if(input.length() == 1 && input.contains("*")) return true;
		else if(input.length() == 1) return false;
		else if(input.charAt(input.length() - 1) == '*') {
			
		}
		 if(input.charAt(0) == input.charAt(input.length() - 1)) {
		 return lan1(input.substring(1,input.length() - 1));  
		 }
		return false;
	}
	/*
	 * checks to see if the string is in alphebetical order, returns true if so, returns false otherwise 
	 */
	public static boolean lan2(String input) { //there must be at least one of each and 
		//order of characters must be alphabetic with repeats allowed
		if( input.equals("ABC")) return true;
		if(input.length() <= 3) return false;
		if(input.charAt(0) == 'A') {
			if(input.charAt(1) == 'B') {
				if(input.charAt(2) == 'C') {
					return lan2(input.substring(0,3));
				}
				return lan2(input.substring(0,1) + input.substring(2));
			}
			return lan2(input.substring(1));
		}
		return false;
	}
	/*
	 * if the string is the correct size and the core of the string when recursively partitioned
	 * from the last indexes until the string is 3 elements long. if the elements are 
	 * equal to the base case return true else return false
	 */
	public static boolean lan3(String input ) { //there must be double the amount of B's of total A's
		if(input.length() == 3 && input.equals("ABB")) {
			return true;
		}
		else if (input.length() > 2 && lan3(input.substring(1,input.length() - 2))) {
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		System.out.println("----------------\nlanguage 1 test:\n");
		System.out.println(lan1("*"));
		System.out.println(lan1("A*A"));
		System.out.println(lan1("AbghA*AhgbA"));
		System.out.println(lan1("Abd*Abd"));
		System.out.println(lan1("AA"));
		
		System.out.println("----------------\nlangauge 2 test:");
		System.out.println(lan2("ABC"));
		System.out.println(lan2("AABBCC"));
		System.out.println(lan2("ABBBCCCC"));
		System.out.println(lan2("AAC"));
		System.out.println(lan2("BBCA"));
		
		System.out.println("----------------\nlangauge 3 test:\n");
		System.out.println(lan3("ABB"));
		System.out.println(lan3("AABBBB"));
		System.out.println(lan3("AAABBBBBB"));
		System.out.println(lan3("AB"));
		System.out.println(lan3("AAAABB"));
	}
}
