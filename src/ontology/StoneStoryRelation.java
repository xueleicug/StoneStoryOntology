package ontology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import com.util.*;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.OWLFBRuleReasonerFactory;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.log4j.Logger;

/**
 * 红楼梦人物关系推理本体构建
 * @author xuelei xueleicug@163.com
 * @time 2016年12月3日 下午9:03:24
 * @version
 **/
public class StoneStoryRelation {
    
    /**
     * 构建本体模型的对象
     */
    private OntModel ontModel = null;

    /**
     * 构建推理模型的对象
     */
    private InfModel infModel = null;
    
    /**
     * StoneStory本体模型命名空间
     */
    private String StoneStoryNS = "http://www.semanticweb.org/StoneStory#";
    
    private static StoneStoryRelation instance = null;
    
    /**
     * StoneStorySchema 对象
     */
    private SSS sss = null;
    
    private final Logger logger = Logger.getLogger("StoneStoryLogger"); 
    
    /**
     *
     * @param dirPath 基础数据所在目录
     */
    private StoneStoryRelation(String dirPath) {

        this.ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_TRANS_INF);
        this.ontModel.setNsPrefix("stoneStory", StoneStoryNS);
        sss = new SSS(this.ontModel);
    }
    
    /**
     *
     * @param dirPath 基础数据所在目录
     * @return
     */
    public static StoneStoryRelation getInstance(String dirPath) {
        if (StoneStoryRelation.instance == null) {
            return new StoneStoryRelation(dirPath);
        }
        else {
            return StoneStoryRelation.instance;
        }
    }
    
    /**
     * 开始构建StoneStory本体
     * @param dirPath 基础数据所在目录
     */
    public void buildStoneStoryOntology(String dirPath) {
        this.buildOntCls(dirPath);
        this.buildOntClsHer(dirPath);
        this.buildOntClsDp(dirPath);
        this.buildOntIns(dirPath);
        this.buildOntClsRelation(dirPath);
        this.buildOntInsOp(dirPath);
        this.buildOntInsDp(dirPath);
    }
    
    /**
     * 开始构建本体中的类
     * @param dirPath 基础数据所在目录
     */
    public void buildOntCls(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_cls.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                logger.info("构建类 " + line);
                this.ontModel.createClass(StoneStoryNS + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }
    
    /**
     * 构建本体中的类层次关系
     * @param dirPath 基础数据所在目录
     */
    public void buildOntClsHer(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_cls_her.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取类 " + line);
                OntClass subCls = this.ontModel.getOntClass(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i = i + 2) {
                    logger.info(items[0] + " subClassOf " + items[i + 1]);
                    Property p = sss.getPropertyByName(items[i]);
                    OntClass objCls = this.ontModel.createClass(StoneStoryNS + items[i + 1]);
                    subCls.addProperty(p, objCls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }

    /**
     * 构建本体中的类关联关系
     * @param dirPath 基础数据所在目录
     */
    public void buildOntClsRelation(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_cls_relation.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取类 " + items[0]);
                OntClass subCls = this.ontModel.getOntClass(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i = i + 2) {
                    logger.info(items[0] + " " + items[i] + " " + items[i + 1]);
                    ObjectProperty p = (ObjectProperty)sss.getPropertyByName(items[i]);
                    OntClass objCls = this.ontModel.createClass(StoneStoryNS + items[i + 1]);
                    subCls.addProperty(p, objCls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }
    
    /**
     * 构建本体中的实例
     * @param dirPath 基础数据所在目录
     */
    public void buildOntIns(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_cls_ins.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取类 " + items[0]);
                OntClass cls = this.ontModel.getOntClass(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i++) {
                    logger.info(items[0] + " 构建实例 " + items[i]);
                    cls.createIndividual(StoneStoryNS + items[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }

    /**
     * 构建本体中类的 DataProperty 关系
     * @param dirPath 基础数据所在目录
     */
    public void buildOntClsDp(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_cls_dp.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取类 " + line);
                OntClass subCls = this.ontModel.getOntClass(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i = i + 2) {
                    logger.info(items[0] + " 性别 " + items[i + 1]);
                    DatatypeProperty p = (DatatypeProperty)sss.getPropertyByName(items[i]);
                    String val = items[i + 1];
                    Literal obj = ResourceFactory.createTypedLiteral(val);
                    subCls.addLiteral(p, obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }
    
    /**
     * 构建本体中实例之间的ObjectProperty
     * @param dirPath 基础数据所在目录
     */
    public void buildOntInsOp(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_ins_op.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取实例 " + items[0]);
                Individual subInd = this.ontModel.getIndividual(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i = i + 2) {
                    logger.info(items[0] + " " + items[i] + " " + items[i + 1]);
                    ObjectProperty p = (ObjectProperty)sss.getPropertyByName(items[i]);
                    Individual objInd = this.ontModel.getIndividual(StoneStoryNS + items[i + 1]);
                    subInd.addProperty(p, objInd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }
    
    /**
     * 构建本体中实例的DatatypeProperty
     * @param dirPath 基础数据所在目录
     */
    public void buildOntInsDp(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/hlm_ins_dp.txt"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split("-");
                logger.info("获取实例 " + items[0]);
                Resource subRes = this.ontModel.getResource(StoneStoryNS + items[0]);
                for (int i = 1; i < items.length; i = i + 2) {
                    logger.info(items[0] + " " + items[i] + " " + items[i + 1]);
                    DatatypeProperty p = (DatatypeProperty)sss.getPropertyByName(items[i]);
                    String val = items[i + 1];
                    Literal objRes = ResourceFactory.createTypedLiteral(val);
                    subRes.addLiteral(p, objRes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.closeBufferedReader(br);
        FileUtil.closeInputStream(in);
    }
    
    /**
     * 结合规格构建推理模型
     * @param dirPath 推理规则所在目录
     */
    public void executeInfRules(String dirPath) {
        InputStream in = FileUtil.getInputStreamByFile(PathUtil.getPath(dirPath + "/rules"));
        BufferedReader br = FileUtil.getBufferedReader(in);
        List<Rule> rules = Rule.parseRules(Rule.rulesParserFromReader(br));
        Reasoner reasoner = new GenericRuleReasoner(rules, OWLFBRuleReasonerFactory.theInstance());
        reasoner.setDerivationLogging(true);
        this.infModel = ModelFactory.createInfModel(reasoner, this.ontModel);
    }
    
    /**
     * 获取推理模型对象
     * @return 推理模型对象
     */
    public Model getInfModel() {
        return this.infModel;
    }
    
    /**
     * @param sss 设置当前本体的StoneStorySchema
     */
    public void setSss(SSS sss) {
        this.sss = sss;
    }

    /**
     * 存储推理模型到本地
     * @param dirPath 存储文件的目录
     */
    public void persistInfModel(String dirPath) {
        if(this.infModel == null) {
            return;
        }
        Model m = ModelFactory.createOntologyModel();
        m.add(infModel);
        OutputStream out = null;
        out = FileUtil.getOutputStream(PathUtil.getPath(dirPath + "/hlmInfModel.owl"));
        m.write(out);
        FileUtil.closeOutputStream(out);
    }
    
    /**
     * 获取基础本体模型对象
     * @return 基础本体模型对象
     */
    public Model getOntModel() {
        return this.ontModel;
    }
    
    /**
     * 存储基础本体模型到本地
     * @param dirPath 存储文件的目录
     */
    public void persistOntModel(String dirPath) {
        OutputStream out = null;
        out = FileUtil.getOutputStream(PathUtil.getPath(dirPath + "/hlmOntModel.owl"));
        this.ontModel.write(out);
        FileUtil.closeOutputStream(out);
    }
}
