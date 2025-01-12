import java.util.Scanner;

public class typing_speed {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("************ Hello ************");
        System.out.println(" ****Welcome to the test!****");
        System.out.println("Type the following paragraph to test your speed");
        String paragraph="The quick brown fox jumps over the lazy dog. In the quiet forest, sunlight filtered through the leaves, creating a peaceful, dappled pattern on the ground. Birds chirped melodiously as a gentle breeze rustled the branches. The fox, with its sleek fur and sharp eyes, moved gracefully, alert to every sound. Nearby, a sleepy dog lay basking in the warmth, oblivious to the world around it. Nature’s serene beauty painted a tranquil picture of harmony and calm.";
        System.out.println(paragraph);
        String str;int i;
        long start_time=System.currentTimeMillis();
        str=in.nextLine();
        long end_time=System.currentTimeMillis();
        long total_time=end_time-start_time;
        double total_time_in_sec;
        total_time_in_sec = total_time/1000;
        int words=0;
        str=str.trim();
        for(i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                words++;
            }
        }
        System.out.println("Total number of words per minute = "+((words/total_time_in_sec)*60));
    }
}
