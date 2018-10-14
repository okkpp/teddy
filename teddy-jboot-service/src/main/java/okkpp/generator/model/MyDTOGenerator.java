package okkpp.generator.model;

import java.util.List;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.generator.BaseModelGenerator;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;

public class MyDTOGenerator extends BaseModelGenerator {

	public MyDTOGenerator(String modelPackageName, String baseModelOutputDir) {
		super(modelPackageName, baseModelOutputDir);
		this.template = "/okkpp/generator/model/dto_template.jf";
	}

	@Override
	public void generate(List<TableMeta> tableMetas) {
		System.out.println("Generate base model ...");
		System.out.println("Base Model Output Dir: " + baseModelOutputDir);
		
		Engine engine = Engine.create("forDTO");
		engine.setSourceFactory(new ClassPathSourceFactory());
		engine.addSharedMethod(new StrKit());
		engine.addSharedObject("getterTypeMap", getterTypeMap);
		engine.addSharedObject("javaKeyword", javaKeyword);
		
		for (TableMeta tableMeta : tableMetas) {
			TableMeta tableMetaDTO = tableMeta;
			tableMetaDTO.baseModelName = tableMetaDTO.modelName + "DTO";
			genBaseModelContent(tableMetaDTO);
		}
		writeToFile(tableMetas);
	}
}
