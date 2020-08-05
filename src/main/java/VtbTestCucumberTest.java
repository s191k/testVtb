import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/featuresVtb",
        glue = "ru.savkk.test",
        tags = "@all",
        snippets = SnippetType.CAMELCASE
)
public class VtbTestCucumberTest {
}
