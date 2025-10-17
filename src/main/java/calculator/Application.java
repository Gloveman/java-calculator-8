package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String test=Console.readLine(); //입력받기
        String[] numbers=test.split("[,:]"); //기본 구분자로 숫자 분리
        int result=0;
        for(String num:numbers){
            result+=Integer.parseInt(num); //숫자만 더함
        }

        System.out.println("결과 :"+" "+result); //결과 출력

    }
}
