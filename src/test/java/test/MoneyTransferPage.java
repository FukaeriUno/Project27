package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferPage {

        @Test
        void shouldTransferMoneyFromSecondCardToFirst() {
            Configuration.holdBrowserOpen = true;
            open("http://localhost:9999");
            var loginPage = new LoginPage();
            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            var dashboardPage = verificationPage.validVerify(verificationCode);
            int firstCardBalance1 = dashboardPage.getCardBalance(DataHelper.FirstCardId);
            dashboardPage.TransferMoney(DataHelper.FirstCardNumber, "1000");
            int firstCardBalance2 = dashboardPage.getCardBalance(DataHelper.FirstCardId);
            int result = firstCardBalance2 - firstCardBalance1;
            int sum = Integer.parseInt("1000");
            assertEquals(sum, result);
        }

    @Test
    void shouldTransferMoneyFromFirstCardToSecond() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int secondCardBalance1 = dashboardPage.getCardBalance(DataHelper.SecondCardId);
        dashboardPage.TransferMoney(DataHelper.SecondCardNumber, "1000");
        int firstCardBalance2 = dashboardPage.getCardBalance(DataHelper.SecondCardId);
        int result = firstCardBalance2 - secondCardBalance1;
        int sum = Integer.parseInt("1000");
        assertEquals(sum, result);
    }
}
