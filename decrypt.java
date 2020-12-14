
import java.lang.*;
import java.util.*;
import java.io.*;
import edu.duke.*;
public class decrypt {
    
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int ALPHABET_LENGTH = ALPHABET.length();
    private int LETTER_E_POSITION = ALPHABET.indexOf('e');

public String encrypt(String s,int key)
{
StringBuilder sh = new StringBuilder(s);
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
String a= "abcdefghijklmnopqrstuvwxyz";
String as = a.substring(key)+a.substring(0,key);
alphabet +=a;
shiftedAlphabet +=as;
for(int i=0;i<sh.length();i++)
{
char ch = sh.charAt(i);
int index = alphabet.indexOf(ch);
if(index!=-1)
{
   char newch = shiftedAlphabet.charAt(index);
   sh.setCharAt(i,newch);
}
}
return sh.toString();
}
public int[] countLetters (String message) {
        int[] counts = new int[ALPHABET_LENGTH];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = ALPHABET.indexOf(ch);
            if (index != -1) counts[index] += 1;
        }
        return counts;
    }
public int indexOfMax(int values[]) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
    public int keyfinder(int m)
    {
    if(LETTER_E_POSITION < m)
    return (m-LETTER_E_POSITION);
    else
    return (26-(LETTER_E_POSITION-m));
    }
public void decrypted()
{
    String s = "";
try
{
Scanner x= new Scanner(new File("file name with encrypted message"));
while(x.hasNext())
{
s+=x.nextLine();
}
}
catch(Exception e)
{
System.out.println("not found");
}
String s1="";
String s2="";
for(int i=0;i<s.length();i++)
{
if(i%2==0)
s1=s1+s.charAt(i);
else
s2=s2+s.charAt(i);
}

int c1[] = countLetters(s1);
int c2[] =countLetters(s2);

int m1= indexOfMax(c1);
int m2= indexOfMax(c2);

int key1= keyfinder(m1);
int key2= keyfinder(m2);

s1=encrypt(s1,26-key1);
s2=encrypt(s2,26-key2);
int j=0;
int k=0;
String combine ="";
for(int i=0;i<s.length();i++)
{
if(i%2==0)
{
combine = combine +s1.charAt(j);
j++;
}
else
{
combine = combine +s2.charAt(k);
k++;
}
}
System.out.println(" after decryption "+combine+" key1,key2 are "+key1+" "+key2);
}    
}
