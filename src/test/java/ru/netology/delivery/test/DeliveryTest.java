package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.delivery.data.DataGenerator.*;

public class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        Configuration.timeout = 100;
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void shouldOrderCardDelivery() {
        $x("//*[@data-test-id='city']//input").setValue(generateCity("ru"));
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.generateDate(7));
        $("[data-test-id='name'] input").setValue(generateName("ru"));
        $x("//*[@data-test-id='phone']//input").setValue(generatePhone("ru"));
        $("[data-test-id='agreement']").click();
        $x("//*[text()='Запланировать']").click();
        $("[data-test-id='success-notification'] .notification__title")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Успешно!"));
    }


}