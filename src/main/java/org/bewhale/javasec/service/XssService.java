package org.bewhale.javasec.service;

import org.bewhale.javasec.model.Xss;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XssService {
    List<String > getContent();

    void setContent(Xss xss);

    void clear();
}
