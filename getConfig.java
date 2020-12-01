package edu.wit.comp1050;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileLocator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class getConfig {
    static Configurations configs = new Configurations();
    public int codeSize() throws ConfigurationException {
        int size = 4;
        Configuration config = configs.properties(new File("src/edu/wit/comp1050/mmind.properties"));
        size = config.getInt("codeSize");
        return size;
    }
    public int codePegRows() throws ConfigurationException {
        int size = 12;
        Configuration config = configs.properties(new File("src/edu/wit/comp1050/mmind.properties"));
        size = config.getInt("codePegRows");
        return size;
    }
    public boolean dupsAllowedInCode() throws ConfigurationException {
        boolean allow = true;
        Configuration config = configs.properties(new File("src/edu/wit/comp1050/mmind.properties"));
        allow = config.getBoolean("dupsAllowedInCode");
        return allow;
    }
    public boolean blanksAllowedInCode() throws ConfigurationException {
        boolean allow = false;
        Configuration config = configs.properties(new File("src/edu/wit/comp1050/mmind.properties"));
        allow = config.getBoolean("blanksAllowedInCode");
        return allow;
    }

    public void setDupe(boolean dupe) throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("src/edu/wit/comp1050/mmind.properties");
        Configuration config = builder.getConfiguration();
        config.setProperty("dupsAllowedInCode", dupe);
        builder.save();
    }

    public void setBlank(boolean dupe) throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("src/edu/wit/comp1050/mmind.properties");
        Configuration config = builder.getConfiguration();
        config.setProperty("blanksAllowedInCode", dupe);
        builder.save();
    }
    public void setRows(int numRows) throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("src/edu/wit/comp1050/mmind.properties");
        Configuration config = builder.getConfiguration();
        config.setProperty("codePegRows", numRows);
        builder.save();
    }

    public static void main(String[] args) throws ConfigurationException {
        Configuration config = configs.properties(new File("src/edu/wit/comp1050/mmind.properties"));
        System.out.println(config.getInt("codeSize"));

    }


}
