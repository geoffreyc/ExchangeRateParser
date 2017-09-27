package rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    @RequestMapping("/exchange")
    public ExchangeResult Exchange(
            @RequestParam(value="from", defaultValue="GBP") String from,
            @RequestParam(value="to", defaultValue="EUR") String to
    ) {
        // Create Jsoup parser object
        XeParser parser = new XeParser();
        // Initial return object
        ExchangeResult result = null;
        try {
            // Fetch rate from source (google)
            result = parser.getRate(from, to);
        } catch (Exception e) {
            // Populate error message in case of failure
            e.printStackTrace();
            result = new ExchangeResult(from, to, 0.00, true, e.getMessage());
        }

        // Return rate as JSON string
        return result;
    }

}
