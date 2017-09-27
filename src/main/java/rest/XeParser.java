package rest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XeParser {

    public ExchangeResult getRate(String from, String to) throws Exception {
        // Set request URL to google
        String request = "https://www.google.com/search?q=1"+from+"+IN+"+to+"&num=1";
        String resultstr = "";
        Document doc = null;
        try {
            // Fetch DOM from google (Emulating browser request through user agent string)
            doc = Jsoup
                    .connect(request)
                    .userAgent(
                            "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
                    .timeout(5000).get();

            // Fetching element containing exchange rate data
            Element result = doc.select(".vk_ans").first();
            // Regex pattern to only get decimal number (strips line returns and any unwanted strings)
            Pattern decimalRegex = Pattern.compile("([0-9]\\d*(\\.\\d+)?)");
            Matcher m = decimalRegex.matcher(result.text());
            if(m.find()) {
                resultstr = m.group(1);
            }
            else{
                // Deal with scenarios where rate could not be found in HTML DOM
                throw new Exception("Could not find exchange rate");
            }

        } catch (IOException e) {
            // Could not get rate (google time out, could not find DOM elements
            throw e;
        }

        // Cast result to Double
        Double rate = Double.parseDouble(resultstr);

        return new ExchangeResult(from, to, rate);

    }

}
