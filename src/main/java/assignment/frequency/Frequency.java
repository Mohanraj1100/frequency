package assignment.frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Frequency 
{

	public static void main( String[] args ) throws FileNotFoundException
    {
	String address = "C:\\Users\\Tringapps-User25\\freq.txt";
        File f = new File(address);
        Scanner sc = new Scanner(f);
        Logger logger = Logger.getLogger("hi");
	StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> wordcount = new HashMap<>();
        while (sc.hasNextLine())
        {
        	sb.append(sc.nextLine());
        	sb.append(" ");
        }
        String[] words = sb.toString().split(" ");
        for(int i=0;i<words.length;i++)
        {
        	if(wordcount.containsKey(words[i]))
        	{
        		wordcount.put(words[i],wordcount.get(words[i]) +1);
        	}
        	else
        	{
        		wordcount.put(words[i], 1);
        	}
        	
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> {
        	return b.getValue() - a.getValue();
        });    
        	pq.addAll(wordcount.entrySet());
        	while(!pq.isEmpty())
        	{
        		logger.log(Level.INFO,()->"\n"+pq.poll());
        	}
        	sc.close();
    }
}
