package com.lanyus.typecho.service;

import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2015/11/13.
 */
@Service
public interface InstallService {

    /**
     * 是否已经安装typecho
     * @return
     */
    public boolean isInstall();


}
