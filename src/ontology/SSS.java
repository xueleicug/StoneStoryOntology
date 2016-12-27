package ontology;

import java.util.HashMap;
import java.util.Map;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author xuelei xueleicug@163.com
 * @time   2016年12月5日 下午4:42:11
 **/
public class SSS {
	
	private static String uri = "http://www.semanticweb.org/StoneStory#";
	
	private OntModel ontModel = null;
	
	private Map<String, Property> propertyMap = null;
	//爷爷
	public ObjectProperty hasGrandFather = null;
	//奶奶
	public ObjectProperty hasGrandMother = null;
	//姥爷
	public ObjectProperty hasGrandPa = null;
	//姥姥
	public ObjectProperty hasGrandMa = null;
	//父亲
	public ObjectProperty hasFather = null;
	//母亲
	public ObjectProperty hasMother = null;
	//姨妈
	public ObjectProperty hasAuntYi = null;
	//姨夫
	public ObjectProperty hasUncleYi = null;
	//叔叔
	public ObjectProperty hasUncle = null;
	//婶婶
	public ObjectProperty hasAunt = null;
	//舅舅
	public ObjectProperty hasJiujiu = null;
	//舅妈
	public ObjectProperty hasJiuma = null;
	//姑姑
	public ObjectProperty hasGuma = null;
	//姑父
	public ObjectProperty hasGufu = null;
	//表姨妈
	public ObjectProperty hasBiaoAuntYi = null;
	//表姨夫
	public ObjectProperty hasBiaoUncleYi = null;
	//表叔叔
	public ObjectProperty hasBiaoUncle = null;
	//表婶婶
	public ObjectProperty hasBiaoAunt = null;
	//表舅舅
	public ObjectProperty hasBiaoJiujiu = null;
	//表舅妈
	public ObjectProperty hasBiaoJiuma = null;
	//表姑姑
	public ObjectProperty hasBiaoGuma = null;
	//表姑父
	public ObjectProperty hasBiaoGufu = null;
	//丈夫
	public ObjectProperty hasHusband = null;
	//妻子
	public ObjectProperty hasWife = null;
	//妾室
	public ObjectProperty hasConcubine = null;
	//姐姐
	public ObjectProperty hasElderSister = null;
	//妹妹
	public ObjectProperty hasYoungerSister = null;
	//亲姐妹
	public ObjectProperty hasNearSister = null;
	//亲兄弟
	public ObjectProperty hasNearBrother = null;
	//哥哥
	public ObjectProperty hasElderBrother = null;
	//弟弟
	public ObjectProperty hasYoungerBrother = null;
	//堂姐妹
	public ObjectProperty hasConsinSister = null;
	//堂兄弟
	public ObjectProperty hasConsinBrother = null;
	//表兄弟
	public ObjectProperty hasBiaoBrother = null;
	//表姐妹
	public ObjectProperty hasBiaoSister = null;
	//女儿
	public ObjectProperty hasDaughter = null;
	//儿子
	public ObjectProperty hasSon = null;
	//侄女
	public ObjectProperty hasNiece = null;
	//侄子
	public ObjectProperty hasNephew = null;
	//外甥
	public ObjectProperty hasWaisheng = null;
	//外甥女
	public ObjectProperty hasWaishengnv = null;
	//孙子
	public ObjectProperty hasGrandSon = null;
	//孙女
	public ObjectProperty hasGrandDaughter = null;
	//外孙
	public ObjectProperty hasGrandMatSon = null;
	//外孙女
	public ObjectProperty hasGrandMatDaughter = null;
	//孙侄女
	public ObjectProperty hasGrandNiece = null;
	//下人
	public ObjectProperty hasMaidPeople = null;
	//侍婢
	public ObjectProperty hasMaidWoman = null;
	//小厮
	public ObjectProperty hasMaidMan = null;
	//结拜兄弟
	public ObjectProperty hasSworeBrother = null;
	//居所
	public ObjectProperty locateIn = null;
	//后代
	public ObjectProperty hasDescendant = null;
	//前辈
	public ObjectProperty hasPredecessor = null;
	//下一代
	public ObjectProperty nextGeneration = null;
	//上一代
	public ObjectProperty preGeneration = null;
	//孩子
	public ObjectProperty hasChildren = null;
	//兄弟
	public ObjectProperty hasBrother = null;
	//姐妹
	public ObjectProperty hasSister = null;
	//性别
	public DatatypeProperty gender = null;
	//别名
	public DatatypeProperty alias = null;
	//职位
	public DatatypeProperty rank = null;
	//判词
	public DatatypeProperty panCi = null;
	//判曲
	public ObjectProperty panQu = null;
	//内容
	public DatatypeProperty panQuContent = null;
	
	protected ObjectProperty objProperty(OntModel ontModel, String local) {
		return this.ontModel.createObjectProperty(uri + local);
	} 
	
	protected DatatypeProperty dataProperty(OntModel ontModel, String local) {
		return this.ontModel.createDatatypeProperty(uri + local); 
	} 
	
	public SSS(OntModel ontModel) {
		this.ontModel = ontModel;
		propertyMap = new HashMap<String, Property>();
		this.init();
	}
	
	public void init() {
		//爷爷
		this.hasGrandFather = objProperty(ontModel, "爷爷");
		this.propertyMap.put("爷爷", this.hasGrandFather);
		//奶奶
		this.hasGrandMother = objProperty(ontModel, "奶奶");
		this.propertyMap.put("奶奶", this.hasGrandMother);
		//姥爷
		this.hasGrandPa = objProperty(ontModel, "姥爷");
		this.propertyMap.put("姥爷", this.hasGrandPa);
		//姥姥
		this.hasGrandMa = objProperty(ontModel, "姥姥");
		this.propertyMap.put("姥姥", this.hasGrandMa);
		//父亲
		this.hasFather = objProperty(ontModel, "父亲");
		this.propertyMap.put("父亲", this.hasFather);
		//母亲
		this.hasMother = objProperty(ontModel, "母亲");
		this.propertyMap.put("母亲", this.hasMother);
		//叔叔
		this.hasUncle = objProperty(ontModel, "叔叔");
		this.propertyMap.put("叔叔", this.hasUncle);
		//婶婶
		this.hasAunt = objProperty(ontModel, "婶婶");
		this.propertyMap.put("婶婶", this.hasAunt);
		//舅舅
		this.hasJiujiu = objProperty(ontModel, "舅舅");
		this.propertyMap.put("舅舅", this.hasJiujiu);
		//舅妈
		this.hasJiuma = objProperty(ontModel, "舅妈");
		this.propertyMap.put("舅妈", this.hasJiuma);
		//姑姑
		this.hasGuma = objProperty(ontModel, "姑姑");
		this.propertyMap.put("姑姑", this.hasGuma);
		//姑父
		this.hasGufu = objProperty(ontModel, "姑父");
		this.propertyMap.put("姑父", this.hasGufu);
		//姨妈
		this.hasAuntYi = objProperty(ontModel, "姨妈");
		this.propertyMap.put("姨妈", this.hasAuntYi);
		//姨父
		this.hasUncleYi = objProperty(ontModel, "姨父");
		this.propertyMap.put("姨父", this.hasUncleYi);
		//表叔
		this.hasBiaoUncle = objProperty(ontModel, "表叔");
		this.propertyMap.put("表叔", this.hasBiaoUncle);
		//表婶
		this.hasBiaoAunt = objProperty(ontModel, "表婶");
		this.propertyMap.put("表婶", this.hasBiaoAunt);
		//表舅
		this.hasBiaoJiujiu = objProperty(ontModel, "表舅");
		this.propertyMap.put("表舅", this.hasBiaoJiujiu);
		//表舅妈
		this.hasBiaoJiuma = objProperty(ontModel, "表舅妈");
		this.propertyMap.put("表舅妈", this.hasBiaoJiuma);
		//表姑
		this.hasBiaoGuma = objProperty(ontModel, "表姑");
		this.propertyMap.put("表姑", this.hasBiaoGuma);
		//表姑父
		this.hasBiaoGufu = objProperty(ontModel, "表姑父");
		this.propertyMap.put("表姑父", this.hasBiaoGufu);
		//表姨
		this.hasBiaoAuntYi = objProperty(ontModel, "表姨");
		this.propertyMap.put("表姨", this.hasBiaoAuntYi);
		//表姨父
		this.hasBiaoUncleYi = objProperty(ontModel, "表姨父");
		this.propertyMap.put("表姨父", this.hasBiaoUncleYi);
		//丈夫
		this.hasHusband = objProperty(ontModel, "丈夫");
		this.propertyMap.put("丈夫", this.hasHusband);
		//妻子
		this.hasWife = objProperty(ontModel, "妻子");
		this.propertyMap.put("妻子", this.hasWife);
		//妾室
		this.hasConcubine = objProperty(ontModel, "妾室");
		this.propertyMap.put("妾室", this.hasConcubine);
		//姐姐
		this.hasElderSister = objProperty(ontModel, "姐姐");
		this.propertyMap.put("姐姐", this.hasElderSister);
		//妹妹
		this.hasYoungerSister = objProperty(ontModel, "妹妹");
		this.propertyMap.put("妹妹", this.hasYoungerSister);
		//哥哥
		this.hasElderBrother = objProperty(ontModel, "哥哥");
		this.propertyMap.put("哥哥", this.hasElderBrother);
		//弟弟
		this.hasYoungerBrother = objProperty(ontModel, "弟弟");
		this.propertyMap.put("弟弟", this.hasYoungerBrother);
		//堂姐妹
		this.hasConsinSister = objProperty(ontModel, "堂姐妹");
		this.propertyMap.put("堂姐妹", this.hasConsinSister);
		//堂兄弟
		this.hasConsinBrother = objProperty(ontModel, "堂兄弟");
		this.propertyMap.put("堂兄弟", this.hasConsinBrother);
		//表姐妹
		this.hasBiaoSister = objProperty(ontModel, "表姐妹");
		this.propertyMap.put("表姐妹", this.hasBiaoSister);
		//表兄弟
		this.hasBiaoBrother = objProperty(ontModel, "表兄弟");
		this.propertyMap.put("表兄弟", this.hasBiaoBrother);
		//女儿
		this.hasDaughter = objProperty(ontModel, "女儿");
		this.propertyMap.put("女儿", this.hasDaughter);
		//儿子
		this.hasSon = objProperty(ontModel, "儿子");
		this.propertyMap.put("儿子", this.hasSon);
		//侄女
		this.hasNiece = objProperty(ontModel, "侄女");
		this.propertyMap.put("侄女", this.hasNiece);
		//侄子
		this.hasNephew = objProperty(ontModel, "侄子");
		this.propertyMap.put("侄子", this.hasNephew);
		//外甥
		this.hasWaisheng = objProperty(ontModel, "外甥");
		this.propertyMap.put("外甥", this.hasWaisheng);
		//外甥女
		this.hasWaishengnv = objProperty(ontModel, "外甥女");
		this.propertyMap.put("外甥女", this.hasWaishengnv);
		//孙子
		this.hasGrandSon = objProperty(ontModel, "孙子");
		this.propertyMap.put("孙子", this.hasGrandSon);
		//孙女
		this.hasGrandDaughter = objProperty(ontModel, "孙女");
		this.propertyMap.put("孙女", this.hasGrandDaughter);
		//孙子
		this.hasGrandMatSon = objProperty(ontModel, "外孙");
		this.propertyMap.put("外孙", this.hasGrandMatSon);
		//孙女
		this.hasGrandMatDaughter = objProperty(ontModel, "外孙女");
		this.propertyMap.put("外孙女", this.hasGrandMatDaughter);
		//孙侄女
		this.hasGrandNiece = objProperty(ontModel, "孙侄女");
		this.propertyMap.put("孙侄女", this.hasGrandNiece);
		//下人
		this.hasMaidPeople = objProperty(ontModel, "下人");
		this.propertyMap.put("下人", this.hasMaidPeople);
		//侍婢
		this.hasMaidWoman = objProperty(ontModel, "侍婢");
		this.propertyMap.put("侍婢", this.hasMaidWoman);
		//小厮
		this.hasMaidMan = objProperty(ontModel, "小厮");
		this.propertyMap.put("小厮", this.hasMaidMan);
		//孩子
		this.hasChildren = objProperty(ontModel, "孩子");
		this.propertyMap.put("孩子", hasChildren);
		//兄弟
		this.hasBrother = objProperty(ontModel, "兄弟");
		this.propertyMap.put("兄弟", hasBrother);
		//姐妹
		this.hasSister = objProperty(ontModel, "姐妹");
		this.propertyMap.put("兄弟", hasSister);
		//亲兄弟
		this.hasNearBrother = objProperty(ontModel, "亲兄弟");
		this.propertyMap.put("亲兄弟", hasNearBrother);
		//亲姐妹
		this.hasNearSister = objProperty(ontModel, "亲姐妹");
		this.propertyMap.put("亲姐妹", hasNearSister);
		//后代
		this.hasDescendant = objProperty(this.ontModel, "后代");
		this.propertyMap.put("后代", this.hasDescendant);
		//前辈
		this.hasPredecessor = objProperty(this.ontModel, "前辈");
		this.propertyMap.put("前辈", this.hasPredecessor);
		//下一代
		this.nextGeneration = objProperty(ontModel, "下一代");
		this.propertyMap.put("下一代", this.nextGeneration);
		//上一代
		this.preGeneration = objProperty(ontModel, "上一代");
		this.propertyMap.put("上一代", this.preGeneration);
		//结拜兄弟
		this.hasSworeBrother = objProperty(ontModel, "结拜兄弟");
		this.propertyMap.put("结拜兄弟", this.hasSworeBrother);
		//住所
		this.locateIn = objProperty(ontModel, "居所");
		this.propertyMap.put("住所", this.locateIn);
		//性别
		this.gender = dataProperty(ontModel, "性别");
		this.propertyMap.put("性别", this.gender);
		//别名
		this.alias = dataProperty(ontModel, "别名");
		this.propertyMap.put("别名", this.alias);
		//职位
		this.rank = dataProperty(ontModel, "职位");
		this.propertyMap.put("职位", this.rank);
		//判曲
		this.panQu = objProperty(ontModel, "判曲");
		this.propertyMap.put("判曲", this.panQu);
		//判曲内容
		this.panQuContent = dataProperty(ontModel, "内容");
		this.propertyMap.put("内容", this.panQuContent);
		//判词
		this.panCi = dataProperty(ontModel, "判词");
		this.propertyMap.put("判词", this.panCi);
		
		this.propertyMap.put("上位类", RDFS.subClassOf);
		
		this.nextGeneration.addProperty(RDFS.subPropertyOf, this.hasDescendant);
		this.hasChildren.addProperty(RDFS.subPropertyOf, this.hasDescendant);
		this.hasDaughter.addProperty(RDFS.subPropertyOf, this.hasChildren);
		this.hasSon.addProperty(RDFS.subPropertyOf, this.hasChildren);
		
		this.preGeneration.addProperty(RDFS.subPropertyOf, this.hasPredecessor);
		this.hasFather.addProperty(RDFS.subPropertyOf, this.preGeneration);
		this.hasMother.addProperty(RDFS.subPropertyOf, this.preGeneration);
		this.hasGrandFather.addProperty(RDFS.subPropertyOf, this.hasPredecessor);
		this.hasGrandMother.addProperty(RDFS.subPropertyOf, this.hasPredecessor);
		this.hasGrandPa.addProperty(RDFS.subPropertyOf, this.hasPredecessor);
		this.hasGrandMa.addProperty(RDFS.subPropertyOf, this.hasPredecessor);
		
		this.hasMaidMan.addProperty(RDFS.subPropertyOf, this.hasMaidPeople);
		this.hasMaidWoman.addProperty(RDFS.subPropertyOf, this.hasMaidPeople);
		
		this.hasBiaoBrother.addProperty(RDFS.subPropertyOf, this.hasBrother);
		this.hasNearBrother.addProperty(RDFS.subPropertyOf, this.hasBrother);
		this.hasConsinBrother.addProperty(RDFS.subPropertyOf, this.hasBrother);
		
		this.hasBiaoSister.addProperty(RDFS.subPropertyOf, this.hasSister);
		this.hasNearSister.addProperty(RDFS.subPropertyOf, this.hasSister);
		this.hasConsinSister.addProperty(RDFS.subPropertyOf, this.hasSister);
		
		this.hasElderSister.addProperty(RDFS.subPropertyOf, this.hasNearSister);
		this.hasElderBrother.addProperty(RDFS.subPropertyOf, this.hasNearBrother);
		this.hasYoungerSister.addProperty(RDFS.subPropertyOf, this.hasNearSister);
		this.hasYoungerBrother.addProperty(RDFS.subPropertyOf, this.hasNearBrother);
	}	
	
	public static String getNameSpace() {
		return SSS.uri;
	}
	
	public Property getPropertyByName(String localName) {
		Property p = this.propertyMap.get(localName);
		return p;
	}
}
