package pl.edu.pw.stackexchange.download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lukasz on 13.03.2018.
 */
public class LinkExtractor {

    private static final String STACK_EXCHANGE_ARCHIVE_URL = "https://archive.org/details/stackexchange";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public List<String> extractLinks() {

        try {
            Document doc = Jsoup.connect(STACK_EXCHANGE_ARCHIVE_URL).get();
            List<String> urls = doc.select("a.stealth.download-pill").stream()
                    .map(a -> a.attr("abs:href"))
                    .filter(a -> a.endsWith(".7z"))
                    .collect(Collectors.toList());
            return urls;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return Collections.EMPTY_LIST;
        }

    }

    public static void main(String[] args) {
        new LinkExtractor().extractLinks();
    }


}
