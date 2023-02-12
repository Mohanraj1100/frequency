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
        File f = new File("C:\\Users\\Tringapps-User25\\freq.txt");
        String str = "";
        Scanner sc = new Scanner(f);
        Logger logger = Logger.getLogger("hi");
        HashMap<String,Integer> wordcount = new HashMap<>();
        while (sc.hasNextLine())
        {
        	str += sc.nextLine();
        	str+= " ";
        }
        String[] words = str.split(" ");
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
        PriorityQueue<HashMap.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> {
        	return b.getValue() - a.getValue();
        });    
        	for(HashMap.Entry<String,Integer> e : wordcount.entrySet())
        	{
        		pq.add(e);
        	}
        	while(!pq.isEmpty())
        	{
        		logger.log(Level.INFO,()->"\n"+pq.poll());
        	}
        	sc.close();
    }
}
