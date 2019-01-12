package mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 <<<<<<< Updated upstream
 * myBatis的逆向工程
 =======
 >>>>>>> Stashed changes
 *
 * @author xuhongda on 2017/10/21
 * com.xu.scw.util
 * scw-parent
 */

public class MBGUtil {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("E:\\code\\git\\com-boot-ex\\com-boot-dao\\src\\main\\resources\\mbg.xml");
        System.out.println(configFile);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("mybatis逆向ok");
    }
}
