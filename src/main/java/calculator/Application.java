package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    String inputString = ""; // null 방지를 위한 초기화
    inputString = Console.readLine(); // 문자열 입력
    String spliters = ",:"; // 기본 구분자 설정
    long result = 0; // 결과 저장 변수

    // 1. 아무것도 입력되지 않은 경우
    if (inputString.isEmpty())  {
      throw new IllegalArgumentException("값이 입력되지 않았습니다.");
    }

    // 2.커스텀 구분자가 입력된 경우
    if (inputString.startsWith("//")) {
      int endSpliterIndex = inputString.indexOf("\\n");
      if  (endSpliterIndex == -1) {
        throw new IllegalArgumentException("커스텀 구분자가 제대로 설정되지 않았습니다.");
      }
      String customSpliter = inputString.substring(2,endSpliterIndex); // 커스텀 구분자 추출
      String[] specialChars={"\\", "^", "$", ".", "|", "?", "*", "+", "(", ")", "[","]","{","}"};
      for (String sc : specialChars)
      {
        if (customSpliter.contains(sc)) {
          customSpliter = customSpliter.replace(customSpliter, "\\"+customSpliter);
          break;
        }
      }
      spliters = customSpliter+spliters; // 커스텀 구분자 추가
      inputString = inputString.substring(endSpliterIndex+2); // custom spliter 이후 문자열에 대해 분석
    }

    spliters="["+spliters+"]"; //정규식 검사를 위한 그룹화
    // System.out.println("구분자 : "+spliters);
    // 3.구분자 기준으로 문자열 분리
    String[] tokens = inputString.split(spliters);
    for (String token : tokens) {
      if (token.trim().isEmpty()) { // 구분자 사이 아무것도 없는 경우
        continue;
      }
      try {
        // System.out.println(token);
        int  number = Integer.parseInt(token.trim());
        if  (number < 0) {
          throw new NumberFormatException();
        }
        else{
          result += number;
        }
      }
      catch (NumberFormatException e) {
        throw new IllegalArgumentException("입력값에 문제가 발생했습니다.");
      }
    }
    System.out.println("결과 : " + result); //결과 출력
  }

}
