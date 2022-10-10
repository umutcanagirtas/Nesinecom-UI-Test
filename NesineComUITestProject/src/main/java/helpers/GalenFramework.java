package helpers;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class GalenFramework {
    public static void checkLayout(WebDriver driver,String specPath,String device) throws IOException {
        LayoutReport layoutReport = Galen.checkLayout(driver,specPath,asList(device));
        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");
        test.getReport().layout(layoutReport, "check homepage layout");
        tests.add(test);
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(tests, "target/galen-results");
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }
    }
}
