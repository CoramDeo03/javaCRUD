package crud.word;

import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
    Scanner scanner= new Scanner(System.in);

    ArrayList <Word> list;

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
// 새로운 워드를 리스트에 넣고, 인터페이스 역할..
    public void AddWord(){
        Word one = (Word)Add(); // 이게 뭐한거임??? ㅋㅋㅋㅋ
        list.add(one);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!! ");
    }

    @Override
    public int Update(Object obj) {
        return 0;
    }

    @Override
    public int Delete(Object obj) {
        return 0;
    }

    @Override
    public void SelectOne(int id) {

    }

    public void ListAll(){
        Word word= new Word();
        System.out.println("--------------------------------");
for(int i=0;i<list.size();i++){
    // word 받고 to string ㄴㅓㅎ어줘
    word=list.get(i);
    System.out.print((i+1)+" ");
    System.out.println(word.toString());

}
        System.out.println("--------------------------------");
    }

}
