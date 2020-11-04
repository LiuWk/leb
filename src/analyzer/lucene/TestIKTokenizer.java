//package analyzer.lucene;
//
//import analyzer.core.Lexeme;
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
//import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class TestIKTokenizer {
//
//    public static void main(String[] args) throws Exception {
////        System.out.print(CorpusType.MESSAGE.getCorpusType());
//        //Lucene Document的域名
//        String fieldName = "text";
//        //检索内容
//        String text = "盛1234";
//        //text="战舰车";
//        //TokenizerFactory t=null;
//        List<Map> list=new ArrayList<Map>();
//        //实例化IKAnalyzer分词器
//        IKTokenizer iKTokenizer = new IKTokenizer( true);
//        while (iKTokenizer.incrementToken()) {
//            CharTermAttribute charTermAttribute = iKTokenizer.getAttribute(CharTermAttribute.class);
//            OffsetAttribute offsetAttribute = iKTokenizer.getAttribute(OffsetAttribute.class);
//            TypeAttribute typeAttribute = iKTokenizer.getAttribute(TypeAttribute.class);
//            System.out.print(charTermAttribute.toString() + "\n");
//            System.out.print(offsetAttribute.startOffset() + "-" + offsetAttribute.endOffset() + "\n");
//            System.out.print(typeAttribute.type() + "\n");
//            String wordType = String.valueOf(Lexeme.TYPE_CNWORD);
//            String currentType = typeAttribute.type();
//            String currentType_1 = currentType.split("_")[0];
//            if (currentType_1.equals(wordType)) {
//                Map term = new HashMap<String,Object>();
//                term.put("Text", charTermAttribute.toString());
//                term.put("Type",currentType);
//                term.put("Start",offsetAttribute.startOffset());
//                term.put("End", offsetAttribute.endOffset());
//                list.add(term);
//            }
//
//        }
//        String textType="3";
//        for (Map dirtyWord : list) {
//            String tmpTextType = dirtyWord.get("Type").toString().split("_")[1];
//            if (tmpTextType.contains(textType)) {
//                System.out.println(dirtyWord);
//            }
//        }
//
//
//    }
//}
