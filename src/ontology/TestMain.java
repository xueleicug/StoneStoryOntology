package ontology;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年12月3日 下午8:10:57
 **/
public class TestMain {
	
	public static void main(String[] args) {
//		String dirPath = "E:\\Semantic";
		
		String dirPath = "/home/xuelei";
		StoneStoryRelation ssr = StoneStoryRelation.getInstance(dirPath);
		ssr.executeInfRules(dirPath);
		ssr.persistInfModel(dirPath);
//		ssr.test();
	}
}
