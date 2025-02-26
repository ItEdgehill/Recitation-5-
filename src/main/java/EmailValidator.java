public class EmailValidator {
    public static final String PRINTABLE_CHAR = "!#$%&'*+-/=?^_`{|}~";
    public static final char DOT = '.';
    public static final char HYPHEN = '-';
    public static final char AT = '@';

    // Add your enumerated states after this line
    private static final int INVALID = 0;
    private static final int LOCAL_START = 1;
    private static final int LOCAL_PART = 2;
    private static final int ONE_DOT = 3;
    private static final int DOMAIN_START = 4;
    private static final int DOMAIN_LABEL = 5;
    private static final int DOMAIN_DOT = 6;
    private static final int DOMAIN_HYPHEN = 7;


    public static boolean isEmailValid(String address) {
        int state = LOCAL_START;
        int index;
        int count = 0;
        int totalDomainCount = 0;
        for (index = 0; index < address.length(); index += 1) {
            char ch = address.charAt(index);
            boolean legalLocalChar = Character.isDigit(ch) || Character.isLetter(ch) || PRINTABLE_CHAR.indexOf(ch) >= 0;
            boolean legalDomainChar = Character.isDigit(ch) || Character.isLetter(ch);

            if (state == DOMAIN_START) {
                if (legalDomainChar) {
                    count += 1;
                    totalDomainCount += 1;
                    state = DOMAIN_LABEL;
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
            if (state == ONE_DOT) {
                if (legalLocalChar) {
                    count += 1;
                    state = LOCAL_PART;

                } else {
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                    state = INVALID;
                }
            }
            if (state == LOCAL_PART) {
                if (legalLocalChar) {
                    count += 1;
                } else if (ch == DOT) {
                    count += 1;
                    state = ONE_DOT;
                } else if (ch == AT) {
                    if (count < 63) {
                        count = 0;
                        state = DOMAIN_START;
                    } else {
                        state = INVALID;
                        System.out.println("Email Address is: " + address + ", Count is '" + count + "' ... Entering State INVALID");
                    }
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
            if (state == LOCAL_START) {
                if (legalLocalChar) {
                    count += 1;
                    state = LOCAL_PART;
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
            if (state == DOMAIN_DOT) {
                if (legalDomainChar) {
                    count += 1;
                    totalDomainCount += 1;
                    state = DOMAIN_LABEL;
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
            if (state == DOMAIN_LABEL) {
                if (legalDomainChar) {
                    count += 1;
                    totalDomainCount += 1;
                } else if (ch == DOT) {
                    count = 0;
                    totalDomainCount += 1;
                    state = DOMAIN_DOT;
                } else if (ch == HYPHEN) {
                    count += 1;
                    totalDomainCount += 1;
                    state = DOMAIN_HYPHEN;
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
            if (state == DOMAIN_HYPHEN) {
                if (legalDomainChar) {
                    count += 1;
                    totalDomainCount += 1;
                    state = DOMAIN_LABEL;
                } else if (ch == HYPHEN) {
                    count += 1;
                    totalDomainCount += 1;
                } else {
                    state = INVALID;
                    System.out.println("Email Address is: " + address + ", Invalid character is: '" + ch + "' ... Entering State INVALID");
                }
            }
        }
        if (totalDomainCount > 253) {
            state = INVALID;
            System.out.println("Email Address is: " + address + ", Total Domain Count is '" + totalDomainCount + "' ... Entering State INVALID");
        }
        return state != INVALID;
    }

}

