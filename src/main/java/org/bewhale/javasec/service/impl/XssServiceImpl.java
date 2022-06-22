package org.bewhale.javasec.service.impl;

import org.bewhale.javasec.dao.XssDao;
import org.bewhale.javasec.model.Xss;
import org.bewhale.javasec.service.XssService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XssServiceImpl implements XssService {
    final
    XssDao xssDao;

    public XssServiceImpl(XssDao xssDao) {
        this.xssDao = xssDao;
    }

    @Override
    public List<String> getContent() {
        return xssDao.getContent();
    }

    @Override
    public void setContent(Xss xss) {
        xssDao.setContent(xss);
    }

    @Override
    public void clear() {
        xssDao.clear();
    }
}
