package okkpp.generator.model;

import com.jfinal.plugin.activerecord.generator.ModelGenerator;

public class MyModelInfoGenerator extends ModelGenerator {

	public MyModelInfoGenerator(String modelPackageName, String baseModelPackageName, String modelOutputDir) {
		super(modelPackageName, baseModelPackageName, modelOutputDir);
		this.template = "/okkpp/generator/model/model_template.jf";
	}

}
