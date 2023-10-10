package dev.selenium.containers;

import dev.selenium.manager.PageFactoryManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class PageFactoryContainer {
    private PageFactoryManager pageFactoryManager;
}
