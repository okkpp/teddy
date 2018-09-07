package okkpp.generator.model;

import com.jfinal.plugin.activerecord.generator.BaseModelGenerator;

public class MyBaseModelGenerator extends BaseModelGenerator {

	public MyBaseModelGenerator(String baseModelPackageName, String baseModelOutputDir) {
		super(baseModelPackageName, baseModelOutputDir);
		this.template = "/okkpp/generator/model/base_model_template.jf";
	}

}
