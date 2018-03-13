package pl.edu.pw.stackexchange.download;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by lukasz on 14.03.2018.
 */
public class LinkExtractorTest {
    @Test
    public void extractLinks() {
        List<String> urls = new LinkExtractor().extractLinks();
        Assert.check(urls.size() > 0);
        Assert.check(urls.contains("https://archive.org/download/stackexchange/writers.stackexchange.com.7z"));

    }

}