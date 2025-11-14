package practiceTopics;

public class Interview {

	static String ReverseWord(String word) {
		String reverse="";
		for(int i=word.length()-1;i>=0;i--) {
			reverse+=word.charAt(i);
		}
		return reverse;
	}
	
	static String reverseSentance(String Sentance) {
		String reverse="";
		String words[]=Sentance.split(" ");
		for(int i=words.length-1;i>=0;i--) {
			reverse+=words[i]+" ";
			reverse.trim();
		}
		return reverse;
	}
	
	static String DuplicateAlphabetes(String str) {
		int count=0;
		String dup = null;
		for(int i=0;i<str.length();i++) {
			
			for(int j=0;j<str.length();j++) {
				if(i!=j) {
					if(str.charAt(j)==str.charAt(i)) {
						System.out.println("i="+i+" j="+j+ "\t "+str.charAt(i));
						dup=""+str.charAt(i);
						count++;
					//	if(count>1)
						//duplicate +=""+str.charAt(i);
						
					}
				}
		}
		}
		System.out.println("number of duplicates: "+count/2);
		return dup;
	}
	
	public static void main(String[] args) {
		/*String word="HelloDear";
		String Sentance ="Hello brother how are you";
		
		System.out.println("Original word: "+word+ "\nreverse:\t"+ReverseWord(word));
		System.out.println();
		
		System.out.println("Original Sentance: "+Sentance+ "\nreverse:\t"+reverseSentance(Sentance));
		System.out.println();
		
		System.out.println("ReverseWordsInSentance:\t"+ReverseWord(reverseSentance(Sentance)));
		System.out.println();*/
		
		System.out.println(DuplicateAlphabetes("Hello"));
		
	}

}
/*
 * import java.util.HashMap;
import java.util.Map;

static String DuplicateAlphabets(String str) {
    Map<Character, Integer> freq = new HashMap<>();
    StringBuilder duplicates = new StringBuilder();

    // Count occurrences of each alphabet
    for (char ch : str.toCharArray()) {
        if (Character.isLetter(ch)) { // only alphabets
            ch = Character.toLowerCase(ch); // ignore case
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
    }

    // Find and record duplicates with counts
    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
        if (entry.getValue() > 1) {
            duplicates.append(entry.getKey())
                      .append("=")
                      .append(entry.getValue())
                      .append(" ");
        }
    }

    // Optional: show total duplicate letters
    long totalDuplicates = freq.values().stream().filter(v -> v > 1).count();
    System.out.println("Number of duplicate alphabets: " + totalDuplicates);

    return duplicates.toString().trim();
}
*/
