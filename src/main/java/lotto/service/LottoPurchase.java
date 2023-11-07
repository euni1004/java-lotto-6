package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ErrorCode;

public class LottoPurchase {

    public int inputLottoPurchase(String userPurchase) {
        while (true) {
            try {
                return isDivisibleBy1000(validateNumber(userPurchase));
            } catch (CustomException customException) {
                System.out.println(customException.getMessage());
            }
        }
    }

    public String inputLottoString(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int validateNumber(String userPurchase) {
        try {
            return Integer.parseInt(userPurchase);
        } catch (NumberFormatException numberFormatException) {
            throw new CustomException(ErrorCode.PARSEERRORTYPE);
        }
    }

    private int isDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new CustomException(ErrorCode.DIVISIBILITYERROR);
        }
        return (number / 1000);
    }
}
