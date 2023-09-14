package crud.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
    Scanner scanner= new Scanner(System.in);

    ArrayList <Word> list;
    final String fname = "Dictionary.txt";

    WordCRUD(Scanner scanner){
        list = new ArrayList<>();
        this.scanner=scanner; // 이거 왜 하는 거지??
    }

    @Override
    public Object Add() { // 새로운 워드 만들기
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level= scanner.nextInt();
        String word = scanner.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = scanner.nextLine();
        return new Word(0,level,word,meaning);
    }
    public void AddWord(){
        Word one = (Word)Add(); // object를 Word로 설정..
        list.add(one);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!! ");
    }

    @Override
    public int Update(Object obj) {
        System.out.println("=> 수정할 단어 검색 : ");
        String word = scanner.nextLine();
        for(int i=0;i<list.size();i++){
           // if(((list.get(i)).getWord()).compareTo(word)==0)




        }
        return 0;
    }

    @Override
    public int Delete(Object obj) {
        return 0;
    }

    @Override
    public void SelectOne(int id) {

    }

    public void loadFile(){
        try {
            System.out.println("haha");
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count=0;
            //  자.... 읽어 드려서 각자 워드에 넣어 줘야됨... 그럼 .. word를 정의하고, 그걸 arraylist에 넣어야 함.
            while(true) {
                line = br.readLine();
                if(line==null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt( data[0]);
                String name = data[1];
                String meaning= data[2];
                list.add(new Word(0,level,name,meaning));
                count++;
            }
            System.out.println("=> "+count+"개 단어 로딩 완료!\n");
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(){

    }

    public void ListAll(){
        Word word= new Word();
        System.out.println("--------------------------------");
for(int i=0;i<list.size();i++){
    // word 받고 to string 넣어줘
    word=list.get(i);
    System.out.print((i+1)+" ");
    System.out.println(word.toString());

}
        System.out.println("--------------------------------");
    }

}
