package crud.word;

import java.io.*;
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
    public int Update(Object obj) {return 0;}

    public void updateWord(){
        Word Word= new Word();
        System.out.print("=> 수정할 단어 검색 : ");
        String word = scanner.next();
        ArrayList<Integer> kword = this.ListAll(word);
        System.out.print("=> 수정할 번호 선택 : ");
        int num= scanner.nextInt();
        scanner.nextLine(); // enter 할때 인식됨..
        System.out.print("=> 뜻 입력 : ");
        String realmeaning = scanner.nextLine();
        Word=list.get(kword.get(num-1));
        Word.setMeaning(realmeaning);
        System.out.println("\n단어 수정이 성공적으로 되었습니다!!");
    }

    @Override
    public int Delete(Object obj) {

        return 0;
    }

    @Override
    public void SelectOne(int id) {}

    public void worDelete(){
        Word Word= new Word();
        System.out.print("=> 삭제할 단어 검색 : ");
        String word = scanner.next();
        ArrayList<Integer> kword = this.ListAll(word);
        System.out.print("=> 삭제할 번호 선택 : ");
        int num= scanner.nextInt();
        scanner.nextLine(); // enter 할때 인식됨..
        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        String ans = scanner.nextLine();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)kword.get(num - 1));
            System.out.println("\n선택한 단어 삭제 완료 !!! ");
        }else{
            System.out.println("취소되었습니다. ");
        }
    }

    public void searchLevel(){
        System.out.println("=> 레벨(1:초급, 2:중급, 3:고급) 선택 : ");

    }


    public void loadFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count=0;
            //  자.... 읽어 드려서 각자 워드에 넣어 줘야됨... 그럼 .. word를 정의하고, 그걸 arraylist에 넣어야 함.
            while(true) {
                line = br.readLine();
                if(line==null) break;
                String data[] = line.split("\\|"); // | 기준으로 나누기
                int level = Integer.parseInt( data[0]);
                String name = data[1];
                String meaning= data[2];
                list.add(new Word(0,level,name,meaning));// 새로운 워드 만들고 array에 넣기
                count++;
            }
            System.out.println("=> "+count+"개 단어 로딩 완료!\n");
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveFile(){
        try {
            Word word = new Word();
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one : list){
                pr.write(one.toFileString()+"\n");
            }
                pr.close();
            System.out.println("모든 단어 파일 저장 완료 !!! \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public ArrayList<Integer> ListAll(String keyword) {
        Word word = new Word();
        ArrayList<Integer> kwlist = new ArrayList<>();
        System.out.println("--------------------------------");
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            String kword = list.get(i).getWord();
            if (kword.contains(keyword)) {
                kwlist.add(i);
                word = list.get(i);
                System.out.print((j + 1) + " ");
                j++;
                System.out.println(word.toString());
            }
        }
        return kwlist;
    }
        public void ListAll( int level ){
            int j=0;
            System.out.println("--------------------------------");
            for(int i=0;i<list.size();i++) {
                int ilevel= list.get(i).getLevel();
                if(ilevel != level) cotinue;
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
        // update.. 일치하는거 찾고... print,.
        System.out.println("--------------------------------");
    }

}
