import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.lang.String;

public class wcbasic{
    static BufferedReader br;
    static FileOutputStream fos;
    static int countWord=0;
    static int countChar=0;
    static int countLine=0;
    private String filepath = "undefined";
    public wcbasic(String filepath)throws FileNotFoundException{
        this.br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filepath))));
        this.fos = new FileOutputStream (new File("output.txt"));
        this.filepath = filepath;
    }
    public void wcexe(char m) throws IOException{
        String s="";
        String strCount="";
        try {
            while((s=br.readLine())!=null)
            {
                countChar += s.length();
                if(s.contains("\t")){
                    countChar--;
                }
                strCount+=(s+" ");
                countLine++;
                if(countLine!=1)
                    countChar++;
            }
            String results[]  = strCount.split("( |,|\\n|\\t)+");
            countWord = results.length;
            String content = null;
            switch(m){
                case 'c':
                    content=filepath+" 字符数："+countChar;
                    System.out.print(filepath+" 字符数："+countChar);
                    break;
                case 'w':
                    content=filepath+" 单词数："+countWord;
                    System.out.print(filepath+" 单词数："+countWord);
                    break;
                case 'l':
                    content=filepath+" 行数："+countLine;
                    System.out.print(filepath+" 行数："+countLine);
                    break;
                case 'o':
                    content=filepath+" 字符数："+countChar+" 单词数："+countWord+" 行数："+countLine;
                    System.out.print(filepath+" 字符数："+countChar+" 单词数："+countWord+" 行数："+countLine);
                    break;
            }
            fos.write(content.getBytes());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
        }
    }
    public static void main(String[] args) throws IOException{
        char m=' ';
        String filepath= " ";
        if(args.length>=2){
            filepath= args[args.length-1];
            wcbasic w=new wcbasic(filepath);
            for (int i = 0; i < args.length-1; i++) {
                if (args[i].charAt(0) == '-') {
                    char t = args[i].charAt(1);
                    if(t == 'w'|| t == 'l'|| t == 'c'||t == 'o'){
                        w.wcexe(t);
                    }else{
                        System.out.println("wrong command");
                    }
                } else {
                    System.out.println("wrong command");
                }
            }
        }
        wcbasic.fos.flush();
        wcbasic.fos.close();
        wcbasic.br.close();
        }
    }
