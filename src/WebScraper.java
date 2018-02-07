import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    public static int wordCount(final String fromweb) {
        int word = 0;
        for (int i = 0; i < fromweb.length(); i++) {
            if (fromweb.charAt(i) == ' ') {
                word++;
            }
        }
        return word;
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String web = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int wordintext = wordCount(web);
        System.out.println(web);
        System.out.println(wordintext);

    }
}
