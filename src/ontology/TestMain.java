package ontology;

import com.util.PropertiesUtil;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年12月3日 下午8:10:57
 **/
public class TestMain {
	
	public static void main(String[] args) {
		
        PropertiesUtil pu = new PropertiesUtil("config");
        String dirPath = pu.getValueofKey("dataPath");
		StoneStoryRelation ssr = StoneStoryRelation.getInstance(dirPath);
        ssr.buildStoneStoryOntology(dirPath);
		ssr.executeInfRules(dirPath);
		ssr.persistInfModel(dirPath);
	}
}
