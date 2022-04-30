package org.bewhale.javasec.service;

import org.bewhale.javasec.model.Admin;

public interface AdminService {
     Admin login(String username, String password);
}
