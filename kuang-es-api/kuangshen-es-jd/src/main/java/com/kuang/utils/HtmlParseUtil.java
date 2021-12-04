package com.kuang.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.kuang.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/16 11:02
 */
@Component
public class HtmlParseUtil {
//    public static void main(String[] args) throws IOException {
//        new HtmlParseUtil().parseJD("vue").forEach(System.out::println);
//    }

    public List<Content> parseJD(String keywords) throws IOException {
        //获取请求
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        //解析网页 。（jsoup返回Document就是浏览器Document对象）
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        List<Content> contents = new ArrayList<>();
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            contents.add(content);
        }
        return contents;
    }
}
