package data;


public class DataHelper {
    private DataHelper() {
    }

    public static String FirstCardNumber = "5559 0000 0000 0001";
    public static String SecondCardNumber = "5559 0000 0000 0002";
    public static String FirstCardId = "92df3f1c-a033-48e6-8390-206f6b1f56c0";
    public static String SecondCardId = "0f3f5c2a-249e-4c3d-8287-09f7a039391d";

    public static class AuthInfo {
        private String login;
        private String password;

        AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static class VerificationCode {
        private String code;

        VerificationCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

}