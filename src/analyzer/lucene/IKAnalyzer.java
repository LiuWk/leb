/**
 * IK 中文分词 版本 5.0 IK Analyzer release 5.0
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供 版权声明 2012，乌龙茶工作室 provided by Linliangyi
 * and copyright 2012 by Oolong studio
 *
 */
package analyzer.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IK分词器，Lucene Analyzer接口实现 兼容Lucene 3.1以上版本
 */
public final class IKAnalyzer extends Analyzer {
        private static Logger log = LoggerFactory.getLogger(IKAnalyzer.class);


    private boolean useSmart = true;
    private boolean useSingle;
    private boolean useItself;
    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public boolean isUseSingle() {
        return useSingle;
    }

    public void setUseSingle(boolean useSingle) {
        this.useSingle = useSingle;
    }

    public boolean isUseItself() {
        return useItself;
    }

    public void setUseItself(boolean useItself) {
        this.useItself = useItself;
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    /**
     * IK分词器Lucene 3.5 Analyzer接口实现类
     *
     * 默认细粒度切分算法
     */
    public IKAnalyzer() {
        this(true);
    }

    @Override
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer _IKTokenizer = new IKTokenizer(this.useSmart());
        IKTokenFilter _IKTokenFilter = new IKTokenFilter(_IKTokenizer, useSingle, useItself);
        return new TokenStreamComponents(_IKTokenizer, _IKTokenFilter);
    }

    /**
     * IK分词器Lucene Analyzer接口实现类
     *
     * @param useSmart 当为true时，分词器进行智能切分
     */
    public IKAnalyzer(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    public IKAnalyzer(boolean useSmart, boolean useSingle, boolean useItself) {
        super();
        this.useSmart = useSmart;
        this.useSingle = useSingle;
        this.useItself = useItself;
    }
    /*@Override
     public TokenStream tokenStream(String fieldName, Reader reader) {
     return new IKTokenizer(reader , this.useSmart());
     }
	
     @Override
     public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
     Tokenizer _IKTokenizer = (Tokenizer)getPreviousTokenStream();
     if (_IKTokenizer == null) {
     _IKTokenizer = new IKTokenizer(reader , this.useSmart());
     setPreviousTokenStream(_IKTokenizer);
     } else {
     _IKTokenizer.reset(reader);
     }
     return _IKTokenizer;
     }*/
}
