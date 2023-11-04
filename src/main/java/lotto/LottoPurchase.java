package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ErrorCode;

public class LottoPurchase {

    public int inputLottoPurchase() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String userPurchase = Console.readLine();
            return isDivisibleBy1000(validateNumber(userPurchase));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputLottoPurchase();
        }
    }

    public int validateNumber(String userPurchase) {
        try {
            return Integer.parseInt(userPurchase);
        } catch (NumberFormatException numberFormatException) {
            throw new CustomException(ErrorCode.PARSEERRORTYPE);
        }
    }

    public int isDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new CustomException(ErrorCode.DIVISIBILITYERROR);
        }
        return (number / 1000);
    }
}
