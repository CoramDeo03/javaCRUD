package crud.word;

import java.util.Scanner;

public class WordManager {
    // 사용자에게 보이는 공간
    private int menu;

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public void Menu(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("********************");
        System.out.println("1. 모든 단어 보기\n" + "2. 수준별 단어 보기\n" + "3. 단어 검색\n" + "4. 단어 추가\n" + "5. 단어 수정\n" + "6. 단어 삭제\n" + "7. 파일 저장\n" + "0. 나가기");
        System.out.println("********************");
        menu=scanner.nextInt();
    }
    public void Action(){
        WordCRUD wordcrud=new WordCRUD();
        if(menu==4)
            wordcrud.add();
        else if(menu==1)


    }


}
