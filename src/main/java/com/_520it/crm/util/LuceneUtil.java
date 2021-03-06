package com._520it.crm.util;

import com._520it.crm.vo.LuceneVO;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LuceneUtil {
	//存放索引目录
	private static String path ="D:/crm/src/main/webapp/static/xxoo";
	//版本号
	private static Version version = Version.LUCENE_4_10_4;
	//分词器
	private static Analyzer analyzer = new StandardAnalyzer();
	//查询出来存放的数据
	private static List<LuceneVO> luceneVo = new ArrayList<>();
	private static Long total;


	public static void testIndex() throws Exception {
		//存放索引目录
		Directory d = FSDirectory.open(new File(path));
		//索引写入器的相关配置
		IndexWriterConfig conf = new IndexWriterConfig(version, analyzer);
		//创建写入对象
		IndexWriter writer = new IndexWriter(d, conf);
		//创建需要存储和索引文档
		FieldType type = new FieldType();
		//设置开启存储模式
		type.setStored(true);
		//设置开启
		type.setIndexed(true);
		
		Document document = new Document();
		document.add(new Field("title", "交强险", type));
		document.add(new Field("content", "交通事故责任强制保险,国家强制必须交", type));
		
		Document document1 = new Document();
		document1.add(new Field("title", "车损险", type));
		document1.add(new Field("content", "车险发送意外造成的损失的保险", type));
		  
		Document document2 = new Document();
		document2.add(new Field("title", "第三者责任险", type));
		document2.add(new Field("content", "保第三者,因为交强险11万是不够的", type));
		
		Document document3 = new Document();
		document3.add(new Field("title", "盗抢险", type));
		document3.add(new Field("content", "车子被盗或者被抢了", type));
		
		Document document4 = new Document();
		document4.add(new Field("title", "划痕险", type));
		document4.add(new Field("content", "划你的车的这个人或车跑了,才需要用到划痕险", type));
		
		Document document5 = new Document();
		document5.add(new Field("title", "自然险", type));
		document5.add(new Field("content", "纵火不算", type));
		
		Document document6 = new Document();
		document6.add(new Field("title", "不计免赔险", type));
		document6.add(new Field("content", "不保的话,只陪80%的责任,还是买上好", type));
		
		Document document7 = new Document();
		document7.add(new Field("title", "太平洋保险", type));
		document7.add(new Field("content", "中国太平洋财产保险股份有限公司", type));
		
		Document document8 = new Document();
		document8.add(new Field("title", "阳光保险", type));
		document8.add(new Field("content", "阳光人寿保险股份有限公司", type));
		
		Document document9 = new Document();
		document9.add(new Field("title", "中国人寿", type));
		document9.add(new Field("content", "中国人寿保险公司", type));
		
		Document document10 = new Document();
		document10.add(new Field("title", "中国平安", type));
		document10.add(new Field("content", "中国平安保险股份有限公司", type));
		
		Document document11 = new Document();
		document11.add(new Field("title", "友邦保险", type));
		document11.add(new Field("content", "美国友邦保险有限公司", type));
		
		//通过写入器写入文档
		writer.addDocument(document);
		writer.addDocument(document1);
		writer.addDocument(document2);
		writer.addDocument(document3);
		writer.addDocument(document4);
		writer.addDocument(document5);
		writer.addDocument(document6);
		writer.addDocument(document7);
		writer.addDocument(document8);
		writer.addDocument(document9);
		writer.addDocument(document10);
		writer.addDocument(document11);
		
		writer.commit();
		writer.close();
	}

	public static void testSearch(String text) throws Exception {
		//清空数据
		luceneVo.clear();
		//索引目录
		Directory directory =FSDirectory.open(new File(path));
		//索引的读取
		IndexReader r = DirectoryReader.open(directory);
		//创建搜索对象
		IndexSearcher searcher = new IndexSearcher(r);
		//创建解析器,根据传入的文本解析成Query对象
		QueryParser parser = new QueryParser("content", analyzer);
		//解析查询文本
		Query query = null;
		if(text == null || "".equals(text)){
			query = parser.parse("*:*");
		}else{
			query = parser.parse(text);
		}
		//表示给查询出来的数据加上前缀和后缀
        Formatter formatter = new SimpleHTMLFormatter("<font color=\"red\">", "</font>");
        //表示拿到我们的分数列表
        Scorer scorer = new QueryScorer(query);
        //拿到Highlighter 需要传一个格式,和scorer对象
        Highlighter hl = new Highlighter(formatter, scorer);
        //进行查询(query表示解析好的文本,表示查询前1000条)
        TopDocs tds = searcher.search(query, 1000);
        System.out.println("查询出来的数量" + tds.totalHits);
        Integer ct=tds.totalHits;
        total=ct.longValue();
        //创建一个文件对象
        Document doc = null;
        ScoreDoc[] docs = tds.scoreDocs;
        //表示拿到前面20个来加亮
        hl.setMaxDocCharsToAnalyze(50);
        for (ScoreDoc sd : docs) {
            System.out.println("************************");
            System.out.println("文档的分数:" + sd.score + ",文档编号:" + sd.doc);
            doc = searcher.doc(sd.doc);
            System.out.println("标题:" + doc.get("title"));
            System.out.println("内容:" + doc.get("content"));
            String str = hl.getBestFragment(new StandardAnalyzer(), "content", doc.get("content"));
            if (str != null) {
            luceneVo.add(new LuceneVO(doc.get("title"),doc.get("content"),str));
                System.out.println("查询出来的内容:" + str);
            } else {
            luceneVo.add(new LuceneVO(doc.get("title"),doc.get("content"),str));
                System.out.println("原本的内容:" + doc.get("content"));
            }
        }
        System.out.println("扫描完毕");

	}
	public List<LuceneVO> getLuceneVOList(String text) throws Exception{
		testIndex();
		testSearch(text);
		return luceneVo;
	}
	public Long getTotal(){
		return total;
	}
}
