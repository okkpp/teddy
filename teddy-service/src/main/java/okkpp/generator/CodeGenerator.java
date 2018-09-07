package okkpp.generator;

import java.util.List;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import io.jboot.codegen.CodeGenHelpler;
import okkpp.generator.model.MyBaseModelGenerator;
import okkpp.generator.model.MyModelInfoGenerator;
import okkpp.generator.service.MyServiceImplGenerator;
import okkpp.generator.service.MyServiceInterfaceGenerator;

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

        new MyBaseModelGenerator(baseModelPackage, baseModelDir).generate(tableMetaList);
        new MyModelInfoGenerator(modelPackage, baseModelPackage, modelDir).generate(tableMetaList);
        
        //生成service
        //JbootServiceGenerator.run(basePackage, modelPackage);
        System.out.println("start generate...");

        new MyServiceInterfaceGenerator(basePackage, modelPackage).generate(tableMetaList);
        new MyServiceImplGenerator(basePackage , modelPackage).generate(tableMetaList);

    }
}