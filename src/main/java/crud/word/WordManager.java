package crud.word;


import java.io.*;
import java.util.Scanner;

public class WordManager {
    Scanner scanner= new Scanner(System.in);
    // 사용자에게 보이는 공간
    //Scanner scanner;
    private int menu;

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public void Menu(){
        System.out.println("\n********************");
        System.out.println("1. 모든 단어 보기\n" + "2. 수준별 단어 보기\n" + "3. 단어 검색\n" + "4. 단어 추가\n" + "5. 단어 수정\n" + "6. 단어 삭제\n" + "7. 파일 저장\n" + "0. 나가기");
        System.out.println("********************");
        System.out.print("=> 원하는 메뉴는? ");
        menu=scanner.nextInt();
        System.out.println("");
    }

    public void Action(){
        WordCRUD wordcrud=new WordCRUD(scanner);
        wordcrud.loadFile();
        System.out.println("*** 영단어 마스터 ***");
        while(true) {
            Menu();
            if(menu==0){
                System.out.println("프로그램 종료! 다음에 만나요~");
                break;
            } else if (menu == 4)
                wordcrud.AddWord();
            else if (menu == 1)
                wordcrud.ListAll();
            else if(menu==2)
                wordcrud.searchLevel();
            else if(menu==3)
                wordcrud.searchWord();
            else if(menu==5)
                wordcrud.updateWord();
            else if(menu==6)
                wordcrud.worDelete();
            else if(menu==7)
                wordcrud.saveFile();

        }
    }




}
