package okkpp.gen;

import java.util.List;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import io.jboot.codegen.CodeGenHelpler;
import io.jboot.codegen.model.JbootBaseModelGenerator;
import io.jboot.codegen.model.JbootModelnfoGenerator;
import io.jboot.codegen.service.JbootServiceImplGenerator;
import io.jboot.codegen.service.JbootServiceInterfaceGenerator;

public class CodeGenerator {

    public static void main(String args[]){
        //依赖model的包名
        String modelPackage = "okkpp.model";
        //生成service 的包名
        String basePackage = "okkpp.service";

        //生成model dao层
        //JbootModelGenerator.run(modelPackage);
        String baseModelPackage = modelPackage + ".base";

        String modelDir = PathKit.getWebRootPath() + "/src/main/java/" + modelPackage.replace(".", "/");
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/" + baseModelPackage.replace(".", "/");

        System.out.println("start generate...");
        System.out.println("generate dir:" + modelDir);

        //去掉表前缀
        MetaBuilder metaBuilder = CodeGenHelpler.createMetaBuilder();
        metaBuilder.setRemovedTableNamePrefixes("t_");
        
        List<TableMeta> tableMetaList = metaBuilder.build();
        CodeGenHelpler.excludeTables(tableMetaList, null);

        new JbootBaseModelGenerator(baseModelPackage, baseModelDir).generate(tableMetaList);
        new JbootModelnfoGenerator(modelPackage, baseModelPackage, modelDir).generate(tableMetaList);
        
        //生成service
        //JbootServiceGenerator.run(basePackage, modelPackage);
        System.out.println("start generate...");

        new JbootServiceInterfaceGenerator(basePackage, modelPackage).generate(tableMetaList);
        new JbootServiceImplGenerator(basePackage , modelPackage).generate(tableMetaList);

    }
}