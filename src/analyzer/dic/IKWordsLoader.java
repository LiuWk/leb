/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer.dic;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Properties;

/**
 *
 * @author jasstion
 */
public class IKWordsLoader implements WordsLoader {

    private static Logger log = LoggerFactory.getLogger(IKWordsLoader.class);

    public static Properties dicProp = new Properties();

    static {
        try {
            //load a properties file from class path, inside static method
            dicProp.load(Dictionary.class.getClassLoader().getResourceAsStream("dic.properties"));

        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 加载字典
     * @param filePath 路径
     * @param corpusType 字典类型，
     * @return
     */
    private Collection<Word> loadFromOneFile(String filePath, int corpusType) {
        Collection<Word> words = Lists.newArrayList();
        System.out.println("加载扩展词典：" + filePath);
        InputStream is = null;
        try {

            is = new FileInputStream(filePath);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8), 512);
            String theWord = null;
            do {
                theWord = br.readLine();
                if (theWord != null && !"".equals(theWord.trim())) {
                    words.add(new Word(theWord.trim(), corpusType));
                }
            } while (theWord != null);

        } catch (IOException ioe) {
            System.err.println("Extension Dictionary loading exception.");
            ioe.printStackTrace();

        } finally {
            try {
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return words;

    }

    @Override
    public Collection<Word> load() {
        Collection<Word> words = Lists.newArrayList();
        //读取扩展词典文件

        /**
         * 数据库配置字典
         */
        /*String message = dicProp.getProperty("dicPath") + "message.dic";//1
        String nickname = dicProp.getProperty("dicPath") + "nickname.dic";//2
        String selfintroduce = dicProp.getProperty("dicPath") + "selfintroduce.dic";//3
        String stopWords = dicProp.getProperty("dicPath") + "stopword.dic";//4

//        String message = IKWordsLoader.class.getClassLoader().getResource("message.dic").getPath();//1
//        String nickname = IKWordsLoader.class.getClassLoader().getResource("nickname.dic").getPath();//2
//        String selfintroduce = IKWordsLoader.class.getClassLoader().getResource("selfintroduce.dic").getPath();//3
        //String stopWords = IKWordsLoader.class.getClassLoader().getResource("stopword.dic").getPath();//4

        words.addAll(loadFromOneFile(nickname, 2));
        words.addAll(loadFromOneFile(message, 1));
        words.addAll(loadFromOneFile(selfintroduce, 3));
        words.addAll(loadFromOneFile(stopWords, 4));*/


        /**
         * 自测字典
         */
        String main2012dic = IKWordsLoader.class.getClassLoader().getResource("main2012.dic").getPath();
        String quantifierdic = IKWordsLoader.class.getClassLoader().getResource("quantifier.dic").getPath();
        words.addAll(loadFromOneFile(main2012dic,1));
        words.addAll(loadFromOneFile(quantifierdic,2));
        String extdic = IKWordsLoader.class.getClassLoader().getResource("ext.dic").getPath();
        String stopworddic = IKWordsLoader.class.getClassLoader().getResource("stopword.dic").getPath();
        words.addAll(loadFromOneFile(extdic,1));
        words.addAll(loadFromOneFile(stopworddic, 2));

        return words;

    }


}
