package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class PlayerValidator {

    private static final String NUMBER_FORMAT = "^[0-9]+";
    private static final String THREE_RANGE_FORMAT = "^[0-9]{3,3}";

    public void validation(String insertNumber) {
        validationRegExp(insertNumber, NUMBER_FORMAT, "숫자만 입력가능합니다.");
        validationRegExp(insertNumber, THREE_RANGE_FORMAT, "숫자는 3자리를 입력해야합니다.");
        duplicateNumber(insertNumber);
    }

    public void validationRegExp(String insertNumber, String regexp, String message) {
        if (!Pattern.matches(regexp, insertNumber)) {
            throw new IllegalArgumentException("[ERROR] " + message);
        }
    }

    public void duplicateNumber(String insertNumber) {
        Set<Byte> set = new HashSet<>();
        for (Byte aByte : insertNumber.getBytes()) {
            set.add(aByte);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}
