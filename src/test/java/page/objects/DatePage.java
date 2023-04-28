package page.objects;

import base.BasePage;
import driver.StoreDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static util.StoreData.SData;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePage extends BasePage {
    @FindBy(id = "datepicker")
    private WebElement datepicker_fecha;
    @FindBy(className = "ui-datepicker-title")
    private WebElement ui_datepicker_title_css;
    @FindBy(xpath = "//*[@title='Next']")
    private WebElement fecha_next;
    public static String mes;
    public static String anio;

    public DatePage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver, this);
    }
    public void clickInputFecha() {
        wait.until(ExpectedConditions.elementToBeClickable(datepicker_fecha));
        datepicker_fecha.click();
    }

    /**
     * Convertir la fecha
     * de 9 May 2025 a 8/5/2025
     */
    public int[] convertirFecha(String fecha){
        String[] array = fecha.split(" ");
        int year = Integer.parseInt(array[2]);
        int day = Integer.parseInt(array[0]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        int mes = localDate.getMonthValue();
        return new int[]{day, mes,year};
    }

    public boolean entersDate(String selectedDate) {
        int[] array = convertirFecha(selectedDate);
        boolean isValidDate = true;
        try {
            // Al intentar crear el objeto LocalDate. Si no se lanza ninguna excepción, entonces la fecha es válida.
            LocalDate.of(array[2], array[1],  array[0]); // yyyy/MMMM/d
        } catch (DateTimeException e) {
            isValidDate = false;
        }
        if (isValidDate) {
            wait.until(ExpectedConditions.visibilityOfAllElements(ui_datepicker_title_css));
            String date[] = selectedDate.split(" ");
            ui_datepicker_title_css.getText();
            mes = ui_datepicker_title_css.getText().split(" ")[0].trim();
            anio = ui_datepicker_title_css.getText().split(" ")[1].trim();
            while (!(mes.equals(date[1]) && anio.equals(date[2]))) {
                fecha_next.click();
                mes = ui_datepicker_title_css.getText().split(" ")[0].trim();
                anio = ui_datepicker_title_css.getText().split(" ")[1].trim();
            }
            driver.findElement(By.xpath("//a[text()='" + date[0] + "']")).click();
        }
        return isValidDate;
    }

    public void loadPage() {
        try {
            driver.get(SData("calendar"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
