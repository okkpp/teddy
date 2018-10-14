package okkpp.generator;

import java.util.List;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import io.jboot.codegen.CodeGenHelpler;
import okkpp.generator.model.MyBaseModelGenerator;
import okkpp.generator.model.MyDTOGenerator;
import okkpp.generator.model.MyModelInfoGenerator;
import okkpp.generator.service.MyServiceImplGenerator;
import okkpp.generator.service.MyServiceInterfaceGenerator;

public class CodeGenerator {

    public static void main(String[] args){
        //依赖model的包名
        String modelPackage = "okkpp.model";
        //生成service 的包名
        String servicePackage = "okkpp.service";

        String dtoPackage = "okkpp.dto";
        
        //去掉表前缀
        MetaBuilder metaBuilder = CodeGenHelpler.createMetaBuilder();
        metaBuilder.setRemovedTableNamePrefixes("t_");
        List<TableMeta> tableMetaList = metaBuilder.build();
        CodeGenHelpler.excludeTables(tableMetaList, null);

        genModel(modelPackage, tableMetaList);
        genDto(dtoPackage, tableMetaList);
        
        //生成service
        genService(modelPackage, servicePackage, tableMetaList);

    }
    private static void genModel(String modelPackage, List<TableMeta> tableMetaList) {
    	String baseModelPackage = modelPackage + ".base";
    	String modelDir = PathKit.getWebRootPath() + "/src/main/java/" + modelPackage.replace(".", "/");
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/" + baseModelPackage.replace(".", "/");
    	new MyBaseModelGenerator(baseModelPackage, baseModelDir).generate(tableMetaList);
        new MyModelInfoGenerator(modelPackage, baseModelPackage, modelDir).generate(tableMetaList);
    }
    private static void genDto(String dtoPackage, List<TableMeta> tableMetaList) {
    	String outputDir = PathKit.getWebRootPath() + "/src/main/java/" + dtoPackage.replace(".", "/");
    	new MyDTOGenerator(dtoPackage, outputDir).generate(tableMetaList);
    }
    private static void genService(String modelPackage, String servicePackage, List<TableMeta> tableMetaList) {
    	new MyServiceInterfaceGenerator(servicePackage, modelPackage).generate(tableMetaList);
        new MyServiceImplGenerator(servicePackage , modelPackage).generate(tableMetaList);
    }
}