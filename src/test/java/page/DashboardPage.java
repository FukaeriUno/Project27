package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import lombok.val;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement secondCardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getCardBalance(String id) {
        SelenideElement card = $(String.format("[data-test-id='%s'", id));
        String text = card.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        int start = text.indexOf(balanceStart);
        int finish = text.indexOf(balanceFinish);
        String value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public void TransferMoney(String number, String sum) {
        if (number.equals(DataHelper.FirstCardNumber)) {
            firstCardButton.click();
            $("[data-test-id=amount] input").setValue(sum);
            $("[data-test-id=from] input").setValue(DataHelper.SecondCardNumber);
            $("[data-test-id='action-transfer']").click();
        } else if (number.equals(DataHelper.SecondCardNumber)) {
            secondCardButton.click();
            $("[data-test-id=amount] input").setValue(sum);
            $("[data-test-id=from] input").setValue(DataHelper.FirstCardNumber);
            $("[data-test-id='action-transfer']").click();
        }
    }
}
