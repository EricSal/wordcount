import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;

public class wcbasic {
    public void wcexe(char m) throws IOException{
        String filepath="F:/test1.txt";//文件路径
        BufferedReader br =null;
        int countWord=0;
        int countChar=0;
        int countLine=0;
        String s="";
        String strCount="";
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filepath))));
            while((s=br.readLine())!=null)
            {
                s=s+" ";
                strCount+=s;
                countLine++;
            }
            for(int i=0;i<strCount.split(" ").length;i++){
                if(!strCount.split(" ")[i].equals(" "))
                    countWord++;
                countChar+= strCount.split(" ")[i].length();
            }
            File file = new File("F:/output.txt");
            FileOutputStream fos = new FileOutputStream(file);
            String content = null;
            switch(m){
                case 'c':
                    content="字符数："+countChar;
                    break;
                case 'w':
                    content="单词数："+countWord;
                    break;
                case 'l':
                    content="行数："+countLine;
                    break;
                case 'o':
                    content="字符数："+countChar+" 单词数："+countWord+" 行数："+countLine;
            }
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            br.close();
        }
    }
    public static void main(String[] args) throws IOException{
        wcbasic w=new wcbasic();
        char i = (char) System.in.read();
        w.wcexe(i);
    }
}