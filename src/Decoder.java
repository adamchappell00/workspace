import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoder {
    public static String decode(String filepath) throws FileNotFoundException {
        System.out.println("Decode Method Called with - Filepath:" + filepath);
        File file = new File(filepath);
        Scanner sc = new Scanner(file);
        Map<Integer, String> pairs = new HashMap<Integer, String>();

        int curNum;
        String curWord;
        int highest = 0;
        while(sc.hasNext()){
            curNum = Integer.parseInt(sc.next());
            curWord = sc.next();
            pairs.put(curNum, curWord);
            if(curNum > highest){
                highest = curNum;
            }
        }
        int endLineInt = 1;
        int lineSize = 1;
        StringBuilder decoderStr = new StringBuilder();
        while(endLineInt < highest){
            System.out.println("Current Line Size: "+lineSize);
            decoderStr = new StringBuilder(decoderStr + pairs.get(endLineInt) + " ");
            System.out.println("Current Number: " + endLineInt);
            System.out.println("Paired word: "+pairs.get(endLineInt));
            lineSize++;
            endLineInt = endLineInt + lineSize;

        }
        String decoded = decoderStr.toString();
        return decoded;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String answer = decode("/Users/ac/Documents/test.txt");
        System.out.println(answer);
    }
}