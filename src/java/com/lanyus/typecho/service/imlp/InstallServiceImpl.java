package com.lanyus.typecho.service.imlp;

import com.lanyus.typecho.service.InstallService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by Admin on 2015/11/13.
 */
@Service
public class InstallServiceImpl implements InstallService {

    public boolean isInstall() {
        String ClassesPath = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(ClassesPath + "/config.properties");
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }
}
