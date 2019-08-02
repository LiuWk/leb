package java8;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author lwk
 * @date 2019-07-08 14:38
 */
public class GroupTest {
    public static void main(String[] args) {
        List<Article> list = Arrays.asList(new Article("1", "11", ArticleType.NEWS, 11),
                new Article("2", "22", ArticleType.NEWS, 6),
                new Article("3", "33", ArticleType.GUIDE, 1),
                new Article("4", "44", ArticleType.NEWS, 3),
                new Article("5", "55", ArticleType.REVIEW, 1),
                new Article("6", "22", ArticleType.GUIDE, 10)
        );

        /**
         * 根据文章作者分组
         */
        Map<String, List<Article>> authorList = list.stream().collect(Collectors.groupingBy(Article::getAuthor));
        System.out.println(JSON.toJSONString(authorList));
        /**
         * 多条件分组
         */
        Map<String, Map<ArticleType, List<Article>>> authorType = list.stream().collect(Collectors.groupingBy(Article::getAuthor, Collectors.groupingBy(Article::getType)));
        System.out.println(JSON.toJSONString(authorType));
        /**
         * 根据名称排序（）
         */
        Map<String, List<Article>> resultMap = new LinkedHashMap<>();
        authorList.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(o -> resultMap.put(o.getKey(), o.getValue()));
        System.out.println(JSON.toJSONString(resultMap));

        /**
         * 根据文章类型分组
         */
        Map<ArticleType, List<Article>> typeMap = list.stream().collect(Collectors.groupingBy(Article::getType));
        System.out.println(JSON.toJSONString(typeMap));

        /**
         * 常见（默认）统计数据
         */
        Map<String, IntSummaryStatistics> summarMap = list.stream().collect(Collectors.groupingBy(Article::getAuthor, Collectors.summarizingInt(Article::getLikes)));
        System.out.println(JSON.toJSONString(summarMap));

        /**
         * 并发流
         */
        ConcurrentMap<String, List<Article>> concurMap = list.parallelStream().collect(Collectors.groupingByConcurrent(Article::getAuthor));
        System.out.println(JSON.toJSONString(concurMap));
    }
}

