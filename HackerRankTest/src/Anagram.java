import java.util.Arrays;

public class Anagram {
	static int anagram(String s) {
        if(s.length()%2 == 0)
        {
            int size = s.length();
            char[] ch = s.toCharArray();
            char[] ch1 = new char[size/2];
            char[] ch2 = new char[size/2];
            for(int i=0; i<ch1.length; i++)
            {
            	ch1[i]=ch[i];
            }
            for(int i=0; i<ch1.length; i++)
            {
            	ch2[i]=ch[size/2-i-1];
            }
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            if(Arrays.equals(ch1, ch2))
            {
                return 1;
            }
            else
            {
                for(int i=0; i<ch1.length; i++)
                {
                    
                }
            }
            return 0;
        }
        else
        {
            return -1;
        }
	}
	public static void main(String[] args)
	{
		System.out.println(anagram("ab"));
	}
}
